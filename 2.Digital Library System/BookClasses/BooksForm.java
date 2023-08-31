package BookClasses;

import AdminClasses.AdminLoged;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BooksForm extends JFrame {

    static BooksForm frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;



    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new BooksForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BooksForm() {

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setBounds(200, 80, 880, 550);


        ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/JuicyOrange.jpg"));
        Image scalebgImg = bgImg.getImage().getScaledInstance(880,550,Image.SCALE_DEFAULT);
        ImageIcon newbgImg= new ImageIcon(scalebgImg);

        JLabel background = new JLabel();
        background.setBounds(0,0,880,550);
        background.setIcon(newbgImg);
        background.setOpaque(true);
        add(background);

        ImageIcon Img22 = new ImageIcon(ClassLoader.getSystemResource("img/Img22.jpg"));
        Image scaleImg22 = Img22.getImage().getScaledInstance(400,455,Image.SCALE_DEFAULT);
        ImageIcon newImg22 = new ImageIcon(scaleImg22);
        JLabel lblImg22 = new JLabel();
        lblImg22.setBounds(25,28,400,455);
        lblImg22.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        lblImg22.setIcon(newImg22);
        background.add(lblImg22);

        JLabel lblAddBooks = new JLabel("Add Books");
        lblAddBooks.setForeground(Color.BLACK);
        lblAddBooks.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblAddBooks.setBounds(560,5,200,60);
        background.add(lblAddBooks);


        JLabel lblCallNo = new JLabel("Call No:");
        lblCallNo.setBounds(455,85,100,50);
        lblCallNo.setFont(new Font("Tahoma", Font.BOLD, 23));
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(600,90,200,34);
        background.add(textField);
        background.add(lblCallNo);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(455,150,100,50);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 23));
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(600,155,200,34);
        background.add(textField_1);
        background.add(lblName);

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(455,215,100,50);
        lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 23));
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(600,220,200,34);
        background.add(textField_2);
        background.add(lblAuthor);

        JLabel lblPublisher = new JLabel("Publisher:");
        lblPublisher.setBounds(455,275,150,50);
        lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 23));
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(600,280,200,34);
        background.add(textField_3);
        background.add(lblPublisher);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(455,335,120,50);
        lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 23));
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(600,340,200,34);
        background.add(textField_4);
        background.add(lblQuantity);


        JButton btnAddBooks = new JButton("Add Books");
        btnAddBooks.setBounds(470, 425, 120, 50);
        btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddBooks.setBackground(new Color(55, 55, 55));
        btnAddBooks.setForeground(Color.white);
        background.add(btnAddBooks);
        btnAddBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    String bookCallNo = textField.getText();
                    String bookName = textField_1.getText();
                    String author = textField_2.getText();
                    String publisher = textField_3.getText();
                    String squantity = textField_4.getText();
                    int quantity = Integer.parseInt(squantity);

                    int i = BookDoc.save(bookCallNo, bookName, author, publisher, quantity);

                    if (i > 0) {

                        JOptionPane.showMessageDialog(BooksForm.this, "Books added successfully!");
                        AdminLoged.main(new String[]{});
                        frame.dispose();

                    } else {
                        JOptionPane.showMessageDialog(BooksForm.this, "Sorry, unable to save!");
                    }
                }
            });


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(665,425,120,50);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBackground(new Color(55,55,55));
        btnBack.setForeground(Color.white);
        background.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  AdminLoged.main(new String[]{});
                  frame.dispose();
            }
         });

    }

}
