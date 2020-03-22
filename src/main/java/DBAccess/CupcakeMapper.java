package DBAccess;

import FunctionLayer.Bottom;
import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CupcakeMapper {

    public ArrayList<Topping> toppingList() throws SQLException, ClassNotFoundException{
        ArrayList<Topping> returnList = new ArrayList<>();
        Connector myConnector = new Connector();
        myConnector.getConnector();

        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT Name, Price FROM cupcake_shop.toppings";
        statement = myConnector.getConnector().createStatement();
        // ResultSet sender dataen over i programmet
        resultSet = statement.executeQuery(query);

        //executeUpdate
        while (resultSet.next()){
            String name = resultSet.getString("Name");
            double price = resultSet.getInt("Price");
            Topping tmpTopping = new Topping(name, price);
            returnList.add(tmpTopping);
        }

        // Lukker efter mig:
        resultSet.close();
        statement.close();

        return returnList;
    }

    public ArrayList<Bottom> bottomList() throws SQLException, ClassNotFoundException{
        ArrayList<Bottom> returnList = new ArrayList<>();
        Connector myConnector = new Connector();
        myConnector.getConnector();

        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT Name, Price FROM cupcake_shop.bottoms";
        statement = myConnector.getConnector().createStatement();
        // ResultSet sender dataen over i programmet
        resultSet = statement.executeQuery(query);

        //executeUpdate
        while (resultSet.next()){
            String name = resultSet.getString("Name");
            double price = resultSet.getInt("Price");
            Bottom tmpBottom = new Bottom(name, price);
            returnList.add(tmpBottom);
        }

        // Lukker efter mig:
        resultSet.close();
        statement.close();

        return returnList;
    }

}
