package Database;

import contaner.DataContaner;

import java.sql.*;
import java.util.ArrayList;

public class StudentData {
    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/systemunivercity","dbabdo","dbabdo");
    }
    public static ArrayList<DataContaner> GetStudentData()
    {
        ArrayList<DataContaner>data=new ArrayList<>();
        String dep=sign.x;
        try (
                Connection connection=Connect();
                PreparedStatement ps=connection.prepareStatement("SELECT student.Id,student.f_name,student.l_name,student.department,degree.total FROM student INNER JOIN degree ON degree.Id=student.Id  WHERE student.department='"+dep+"'");
                ResultSet rs=ps.executeQuery();
        )
        {
            while (rs.next())
            {
                DataContaner dataContaner=new DataContaner(rs.getString("f_name"),rs.getString("l_name"), rs.getString("department"), rs.getInt("total"));
                data.add(dataContaner);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;

    }
}
