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
        FunctionLayer.Kurv kurv = (FunctionLayer.Kurv) session.getAttribute("kurv");
        session.setAttribute("finalPrice", kurv.getTotalSum());
        request.setAttribute("kurv", kurv.getCupcakeList());

        /*
         public static void insertOrder(String email, int customerID, Date date) throws LoginSampleException {
        Order order = new Order(email, customerID, date);
        OrdreMapper.insertOrder(order);
    }
    public static void insertIndiOrdre(int orderID, Date date, String email, String toppingName,
             double toppingPrice, String bottomName, double bottomPrice, int quantity, double sum) throws LoginSampleException {

        IndividualOrder indiOrder = new IndividualOrder(orderID, date, email, toppingName, toppingPrice, bottomName,
                                    bottomPrice, quantity, sum);

        IndividualOrderMapper.insertIndiOrdre(indiOrder);
    }
         */
        


        double balance = 500;
        balance -= kurv.getTotalSum();
        System.out.println(balance);
        return "kurv";
    }


}
