package PresentationLayer;

import DBAccess.OldOrderMapper;
import DBAccess.OrdreMapper;
import FunctionLayer.*;
import UtilClass.Initializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {

        int orderID = Integer.parseInt(request.getParameter("orderID"));
        request.setAttribute("orderID", orderID);

        OrdreMapper.deleteOrder(orderID);

        Initializer.getOrderList().remove(new Order(orderID));

        //Initializer.getOrderList().remove(order);

        request.setAttribute("messageOrdre", "Ordre slettet");




        return "employeepage";
    }
}
