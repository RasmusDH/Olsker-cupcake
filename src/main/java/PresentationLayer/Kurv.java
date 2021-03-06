package PresentationLayer;

import DBAccess.OrdreMapper;
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

        User user = (User) session.getAttribute("user");

        double balance = 500;
        balance -= kurv.getTotalSum();

        OrdreMapper.insertOrder(user);

        kurv.emptyKurv();
        System.out.println(balance);
        return "kurv";
    }


}
