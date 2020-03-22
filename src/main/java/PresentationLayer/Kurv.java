package PresentationLayer;

import DBAccess.ToppingMapper;
import FunctionLayer.*;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kurv extends Command {




    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

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

        ArrayList<Cupcake> cupcakeList = cupcake.getCupcakeOrdre();
        cupcakeList.add(cupcake);
        session.setAttribute("cupcakeList", cupcakeList);

/*
      Fang topping parameter:
        HttpSession session = request.getSession();

        // ToppingID:
        int toppingID = 0;
        toppingID = Integer.parseInt(request.getParameter("topping"));
        session.setAttribute("toppingID", toppingID);

        // BottomID:
        int bottomID = 0;
        bottomID = Integer.parseInt(request.getParameter("bottom"));
        session.setAttribute("bottomID", bottomID);



        String toppingName = request.getParameter("topping");
        String bottomName = request.getParameter("bottom");
        double toppingPrice = Double.parseDouble(request.getParameter("toppingPrice"));
        double bottomPrice = Double.parseDouble(request.getParameter("bottomPrice"));

        Cupcake cupcake = new Cupcake(toppingName, bottomName, toppingPrice, bottomPrice);




        // Sum:


        double sum = UtilClass.Sum.beregnSummen(toppingPrice, bottomPrice, quantity);
        session.setAttribute("sum", sum);
        System.out.println(toppingPrice);
        System.out.println(bottomPrice);
        System.out.println(quantity);
        System.out.println(sum);

        //LogicFacade.insertOrdre(quantity, sum, toppingValue, bottomValue);
<<<<<<< HEAD

        return "kurv"; */
return "kurv";
    }
}
