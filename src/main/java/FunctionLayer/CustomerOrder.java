package FunctionLayer;

import java.util.Date;

public class CustomerOrder {

    private int customerID;
    private String name;
    private int orderID;
    private Date date;


    public CustomerOrder(int customerID, String name, int orderID, Date date) {
        this.customerID = customerID;
        this.name = name;
        this.orderID = orderID;
        this.date = date;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
