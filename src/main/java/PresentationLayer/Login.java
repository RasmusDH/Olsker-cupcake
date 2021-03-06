package PresentationLayer;

import FunctionLayer.Kurv;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Mia
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();
        Kurv kurv = (Kurv) session.getAttribute("kurv");
        if (kurv == null) {
            kurv = new Kurv();
        }

        session.setAttribute("kurv", kurv);
        session.setAttribute( "user", user );
        session.setAttribute("navn", user.getName());
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("balance", user.getBalance());
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke

        return user.getRole() + "page";
    }

}
