package enums;

public enum State {

    CALIFORNIA("California"),
    NEW_YORK("New York"),
    WASHINGTON("Washington");


    private String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
