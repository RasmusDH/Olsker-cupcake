package FunctionLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;

import java.util.List;

public class Cupcake {

    private Topping topping;
    private Bottom bottom;
    private int antal;

    private double cupcakePrice;
    private int cupcakeID;
    private int topID;
    private int botID;


    public double totalPriceCalculator() throws LoginSampleException {
        List<Bottom> bottoms = BottomMapper.getBottom();
        List<Topping> toppings = ToppingMapper.getTopping();


                //double topPrice = toppings.get(toppings.indexOf(topping)).getToppingPrice();
                //double botPrice = bottoms.get(bottoms.indexOf(bottom)).getBottomPrice();
                //cupcakePrice = (topPrice + botPrice);
        double topPrice = toppings.get(toppings.indexOf(topping)).getToppingPrice();
        double botPrice = bottoms.get(bottoms.indexOf(bottom)).getBottomPrice();

        cupcakePrice = (topPrice + botPrice);

        return cupcakePrice;
    }

    public Cupcake(Topping topping, Bottom bottom, int antal) {
        this.topping = topping;
        this.bottom = bottom;
        this.antal = antal;

    }



    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public int getCupcakeID() {
        return cupcakeID;
    }

    public void setCupcakeID(int cupcakeID) {
        this.cupcakeID = cupcakeID;
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

    @Override
    public String toString() {
        return "Cupcake{" +
                "topping=" + topping +
                ", bottom=" + bottom +
                ", antal=" + antal +
                '}';
    }
}
