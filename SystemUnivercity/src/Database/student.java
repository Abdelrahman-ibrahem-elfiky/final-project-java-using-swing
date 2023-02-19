package Database;

import contaner.StudentContaner;
import java.sql.*;
import java.util.ArrayList;

public class student {

    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/systemunivercity","dbabdo","dbabdo");
    }

    public static void InsertStudent(String f_name,String l_name,String address,String department) throws SQLException {

        try {
            Connection connection=Connect();
            PreparedStatement ps=connection.prepareStatement("insert into student (f_name,l_name,address,department) value(?,?,?,?)");
            ps.setString(1,f_name);
            ps.setString(2,l_name);
            ps.setString(3,address);
            ps.setString(4,department);
            ps.execute();
        }catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<StudentContaner> GetDataStudent() throws SQLException {
        ArrayList<StudentContaner>Data=new ArrayList<>();

        try {
            Connection connection=Connect();
            String dep=sign.x;
            PreparedStatement ps=connection.prepareStatement("select* from student where department='"+dep+"' ");
            ResultSet rs= ps.executeQuery();
            while (rs.next())
            {
                StudentContaner sc=new StudentContaner(rs.getInt("Id"),rs.getString("f_name"),rs.getString("l_name"),rs.getString("address"),rs.getString("department"));
                Data.add(sc);
            }
        }catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return Data;

    }
}
