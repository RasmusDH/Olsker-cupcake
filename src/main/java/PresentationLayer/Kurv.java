package PresentationLayer;

import DBAccess.ToppingMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kurv extends Command {




    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();
       

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

        return "kurv"; */
return "kurv";
    }
}
