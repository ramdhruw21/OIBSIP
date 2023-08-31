package UserClasses;

import AdminClasses.AdminLoged;

import javax.swing.*;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserForm extends JFrame {

    static UserForm frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JPasswordField passwordField;


    public static void main(String [] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    frame = new UserForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserForm()
    {


        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 880, 550);
        getContentPane().setBackground(Color.white);

        setTitle("User Entry Form");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/lib2.jpg"));
        Image scaleIcon = icon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        setIconImage(scaleIcon);

        ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/Maldives.jpg"));
        Image scalebgImg = bgImg.getImage().getScaledInstance(880,550,Image.SCALE_DEFAULT);
        ImageIcon newbgImg= new ImageIcon(scalebgImg);

        JLabel background = new JLabel();
        background.setBounds(0,0,880,550);
        background.setIcon(newbgImg);
        background.setOpaque(true);
        add(background);

        ImageIcon Img = new ImageIcon(ClassLoader.getSystemResource("img/Img4.jpg"));
        Image scaleImg = Img.getImage().getScaledInstance(400,455,Image.SCALE_DEFAULT);
        ImageIcon newImg = new ImageIcon(scaleImg);
        JLabel lblImg = new JLabel();
        lblImg.setBounds(25,29,400,455);
        lblImg.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),10));
        lblImg.setIcon(newImg);
        background.add(lblImg);

        JLabel lblAddUser = new JLabel("Add User");
        lblAddUser.setForeground(Color.BLACK);
        lblAddUser.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblAddUser.setBounds(560,5,180,50);
        background.add(lblAddUser);

        JLabel userName = new JLabel("Name:");
        userName.setBounds(455,80,80,50);
        userName.setFont(new Font("Tahoma", Font.BOLD, 23));
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(600,80,200,34);
        background.add(textField);
        background.add(userName);

        JLabel userPassword = new JLabel("Password:");
        userPassword.setBounds(455,140,120,50);
        userPassword.setFont(new Font("Tahoma", Font.BOLD, 22));
        passwordField = new JPasswordField();
        passwordField.setBounds(600,140,200,34);
        background.add(passwordField);
        background.add(userPassword);

        JLabel userEmail = new JLabel("Email:");
        userEmail.setBounds(455,198,80,50);
        userEmail.setFont(new Font("Tahoma", Font.BOLD, 22));
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(600,198,200,34);
        background.add(textField_1);
        background.add(userEmail);

        JLabel userAddress = new JLabel("Address:");
        userAddress.setBounds(455,250,100,50);
        userAddress.setFont(new Font("Tahoma", Font.BOLD, 22));
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(600,255,200,34);
        background.add(textField_2);
        background.add(userAddress);

        JLabel userCity = new JLabel("City:");
        userCity.setBounds(455,305,80,50);
        userCity.setFont(new Font("Tahoma", Font.BOLD, 22));
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(600,310,200,34);
        background.add(textField_3);
        background.add(userCity);

        JLabel userContactNo = new JLabel("Contact No:");
        userContactNo.setBounds(455,360,150,50);
        userContactNo.setFont(new Font("Tahoma", Font.BOLD, 22));
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(600,370,200,34);
        background.add(textField_4);
        background.add(userContactNo);

        JButton btnAddUser = new JButton("Add User");
        btnAddUser.setBounds(470,438,120,45);
        btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddUser.setBackground(Color.LIGHT_GRAY);
        background.add(btnAddUser);
        btnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name=textField.getText();
                String password=String.valueOf(passwordField.getPassword());
                String email=textField_1.getText();
                String address=textField_2.getText();
                String city=textField_3.getText();
                String contact=textField_4.getText();

                int i = UserDoc.save(name, password, email, address, city, contact);

                if(i>0){
                    JOptionPane.showMessageDialog(UserForm.this,"User added successfully!");
                    AdminLoged.main(new String[]{});
                    frame.dispose();

                }else{
                    JOptionPane.showMessageDialog(UserForm.this,"Sorry, unable to save!");
                }
            }
        });

        btnAddUser.setForeground(Color.DARK_GRAY);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(675,438,120,45);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBackground(Color.LIGHT_GRAY);
        background.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminLoged.main(new String[]{});
                frame.dispose();
            }
        });
    }
}
