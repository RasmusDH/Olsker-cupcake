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

}
