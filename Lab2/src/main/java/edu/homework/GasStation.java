package edu.homework;

public class GasStation extends Location{
    private double gasPrice;

    public GasStation(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public GasStation(String name, double x, double y, double gasPrice) {
        super(name, x, y);
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }
}
