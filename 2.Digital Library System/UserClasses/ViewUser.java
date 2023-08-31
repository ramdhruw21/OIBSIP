package UserClasses;

import AdminClasses.AdminLoged;
import DbClasses.java.DB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import java.awt.*;

public class ViewUser extends JFrame {


     private JTable table;
     static  JFrame frame;

     public static void main(String[] args) {
          EventQueue.invokeLater(new Runnable() {
               public void run() {
                    try {

                         frame = new ViewUser();
                         frame.setVisible(true);

                    } catch (Exception e) {
                         e.printStackTrace();
                    }
               }
          });
     }

     public ViewUser() {

          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setBounds(200, 80, 950, 550);
          setTitle("User Database");


          String data[][]=null;
          String column[]=null;

          try{

               Connection con= DB.getConnection();
               PreparedStatement ps = con.prepareStatement("select * from users",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

               ResultSet rs=ps.executeQuery();

               ResultSetMetaData rsmd = rs.getMetaData();

               int cols= rsmd.getColumnCount();
               column=new String[cols];

               for(int i=1; i<=cols; i++){

                    column [i-1] = rsmd.getColumnName(i);
               }

               rs.last();

               int rows = rs.getRow();
               rs.beforeFirst();

               data=new String[rows][cols];
               int count = 0;

               while(rs.next()){

                    for(int i=1; i<=cols; i++){

                         data[count][i-1]=rs.getString(i);
                    }
                    count++;
               }
               con.close();

          }catch(Exception e)
          {
               System.out.println(e);
          }

          JButton btnback = new JButton("Back");
          btnback.setBounds(720,430,100,40);
          add(btnback);
          btnback.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    AdminLoged.main(new String[]{});
                    frame.dispose();

               }
          });

          table = new JTable(data,column);
          table.setBackground(Color.orange);
          JScrollPane sp=new JScrollPane(table);
          add(sp);

     }

}


