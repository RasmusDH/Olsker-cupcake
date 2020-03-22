package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToppingMapper {



    public static List<Topping> getAllToppings() throws LoginSampleException {

        List<Topping> toppingList = null;

        try {
            Connector con = new Connector();
            String SQL = "SELECT * FROM toppings";
            PreparedStatement ps = con.getConnector().prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                if (toppingList == null){
                    toppingList = new ArrayList<>();
                }
                int toppingID = rs.getInt( "ToppingID" );
                String name = rs.getString( "Name" );
                double toppingPrice = rs.getDouble("Price");
                Topping topping = new Topping(toppingID, name, toppingPrice);
                toppingList.add(topping);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
        return toppingList;
    }

}
