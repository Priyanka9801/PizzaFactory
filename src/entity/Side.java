package entity;

public class Side {
    private int sideId;
    private String sideName;
    private double sidePrice;

    public Side(int sideId, String sideName, double sidePrice) {
        this.sideId = sideId;
        this.sideName = sideName;
        this.sidePrice = sidePrice;
    }

    public Side() {
    }

    public int getSideId() {
        return sideId;
    }

    public void setSideId(int sideId) {
        this.sideId = sideId;
    }

    public String getSideName() {
        return sideName;
    }

    public void setSideName(String sideName) {
        this.sideName = sideName;
    }

    public double getSidePrice() {
        return sidePrice;
    }

    public void setSidePrice(double sidePrice) {
        this.sidePrice = sidePrice;
    }
}
