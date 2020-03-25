package DBAccess;

import FunctionLayer.IndividualOrder;
import FunctionLayer.LoginSampleException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndividualOrderMapper {

    public static List<IndividualOrder> listOfIndiOrders() throws LoginSampleException {

        List<IndividualOrder> listOfIndiOrders = null;

        try {
            Connector con = new Connector();
            String SQL = "SELECT * FROM cupcake_shop.individualorders order by Date";
            PreparedStatement ps = con.getConnector().prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                if (listOfIndiOrders == null){
                    listOfIndiOrders = new ArrayList<>();
                }
                int orderID = rs.getInt( "OrderID" );
                Date date = rs.getDate( "Date" );
                String email = rs.getString("Email");
                String toppingName = rs.getString("Topping");
                double toppingPrice = rs.getDouble("ToppingPrice");
                String bottomName = rs.getString("Bottom");
                double bottomPrice = rs.getDouble("BottomPrice");
                int quantity = rs.getInt("Quantity");
                double sum = rs.getDouble("Sum");

                IndividualOrder order = new IndividualOrder(orderID, date, email, toppingName, toppingPrice,
                        bottomName, bottomPrice, quantity, sum);
                listOfIndiOrders.add(order);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
        return listOfIndiOrders;
    }

    public static void insertIndiOrdre(IndividualOrder indiOrder) throws LoginSampleException {
        try {
            Connector con = new Connector();
            String SQL = "INSERT INTO cupcake_shop.individualorders" +
                    "(OrderID, Date, Email, Topping, ToppingPrice, Bottom, BottomPrice, Quantity, Sum) " +
                    "VALUES (?,?,?,?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.getConnector().prepareStatement(SQL);

            ps.setInt(1, indiOrder.getOrderID());
            ps.setDate(2, (Date) indiOrder.getDate());
            ps.setString(3, indiOrder.getEmail());
            ps.setString(4, indiOrder.getToppingName());
            ps.setDouble(5, indiOrder.getToppingPrice());
            ps.setString(6, indiOrder.getBottomName());
            ps.setDouble(7, indiOrder.getBottomPrice());
            ps.setInt(8, indiOrder.getQuantity());
            ps.setDouble(9, indiOrder.getSum());
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    /*
    public static void insertIndiOrdre(int OrderID, Date Date, String Email, String Topping, double ToppingPrice,
                                   String Bottom, double BottomPrice, int Quantity, double Sum) throws LoginSampleException {
        try {
            Connector con = new Connector();
            String SQL = "INSERT INTO cupcake_shop.individualorders" +
                    "(OrderID, Date, Email, Topping, ToppingPrice, Bottom, BottomPrice, Quantity, Sum) " +
                    "VALUES (?,?,?,?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.getConnector().prepareStatement(SQL);

            ps.setInt(1, OrderID);
            ps.setDate(2, Date);
            ps.setString(3, Email);
            ps.setString(4, Topping);
            ps.setDouble(5, ToppingPrice);
            ps.setString(6, Bottom);
            ps.setDouble(7, BottomPrice);
            ps.setInt(8, Quantity);
            ps.setDouble(9, Sum);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

     */

}
