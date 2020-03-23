package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {

        String navn = request.getParameter( "navn" );
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
       if ( password1.equals( password2 ) ) {
            Customer customer = LogicFacade.createCustomer( navn, email, password1 );
            User user = LogicFacade.createUser(navn, email, password1);
            HttpSession session = request.getSession();

            session.setAttribute("navn",navn);
            session.setAttribute("email",email);

            session.setAttribute( "customer", customer );
            session.setAttribute("user", user);

            session.setAttribute( "role", customer.getRole() );

            session.setAttribute("balance", customer.getBalance());
            return customer.getRole() + "page";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
