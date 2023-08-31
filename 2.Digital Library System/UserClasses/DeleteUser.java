package UserClasses;

import AdminClasses.AdminLoged;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUser extends JFrame {
    static DeleteUser frame;
    private JTextField textField;

    public  JLabel background;


    public static void main(String[] args) {
             EventQueue.invokeLater(new Runnable() {
                  public void run() {

                        try {
                          frame = new DeleteUser();
                          frame.setVisible(true);

                        } catch (Exception e) {
                             e.printStackTrace();
                        }
            }
        });
    }

    public DeleteUser() {


        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 880, 550);

        ImageIcon headImg = new ImageIcon(ClassLoader.getSystemResource("img/Bg.jpg"));
        Image image = headImg.getImage().getScaledInstance(880, 550, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image);
        background = new JLabel();
        background.setIcon(image2);
        background.setBounds(0, 0, 880, 550);
        add(background);

        JLabel lblDelete = new JLabel("Delete User");
        lblDelete.setBounds(390,85,150,40);
        lblDelete.setForeground(Color.DARK_GRAY);
        lblDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
        background.add(lblDelete);

        JLabel lblEnterId = new JLabel("Enter Id:");
        lblEnterId.setFont(new Font("Tahoma",Font.BOLD,22));
        lblEnterId.setBounds(300,180,130,40);
        background.add(lblEnterId);
        textField = new JTextField();
        textField.setBounds(445,180,180,35);
        textField.setColumns(10);
        background.add(textField);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDelete.setBackground(new Color(123,180,100));
        btnDelete.setBounds(320,430,150,50);
        background.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {

                String uid = textField.getText();


                if (uid == null || uid.trim().equals("")) {

                      JOptionPane.showMessageDialog(DeleteUser.this, "Id can't be blank");

                } else {

                         int id = Integer.parseInt(uid);
                         int i = UserDoc.delete(id);

                    if (i > 0) {
                        JOptionPane.showMessageDialog(DeleteUser.this, "Record deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(DeleteUser.this, "Unable to delete given id!");
                    }
                }
            }
        });


        JButton btnNewButton = new JButton("Back");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setBackground(new Color(100,100,100));
        btnNewButton.setBounds(520,430,145,50);
        background.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminLoged.main(new String[]{});
                frame.dispose();
            }
        });

    }

}