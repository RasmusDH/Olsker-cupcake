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

        // Quantity (antal):
        int quantity;
        quantity = Integer.parseInt(request.getParameter("quantity"));


        Cupcake cupcake = new Cupcake(toppingName, bottomName);
        cupcake.setCupcakePrice(cupcake.totalPriceCalculator(toppingName, bottomName));

        double sum = cupcake.getCupcakePrice() * quantity;

        session.setAttribute("sum", sum);

        return "bestilling";

    }
}
