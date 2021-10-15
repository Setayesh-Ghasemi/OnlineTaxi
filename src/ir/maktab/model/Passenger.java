package ir.maktab.model;

public class Passenger extends User {

    private double Balance;

    public Passenger(String id, String name, String family, String nationalCode, String phoneNumber, int age, double balance) {
        super(id, name, family, nationalCode, phoneNumber, age);
        Balance = balance;
    }

    public Passenger() {
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

}
