package DBAccess;

import FunctionLayer.CustomerOrder;

import java.sql.*;
import java.util.ArrayList;

public class CustomerOrderMapper {


    public static ArrayList<CustomerOrder> customerOrderList() throws SQLException, ClassNotFoundException{
        ArrayList<CustomerOrder> returnList = new ArrayList<>();
        Connector con = new Connector();

        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM cupcake_shop.customersorders;";
        statement = con.getConnector().createStatement();
        // ResultSet sender dataen over i programmet
        resultSet = statement.executeQuery(query);

        //executeUpdate
        while (resultSet.next()){
            int customerID = resultSet.getInt("CustomerID");
            String name = resultSet.getString("Name");
            int orderID = resultSet.getInt("OrderID");
            Date date = resultSet.getDate("Date");

            CustomerOrder tmp = new CustomerOrder(customerID, name, orderID, date);
            returnList.add(tmp);
        }

        // Lukker efter mig:
        resultSet.close();
        statement.close();


        return returnList;
    }


}
