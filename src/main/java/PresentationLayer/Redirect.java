package PresentationLayer;

import FunctionLayer.LoginSampleException;
import UtilClass.Initializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
