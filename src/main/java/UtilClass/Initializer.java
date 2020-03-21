package UtilClass;

import FunctionLayer.Bottom;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.Topping;

import java.util.List;

public class Initializer {

    private static List<Topping> toppingList = null;
    private static List<Bottom> bottomList = null;
    private static List<Order> orderList = null;
    private static List<Order> oldOrderList = null;

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
}
