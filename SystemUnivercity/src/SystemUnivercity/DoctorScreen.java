package SystemUnivercity;

import Tabed.Add;
import Tabed.Degree;
import Tabed.PrintData;
import Tabed.UpdataStudent;

import javax.swing.*;
import java.sql.SQLException;

public class DoctorScreen extends JFrame {
    JTabbedPane TabALL=new JTabbedPane();
    Tabed.Add add=new Add();
    Tabed.Degree degree=new Degree();
    Tabed.PrintData printData=new PrintData();
    Tabed.UpdataStudent updataStudent=new UpdataStudent();
    public DoctorScreen() throws SQLException {
        setting_screan();
        ShowTabbed();
    }
    public void setting_screan()
    {
        this.setTitle("Welcome Doctor");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(400,250);

    }
    public void ShowTabbed()
    {
        TabALL.addTab("Add Student",add);
        TabALL.addTab("Add Degree",degree);
        TabALL.addTab("Print Data",printData);
        TabALL.addTab("Updat Student",updataStudent);
        //add frame
        this.add(TabALL);
    }
}
