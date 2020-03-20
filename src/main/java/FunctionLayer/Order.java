package FunctionLayer;

import java.util.Date;

public class Order {

    private int orderID;
    private Date date;
    private int customerID;

    public Order(Date date, int customerID) {
        this.date = date;
        this.customerID = customerID;
    }

    public Order(int orderID, Date date, int customerID) {
        this.orderID = orderID;
        this.date = date;
        this.customerID = customerID;
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

    @Override
    public String toString() {
        return "Order: " + orderID + ". Date: " + date + ". Order made by customer: " + customerID;

    }
}
