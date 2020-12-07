/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamiccheeseapp;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 *
 * @author samnishita
 */
public class CheeseModel {

    private HashMap<Integer, ArrayList<Cheese>> cheeseData = new HashMap();
    private String jdbc;
    private String username;
    private String password;
    private Connection conn = null;
    private ArrayList<Cheese> cheeseArray;
    private String sql = "SELECT * FROM year_data";
    private ResourceBundle reader;

    public void CheeseModel() {
        this.cheeseArray = new ArrayList();
        //this.cheeseData = new HashMap<Integer, ArrayList<Cheese>>();
    }

    public static Connection getConnection(String url) throws SQLException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void importCheeseData() throws FileNotFoundException {
        try {
            reader = ResourceBundle.getBundle("dbproperties");
            jdbc = reader.getString("db.jdbc");
            username = reader.getString("db.username");
            password = reader.getString("db.password");
            System.out.println(jdbc);
            System.out.println(username);
            System.out.println(password);
            conn = DriverManager.getConnection(jdbc, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            try {
                ResultSet rs = conn.createStatement().executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                ArrayList<Cheese> allCheeses = new ArrayList();
                //add cheeses based on names in database
                allCheeses.add(new Cheese("blue"));
                allCheeses.add(new Cheese("cheddar"));
                allCheeses.add(new Cheese("creamneufchatel"));
                allCheeses.add(new Cheese("jack"));
                allCheeses.add(new Cheese("mozzarella"));
                allCheeses.add(new Cheese("muenster"));
                allCheeses.add(new Cheese("processedcheese"));
                allCheeses.add(new Cheese("swiss"));
                //int year = 1970;
                //each row at a time (aka each year)
                while (rs.next()) {
                    ArrayList<Cheese> cheeseRank = new ArrayList<Cheese>();
                    //for each column take the data
                    for (int i = 2; i < 10; i++) {
                        Cheese cheese = null;
                        String columnName = rsmd.getColumnName(i);
                        switch (columnName) {
                            case "blue":
                                cheese = allCheeses.get(0);
                                cheese.setValue(rs.getDouble(5));
                                cheese.getAllValues().add(rs.getDouble(5));
                                break;
                            case "cheddar":
                                cheese = allCheeses.get(1);
                                cheese.setValue(rs.getDouble(2));
                                cheese.getAllValues().add(rs.getDouble(2));
                                break;

                            case "creamneufchatel":
                                cheese = allCheeses.get(2);
                                cheese.setValue(rs.getDouble(7));
                                cheese.getAllValues().add(rs.getDouble(7));
                                break;

                            case "jack":
                                cheese = allCheeses.get(3);
                                cheese.setValue(rs.getDouble(8));
                                cheese.getAllValues().add(rs.getDouble(8));
                                break;

                            case "mozzarella":
                                cheese = allCheeses.get(4);
                                cheese.setValue(rs.getDouble(3));
                                cheese.getAllValues().add(rs.getDouble(3));
                                break;

                            case "muenster":
                                cheese = allCheeses.get(5);
                                cheese.setValue(rs.getDouble(6));
                                cheese.getAllValues().add(rs.getDouble(6));
                                break;

                            case "processedcheese":
                                cheese = allCheeses.get(6);
                                cheese.setValue(rs.getDouble(9));
                                cheese.getAllValues().add(rs.getDouble(9));
                                break;

                            case "swiss":
                                cheese = allCheeses.get(7);
                                cheese.setValue(rs.getDouble(4));
                                cheese.getAllValues().add(rs.getDouble(4));
                                break;

                        }
                        //add the cheese to an array to be sorted later
                        cheeseRank.add(cheese);

                    }
                    //sort the array
                    //need to keep cheese.setvalue just for this step
                    Collections.sort(cheeseRank, new Comparator<Cheese>() {
                        @Override
                        public int compare(Cheese a, Cheese b) {
                            return Double.compare(b.getValue(), a.getValue());
                        }
                    });
                    //add cheese's rank to each cheese rank list
                    for (Cheese each : cheeseRank) {

                        each.getAllRanks().add(cheeseRank.indexOf(each) + 1);
                    }
                    //add to hashmap<year,arraylist of cheeses>
                    this.cheeseData.put(rs.getInt(1), cheeseRank);
                    //year++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.err.println("ERROR");
        }

    }

    public HashMap getHashMap() {
        return this.cheeseData;
    }
}
