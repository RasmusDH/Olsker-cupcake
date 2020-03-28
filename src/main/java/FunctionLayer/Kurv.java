package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Kurv {

    private List<Cupcake> cupcakeList = new ArrayList<>();
    private int quantity = 0;

    public Kurv() {
        this.quantity = 0;
    }

    /**
    * @author Rasmus
    * @param cake er den cupcake der er blevet tilføjet til kurven
    */
    public void addCupcake(Cupcake cake) {
        cupcakeList.add(cake);
        quantity++;
    }

    public void emptyKurv() {
        cupcakeList.clear();
        this.quantity = 0;
    }

    /**
     * @author Rasmus
     * @return metoden returnerer den totale pris for hele ordren, alle cupcakesne
     */
    public double getTotalSum() {
        double sum = 0.0;
        for (Cupcake cupcake : cupcakeList) {
            sum += cupcake.getCupcakePrice();
        }
        return sum;
    }

    public List<Cupcake> getCupcakeList() {
        return cupcakeList;
    }

    public void setCupcakeList(List<Cupcake> cupcakeList) {
        this.cupcakeList = cupcakeList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
