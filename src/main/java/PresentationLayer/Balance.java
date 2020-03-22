package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class Balance extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {


        int id = Integer.parseInt(request.getParameter("customerID"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        double insert = (amount);

        LogicFacade.insert(id, insert);
        //LogicFacade.insertBalance(id, balance);

        return "Employeepage";
    }
}
