package DBAccess;


import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.*;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createCustomer(Customer customer) throws LoginSampleException {
        try {
            Connector con = new Connector();
            String SQL = "INSERT INTO cupcake_shop.customers (name, email, password, role, balance) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.getConnector().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPassword());
            ps.setString(4, customer.getRole());
            ps.setDouble(5, customer.getBalance());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            customer.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connector con = new Connector();
            String SQL = "INSERT INTO cupcake_shop.users (name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.getConnector().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connector con = new Connector();
            String SQL = "SELECT ID, name, role FROM cupcake_shop.users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.getConnector().prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                int id = rs.getInt("ID");
                User user = new User(name, email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


}