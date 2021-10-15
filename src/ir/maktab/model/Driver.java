package ir.maktab.model;

import ir.maktab.enums.TypeOfVehicle;
import ir.maktab.model.vehicle.Vehicle;

public class Driver extends User {

    private Vehicle vehicle;
    private TypeOfVehicle typeOfVehicle;
    private String location;

    public Driver(String userName, String name, String family, String nationalCode, String phoneNumber, int age, Vehicle vehicle, TypeOfVehicle typeOfVehicle, String location) {
        super(userName, name, family, nationalCode, phoneNumber, age);
        this.vehicle = vehicle;
        this.typeOfVehicle = typeOfVehicle;
        this.location = location;
    }

    public Driver() {

    }

    public Driver(String userName, String name, String family, String nationalCode, String phoneNumber, int age, Vehicle vehicle) {
    }

    public Driver(String username, String name, String family, String nationalCode, String phoneNumber, String strAge, Vehicle vehicle) {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Driver{" +
                super.toString() + '\'' +
                ",vehicle" + vehicle +'\'' +
                ", typeOfVehicle=" + typeOfVehicle + '\'' +
                ", location='" + location +
                '}';
    }
}
