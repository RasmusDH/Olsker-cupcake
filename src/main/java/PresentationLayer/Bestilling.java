package PresentationLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;
import FunctionLayer.*;
import UtilClass.Initializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bestilling extends Command {

    public static ArrayList<Cupcake> kurv = new ArrayList<>();

    static double finalPrice = 0;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {

        ArrayList<Bottom> bottoms = BottomMapper.getBottom();
        ArrayList<Topping> toppings = ToppingMapper.getTopping();

        HttpSession session = request.getSession();

        int antal = Integer.parseInt(request.getParameter("quantity"));
        String bottom = request.getParameter("bund");
        String topping = request.getParameter("top");

        Cupcake temp = new Cupcake(getTopping(toppings, topping), getBottom(bottoms, bottom), antal);
        kurv.add(temp);

        request.setAttribute("toppings", Initializer.getToppingList());
        request.setAttribute("bottoms", Initializer.getBottomList());
        session.setAttribute("cart", kurv);


        for (Cupcake cupcake:kurv){
             finalPrice += cupcake.cupcakePriceCalculator();
        }

        session.setAttribute("finalPrice", finalPrice);


        return "bestilling";
    }

    public static Bottom getBottom(ArrayList<Bottom> bottoms, String bottom) {
        for (Bottom b: bottoms) {
            if(bottom.contains(b.getName())) {
                Bottom bot = new Bottom(b.getId(), b.getName(), b.getBottomPrice());
                return bot;
            }
        }
        return null;
    }

    public static Topping getTopping(ArrayList<Topping> toppings, String topping) {
        for (Topping t: toppings) {
            if(topping.contains(t.getName())) {
                Topping top = new Topping(t.getId(), t.getName(), t.getToppingPrice());
                return top;
            }
        }
        return null;
    }


}
