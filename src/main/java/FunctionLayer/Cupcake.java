package FunctionLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;

import java.util.ArrayList;
import java.util.List;

public class Cupcake {

    private Topping topping;
    private Bottom bottom;
    private double cupcakePrice;
    private int cupcakeID;
    private int topID;
    private int botID;
    private ArrayList<Cupcake> cupcakeOrdre = new ArrayList<Cupcake>();



    public double totalPriceCalculator() throws LoginSampleException {
        List<Bottom> bottoms = BottomMapper.getAllBottoms();
        List<Topping> toppings = ToppingMapper.getAllToppings();


                //double topPrice = toppings.get(toppings.indexOf(topping)).getToppingPrice();
                //double botPrice = bottoms.get(bottoms.indexOf(bottom)).getBottomPrice();
                //cupcakePrice = (topPrice + botPrice);
        double topPrice = toppings.get(toppings.indexOf(topping)).getToppingPrice();
        double botPrice = bottoms.get(bottoms.indexOf(bottom)).getBottomPrice();

        cupcakePrice = (topPrice + botPrice);

        return cupcakePrice;
    }

    public void addCupcake(Cupcake cupcake){
        cupcakeOrdre.add(cupcake);
    }

    public Cupcake(Topping topping, Bottom bottom) {
        this.topping = topping;
        this.bottom = bottom;

    }

    public ArrayList<Cupcake> getCupcakeOrdre() {
        return cupcakeOrdre;
    }

    public void setCupcakeOrdre(ArrayList<Cupcake> cupcakeOrdre) {
        this.cupcakeOrdre = cupcakeOrdre;
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
        return bottom + " bund med " + topping + " topping";
    }
}
