package BookClasses;
import UserClasses.UserLoged;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame{

      static ReturnBook frame;
      private JTextField textField1;
      private JTextField textField2;

     public static void main(String[] args)
     {
          EventQueue.invokeLater(new Runnable() {
              @Override
              public void run() {

                 try {
                     frame = new ReturnBook();
                     frame.setVisible(true);
                 }catch (Exception e)
                 {
                      e.printStackTrace();
                 }
              }
          });
     }


     public ReturnBook()
     {


         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(200,80,880,550);

         ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/Bg.jpg"));
         Image scalebgImg = bgImg.getImage().getScaledInstance(880,550,Image.SCALE_DEFAULT);
         ImageIcon newbgImg= new ImageIcon(scalebgImg);

         JLabel background = new JLabel();
         background.setBounds(0,0,880,550);
         background.setIcon(newbgImg);
         background.setOpaque(true);
         add(background);

         JLabel lblReturnBook = new JLabel("Return Book");
         lblReturnBook.setBounds(390,85,150,40);
         lblReturnBook.setForeground(Color.DARK_GRAY);
         lblReturnBook.setFont(new Font("Tahoma", Font.BOLD, 20));
         background.add(lblReturnBook);


         JLabel lblBookCallNo = new JLabel("Book Callno:");
         lblBookCallNo.setBounds(290,165,150,50);
         lblBookCallNo.setFont(new Font("Tahoma", Font.BOLD,20));
         textField1 = new JTextField();
         textField1.setBounds(440,170,180,35);
         textField1.setColumns(10);
         background.add(lblBookCallNo);
         background.add(textField1);


         JLabel lblUserId = new JLabel("User Id:");
         lblUserId.setBounds(290,230,150,50);
         lblUserId.setFont(new Font("Tahoma", Font.BOLD,20));
         textField2 = new JTextField();
         textField2.setBounds(440,235,180,35);
         textField2.setColumns(10);
         background.add(lblUserId);
         background.add(textField2);


         JButton btnReturnBook = new JButton("Return Book");
         btnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 13));
         btnReturnBook.setBounds(320,430,150,50);
         btnReturnBook.setBackground(Color.green);
         background.add(btnReturnBook);
         btnReturnBook.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                   String bookCallNo = textField1.getText();

                   int userId = Integer.parseInt(textField2.getText());

                   int i = ReturnBookDoc.delete(bookCallNo,userId);

                   if(i>0)
                   {
                         JOptionPane.showMessageDialog(ReturnBook.this,"Book returned successfully!");
                         UserLoged.main(new String[]{});
                         frame.dispose();
                   }
                   else{
                          JOptionPane.showMessageDialog(ReturnBook.this,"Sorry, unable to return book!");
                   }
             }
         });


         JLabel lblNewLabel = new JLabel("Note: Check the book properly!");
         lblNewLabel.setForeground(Color.red);
         lblNewLabel.setFont(new Font("Tahoma",Font.BOLD,13));
         lblNewLabel.setBounds(100,52,250,50);
         background.add(lblNewLabel);


         JButton btnBack = new JButton("Back");
         btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
         btnBack.setBounds(520,430,145,50);
         btnBack.setBackground(Color.orange);
         background.add(btnBack);
         btnBack.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                   UserLoged.main(new String[]{});
                   frame.dispose();
             }
         });
     }
}
