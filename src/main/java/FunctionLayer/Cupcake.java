package FunctionLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;

import java.util.List;

public class Cupcake {

    /**
     * @author Mia
     */

    private Topping topping;
    private Bottom bottom;
    private int antal;

    private double cupcakePrice;

    public double cupcakePriceCalculator() {

        cupcakePrice = (topping.getToppingPrice() + bottom.getBottomPrice())*antal;

        return cupcakePrice;
    }

    public Cupcake(Topping topping, Bottom bottom, int antal) {
        this.topping = topping;
        this.bottom = bottom;
        this.antal = antal;
        cupcakePriceCalculator();

    }


    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public double getCupcakePrice() {
        return cupcakePrice;
    }

    public int getAntal() {
        return antal;
    }

    @Override
    public String toString() {
        return bottom.getName() + " bund med " + topping.getName() + " topping. " + antal + " stk.";
    }
}
