package Tabed;

import contaner.StudentContaner;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdataStudent extends JPanel implements ActionListener {
    private ImageIcon icon;
    private int id;
    JLabel f_name,l_name,address,department;

    JTextField tf_name,tl_name,taddress,tdepartment;
    JButton updata ,refresh;
    //table
    JTable table;
    JScrollPane scrollPane;
    String column[]={"Id","FirstName","LastName","Adderss","Department"};
    ArrayList<StudentContaner> info=Database.student.GetDataStudent();
    String [][] data;
    public UpdataStudent() throws SQLException {
        this.setLayout(null);
        label();
        text();
        button();
        show_table();
        updata.addActionListener(this);
        refresh.addActionListener(this);


    }

    public void label()
    {
        f_name=new JLabel("First Name");
        l_name=new JLabel("Last Name");
        address=new JLabel("Address");
        department=new JLabel("Department");
        f_name.setBounds(50,50,100,100);
        l_name.setBounds(50,100,100,100);
        address.setBounds(50,150,100,100);
        department.setBounds(50,200,100,100);

        f_name.setForeground(Color.cyan);
        l_name.setForeground(Color.cyan);
        address.setForeground(Color.cyan);
        department.setForeground(Color.cyan);

        this.add(f_name);this.add(l_name);this.add(address);this.add(department);



    }
    public void text()
    {
        tf_name=new JTextField();
        tl_name=new JTextField();
        taddress=new JTextField();
        tdepartment=new JTextField();

        tf_name.setBounds(150,90,100,20);
        tl_name.setBounds(150,140,100,20);
        taddress.setBounds(150,190,100,20);
        tdepartment.setBounds(150,240,100,20);

        this.add(tf_name);this.add(tl_name);this.add(taddress);this.add(tdepartment);
    }
    public void button()
    {
        updata=new JButton("Update");
        refresh=new JButton("refresh");
        updata.setBackground(Color.cyan);
        updata.setBounds(100,500,120,30);
        refresh.setBackground(Color.cyan);
        refresh.setBounds(250,500,120,30);
        this.add(updata);this.add(refresh);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        icon=new ImageIcon(getClass().getResource("..\\images\\image1.jpg"));
        icon.paintIcon(this,g,0,0);
    }

    //table
    public void show_table()
    {
        data=new String[info.size()][5];
        for (int i=0;i<info.size();i++)
        {
            data[i][0]=""+info.get(i).getId();
            data[i][1]=""+info.get(i).getF_name();
            data[i][2]=""+info.get(i).getL_name();
            data[i][3]=""+info.get(i).getAddress();
            data[i][4]=""+info.get(i).getDepartment();
        }
        table=new JTable(data,column);
        scrollPane=new JScrollPane(table);
        scrollPane.setBounds(280,90,400,200);
        this.add(scrollPane);

        //CENTER TEXT
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer setting=new DefaultTableCellRenderer();
        setting.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(setting);
        for (int i=0;i<table.getColumnCount();i++)
        {
            table.getColumnModel().getColumn(i).setCellRenderer(setting);
        }
        //arabic or english
        table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //EVENT
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventTable(e);
            }
        });
    }
    private void EventTable(MouseEvent e)
    {
        int row=table.getSelectedRow();
        id=info.get(row).getId();
        tf_name.setText(info.get(row).getF_name());
        tl_name.setText(info.get(row).getL_name());
        taddress.setText(info.get(row).getAddress());
        tdepartment.setText(info.get(row).getDepartment());
    }
    public void setUpdata() throws SQLException {
        Connection con=Database.sign.Connect();
        PreparedStatement ps=con.prepareStatement("UPDATE student SET f_name='"+tf_name.getText()+"',l_name='"+tl_name.getText()+"',address='"+taddress.getText()+"',department='"+tdepartment.getText()+"' WHERE Id='"+id+"'");
            ps.execute();
            show_table();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==updata)
        {
            try {
                setUpdata();
                JOptionPane.showMessageDialog(null,"Inserted","message",JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
            }

        }

    }
}
