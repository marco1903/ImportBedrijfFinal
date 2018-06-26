package sr.unasat.jdbc.ImportBedrijfFinal.repositories;

import sr.unasat.jdbc.ImportBedrijfFinal.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private Connection connection;

    public CustomerRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost/Import_Bedrijf";
            String USER = "root";
            String PASS = "12345678";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("\n**************************************************************************************" +
                    "\nSuccesfully connected with database (Customer): " + connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> findAllRecords() {
        List<Customer> customerList = new ArrayList<Customer>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from customer";
            ResultSet rs = stmt.executeQuery(sql);
           // System.out.println("resultset: " + rs);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int customer_id = rs.getInt("customer_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String street_name = rs.getString("street_name");
                String house_number = rs.getString("house_number");
                String identification_number = rs.getString("identification_number");
                String mobile_number = rs.getString("mobile_number");

                customerList.add(new Customer(customer_id, first_name, last_name, street_name, house_number, identification_number, mobile_number));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return customerList;
    }

    public int insertRecord(Customer customer) {
        //Connection connection = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "INSERT INTO customer values (?, ?, ?, ?, ?, ?, ? )";
                    //"insert into customer (first_name) values(?)";
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, customer.getCustomer_id());
            stmt.setString(2, customer.getFirst_name());
            stmt.setString(3, customer.getLast_name());
            stmt.setString(4, customer.getStreet_name());
            stmt.setString(5, customer.getHouse_number());
            stmt.setString(6, customer.getIdentification_number());
            stmt.setString(7, customer.getMobile_number());
            result = stmt.executeUpdate();
            stmt.close();
            connection.close();
            //System.out.println("resultset: " + result);
            System.out.println("\nRecord added in Customer table!");

        } catch (SQLException e) {

        } finally {
            try {
                if (stmt!=null)
                    connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public int deleteRecord(Customer customer){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM customer WHERE customer.customer_id = ? ";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, customer.getCustomer_id());
            result = stmt.executeUpdate();
            System.out.println("\nDeleted record with Customer ID: " + customer.getCustomer_id());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int updateRecord(Customer customer){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "UPDATE customer SET customer.mobile_number = ? WHERE customer.customer_id = ? ";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, customer.getMobile_number());
            stmt.setInt(2, customer.getCustomer_id());
            result = stmt.executeUpdate();
            System.out.println("\nUpdated Customer mobile number!");

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

}
