package AdminClasses;

import UserClasses.UserLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeLibrary extends JFrame {

     static HomeLibrary frame;



    public static void main(String[] args)
    {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {


                try {
                    frame = new HomeLibrary();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

        public HomeLibrary()
        {

            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(180,100,880,550);
            setTitle("Digital Library Management");

            ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/lib2.jpg"));
            Image scaleIcon = icon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
            setIconImage(scaleIcon);

            ImageIcon libImg = new ImageIcon(ClassLoader.getSystemResource("img/lib6.jpg"));
            Image scaleImg = libImg.getImage().getScaledInstance(880,513,Image.SCALE_DEFAULT);
            ImageIcon newLib = new ImageIcon(scaleImg);

            JLabel libraryMgm = new JLabel();
            libraryMgm.setBounds(0,0,870,513);
            libraryMgm.setIcon(newLib);
            add(libraryMgm);


            JLabel wlclabel = new JLabel("Welcome to your Library");
            wlclabel.setForeground(Color.YELLOW);
            wlclabel.setFont(new Font("Tahoma",Font.BOLD,30));
            wlclabel.setBounds(265,10,400,150);
            libraryMgm.add(wlclabel);


            JButton btnAdminLogin = new JButton("Admin Login");
            btnAdminLogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    AdminLogin.main(new String[]{});
                    frame.dispose();
                }
            });
            btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnAdminLogin.setBounds(350,200,190,60);
            btnAdminLogin.setBackground(new Color(255,255,255));
            libraryMgm.add(btnAdminLogin);


            JButton btnUserLogin = new JButton("User Login");
            btnUserLogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    UserLogin.main(new String[]{});
                    frame.dispose();
                }
            });
            btnUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnUserLogin.setBounds(350,300,190,60);
            btnUserLogin.setBackground(new Color(255,255,255));
            libraryMgm.add(btnUserLogin);

        }

}
