package UtilClass;

import FunctionLayer.*;

import java.util.List;

public class Initializer {

    private static List<Topping> toppingList = null;
    private static List<Bottom> bottomList = null;
    private static List<Order> orderList = null;
    private static List<Order> oldOrderList = null;
    private static List<Customer> customerList = null;
    private static List<CustomerOrder> customerOrderList = null;

    public static List<Topping> getToppingList() {
        if (toppingList == null){
            try {
                toppingList = LogicFacade.getAllToppings();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return toppingList;
    }

    public static List<Bottom> getBottomList() {
        if (bottomList == null){
            try {
                bottomList = LogicFacade.getAllBottoms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bottomList;
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
    public static List<CustomerOrder> getCustomerOrderList() {
        if (customerOrderList == null){
            try {
                customerOrderList = LogicFacade.customerOrderList();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return customerOrderList;
    }

}
