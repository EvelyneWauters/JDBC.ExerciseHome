package ca.flixxi;

import java.sql.*;

/**
 * Created by Flyne on 14/06/2015.
 */
public class M5Batch {
    public static void main(String[] args) {
        Connection c = null;

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitsies", "root", "root");
            try {
                c.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            PreparedStatement pst = c.prepareStatement("insert into kitties (id, name, age, color) values (?,'Sookie',1,'sealpoint' ");     //deze input wordt niet toegevoegd?
            pst.setInt(1,8);
           Statement st = c.createStatement();
           ResultSet rs = st.executeQuery("select name,color from kitties");
            c.commit();
            while(rs.next())    {
                System.out.println("name: " + rs.getString("name")+ " color: " + rs.getString("color"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally   {
            if (c != null)  {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
