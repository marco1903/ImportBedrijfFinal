package sr.unasat.jdbc.ImportBedrijfFinal.repositories;

import sr.unasat.jdbc.ImportBedrijfFinal.entities.Store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
    private Connection connection;

    public StoreRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost/Import_Bedrijf";
            String USER = "root";
            String PASS = "12345678";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("\n************************************************************************************" +
                    "\nSuccessfully connected with database (Store): " + connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Store> findAllRecords() {
        List<Store> storeList = new ArrayList<Store>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from store";
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set

            while (rs.next()) {
                //Retrieve by column name
                int store_id = rs.getInt("store_id");
                String name = rs.getString("name");
                String website = rs.getString("website");
                String email = rs.getString("email");
                String street_name = rs.getString("street_name");

                storeList.add(new Store(store_id, name, website, email, street_name));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return storeList;
    }

    public int insertRecord(Store store) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into store values(?, ?, ?, ?, ? )";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, store.getStore_id());
            stmt.setString(2, store.getName());
            stmt.setString(3, store.getWebsite());
            stmt.setString(4, store.getEmail());
            stmt.setString(5, store.getStreet_name());
            result = stmt.executeUpdate();
            //System.out.println("resultset: " + result);
            System.out.println("\nRecord added in Store table!");

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteRecord(Store store){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM store WHERE store.store_id = ? ";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, store.getStore_id());
            result = stmt.executeUpdate();
            System.out.println("\nDeleted record with Store ID: " + store.getStore_id());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}
