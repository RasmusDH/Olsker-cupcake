package PresentationLayer;

import DBAccess.OldOrderMapper;
import DBAccess.OrdreMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        // Ting der skal settes på employee:
       // List<Order> orderList =  OrdreMapper.listOfOrders();

        //session.setAttribute("orderList", orderList);

        // Ting der skal hentes fra employee:
        String order = request.getParameter("order");

        int orderID = Integer.parseInt(request.getParameter("orderID"));
        OldOrderMapper.deleteOrder(orderID);

        request.setAttribute("message", "Ordre slettet");

        return "Employeepage";
    }
}
