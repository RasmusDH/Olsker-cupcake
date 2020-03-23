package DBAccess;

import FunctionLayer.CustomerOrder;
import FunctionLayer.Order;

import java.sql.*;
import java.util.ArrayList;

public class CustomerOrderMapper {


    public static ArrayList<Order> customerOrderList() throws SQLException, ClassNotFoundException{
        ArrayList<Order> returnList = new ArrayList<>();
        Connector con = new Connector();

        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM cupcake_shop.orders;";
        statement = con.getConnector().createStatement();
        // ResultSet sender dataen over i programmet
        resultSet = statement.executeQuery(query);

        //executeUpdate
        while (resultSet.next()){
            int orderID = resultSet.getInt("OrderID");
            Date date = resultSet.getDate("Date");
            String name = resultSet.getString("Name");
            int customerID = resultSet.getInt("CustomerID");

            Order tmp = new Order(orderID, date, name, customerID);
            returnList.add(tmp);
        }

        // Lukker efter mig:
        resultSet.close();
        statement.close();


        return returnList;
    }


}
