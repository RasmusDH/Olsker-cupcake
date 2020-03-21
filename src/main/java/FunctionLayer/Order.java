package FunctionLayer;

import java.util.Date;

public class Order {

    private int orderID;
    private Date date;
    private int customerID;
    private String email;



    public Order(Date date, int customerID) {
        this.date = date;
        this.customerID = customerID;
    }

    public Order(int orderID, String email, int customerID, Date date) {
        this.orderID = orderID;
        this.email = email;
        this.customerID = customerID;
        this.date = date;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Order: " + orderID + ". Date: " + date + ". Order made by customer: " + customerID;

    }
}
