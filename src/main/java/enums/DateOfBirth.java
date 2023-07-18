package enums;

public enum DateOfBirth {


    DAY_1("1"),
    DAY_2("2"),
    DAY_3("3"),
    DAY_4("4"),
    DAY_5("5"),
    DAY_6("6"),
    DAY_7("7"),
    DAY_8("8"),
    DAY_9("9"),
    DAY_10("10"),
    DAY_11("11"),
    DAY_12("12"),
    DAY_13("13"),
    DAY_14("14"),
    DAY_15("15"),
    DAY_16("16"),
    DAY_17("17"),
    DAY_18("18"),
    DAY_19("19"),
    DAY_20("20"),
    DAY_21("21"),
    DAY_22("22"),
    DAY_23("23"),
    DAY_24("24"),
    DAY_25("25"),
    DAY_26("26"),
    DAY_27("27"),
    DAY_28("28"),
    DAY_29("29"),
    DAY_30("30"),
    DAY_31("31"),

    MONTH_JANUARY("January"),
    MONTH_FEBRUARY("February"),
    MONTH_MARCH("March"),
    MONTH_APRIL("April"),
    MONTH_MAY("May"),
    MONTH_JUNE("June"),
    MONTH_JULY("July"),
    MONTH_AUGUST("August"),
    MONTH_SEPTEMBER("September"),
    MONTH_OCTOBER("October"),
    MONTH_NOVEMBER("November"),
    MONTH_DECEMBER("December"),

    YEAR_1990("1990"),
    YEAR_1991("1991"),
    YEAR_1992("1992"),
    YEAR_1993("1993"),
    YEAR_1994("1994"),
    YEAR_1995("1995"),
    YEAR_1996("1996"),
    YEAR_1997("1997"),
    YEAR_1998("1998"),
    YEAR_1999("1999"),
    YEAR_2000("2000");


    private String value;

    DateOfBirth(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
