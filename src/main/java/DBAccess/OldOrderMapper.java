package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OldOrderMapper {

    public static Order order;

    public static List<Order> listOfOldOrders() throws LoginSampleException {

        List<Order> listOfOldOrders = null;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake_shop.oldorders";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                if (listOfOldOrders == null){
                    listOfOldOrders = new ArrayList<>();
                }
                int orderID = rs.getInt( "OrderID" );
                String email = rs.getString("Email");
                int customerID = rs.getInt( "CustomerID" );
                Date date = rs.getDate( "Date" );
                order = new Order(orderID, email, customerID, date);
                listOfOldOrders.add(order);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
        return listOfOldOrders;
    }

    public static void deleteOrder(int orderID) {
        Connection con = null;

        try {
            con = Connector.connection();
            String sql = "delete from oldorders where OrderID ='"+orderID+"'";
            System.out.println("SQL:" + sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
