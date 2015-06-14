package ca.flixxi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flyne on 14/06/2015.
 */
public class M2StatementInList {
    public static void main(String[] args) {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitsies",
                    "root",
                    "root");

            //create a statement object & put them in a List of Cats
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from kitties");
            List<Cat> k = new ArrayList<Cat>();
            while (rs.next()) {
                k.add(new Cat(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("color")));
            }
            for (Cat cat : k) {
                System.out.println(cat);
            }
        } catch (SQLException e) {

        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
