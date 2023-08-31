package AdminClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AdminLogin extends JFrame {

    static AdminLogin frame;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel heading, icon;

    //Launch the application
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    frame = new AdminLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


// Create the frame

    public AdminLogin() {


        setLayout(null);
        getContentPane().setBackground(new Color(255,255,255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 880, 550);

        ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/SweetMorning.jpg"));
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

        JLabel rootAdminLoginForm = new JLabel("Admin Login");
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

        JLabel rootEnterName = new JLabel("Enter Name:");
        rootEnterName.setBounds(430,300,200,100);
        rootEnterName.setFont(new Font("Monospaced",Font.BOLD,15));
        rootEnterName.setForeground(Color.black);
        textField = new JTextField();
        textField.setBounds(640,340,180,25);
        textField.setColumns(10);
        add(textField);
        add(rootEnterName);

        JLabel rootEnterPassword = new JLabel("Enter Password:");
        rootEnterPassword.setBounds(430,360,200,100);
        rootEnterPassword.setFont(new Font("Monospaced",Font.BOLD,15));
        rootEnterPassword.setForeground(Color.black);
        passwordField = new JPasswordField();
        passwordField.setBounds(640,400,180,25);
        add(passwordField);
        add(rootEnterPassword);


        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(430,460,175,35);
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLogin.setBackground(new Color(115, 147, 179));
        btnLogin.setForeground(Color.white);
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = textField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (name.equals("admin") && password.equals("admin12")) {

                    //Admin login successfully
                    AdminLoged.main(new String[]{});
                    frame.dispose();

                } else {

                    JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or password Error", "Login Erorr!", JOptionPane.ERROR_MESSAGE);

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