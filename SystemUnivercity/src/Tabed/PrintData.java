package Tabed;

import contaner.DataContaner;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class PrintData extends JPanel implements ActionListener {
    private ImageIcon icon;
    JTable table2;
    JScrollPane sp;
    String colums[]={"FirstName","LastName","Department","Total Degree"};
    ArrayList<DataContaner> DataStudent= Database.StudentData.GetStudentData();
    String [][] data;
    JButton print;
    public PrintData()
    {
        show_table();
        print=new JButton("Print");
        print.setBounds(300,500,50,20);
        print.setBackground(Color.cyan);
        this.add(print);

        print.addActionListener(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        icon=new ImageIcon(getClass().getResource("..\\images\\image1.jpg"));
        icon.paintIcon(this,g,0,0);
    }

    public void show_table()
    {
        data=new String[DataStudent.size()][4];
        for (int i=0;i<DataStudent.size();i++)
        {
            data[i][0]=""+DataStudent.get(i).getF_name();
            data[i][1]=""+DataStudent.get(i).getL_name();
            data[i][2]=""+DataStudent.get(i).getDepartment();
            data[i][3]=""+DataStudent.get(i).getTotal();

        }
        table2=new JTable(data,colums);
        sp=new JScrollPane(table2);
        sp.setBounds(0,0,400,200);
        //scrollPane.add(table);
        this.add(sp);
        //CENTER TEXT
        ((DefaultTableCellRenderer) table2.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer setting=new DefaultTableCellRenderer();
        setting.setHorizontalAlignment(JLabel.CENTER);
        table2.getColumnModel().getColumn(0).setCellRenderer(setting);
        for (int i=0;i<table2.getColumnCount();i++)
        {
            table2.getColumnModel().getColumn(i).setCellRenderer(setting);
        }
        //arabic or english
        table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //EVENT
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //EventTable(e);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MessageFormat h=new MessageFormat("Student Degree");
        MessageFormat t=new MessageFormat("page 1");
        try {
            table2.print(JTable.PrintMode.NORMAL,h,t);
        } catch (PrinterException ex) {
        System.out.println(ex.getMessage());
        }
    }
}
