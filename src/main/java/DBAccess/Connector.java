package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    public Connection getConnector() throws ClassNotFoundException, SQLException{
        Connection connector = null;
        String url = "jdbc:mysql://localhost:3306/cupcake_shop?serverTimezone=UTC&allowPublicKeyRetrieval=" +
                "true&useSSL=false";
        String user = "root";
        String password = "Kat4Kanin5Hund1Hamster1";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connector = DriverManager.getConnection(url,user,password);

        return connector;
    }
    /*
    private static final String URL = "jdbc:mysql://localhost:3306/cupcake_shop?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kat4Kanin5Hund1Hamster1";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }
*/

}
