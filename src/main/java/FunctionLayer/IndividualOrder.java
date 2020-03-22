package FunctionLayer;

import java.util.Date;

public class IndividualOrder {

    private int orderID;
    private Date date;
    private String email;
    private String toppingName;
    private double toppingPrice;
    private String bottomName;
    private double bottomPrice;
    private int quantity;
    private double sum;

    public IndividualOrder(int orderID, Date date, String email, String toppingName,
                           double toppingPrice, String bottomName, double bottomPrice, int quantity, double sum) {
        this.orderID = orderID;
        this.date = date;
        this.email = email;
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
        this.quantity = quantity;
        this.sum = sum;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
