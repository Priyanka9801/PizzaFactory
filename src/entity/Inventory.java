package entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<String> crust = Arrays.asList(
            "New hand tossed",
            "Wheat thin crust",
            "Cheese Burst",
            "Fresh pan pizza"
    );
    Map<String, Double> cheese = new HashMap<>() {
        {
        put("Cheese", 35.0);
    }
    };

    public List<String> getCrust() {
        return crust;
    }

    public void setCrust(List<String> crust) {
        this.crust = crust;
    }

    public Map<String, Double> getCheese() {
        return cheese;
    }

    public void setCheese(Map<String, Double> cheese) {
        this.cheese = cheese;
    }
}