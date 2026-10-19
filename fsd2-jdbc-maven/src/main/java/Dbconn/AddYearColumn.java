package Dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddYearColumn {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/FREEPDB1",
                    "shoaib",
                    "system"
            );

            Statement st = con.createStatement();

            // Add the year column to the students table
            String sql = "ALTER TABLE students ADD year NUMBER";
            st.executeUpdate(sql);

            System.out.println("Year column added successfully to students table!");

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
