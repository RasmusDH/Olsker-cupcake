package PresentationLayer;

import DBAccess.CupcakeMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;
import UtilClass.Initializer;

import javax.ejb.Init;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        if(destination.equals("bestilling")) {
            request.setAttribute("toppings", Initializer.getToppingList());
            request.setAttribute("bottoms", Initializer.getBottomList());
        }

        return destination;
    }
}
