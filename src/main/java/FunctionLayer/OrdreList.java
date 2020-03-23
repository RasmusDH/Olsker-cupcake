package FunctionLayer;

import java.util.ArrayList;

public class OrdreList {

    private int ordreID;
    private static ArrayList<Cupcake> cupcakeOrdre;
    private static double sum;



    public static void addCupcake(Cupcake cupcake){

        cupcakeOrdre.add(cupcake);
    }



    public OrdreList(int ordreID, ArrayList<Cupcake> cupcakeOrdre, int sum) {
        this.ordreID = ordreID;
        this.cupcakeOrdre = cupcakeOrdre;
        this.sum = sum;
    }

    public OrdreList(ArrayList<Cupcake> cupcakeOrdre, int sum) {
        this.cupcakeOrdre = cupcakeOrdre;
        this.sum = sum;
    }

    public int getOrdreID() {
        return ordreID;
    }

    public void setOrdreID(int ordreID) {
        this.ordreID = ordreID;
    }

    public ArrayList<Cupcake> getCupcakeOrdre() {
        return cupcakeOrdre;
    }

    public void setCupcakeOrdre(ArrayList<Cupcake> cupcakeOrdre) {
        this.cupcakeOrdre = cupcakeOrdre;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}