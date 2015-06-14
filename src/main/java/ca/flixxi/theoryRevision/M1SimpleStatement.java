package ca.flixxi.theoryRevision;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class M1SimpleStatement {
    public static void main(String[] args) throws SQLException {
        //Load the driver -> Mavenmagic?

        //Establish the connection:
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitsies",
                                                    "root",
                                                    "root");
        //create a statement object
        Statement st = c.createStatement();
        ResultSet resultSet = st.executeQuery("select * from kitties");
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String color = resultSet.getString("color");
            System.out.println(id + " " + name + " "+ age + " " + color );
        }

        //close the connection
        c.close();

        }
    }

