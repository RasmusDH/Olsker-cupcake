package FunctionLayer;

import java.util.Date;

public class CustomerOrder {

    private int customerID;
    private String email;
    private int orderID;
    private Date date;
    private int orderlineID;
    private int quantity;
    private double sum;
    private String toppingName;
    private double toppingPrice;
    private String bottomName;
    private double bottomPrice;


    public CustomerOrder(int customerID, String email, int orderID, Date date, int orderlineID, int quantity,
                         double sum, String toppingName, double toppingPrice, String bottomName, double bottomPrice) {
        this.customerID = customerID;
        this.email = email;
        this.orderID = orderID;
        this.date = date;
        this.orderlineID = orderlineID;
        this.quantity = quantity;
        this.sum = sum;
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
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

    public int getOrderlineID() {
        return orderlineID;
    }

    public void setOrderlineID(int orderlineID) {
        this.orderlineID = orderlineID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public String getBottomName() {
        return bottomName;
    }

    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }

    public double getBottomPrice() {
        return bottomPrice;
    }

    public void setBottomPrice(double bottomPrice) {
        this.bottomPrice = bottomPrice;
    }
}
