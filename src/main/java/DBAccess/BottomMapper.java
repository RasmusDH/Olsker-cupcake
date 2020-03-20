package DBAccess;

import FunctionLayer.Bottom;
import FunctionLayer.LoginSampleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BottomMapper {

    public static List<Bottom> getAllBottoms() throws LoginSampleException {

        List<Bottom> bottomList = null;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM bottoms";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                if (bottomList == null){
                    bottomList = new ArrayList<>();
                }
                int bottomID = rs.getInt( "BottomID" );
                String name = rs.getString( "Name" );
                double price = rs.getDouble("Price");
                Bottom bottom = new Bottom(bottomID, name, price);
                bottomList.add(bottom);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
        return bottomList;
    }
}
