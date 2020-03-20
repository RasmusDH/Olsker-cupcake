package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrdreMapper {

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
