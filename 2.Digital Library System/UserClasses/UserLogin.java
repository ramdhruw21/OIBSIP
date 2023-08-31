package UserClasses;

import AdminClasses.HomeLibrary;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame {
    static UserLogin frame;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel icon;


    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    frame = new UserLogin();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public UserLogin()
    {

        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 880, 550);

        ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/VeryBlue.jpg"));
        Image scalebgImg = bgImg.getImage().getScaledInstance(380,550,Image.SCALE_DEFAULT);
        ImageIcon newbgImg= new ImageIcon(scalebgImg);

        JLabel background = new JLabel();
        background.setBounds(0,0,380,550);
        background.setIcon(newbgImg);
        background.setOpaque(true);
        add(background);


        ImageIcon headImg = new ImageIcon(ClassLoader.getSystemResource("img/lib.png"));
        Image image = headImg.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image);
        icon = new JLabel();
        icon.setIcon(image2);
        icon.setBounds(365, 0, 500, 170);
        add(icon);



        JLabel rootAdminLoginForm = new JLabel("User Login");
        rootAdminLoginForm.setForeground(Color.black);
        rootAdminLoginForm.setFont(new Font("Monospaced", Font.BOLD, 18));
        rootAdminLoginForm.setBounds(555,245,200,100);
        add(rootAdminLoginForm);

        ImageIcon rootAdminImg = new ImageIcon(ClassLoader.getSystemResource("img/login.png"));
        Image rootImg = rootAdminImg.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon newrootImg = new ImageIcon(rootImg);

        JLabel LoginImg = new JLabel();
        LoginImg.setIcon(newrootImg);
        LoginImg.setBounds(560, 182, 100, 100);
        add(LoginImg);

        JLabel userEnterName = new JLabel("Enter Name:");
        userEnterName.setBounds(430,300,200,100);
        userEnterName.setFont(new Font("Monospaced",Font.BOLD,15));
        userEnterName.setForeground(Color.black);
        textField = new JTextField();
        textField.setBounds(640,340,180,25);
        textField.setColumns(10);
        add(textField);
        add(userEnterName);

        JLabel userEnterPassword = new JLabel("Enter Password:");
        userEnterPassword.setBounds(430,360,200,100);
        userEnterPassword.setFont(new Font("Monospaced",Font.BOLD,15));
        userEnterPassword.setForeground(Color.black);
        passwordField = new JPasswordField();
        passwordField.setBounds(640,400,180,25);
        add(passwordField);
        add(userEnterPassword);


        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(430,460,175,35);
        btnLogin.setBackground(new Color(115, 147, 179));
        btnLogin.setForeground(Color.white);
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String name=textField.getText();
                String password=String.valueOf(passwordField.getPassword());
                //System.out.println(name+" "+password);


                if(UserDoc.validate(name, password)){

                    UserLoged.main(new String[]{});
                    frame.dispose();

                }else{
                    JOptionPane.showMessageDialog(UserLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                    passwordField.setText("");
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(645,460,175,35);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnBack.setForeground(Color.white);
        btnBack.setBackground(new Color(115, 147, 179));
        add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeLibrary.main(new String[]{});
                frame.dispose();
            }
        });



    }
}
