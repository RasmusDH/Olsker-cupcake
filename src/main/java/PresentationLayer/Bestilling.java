package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bestilling extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {

        HttpSession session = request.getSession();

        // Ting der skal settes på bestilling:
        ArrayList<Topping> toppingList = LogicFacade.topping();
        session.setAttribute("toppingList", toppingList);

        ArrayList<Bottom> bottomList = LogicFacade.bottoms();
        session.setAttribute("bottomList", bottomList);

        // Ting der skal hentes fra bestilling:
        String toppingName = request.getParameter("toppingName");
        String bottomName = request.getParameter("bottomName");

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

        Topping topping = new Topping(toppingName, topPrice);
        Bottom bottom = new Bottom(bottomName, botPrice);

        Cupcake cupcake = new Cupcake(toppingName, bottomName);
        //cupcake.setCupcakePrice(cupcake.totalPriceCalculator(topping, bottom));

        cupcake.addCupcake(cupcake);
        ArrayList<Cupcake> cupcakeList = cupcake.getCupcakeOrdre();
        session.setAttribute("cupcakeList", cupcakeList);
        // Quantity (antal):
        /*

        int quantity;
        quantity = Integer.parseInt(request.getParameter("quantity"));
        */


        /*
        double sum = cupcake.getCupcakePrice() * quantity;

        session.setAttribute("sum", sum);
        */
        return "bestilling";

    }
}
