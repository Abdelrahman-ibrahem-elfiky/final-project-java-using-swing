package Tabed;

import contaner.StudentContaner;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class Degree extends JPanel implements ActionListener {
    private ImageIcon icon;
    private int id;
    JLabel ID,M1,M2,M3,M4,M5,M6;

    JTextField tID,tM1,tM2,tM3,tM4,tM5,tM6;
    JButton submit;
    //table
    JTable table;
    JScrollPane scrollPane;
    String column[]={"Id","FirstName","LastName","Adderss","Department"};
    ArrayList<StudentContaner> info=Database.student.GetDataStudent();
    String [][] data;
    public Degree() throws SQLException {

        this.setBackground(Color.black);
        label();
        text();
        button();
        show_table();
        this.setLayout(null);
        submit.addActionListener(this);

    }

    public void label()
    {
        ID=new JLabel("ID");
        M1=new JLabel("Java");
        M2=new JLabel("Python");
        M3=new JLabel("Database");
        M4=new JLabel("Logic");
        M5=new JLabel("oop");
        M6=new JLabel("Software");

        ID.setBounds(50,50,100,100);
        M1.setBounds(50,100,100,100);
        M2.setBounds(50,150,100,100);
        M3.setBounds(50,200,100,100);
        M4.setBounds(50,250,100,100);
        M5.setBounds(50,300,100,100);
        M6.setBounds(50,350,100,100);

       ID.setForeground(Color.cyan);
       M1.setForeground(Color.cyan);
       M2.setForeground(Color.cyan);
       M3.setForeground(Color.cyan);
       M4.setForeground(Color.cyan);
       M5.setForeground(Color.cyan);
       M6.setForeground(Color.cyan);
    this.add(ID);this.add(M1);this.add(M2);this.add(M3);
     this.add(M4);this.add(M5);this.add(M6);


    }
    public void text()
    {
       tID=new JTextField();
       tM1=new JTextField();
       tM2=new JTextField();
       tM3=new JTextField();
       tM4=new JTextField();
       tM5=new JTextField();
       tM6=new JTextField();

        tID.setBounds(150,90,100,20);
        tM1.setBounds(150,140,100,20);
        tM2.setBounds(150,190,100,20);
        tM3.setBounds(150,240,100,20);
        tM4.setBounds(150,290,100,20);
        tM5.setBounds(150,340,100,20);
        tM6.setBounds(150,390,100,20);
        this.add(tID);this.add(tM1);this.add(tM2);this.add(tM3);
        this.add(tM4);this.add(tM5);this.add(tM6);
    }
    public void button()
    {
        submit=new JButton("Submit");
        submit.setBackground(Color.cyan);
        submit.setBounds(100,500,120,30);
        this.add(submit);
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
               /* for (int j=0;j<3;j++)
               {
                   data[i][j]= ""+(info.get(i).getId());
                   data[i][j]= info.get(i).getUsername();
                   data[i][j]= info.get(i).getPassword();
               }

                */
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
       tID.setText(String.valueOf(id));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            /*
            my idea but your idea good
            int total=Integer.parseInt(tM1.getText())+Integer.parseInt(tM2.getText())+
                     Integer.parseInt(tM3.getText())+Integer.parseInt(tM4.getText())+
                     Integer.parseInt(tM5.getText())+Integer.parseInt(tM6.getText());
             */
            try {
                Database.Degree.InsertDegree(Integer.parseInt(tID.getText()),Integer.parseInt(tM1.getText()),
                        Integer.parseInt(tM2.getText()),Integer.parseInt(tM3.getText()),Integer.parseInt(tM4.getText()),
                        Integer.parseInt(tM5.getText()),Integer.parseInt(tM6.getText()));
                JOptionPane.showMessageDialog(null,"Done","message",JOptionPane.INFORMATION_MESSAGE);
                tID.setText("");
                tM1.setText("");
                tM2.setText("");
                tM3.setText("");
                tM4.setText("");
                tM5.setText("");
                tM6.setText("");


            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }


        }
    }
}
