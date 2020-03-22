package PresentationLayer;

import DBAccess.OldOrderMapper;
import DBAccess.OrdreMapper;
import FunctionLayer.*;
import UtilClass.Initializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {

        int orderID = Integer.parseInt(request.getParameter("orderID"));
        OldOrderMapper.deleteOrder(orderID);
        request.setAttribute("message", "Ordre slettet");

        Order order = OldOrderMapper.order;
        Initializer.getOldOrderList().remove(order);
        request.setAttribute("order", order);

        return "Employeepage";
    }
}
