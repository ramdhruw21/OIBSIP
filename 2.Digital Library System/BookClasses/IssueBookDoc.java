package BookClasses;

import DbClasses.java.DB;

import java.sql.*;

public class IssueBookDoc {


    public static boolean checkBook(String bookcallno)
    {
          boolean status = false;

          try {
              Connection con = DB.getConnection();

              PreparedStatement ps = con.prepareStatement("select * from books where callno=?");
              ps.setString(1,bookcallno);

              ResultSet rs = ps.executeQuery();
              status = rs.next();
              con.close();

          }catch (Exception e)
          {
               System.out.println(e);
          }

          return status;
    }

    public static int save(String bookcallno, int userId, String userName, String userContact)
    {
         int status =0;

          try{

               Connection con = DB.getConnection();

               status = updateBook(bookcallno);

               if(status>0)
               {
                   PreparedStatement ps = con.prepareStatement("insert into issuebooks(bookcallno, userid, username, usercontact) values(?,?,?,?)");
                   ps.setString(1,bookcallno);
                   ps.setInt(2,userId);
                   ps.setString(3,userName);
                   ps.setString(4, userContact);

                   status = ps.executeUpdate();
               }

               con.close();

          }catch (Exception e)
          {
              System.out.println(e);
          }


          return status;
    }

    public static int updateBook(String bookcallno)
    {
         int status = 0;
         int quantity = 0;
         int issued = 0;

         try{

             Connection con = DB.getConnection();

             PreparedStatement ps = con.prepareStatement("select quantity, issued from books where callno=?");
             ps.setString(1,bookcallno);

             ResultSet rs = ps.executeQuery();

             if (rs.next())
             {
                  quantity = rs.getInt("quantity");
                  issued = rs.getInt("issued");
             }

             if (quantity>0)
             {
                  PreparedStatement ps2 = con.prepareStatement("update books set quantity=?, issued=? where callno=?");

                  ps2.setInt(1,quantity-1);
                  ps2.setInt(2,issued+1);
                  ps2.setString(3,bookcallno);

                  status = ps2.executeUpdate();
             }

             con.close();

         }catch (Exception e)
         {
              System.out.println(e);
         }
         return status;
    }

}
