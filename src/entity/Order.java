package entity;

public class Order {
    private int pizzaId;
    private int pizzaCategory;
    private int crustId;
    private int toppingId;
    private boolean isCheeseApply;
    private int sideId;

    public Order(int pizzaId, int pizzaCategory, int crustId, int toppingId, boolean isCheeseApply, int sideId) {
        this.pizzaId = pizzaId;
        this.pizzaCategory = pizzaCategory;
        this.crustId = crustId;
        this.toppingId = toppingId;
        this.isCheeseApply = isCheeseApply;
        this.sideId = sideId;
    }

    public Order() {
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getPizzaCategory() {
        return pizzaCategory;
    }

    public void setPizzaCategory(int pizzaCategory) {
        this.pizzaCategory = pizzaCategory;
    }

    public int getCrustId() {
        return crustId;
    }

    public void setCrustId(int crustId) {
        this.crustId = crustId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public boolean isCheeseApply() {
        return isCheeseApply;
    }

    public void setCheeseApply(boolean cheeseApply) {
        isCheeseApply = cheeseApply;
    }

    public int getSideId() {
        return sideId;
    }

    public void setSideId(int sideId) {
        this.sideId = sideId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizzaId=" + pizzaId +
                ", pizzaCategory=" + pizzaCategory +
                ", crustId=" + crustId +
                ", toppingId=" + toppingId +
                ", isCheeseApply=" + isCheeseApply +
                ", sideId=" + sideId +
                '}';
    }
}
