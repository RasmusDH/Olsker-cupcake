package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {


    public static ArrayList<User> customerList() throws LoginSampleException {

        ArrayList<User> listOfCustomers = null;

        try {
            Connector con = new Connector();
            String SQL = "SELECT * FROM customers";
            PreparedStatement ps = con.getConnector().prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                if (listOfCustomers == null){
                    listOfCustomers = new ArrayList<>();
                }
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String role = rs.getString("Role");
                double balance = rs.getDouble("Balance");
                int id = rs.getInt("CustomerID");
                User tmpCus = new User(name, email, password, role, balance);
                tmpCus.setId(id);
                listOfCustomers.add(tmpCus);

            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
        return listOfCustomers;
    }


    public static void insert(String email, double amount) {

        String SQL = "UPDATE customers SET Balance = ? WHERE Email = ?";

        Connector conn = new Connector();
        try (
             PreparedStatement pstmt = conn.getConnector().prepareStatement(SQL)) {

            pstmt.setDouble(1, amount);
            pstmt.setString(2, email);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }



}
