package PresentationLayer;

import FunctionLayer.LoginSampleException;

import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "registrer", new Register() );
        commands.put("redirect", new Redirect());
        commands.put("bestilling", new Bestilling());
        commands.put("kurv", new Kurv());
        commands.put("employee", new Employee());
        commands.put("balance", new Balance());

    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, SQLException, ClassNotFoundException;

}
