package enums;

public enum Size {
    REGULAR("Regular"), MEDIUM("Medium"), LARGE("Large");
    private final String size;

    Size(String size) {
        this.size = size;
    }

    public String getValue() {
        return this.name();
    }


    public String getDescription() {
        return this.size;
    }


}
