package DBAccess;

import FunctionLayer.CustomerOrder;

import java.sql.*;
import java.util.ArrayList;

public class CustomerOrderMapper {

    public static ArrayList<CustomerOrder> customerOrderList() throws SQLException, ClassNotFoundException{
        ArrayList<CustomerOrder> returnList = new ArrayList<>();
        Connection con2 = Connector.connection();

        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM cupcake_shop.customerorder;";
        statement = con2.createStatement();
        // ResultSet sender dataen over i programmet
        resultSet = statement.executeQuery(query);

        //executeUpdate
        while (resultSet.next()){
            int customerID = resultSet.getInt("CustomerID");
            String email = resultSet.getString("Email");
            int orderID = resultSet.getInt("OrderID");
            Date date = resultSet.getDate("Date");
            int orderlineID = resultSet.getInt("OrderlineID");
            int quantity = resultSet.getInt("Quantity");
            double sum = resultSet.getDouble("Sum");
            String toppingName = resultSet.getString("Topping");
            double toppingPrice = resultSet.getDouble("ToppingPrice");
            String bottomName = resultSet.getString("Bottom");
            double bottomPrice = resultSet.getDouble("BottomPrice");
            CustomerOrder tmp = new CustomerOrder(customerID, email, orderID, date, orderlineID, quantity, sum, toppingName,
                    toppingPrice, bottomName, bottomPrice);
            returnList.add(tmp);
        }

        // Lukker efter mig:
        resultSet.close();
        statement.close();


        return returnList;
    }
}
