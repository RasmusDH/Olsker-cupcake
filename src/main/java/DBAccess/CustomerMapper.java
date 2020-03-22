package DBAccess;

import FunctionLayer.Customer;
import FunctionLayer.CustomerOrder;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;

public class CustomerMapper {

    public static ArrayList<Customer> customerList() throws SQLException, ClassNotFoundException{
        ArrayList<Customer> returnList = new ArrayList<>();
        Connector con = new Connector();

        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM customers";
        statement = con.getConnector().createStatement();
        // ResultSet sender dataen over i programmet
        resultSet = statement.executeQuery(query);

        //executeUpdate
        while (resultSet.next()){
            String name = resultSet.getString("Name");
            String email = resultSet.getString("Email");
            String password = resultSet.getString("Password");
            String role = resultSet.getString("Role");
            double balance = resultSet.getDouble("Balance");
            int id = resultSet.getInt("CustomerID");
            Customer tmpCus = new Customer(name, email, password, role, balance);
            tmpCus.setId(id);
            returnList.add(tmpCus);
        }

        // Lukker efter mig:
        resultSet.close();
        statement.close();


        return returnList;
    }

    public static void insert(int customerID, double amount) {

        String SQL = "UPDATE cupcake_shop.customers SET Balance = ? WHERE CustomerID = ?";

        Connector conn = new Connector();
        try (
             PreparedStatement pstmt = conn.getConnector().prepareStatement(SQL)) {

            pstmt.setDouble(1, amount);
            pstmt.setInt(2, customerID);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void insertBalance(int id, double balance) throws LoginSampleException, SQLException, ClassNotFoundException {

        Connector con = new Connector();
        String SQL = "UPDATE cupcake_shop.customers SET Balance ='" + balance + "' where CustomerID='" + id + "'";
        PreparedStatement ps = con.getConnector().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

        ps.setDouble(1, balance);
        ps.setInt(2, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String name = rs.getString("Name");
            String email = rs.getString("Email");
            String password = rs.getString("Password");
            String role = rs.getString("role");

            double firstBalance = rs.getDouble("Balance");
            id = rs.getInt("ID");

            User user = new User(name, email, password, role);
            user.setId(id);
            balance = firstBalance+balance;
            //user.setBalance(balance);
        }
    }


}
