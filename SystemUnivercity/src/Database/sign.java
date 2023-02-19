package Database;

import java.awt.font.FontRenderContext;
import java.sql.*;
import java.util.ArrayList;
import contaner.SingContaner;


public class sign {

    static String x;
    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/systemunivercity","dbabdo","dbabdo");

    }

    public static void Insert(String username,String password,String department) throws SQLException {

       try {
           Connection connection=Connect();
           PreparedStatement ps=connection.prepareStatement("insert into doctors value(?,?,?)");
           ps.setString(1,username);
           ps.setString(2,password);
           ps.setString(3,department);
           ps.execute();
       }catch (SQLException e)
       {
           System.err.println(e.getMessage());
       }
    }

    public static ArrayList<SingContaner> GetData() throws SQLException {
        ArrayList<SingContaner>Data=new ArrayList<>();

       try {
           Connection connection=Connect();
           PreparedStatement ps=connection.prepareStatement("select* from doctors");
           ResultSet rs= ps.executeQuery();
           while (rs.next())
           {
               SingContaner sc=new SingContaner(rs.getString("user_name"),rs.getString("password"),rs.getString("department"));
               Data.add(sc);
           }
       }catch (SQLException e)
       {
           System.err.println(e.getMessage());
       }
       return Data;

    }

    public static String CheckUser(String username,String password) throws SQLException {
        String result="false";
        try {
            Connection connection=Connect();
            ArrayList<SingContaner>check=GetData();
            for (int i=0;i<check.size();i++)
            {
                if (check.get(i).getUsername().equals(username))
                {
                    if (check.get(i).getPassword().equals(password))
                    {
                        result="true";
                         x=check.get(i).getDepartment();
                        break;

                    } else {
                        result="not password";
                        break;
                    }
                } else {
                    result="false";
                }
            }
        }catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return result;

    }






}

