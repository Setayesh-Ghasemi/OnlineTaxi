package ir.maktab.enums;

public enum TypeOfVehicle {
    CAR("car");

    String abbr;

    TypeOfVehicle(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}
