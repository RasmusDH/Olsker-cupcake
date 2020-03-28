package DBAccess;

import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdreMapper {

    public static List<Order> listOfOrders() throws LoginSampleException {

        List<Order> listOfOrders = null;

        try {
            Connector con = new Connector();
            String SQL = "SELECT * FROM orders";
            PreparedStatement ps = con.getConnector().prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                if (listOfOrders == null){
                    listOfOrders = new ArrayList<>();
                }
                int orderID = rs.getInt( "OrderID" );
                String email = rs.getString("Email");
                int customerID = rs.getInt( "CustomerID" );
                Date date = rs.getDate( "Date" );
                Order order = new Order(orderID, email, customerID, date);
                listOfOrders.add(order);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
        return listOfOrders;
    }


    public static void deleteOrder(int orderID) {
        Connector myConnector = new Connector();

        try {
            myConnector.getConnector();
            String sql = "delete from orders where OrderID =?";
            System.out.println("SQL:" + sql);
            PreparedStatement ps = myConnector.getConnector().prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.executeUpdate();

            //ps.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertOrder(User user) throws LoginSampleException {
        try {
            Connector con = new Connector();
            String SQL = "INSERT INTO orders (Email, CustomerID) VALUES (?, ?)";
            PreparedStatement ps = con.getConnector().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setInt(2, user.getId());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
