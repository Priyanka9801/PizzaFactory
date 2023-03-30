package util;

import enums.Size;

public class Category {
    private Size size;
    private double amount;

    public Category() {
    }

    public Category(Size size, double amount) {
        this.size = size;
        this.amount = amount;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "[" + size.getValue() + ", RS: " + amount + ']';
    }
}
