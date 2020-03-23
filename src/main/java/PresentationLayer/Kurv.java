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
        double finalPrice = Bestilling.finalPrice;


        double balance = 500;

        balance = balance - finalPrice;
        System.out.println(balance);
        session.setAttribute("balanceKurv", balance);
        Bestilling.kurv.clear();
        session.removeAttribute("finalPrice");
        finalPrice = 0;
        session.setAttribute("finalPrice", finalPrice);

        return "kurv";
    }



}
