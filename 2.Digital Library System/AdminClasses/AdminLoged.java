package AdminClasses;

import BookClasses.ViewIssuedBook;
import UserClasses.DeleteUser;
import UserClasses.UserForm;
import UserClasses.ViewUser;


import BookClasses.BooksForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoged extends JFrame{
    static AdminLoged frame;


    public static void main(String []args)
    {
        EventQueue.invokeLater(new Runnable() {
             @Override
            public void run()
             {
                 try{

                       frame = new AdminLoged();
                       frame.setVisible(true);
                 }
                 catch (Exception e)
                 {
                     e.printStackTrace();
                 }
             }
        });
    }

    public AdminLoged()
    {

         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getContentPane().setBackground(Color.white);
         setBounds(200,80,880,550);

         ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/lib2.jpg"));
         Image scaleIcon = icon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
         setIconImage(scaleIcon);

         ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/SweetMorning.jpg"));
         Image scalebgImg = bgImg.getImage().getScaledInstance(880,550,Image.SCALE_DEFAULT);
         ImageIcon newbgImg= new ImageIcon(scalebgImg);

         JLabel background = new JLabel();
         background.setBounds(0,0,880,550);
         background.setIcon(newbgImg);
         background.setOpaque(true);
         add(background);

         ImageIcon ContentImg = new ImageIcon(ClassLoader.getSystemResource("img/Img21.png"));
         Image newImg = ContentImg.getImage().getScaledInstance(459,417, Image.SCALE_DEFAULT);
         ImageIcon headImg = new ImageIcon(newImg);
         JLabel head = new JLabel(headImg);
         head.setBounds(35,60,459,417);
         head.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
         background.add(head);


         JLabel AdminSection = new JLabel("Admin Section");
         AdminSection.setBounds(560,5,220,50);
         AdminSection.setFont(new Font("Tahoma",Font.BOLD,30));
         AdminSection.setForeground(Color.black);
         background.add(AdminSection);

         JButton btnBookButton = new JButton("Add Books");
         btnBookButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
         btnBookButton.setBackground(new Color(153,153,255));
         btnBookButton.setBounds(570,65,200,50);
         background.add(btnBookButton);
         btnBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BooksForm.main(new String[]{});
                frame.dispose();
            }
          });


         JButton btnUserButton = new JButton("Add User");
         btnUserButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
         btnUserButton.setBackground(new Color(255,102,0));
         btnUserButton.setBounds(570,140,200,50);
         background.add(btnUserButton);
         btnUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                UserForm.main(new String[]{});
                frame.dispose();
            }
         });


         JButton btnViewUser = new JButton("View Users");
         btnViewUser.setBounds(570,215,200,50);
         btnViewUser.setBackground(new Color(153,204,0));
         background.add(btnViewUser);
         btnViewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                ViewUser.main(new String[]{});
                frame.dispose();
            }
         });
         btnViewUser.setFont(new Font("Tahoma", Font.PLAIN, 15));


         JButton btnViewIssuedBooks = new JButton("View Issued Books");
         btnViewIssuedBooks.setBounds(570,290,200,50);
         btnViewIssuedBooks.setBackground(new Color(205,0,205));
         background.add(btnViewIssuedBooks);
         btnViewIssuedBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewIssuedBook.main(new String[]{});
                frame.dispose();
            }
         });
         btnViewIssuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));


         JButton btnDeleteUser = new JButton("Delete Users");
         btnDeleteUser.setBounds(570,365,200,50);
         btnDeleteUser.setBackground(Color.red);
         background.add(btnDeleteUser);
         btnDeleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteUser.main(new String[]{});
                frame.dispose();
            }
         });
         btnDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 15));


         JButton btnLogout = new JButton("Logout");
         btnLogout.setBackground(new Color(192, 192, 192));
         btnLogout.setBounds(570,434,200,40);
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
