package SystemUnivercity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class first_screan extends JFrame implements ActionListener {
    image image1=new image();
    JLabel l_username,l_password,message;
    JTextField t_username;
    JPasswordField t_password;
    JButton sign_in,sign_up;
    public first_screan()
    {
        setting_screan();
        label();
        text();
        button();

    }
    public void setting_screan()
    {
        this.setTitle("System Univercity");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(400,250);
        this.add(image1);
    }
    public void label()
    {
        message=new JLabel("welcome in system university");
        l_username=new JLabel("Username");
        l_password=new JLabel("Password");
        l_username.setBounds(50,100,100,100);
        l_password.setBounds(50,150,100,100);
        message.setBounds(250,50,250,100);
        message.setForeground(Color.cyan);
        l_username.setForeground(Color.cyan);
        l_password.setForeground(Color.cyan);
        image1.add(l_username);image1.add(l_password);image1.add(message);
    }
    public void text()
    {
        t_username=new JTextField();
        t_password=new JPasswordField();
        t_username.setBounds(150,140,150,20);
        t_password.setBounds(150,190,150,20);
        image1.add(t_username);image1.add(t_password);
    }
    public void button()
    {
        sign_in=new JButton("sign in");
        sign_up=new JButton("sign up");
        sign_in.setBounds(50,250,100,30);
        sign_up.setBounds(200,250,100,30);
        sign_in.setBackground(Color.cyan);
        sign_up.setBackground(Color.cyan);
        image1.add(sign_in);image1.add(sign_up);
        sign_up.addActionListener(this);
        sign_in.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==sign_in)
        {
            try {
                String result=Database.sign.CheckUser(t_username.getText(),t_password.getText());
                if (result=="true")
                {
                    this.dispose();
                    new DoctorScreen();
                }
                if(result=="not password")
                {
                    JOptionPane.showMessageDialog(null,"Password is wrong","Message",JOptionPane.INFORMATION_MESSAGE);

                }
                if(result=="false")
                {
                    JOptionPane.showMessageDialog(null,"Username is wrong","Message",JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
        if (e.getSource()==sign_up)
        {
            this.dispose();
            new secand_screan();
        }
    }
}
