package ca.flixxi.theoryRevision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Flyne on 14/06/2015.
 */
public class M3StatementExUpdate {
    public static void main(String[] args) {
        Connection c  = null;

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitsies", "root", "root");
            Statement st = c.createStatement();
            //st.executeUpdate("insert into kitties (id,name,age,color) values (3,'Diego',1,'lieve tijger')");
            st.executeUpdate("insert into kitties(id,name) values(4,'somethingrandom')");
            st.executeUpdate("delete from kitties where id = 4");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally   {
            if(c!=null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
