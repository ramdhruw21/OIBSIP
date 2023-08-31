package BookClasses;

import DbClasses.java.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class BookDoc {

    public static int save(String bookCallno, String name, String author, String publisher, int quantity)
    {


          int status = 0;

          try{
                  Connection con = DB.getConnection();

                  PreparedStatement ps = con.prepareStatement("insert into books(callno, name, author, publisher, quantity) values(?,?,?,?,?)");
                  ps.setString(1,bookCallno);
                  ps.setString(2,name);
                  ps.setString(3,author);
                  ps.setString(4,publisher);
                  ps.setInt(5,quantity);

                  status = ps.executeUpdate();
                  con.close();
          }
          catch (Exception e)
          {
                 System.out.println(e);
          }

          return status;
    }
}
