import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {

     static  HomePage frame;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                  frame = new HomePage();
                  frame.setVisible(true);

            }
        });
    }

    public HomePage()
    {
          setLayout(null);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setBounds(185,60,910,590);
          setTitle("Number Guessing Game");

          ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("img/Purpink.jpg"));
          Image bgScaleImg = bgImg.getImage().getScaledInstance(910,590, Image.SCALE_DEFAULT);
          ImageIcon bgNewImg = new ImageIcon(bgScaleImg);

          JLabel bg = new JLabel();
          bg.setBounds(0,0,910,590);
          bg.setIcon(bgNewImg);
          add(bg);

          ImageIcon homeImg = new ImageIcon(ClassLoader.getSystemResource("img/Home.png"));
          Image scaleImg = homeImg.getImage().getScaledInstance(820,480, Image.SCALE_DEFAULT);
          ImageIcon newImg = new ImageIcon(scaleImg);

          JLabel home = new JLabel();
          home.setForeground(Color.WHITE);
          home.setBounds(38,38,820,480);
          home.setIcon(newImg);
          bg.add(home);


          JButton btnHome = new JButton("Play");
          btnHome.setFont(new Font("Comic Sans MS",Font.BOLD,30));
          btnHome.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
          btnHome.setBackground(new Color(210, 125, 45));
          btnHome.setBounds(320,350,185,65);
          home.add(btnHome);

          btnHome.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                      GamePage.main( new String[]{});
                      frame.dispose();
              }
          });



    }
}
