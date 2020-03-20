package FunctionLayer;

public class Topping {

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String topping;
    private double toppingPrice;

    public Topping(String topping, double toppingPrice) {
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    public Topping(int id, String topping, double toppingPrice) {
        this.id = id;
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    @Override
    public String toString() {
        return topping + ": " + toppingPrice + "\n";
    }
}
