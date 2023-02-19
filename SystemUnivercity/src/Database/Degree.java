package Database;

import contaner.DegreeContaner;

import java.sql.*;
import java.util.ArrayList;

public class Degree {
    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/systemunivercity","dbabdo","dbabdo");
    }

    public static void InsertDegree(int id,int m1,int m2,int m3,int m4,int m5,int m6)
    {
        try {
            PreparedStatement ps=Connect().prepareStatement("insert into degree value (?,?,?,?,?,?,?,?)");
            ps.setInt(1,id);
            ps.setInt(2,m1);
            ps.setInt(3,m2);
            ps.setInt(4,m3);
            ps.setInt(5,m4);
            ps.setInt(6,m5);
            ps.setInt(7,m6);
            ps.setInt(8,m1+m2+m3+m4+m5+m6);
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public ArrayList<DegreeContaner> GetDegree()
    {
        ArrayList<DegreeContaner> degree=new ArrayList<>();
        try{
            PreparedStatement ps= Connect().prepareStatement("select* from degree");
            ResultSet rs= ps.executeQuery();
            while (rs.next())
            {
                DegreeContaner d=new DegreeContaner(rs.getInt("Id"),rs.getInt("m1")
                        ,rs.getInt("m2"),rs.getInt("m3"),rs.getInt("m4")
                        ,rs.getInt("m5"),rs.getInt("m6"),rs.getInt("total"));
                degree.add(d);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return degree;
    }
}
