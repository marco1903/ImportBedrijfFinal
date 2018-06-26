package sr.unasat.jdbc.ImportBedrijfFinal.app;

import sr.unasat.jdbc.ImportBedrijfFinal.entities.Customer;
import sr.unasat.jdbc.ImportBedrijfFinal.entities.Orders;
import sr.unasat.jdbc.ImportBedrijfFinal.entities.Store;
import sr.unasat.jdbc.ImportBedrijfFinal.repositories.CustomerRepository;
import sr.unasat.jdbc.ImportBedrijfFinal.repositories.OrdersRepository;
import sr.unasat.jdbc.ImportBedrijfFinal.repositories.StoreRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {


        /*CustomerRepository customerRepo = new CustomerRepository();
        List<Customer> customerList = customerRepo.findAllRecords();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }*/

        //int add = customerRepo.insertRecord(new Customer(5,"Edinson", "Cavani", "PSG street", "9", "FF654329M", "+597863207"));
        //int del = customerRepo.deleteRecord(new Customer(11));
        //int updateMobileNumber = customerRepo.updateRecord(new Customer("+5978936565", 11));


        /*StoreRepository storeRepo = new StoreRepository();
        List<Store> storeList = storeRepo.findAllRecords();
        for (Store store : storeList) {
            System.out.println(store);
        }*/

        //int add = storeRepo.insertRecord(new Store(5, "Armani", "www.armani.com", "clothes@armani.com", "Fashion street"));
        //int del = storeRepo.deleteRecord(new Store(10));


        OrdersRepository ordersRepo = new OrdersRepository();
        //List<Orders> ordersList = ordersRepo.findAllRecords();
       // for (Orders orders : ordersList) {
        //    System.out.println(orders);
        //}

        //int update = ordersRepo.updateRecords(new Orders(6, 1 , 1));
        //int del = ordersRepo.deleteOneRecord(new Orders(4));
        Orders findRecord = ordersRepo.findRecord("Jacket",6);
    }
}
