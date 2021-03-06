package FunctionLayer;

import DBAccess.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static Customer createCustomer( String name, String email, String password ) throws LoginSampleException {
        Customer customer = new Customer(name, email, password, "customer", 500);
        UserMapper.createCustomer(customer);
        return customer;
    }

    public static User createUser( String name, String email, String password ) throws LoginSampleException {
        User user = new User(name, email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }


    public static List<Order> getAllOrders() throws LoginSampleException {
        return OrdreMapper.listOfOrders();
    }


    public static ArrayList<User> getAllCustomers() throws LoginSampleException, SQLException, ClassNotFoundException {
        return CustomerMapper.customerList();
    }

    public static void insert(String email, double amount) {
        CustomerMapper.insert(email, amount);
    }


    public static List<IndividualOrder> listOfIndiOrders() throws LoginSampleException {
        return IndividualOrderMapper.listOfIndiOrders();
    }



}
