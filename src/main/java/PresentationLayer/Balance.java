package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.UserMapper;
import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import UtilClass.Initializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Balance extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {

        String email = request.getParameter("email");
        double amount = Double.parseDouble(request.getParameter("amount"));



        double balance = amount ;

        LogicFacade.insert(email, balance);

        return "employeepage";
    }
}
