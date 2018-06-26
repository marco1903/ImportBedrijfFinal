package sr.unasat.jdbc.ImportBedrijfFinal.repositories;

import sr.unasat.jdbc.ImportBedrijfFinal.entities.Customer;
import sr.unasat.jdbc.ImportBedrijfFinal.entities.Orders;
import sr.unasat.jdbc.ImportBedrijfFinal.entities.Store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersRepository {
    private Connection connection;
    public OrdersRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost/Import_Bedrijf";
            String USER = "root";
            String PASS = "12345678";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("\n**************************************************************************************" +
                    "\nSuccesfully connected with database (Orders): " + connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Orders> findAllRecords() {
        List<Orders> ordersList = new ArrayList<Orders>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "SELECT o.order_id, o.item, o.quantity, o.order_number, o.purchase_date, o.customer_id, o.store_id, cus.customer_id cuscustomerid, cus.first_name cusfirstname, cus.last_name cuslastname, cus.street_name cusstreetname, cus.house_number cushousenumber, cus.identification_number cusidnumber, cus.mobile_number cusmobilenumber, s.store_id sstoreid, s.name sname, s.website swebsite, s.email semail, s.street_name sstreetname " +
                    "FROM orders o " +
                    "JOIN customer cus " +
                    "ON cus.customer_id = o.customer_id " +
                    "JOIN store s " +
                    "ON s.store_id = o.store_id ";// +
                    //"WHERE o.order_id = 1";

            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println("resultset: " + rs);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int order_id = rs.getInt("order_id");
                String item = rs.getString("item");
                int quantity = rs.getInt("quantity");
                int order_number = rs.getInt("order_number");
                String purchase_date = rs.getString("purchase_date");
                int o_customer_id = rs.getInt("o.customer_id");
                int o_store_id = rs.getInt("o.store_id");


                int customer_id = rs.getInt("cuscustomerid");
                String first_name = rs.getString("cusfirstname");
                String last_name = rs.getString("cuslastname");
                String street_name_customer = rs.getString("cusstreetname");
                String house_number = rs.getString("cushousenumber");
                String identification_number = rs.getString("cusidnumber");
                String mobile_number = rs.getString("cusmobilenumber");
                Customer customer = new Customer(customer_id, first_name, last_name, street_name_customer, house_number, identification_number, mobile_number);


                int store_id = rs.getInt("sstoreid");
                String name = rs.getString("sname");
                String website = rs.getString("swebsite");
                String email = rs.getString("semail");
                String street_name_store = rs.getString("sstreetname");
                Store store = new Store(store_id, name, website, email, street_name_store);

                ordersList.add(new Orders(order_id, item, quantity, order_number, purchase_date, customer, store));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return ordersList;
    }


    public int updateRecords(Orders order) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = /*"update orders o " +
                         "join customer cus on cus.customer_id = o.customer_id " +
                         "join store s on s.store_id = o.store_id " +
                         "set o.customer_id = ?, o.store_ id = ? where o.quantity = ?";*/
                        "update orders o " +
                                "set o.customer_id = ?, o.store_id = ? where o.quantity = ?";

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getQuantity());
            stmt.setInt(2, order.getCustomer().getCustomer_id());
            stmt.setInt(3, order.getStore().getStore_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);
            System.out.println("Orders records updated!");

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public Orders findRecord(String items, int orQuantity) {
        Orders orders = null;
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT or.id, or.quantity, or.item, cus.customer_id cusid, cus.last_name cuslastname, s.store_id sid, s.name sname" +
                    "FROM orders or " +
                    "JOIN customer cus " +
                    "ON cus.customer_id = or.customer_id " +
                    "JOIN store s " +
                    "ON s.store_id = or.store_id " +
                    "WHERE or.items = ? or or.quantity = ? ";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, items);
            stmt.setInt(2, orQuantity);
            ResultSet rs = stmt.executeQuery();
            System.out.println("resultset: " + rs);

            if (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                String item = rs.getString("item");

                int cusid = rs.getInt("cusid");
                String customerName = rs.getString("cuslastname");
                Customer customer = new Customer(cusid, customerName);

                int sid = rs.getInt("sid");
                String storeName = rs.getString("sname");
                Store store = new Store(sid, storeName);

                orders = new Orders(id, quantity, item, customer, store);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return orders;

    }
    public int deleteOneRecord(Orders orders){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE orders " +
                    "FROM orders o " +
                    "JOIN customer cus " +
                    "ON cus.customer_id = o.customer_id " +
                    "JOIN store s " +
                    "ON s.store_id = o.store_id " +
                    " WHERE o.order_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, orders.getOrder_id());
            stmt.setInt(2, orders.getCustomer().getCustomer_id());
            stmt.setInt(3, orders.getStore().getStore_id());
            result = stmt.executeUpdate();
            System.out.println("\nDeleted record with Order ID: " + orders.getOrder_id());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}
