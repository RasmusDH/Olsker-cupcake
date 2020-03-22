package FunctionLayer;

import DBAccess.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String name, String email, String password ) throws LoginSampleException {
        User user = new User(name, email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static List<Topping> getAllToppings() throws LoginSampleException {
        return ToppingMapper.getAllToppings();
    }
    public static List<Bottom> getAllBottoms() throws LoginSampleException {
        return BottomMapper.getAllBottoms();
    }

    public static List<Order> getAllOrders() throws LoginSampleException {
        return OrdreMapper.listOfOrders();
    }
    public static List<Order> getAllOldOrders() throws LoginSampleException, SQLException, ClassNotFoundException {
        return OldOrderMapper.listOfOldOrders();
    }


    public static ArrayList<Customer> getAllCustomers() throws LoginSampleException, SQLException, ClassNotFoundException {
        return CustomerMapper.customerList();
    }

    public static void insert(int customerID, double amount) {
        CustomerMapper.insert(customerID, amount);
    }

    public static ArrayList<CustomerOrder> customerOrderList() throws SQLException, ClassNotFoundException{
        return CustomerOrderMapper.customerOrderList();
    }

    public static void insertOrdre(int Quantity,
                                   double Sum, int ToppingID, int BottomID) throws LoginSampleException {
        OrdreMapper.insertOrdre(Quantity, Sum, ToppingID, BottomID);
    }



        public static ArrayList<Topping> topping( ) throws LoginSampleException, SQLException, ClassNotFoundException {
        CupcakeMapper c = new CupcakeMapper();
        return c.toppingList();
    }

    public static ArrayList<Bottom> bottoms( ) throws LoginSampleException, SQLException, ClassNotFoundException {
        CupcakeMapper c = new CupcakeMapper();
        return c.bottomList();
    }


}
