package BookClasses;
import DbClasses.java.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ReturnBookDoc {

    public static int delete(String bookCallNo, int userId)
    {
          int status = 0;

          try{

                Connection con = DB.getConnection();

                status = updateBook(bookCallNo);  //updating quantity and issue

               if(status>0)
               {
                     PreparedStatement ps = con.prepareStatement("delete from issuebooks where bookcallno=? and userid = ?");

                     ps.setString(1,bookCallNo);
                     ps.setInt(2, userId);
                     status = ps.executeUpdate();
               }

               con.close();
          }catch (Exception e)
          {
                System.out.println(e);
          }

          return status;
    }

    public static int updateBook(String bookCallNo)
    {
            int status = 0;
            int quantity = 0;
            int issued = 0;

            try{

                  Connection con = DB.getConnection();

                  PreparedStatement ps = con.prepareStatement("select quantity, issued from books where callno=?");

                  ps.setString(1, bookCallNo);
                  ResultSet rs = ps.executeQuery();

                  if(rs.next())
                  {
                        quantity = rs.getInt("quantity");
                        issued = rs.getInt("issued");
                  }

                  if (issued>0)
                  {
                       PreparedStatement ps2 = con.prepareStatement("update books set quantity=?, issued=? where callno=?");
                       ps2.setInt(1,quantity+1);
                       ps2.setInt(2,issued-1);
                       ps2.setString(3,bookCallNo);

                       status = ps2.executeUpdate();
                  }
                  con.close();

            }catch (Exception e)
            {
                System.out.print(e);
            }

            return  status;
    }

}
