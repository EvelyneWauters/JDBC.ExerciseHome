package ca.flixxi;

import java.sql.*;

/**
 * Created by Flyne on 14/06/2015.
 */
public class M4PreparedStatement {
    public static void main(String[] args) {
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitsies","root","root");
            pstmt = c.prepareStatement("select * from kitties where id = ?");
            pstmt.setInt(1,2);
//            pstmt.execute();

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())    {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + " " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }  finally  {
            if (c != null)  {
                try {
                    pstmt.close();
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
