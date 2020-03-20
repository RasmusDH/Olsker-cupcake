package FunctionLayer;

public class Bottom {


    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String bottom;
    private double bottomPrice;

    public Bottom(String bottom, double bottomPrice) {
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
    }

    public Bottom(int id, String bottom, double bottomPrice) {
        this.id = id;
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public double getBottomPrice() {
        return bottomPrice;
    }

    public void setBottomPrice(double bottomPrice) {
        this.bottomPrice = bottomPrice;
    }

    @Override
    public String toString() {
        return bottom + ": " + bottomPrice + "\n";
    }
}
