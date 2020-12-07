/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author samnishita
 */
public class Reader {

    public static void main(String[] args) {
        String jdbc = "jdbc:mysql://localhost:3306/cheese";
        String username = "root";
        String password = "BoneAppleTea2020";
        Connection conn = null;

        String csvName = "src/main/resources/datcsvs/cheese_per_cap 1970 CSV.csv";
        String csvName2 = "src/main/resources/datcsvs/cheese_per_cap 1995 CSV.csv";
        String line = "";
        String cvsSplit = ",";

        try {
            String sqlInsert = "INSERT INTO year_data (year, cheddar ,mozzarella ,swiss ,blue ,muenster, creamneufchatel ,jack ,processedcheese) VALUES (?,?,?,?,?,?,?,?,?) ";

            //IMPORTANT: PUT DRIVER INTO DEPENDENCIES
            conn = DriverManager.getConnection(jdbc, username, password);
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            try (BufferedReader br = new BufferedReader(new FileReader(csvName))) {

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] cheese = line.split(cvsSplit);
                    stmt.setString(1, cheese[0]);
                    stmt.setString(2, cheese[1]);
                    stmt.setString(3, cheese[7]);
                    stmt.setString(4, cheese[11]);
                    stmt.setString(5, cheese[15]);
                    stmt.setString(6, cheese[13]);
                    stmt.setString(7, cheese[14]);
                    stmt.setString(8, cheese[2]);
                    stmt.setString(9, cheese[19]);
                    stmt.execute();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedReader br = new BufferedReader(new FileReader(csvName2))) {
//
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] cheese = line.split(cvsSplit);
                    stmt.setString(1, cheese[0]);
                    stmt.setString(2, cheese[1]);
                    stmt.setString(3, cheese[4]);
                    stmt.setString(4, cheese[7]);
                    if (cheese[8].equals("NA")) {
                        stmt.setString(5, 0 + "");
                    } else {
                        stmt.setString(5, cheese[8]);
                    }

                    stmt.setString(6, cheese[10]);
                    stmt.setString(7, cheese[11]);
                    stmt.setString(8, cheese[2]);
                    stmt.setString(9, cheese[17]);
                    stmt.execute();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    
    }

    

    public static Connection getConnection(String url) throws SQLException {
        try {
            //Java Database Connectivity (JDBC)

            //Class.forName: load the driver’s class file into memory at the runtime
            Class.forName("com.mysql.jdbc.Driver");
            //DriverManager.getConnection: establish connections
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
