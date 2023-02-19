package SystemUnivercity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Database.sign;
import com.mysql.cj.x.protobuf.MysqlxCrud;

public class secand_screan extends JFrame implements ActionListener {
    image image2=new image();
    JLabel l_username,l_password,l_department,message,note;
    static JTextField  t_username,t_department,t_password;
    JButton send,back;
    public secand_screan()
    {
        setting_screan();
        label();
        text();
        button();
    }
    public void setting_screan()
    {
        this.setTitle("System University");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(400,250);
        this.add(image2);
    }
    public void label()
    {
        message=new JLabel("Welcome..Pleas Register New Doctor");
        l_username=new JLabel("Username");
        l_password=new JLabel("Password");
        l_department=new JLabel("Department");
        note=new JLabel("[ CS/IS/IT ]");
        message.setBounds(150,50,250,100);
        l_username.setBounds(50,100,100,100);
        l_password.setBounds(50,150,100,100);
        l_department.setBounds(50,200,100,100);
        note.setBounds(50,220,100,100);
        message.setForeground(Color.cyan);
        l_username.setForeground(Color.cyan);
        l_password.setForeground(Color.cyan);
        l_department.setForeground(Color.cyan);
        note.setForeground(Color.cyan);
        image2.add(l_username);image2.add(l_password);
        image2.add(message);image2.add(l_department);
        image2.add(note);
    }
    public void text()
    {
        t_username=new JTextField();
        t_password=new JTextField();
        t_department=new JTextField();
        t_username.setBounds(150,140,150,20);
        t_password.setBounds(150,190,150,20);
        t_department.setBounds(150,240,150,20);
        image2.add(t_username);image2.add(t_password);
        image2.add(t_department);
    }
    public void button()
    {
        send=new JButton("Register ");
        back=new JButton("back");
        send.setBounds(100,300,120,30);
        back.setBounds(5,5,100,30);
        back.setBackground(Color.orange);
        send.setBackground(Color.cyan);
        image2.add(send);image2.add(back);
        back.addActionListener(this);
        send.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back)
        {
            this.dispose();
            new first_screan();
        }
        if (e.getSource()==send)
        {
            //insert data
            try {
                String dep=t_department.getText();
                 if (dep.equalsIgnoreCase("cs")||dep.equalsIgnoreCase("is")||dep.equalsIgnoreCase("it"))
                {
                    sign.Insert(t_username.getText(),t_password.getText(),t_department.getText());
                    //back the first screen
                    this.dispose();
                    new first_screan();
                }
                 else{
                     JOptionPane.showMessageDialog(null,"Department is not exist..pleas chosse dep from [CS/IS/IT]","Error Department",JOptionPane.WARNING_MESSAGE);

                 }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
    }

    public static JTextField getT_department() {
        return t_department;
    }
}
