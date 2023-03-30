package entity;

public class Topping {
    private int toppingId;
    private String toppingName;
    private boolean isVeg;
    private double toppingPrice;

    public Topping() {
    }

    public Topping(int toppingId, String toppingName, boolean isVeg, double toppingPrice) {
        this.toppingId = toppingId;
        this.toppingName = toppingName;
        this.isVeg = isVeg;
        this.toppingPrice = toppingPrice;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public void setVeg(boolean veg) {
        isVeg = veg;
    }
}
