package UtilClass;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;
import FunctionLayer.*;

import java.util.List;

public class Initializer {

    private static List<Topping> toppingList;
    private static List<Bottom> bottomList;
    private static List<Order> orderList = null;
    private static List<Order> oldOrderList = null;
    private static List<Customer> customerList = null;
    private static List<Order> customerOrderList = null;
    private static List<IndividualOrder> individualOrderList = null;

    public static void initToppings() {
        if (toppingList == null){
            toppingList = ToppingMapper.getTopping();
        }
    }


    public static void initBottoms() {
        if (bottomList == null){
            bottomList = BottomMapper.getBottom();
        }
    }

    public static List<Order> getOrderList() {
        if (orderList == null){
            try {
                orderList = LogicFacade.getAllOrders();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return orderList;
    }
    public static List<Order> getOldOrderList() {
        if (oldOrderList == null){
            try {
                oldOrderList = LogicFacade.getAllOldOrders();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return oldOrderList;
    }

    public static List<Customer> getCustomerList() {
        if (customerList == null){
            try {
                customerList = LogicFacade.getAllCustomers();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return customerList;
    }
    public static List<Order> getCustomerOrderList() {
        if (customerOrderList == null){
            try {
                customerOrderList = LogicFacade.customerOrderList();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return customerOrderList;
    }

    public static List<IndividualOrder> getListOfIndiOrders() {
        if (individualOrderList == null){
            try {
                individualOrderList = LogicFacade.listOfIndiOrders();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return individualOrderList;
    }


    public static List<Bottom> getBottomList(){
        return bottomList;
    }

    public static List<Topping> getToppingList() {
        return toppingList;
    }
}
