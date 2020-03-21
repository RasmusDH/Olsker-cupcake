package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdreMapper {

    public static List<Order> listOfOrders() throws LoginSampleException {

        List<Order> listOfOrders = null;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake_shop.orders2";
            PreparedStatement ps = con.prepareStatement( SQL );
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



    public static void insertOrdre(int Quantity,
                                   double Sum, int ToppingID, int BottomID) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orderline(Quantity, Sum, ToppingID, BottomID) " +
                    "VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, Quantity);
            ps.setDouble(2, Sum);
            ps.setInt(3, ToppingID);
            ps.setInt(4, BottomID);

            int result = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
