package Tabed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import SystemUnivercity.image;
public class Add extends JPanel  implements ActionListener {
    private ImageIcon icon;
    JLabel f_name,l_name,address,department,message;
    JTextField tf_name,tl_name,taddress,tdepartment;
    JButton add;
    public Add()
    {
        label();
        text();
        button();
        this.setLayout(null);
        add.addActionListener(this);
    }
    public void label()
    {
        message=new JLabel("Add New Student");
        f_name=new JLabel("First Name");
        l_name=new JLabel("Last Name");
        address=new JLabel("Address");
        department=new JLabel("Department");
        message.setBounds(250,50,250,100);
        f_name.setBounds(50,100,100,100);
        l_name.setBounds(50,150,100,100);
        address.setBounds(50,200,100,100);
        department.setBounds(50,250,100,100);
        message.setForeground(Color.cyan);
        f_name.setForeground(Color.cyan);
        l_name.setForeground(Color.cyan);
        address.setForeground(Color.cyan);
        department.setForeground(Color.cyan);
        this.add(f_name);this.add(l_name);this.add(address);this.add(department);
        this.add(message);

    }
    public void text()
    {
        tf_name=new JTextField();
        tl_name=new JTextField();
        taddress=new JTextField();
        tdepartment=new JTextField();
        tf_name.setBounds(150,140,150,20);
        tl_name.setBounds(150,190,150,20);
        taddress.setBounds(150,240,150,20);
        tdepartment.setBounds(150,290,150,20);
        this.add(tf_name);this.add(tl_name);this.add(taddress);this.add(tdepartment);

    }
    public void button()
    {
        add=new JButton("Add");
        add.setBackground(Color.cyan);
        add.setBounds(100,350,120,30);
        this.add(add);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        icon=new ImageIcon(getClass().getResource("..\\images\\image1.jpg"));
        icon.paintIcon(this,g,0,0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add)
        {
            try {
                Database.student.InsertStudent(tf_name.getText(), tl_name.getText(),taddress.getText(),tdepartment.getText());
                    JOptionPane.showMessageDialog(null,"Done Add New Student","Student",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
    }
}
