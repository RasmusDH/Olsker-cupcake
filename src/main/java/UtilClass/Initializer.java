package UtilClass;

import FunctionLayer.Bottom;
import FunctionLayer.LogicFacade;
import FunctionLayer.Topping;

import java.util.List;

public class Initializer {

    private static List<Topping> toppingList = null;
    private static List<Bottom> bottomList = null;

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
}
