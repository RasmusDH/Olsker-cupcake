package FunctionLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;

import java.util.ArrayList;
import java.util.List;

public class Cupcake {

    private String topping;
    private String bottom;
    private double cupcakePrice;
    private int topID;
    private int botID;

    public double totalPriceCalculator(String topping, String bottom) throws LoginSampleException {
        List<Bottom> bottoms = BottomMapper.getAllBottoms();
        List<Topping> toppings = ToppingMapper.getAllToppings();

        double topPrice = toppings.get(toppings.indexOf(topping)).getToppingPrice();
        double botPrice = bottoms.get(bottoms.indexOf(bottom)).getBottomPrice();
        cupcakePrice = (topPrice + botPrice);
        return cupcakePrice;
    }

    public Cupcake(String topping, String bottom) {
        this.topping = topping;
        this.bottom = bottom;

    }


    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public double getCupcakePrice() {
        return cupcakePrice;
    }

    public void setCupcakePrice(double cupcakePrice) {
        this.cupcakePrice = cupcakePrice;
    }

    public int getTopID() {
        return topID;
    }

    public void setTopID(int topID) {
        this.topID = topID;
    }

    public int getBotID() {
        return botID;
    }

    public void setBotID(int botID) {
        this.botID = botID;
    }
}
