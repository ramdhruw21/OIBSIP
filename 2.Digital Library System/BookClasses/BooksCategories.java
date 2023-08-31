package BookClasses;

import UserClasses.UserLoged;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BooksCategories extends JFrame {

    static BooksCategories frame;

    public static void main(String []args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try{

                    frame = new BooksCategories();
                    frame.setVisible(true);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }


    public  BooksCategories()
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 880, 550);


        ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/Img1.jpg"));
        Image scalebgImg = bgImg.getImage().getScaledInstance(880,550,Image.SCALE_DEFAULT);
        ImageIcon newbgImg = new ImageIcon(scalebgImg);

        JLabel background = new JLabel();
        background.setBounds(0,0,880,550);
        background.setIcon(newbgImg);
        add(background);

        JLabel lbl1 = new JLabel();
        lbl1.setBounds(260,30, 400, 50);
        lbl1.setText("Book Categories");
        lbl1.setForeground(Color.BLUE);
        lbl1.setFont(new Font("Monospaced", Font.BOLD,40));
        background.add(lbl1);


        JLabel lbl2= new JLabel();
        lbl2.setBounds(280,100, 400, 50);
        lbl2.setText("Science & Technology");
        lbl2.setForeground(Color.black);
        lbl2.setFont(new Font("Monospaced", Font.BOLD,26));
        background.add(lbl2);


        JLabel lbl3= new JLabel();
        lbl3.setBounds(390,140, 400, 50);
        lbl3.setText("History");
        lbl3.setForeground(Color.black);
        lbl3.setFont(new Font("Monospaced", Font.BOLD,26));
        background.add(lbl3);


        JLabel lbl4= new JLabel();
        lbl4.setBounds(390,180, 400, 50);
        lbl4.setText("Poetry");
        lbl4.setForeground(Color.black);
        lbl4.setFont(new Font("Monospaced", Font.BOLD,26));
        background.add(lbl4);

        JLabel lbl5= new JLabel();
        lbl5.setBounds(390,225, 400, 50);
        lbl5.setText("Fiction");
        lbl5.setForeground(Color.black);
        lbl5.setFont(new Font("Monospaced", Font.BOLD,26));
        background.add(lbl5);


        JLabel lbl6= new JLabel();
        lbl6.setBounds(365,270, 400, 50);
        lbl6.setText("Non-Fiction");
        lbl6.setForeground(Color.black);
        lbl6.setFont(new Font("Monospaced", Font.BOLD,26));
        background.add(lbl6);

        JLabel lbl7= new JLabel();
        lbl7.setBounds(380,310, 400, 50);
        lbl7.setText("Biography");
        lbl7.setForeground(Color.black);
        lbl7.setFont(new Font("Monospaced", Font.BOLD,26));
        background.add(lbl7);


        JLabel lbl8= new JLabel();
        lbl8.setBounds(350,350, 400, 50);
        lbl8.setText("Self-help book");
        lbl8.setForeground(Color.black);
        lbl8.setFont(new Font("Monospaced", Font.BOLD,26));
        background.add(lbl8);


        JLabel lbl9= new JLabel();
        lbl9.setBounds(365,390, 400, 50);
        lbl9.setText("Other books");
        lbl9.setForeground(Color.black);
        lbl9.setFont(new Font("Monospaced", Font.BOLD,26));
        background.add(lbl9);



        JButton btnback = new JButton("Back");
        btnback.setForeground(Color.white);
        btnback.setFont(new Font("Tahoma",Font.BOLD,13));
        btnback.setBounds(700,430,120,50);
        btnback.setBackground(Color.BLACK);
        background.add(btnback);
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserLoged.main(new String[]{});
                frame.dispose();

            }
        });

    }
}
