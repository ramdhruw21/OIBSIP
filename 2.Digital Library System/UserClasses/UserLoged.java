package UserClasses;

import AdminClasses.HomeLibrary;
import BookClasses.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserLoged extends JFrame {
     static UserLoged frame;

     public static void main(String[] args) {
          EventQueue.invokeLater(new Runnable() {
               public void run() {
                    try {
                         frame = new UserLoged();
                         frame.setVisible(true);
                    } catch (Exception e) {
                         e.printStackTrace();
                    }
               }
          });
     }

     public UserLoged()
     {

          setLayout(null);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setBounds(200, 80, 880, 550);

          ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/lib2.jpg"));
          Image scaleIcon = icon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
          setIconImage(scaleIcon);

          ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/VeryBlue.jpg"));
          Image scalebgImg = bgImg.getImage().getScaledInstance(880,550,Image.SCALE_DEFAULT);
          ImageIcon newbgImg = new ImageIcon(scalebgImg);

          JLabel background = new JLabel();
          background.setBounds(0,0,880,550);
          background.setIcon(newbgImg);
          background.setOpaque(true);
          add(background);

          ImageIcon Img12 = new ImageIcon(ClassLoader.getSystemResource("img/Img12.png"));
          Image scaleImg12 = Img12.getImage().getScaledInstance(405,455,Image.SCALE_DEFAULT);
          ImageIcon newImg12 = new ImageIcon(scaleImg12);
          JLabel lblImg12 = new JLabel();
          lblImg12.setBounds(45,28,410,455);
          lblImg12.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
          lblImg12.setIcon(newImg12);
          background.add(lblImg12);


          JLabel lblUserSection = new JLabel("User Section");
          lblUserSection.setBounds(540,0,200, 80);
          lblUserSection.setFont(new Font("Tahoma", Font.BOLD, 30));
          lblUserSection.setForeground(Color.ORANGE);

          background.add(lblUserSection);


          JButton btnViewBooks = new JButton("View Books");
          btnViewBooks.setBounds(540,100,200,50);
          btnViewBooks.setBackground(Color.white);
          background.add(btnViewBooks);
          btnViewBooks.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent arg0) {

                    ViewBooks.main(new String[]{});
                    frame.dispose();

               }
          });
          btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));



          JButton btnIssueBook = new JButton("Issue Book");
          btnIssueBook.setBounds(540,184,200,50);
          btnIssueBook.setBackground(Color.orange);
          background.add(btnIssueBook);
          btnIssueBook.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                    IssueBookForm.main(new String[]{});
                    frame.dispose();
               }
          });
          btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 13));


          JButton btnViewIssuedBooks = new JButton("Book Categories");
          btnViewIssuedBooks.setBounds(540,265,200,50);
          btnViewIssuedBooks.setBackground(Color.green);
          background.add(btnViewIssuedBooks);
          btnViewIssuedBooks.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                    BooksCategories.main(new String[]{});
                    frame.dispose();
               }
          });
          btnViewIssuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));


          JButton btnReturnBook = new JButton("Return Book");
          btnReturnBook.setBounds(540,350,200,50);
          btnReturnBook.setBackground(Color.pink);
          background.add(btnReturnBook);
          btnReturnBook.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                    ReturnBook.main(new String[]{});
                    frame.dispose();
               }
          });
          btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 13));


          JButton btnLogout = new JButton("Logout");
          btnLogout.setBounds(540,430,200,40);
          btnLogout.setBackground(Color.red);
          background.add(btnLogout);
          btnLogout.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent arg0) {
                    HomeLibrary.main(new String[]{});
                    frame.dispose();
               }
          });
          btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));

     }

}
