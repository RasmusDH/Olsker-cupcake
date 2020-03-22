package PresentationLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;
import FunctionLayer.*;
import UtilClass.Initializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bestilling extends Command {

    public static ArrayList<Cupcake> kurv = new ArrayList<>();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {

        ArrayList<Bottom> bottoms = BottomMapper.getBottom();
        ArrayList<Topping> toppings = ToppingMapper.getTopping();

        HttpSession session = request.getSession();

        int antal = Integer.parseInt(request.getParameter("quantity"));
        String bottom = request.getParameter("bund");
        String topping = request.getParameter("top");

        Cupcake temp = new Cupcake(getTopping(toppings, topping), getBottom(bottoms, bottom), antal);
        kurv.add(temp);

        request.setAttribute("toppings", Initializer.getToppingList());
        request.setAttribute("bottoms", Initializer.getBottomList());
        session.setAttribute("cart", kurv);
/*
        int toppingID = Integer.parseInt(request.getParameter("toppingName"));
        int bottomID = Integer.parseInt(request.getParameter("bottomName"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String toppingName;
        String bottomName;
        switch (toppingID) {
            case 1:
                toppingName = "Chocolate";
                break;
            case 2:
                toppingName = "Blueberry";
                break;
            case 3:
                toppingName = "Raspberry";
                break;
            case 4:
                toppingName = "Crispy";
                break;
            case 5:
                toppingName = "Strawberry";
                break;
            case 6:
                toppingName = "Rum/Raisin";
                break;
            case 7:
                toppingName = "Orange";
                break;
            case 8:
                toppingName = "Lemon";
                break;
            case 9:
                toppingName = "Blue cheese";
                break;
            default:
                toppingName = "Chocolate";
                break;

        }
        switch (bottomID) {
            case 1:
                bottomName = "Chocolate";
                break;
            case 2:
                bottomName = "Vanilla";
                break;
            case 3:
                bottomName = "Nutmeg";
                break;
            case 4:
                bottomName = "Pistacio";
                break;
            case 5:
                bottomName = "Almond";
                break;
            default:
                bottomName = "Chocolate";
                break;
        }

        double topPrice;

        if (toppingName == "Chocolate" || toppingName == "Blueberry" || toppingName == "Raspberry"){
            topPrice = 5;
        } else if (toppingName == "Crispy" || toppingName == "Strawberry"){
            topPrice = 6;
        } else if (toppingName == "Rum/Raisin"){
            topPrice = 7;
        } else if (toppingName == "Orange" || toppingName == "Lemon"){
            topPrice = 8;
        } else if (toppingName == "Blue cheese"){
            topPrice = 9;
        } else {
            topPrice = 0;
        }

        double botPrice;

        if (bottomName == "Chocolate" || bottomName == "Vanilla" || bottomName == "Nutmeg"){
            botPrice = 5;
        } else if (bottomName == "Pistacio"){
            botPrice = 6;
        } else if (toppingName == "Almond"){
            botPrice = 7;
        } else {
            botPrice = 0;
        }
        double finalPrice = (botPrice * quantity) + (topPrice * quantity);
        session.setAttribute("finalPrice", finalPrice);
        Topping topping = new Topping(toppingName, topPrice);
        Bottom bottom = new Bottom(bottomName, botPrice);

        Cupcake cupcake = new Cupcake(topping, bottom);
        session.setAttribute("cupcake", cupcake);
        //cupcake.setCupcakePrice(cupcake.totalPriceCalculator(topping, bottom));


        cupcakeList.add(cupcake);
        session.setAttribute("cupcakeList", cupcakeList);
        request.setAttribute("cupcakeMessage", "Ordren er tilføjet til kurven!");

*/
        return "bestilling";
    }

    public static Bottom getBottom(ArrayList<Bottom> bottoms, String bottom) {
        for (Bottom b: bottoms) {
            if(bottom.contains(b.getName())) {
                Bottom bot = new Bottom(b.getId(), b.getName(), b.getBottomPrice());
                return bot;
            }
        }
        return null;
    }

    public static Topping getTopping(ArrayList<Topping> toppings, String topping) {
        for (Topping t: toppings) {
            if(topping.contains(t.getName())) {
                Topping top = new Topping(t.getId(), t.getName(), t.getToppingPrice());
                return top;
            }
        }
        return null;
    }


}
