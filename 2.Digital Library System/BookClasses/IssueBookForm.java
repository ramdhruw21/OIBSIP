package BookClasses;
import UserClasses.UserLoged;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class IssueBookForm extends JFrame{

    static IssueBookForm frame;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    frame = new IssueBookForm();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public IssueBookForm()
    {

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setBounds(200, 80, 880, 550);

        ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/BlueSkies.jpg"));
        Image scalebgImg = bgImg.getImage().getScaledInstance(880,550,Image.SCALE_DEFAULT);
        ImageIcon newbgImg= new ImageIcon(scalebgImg);

        JLabel background = new JLabel();
        background.setBounds(0,0,880,550);
        background.setIcon(newbgImg);
        add(background);

        ImageIcon Img16 = new ImageIcon(ClassLoader.getSystemResource("img/Img25.jpg"));
        Image scaleImg16 = Img16.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
        ImageIcon newImg16 = new ImageIcon(scaleImg16);
        JLabel lblImg16 = new JLabel();
        lblImg16.setBounds(28,28,400,450);
        lblImg16.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        lblImg16.setIcon(newImg16);
        background.add(lblImg16);



        JLabel lblNewLabel = new JLabel("Issue Book ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(580,20,200,40);
        lblNewLabel.setForeground(Color.YELLOW);
        background.add(lblNewLabel);

        JLabel lblBookName = new JLabel("Call No:");
        lblBookName.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblBookName.setBounds(460,90,150,30);
        lblBookName.setForeground(Color.BLACK);
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(640,90,180,30);
        background.add(textField_1);
        background.add(lblBookName);

        JLabel lblUserId = new JLabel("User Id:");
        lblUserId.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblUserId.setBounds(460,150,150,30);
        lblUserId.setForeground(Color.BLACK);
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(640,150,180,30);
        background.add(lblUserId);
        background.add(textField_2);

        JLabel lblUserName = new JLabel("User Name:");
        lblUserName.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblUserName.setBounds(460,220,150,30);
        lblUserName.setForeground(Color.BLACK);
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(640,220,180,30);
        background.add(lblUserName);
        background.add(textField_3);


        JLabel lblUserContact = new JLabel("User Contact:");
        lblUserContact.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblUserContact.setBounds(460,290,180,30);
        lblUserContact.setForeground(Color.BLACK);
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(640,290,180,30);
        background.add(lblUserContact);
        background.add(textField_4);


        JButton btnIssueBook = new JButton("Issue Book");
        btnIssueBook.setBounds(480,390,140,50);
        btnIssueBook.setBackground(Color.YELLOW);
        background.add(btnIssueBook);

        btnIssueBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                   String bookCallNo = textField_1.getText();
                   int userId = Integer.parseInt(textField_2.getText());
                   String userName = textField_3.getText();
                   String userContact = textField_4.getText();

                  if (IssueBookDoc.checkBook(bookCallNo)) {

                      int i = IssueBookDoc.save(bookCallNo, userId, userName, userContact);

                      if (i > 0) {
                          JOptionPane.showMessageDialog(IssueBookForm.this, "Book issued successfully!");
                      } else {

                          JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, unable to issue!");
                      }

                  } else {
                      JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, BookCallNo doesn't exist!");
                  }


            }
        });


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(675,390,140,50);
        btnBack.setBackground(Color.MAGENTA);

        background.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserLoged.main(new String[]{});
                frame.dispose();
            }
        });



        JLabel lblNewLabel_1 = new JLabel("Note: Please check User ID Carefully before issuing book!");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setBounds(450,450,400,50);
        background.add(lblNewLabel_1);



    }
}
