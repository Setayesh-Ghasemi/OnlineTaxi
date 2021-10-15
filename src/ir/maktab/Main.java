package ir.maktab;

import ir.maktab.dao.*;
import ir.maktab.model.Driver;
import ir.maktab.model.Passenger;
import ir.maktab.model.vehicle.Vehicle;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        DriverDatabase driverDatabase = new DriverDatabase();
        PassengerDatabase passengerDatabase = new PassengerDatabase();

        while (true) {
            Menu:
            System.out.println("ONLINE TAXI SYSTEM: \n" +
                    "1.Add a group of drivers\n" +
                    "2.Add a group of passengers\n" +
                    "3.Driver signup or login\n" +
                    "4.Passenger signup or login\n" +
                    "5.Show a list of drivers\n" +
                    "6.Show a list of passengers\n" +
                    "7.exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter number of drivers :");
                    int numberOfDrivers = sc.nextInt();
                    for (int i = 0; i < numberOfDrivers; i++) {
                        System.out.println("Enter drivers information: (Username, name, family, nationalCode, phoneNumber ,age,nameOfCar ,color, numberOfCar )");

                        String information = sc.nextLine();
                        String[] arrayInfo = information.split(",");
                        String username = arrayInfo[0];
                        String name = arrayInfo[1];
                        String family = arrayInfo[2];
                        String nationalCode = arrayInfo[3];
                        String phoneNumber = arrayInfo[4];
                        String strAge = arrayInfo[5];
                        int a = Integer.parseInt(strAge);
                        String nameOfCar = arrayInfo[6];
                        String color = arrayInfo[7];
                        String number = arrayInfo[8];

                        Vehicle vehicle = new Vehicle(1, nameOfCar, color, number);
                        int id = CarDatabase.addVehicle(vehicle);
                        vehicle.setVehicleId(id);
                        Driver driver = new Driver(username, name, family, nationalCode, phoneNumber, strAge, vehicle);

                        try {
                            driverDatabase.addDriver(driver);
                        } catch (SQLException e) {
                            System.out.println("CAN NOT ADD DRIVER!! " + e.getMessage());
                        }

                    }
                    System.out.println("successfully added.");
                }
                break;

                case 2: {
                    System.out.println("Enter number of passenger: ");
                    int numberOfPassengers = sc.nextInt();
                    for (int i = 0; i < numberOfPassengers; i++) {
                        System.out.println("Enter passengers information: (userName, name, family, nationalCode, phoneNumber, age, userStatus, Balance) ");
                        sc.nextLine();
                        String information = sc.nextLine();
                        String[] lineArray = information.split(",");
                        String username = lineArray[0];
                        String name = lineArray[1];
                        String family = lineArray[2];
                        String nationalCode = lineArray[3];
                        String phoneNumber = lineArray[4];
                        String strAge = lineArray[5];
                        int age = Integer.parseInt(strAge);
                        String str = lineArray[6];
                        double balance = Double.parseDouble(str);
                        Passenger passenger = new Passenger(username, name, family, nationalCode, phoneNumber, age, balance);
                        try {
                            passengerDatabase.addPassenger(passenger);
                        } catch (SQLException e) {
                            System.out.println("CAN NOT ADD PASSENGER!! " + e.getMessage());
                        }
                    }
                    System.out.println("successfully added.");
                }
                break;
                case 3: {
                    System.out.println("Enter username: ");
                    String driverUsername = sc.next();
                    Driver driver = driverDatabase.getDriverByDriverUserName(driverUsername);
                    if (driver == null) {
                        System.out.println("1.Register\n 2.Exit");
                        int select = sc.nextInt();
                        switch (select) {
                            case 1: {
                                System.out.println("Enter your information: (userName, name, family, nationalCode, phoneNumber ,age ,nameOfCar ,color, numberOfCar)");
                                sc.nextLine();
                                String information = sc.nextLine();
                                String[] arrayInfo = information.split(",");
                                String userName = arrayInfo[0];
                                String name = arrayInfo[1];
                                String family = arrayInfo[2];
                                String nationalCode = arrayInfo[3];
                                String phoneNumber = arrayInfo[4];
                                String strAge = arrayInfo[5];
                                int age = Integer.parseInt(strAge);
                                String nameOfCar = arrayInfo[6];
                                String color = arrayInfo[7];
                                String number = arrayInfo[8];
                                Vehicle vehicle = new Vehicle(1, nameOfCar, color, number);
                                int id = CarDatabase.addVehicle(vehicle);
                                vehicle.setVehicleId(id);
                                Driver newDriver = new Driver(userName, name, family, nationalCode, phoneNumber, age, vehicle);
                                try {
                                    driverDatabase.addDriver(newDriver);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("successfully added.");
                            }
                            break;
                            case 2:
                                break;
                            default:
                                System.out.println("Invalid input!");
                        }
                    } else if (driver.getUserStatus() == driver.getUserStatus()) {
                        System.out.println("waiting trip");
                        System.out.println("1.Exit");
                        break;
                    } else {
                        System.out.println(driver.getUserStatus());
                        System.out.println("1.Receive money");
                        System.out.println("2.Trip Finished");
                        System.out.println("3.Exit");
                    }
                }
                break;
                case 4: {
                    System.out.println("Enter username: ");
                    String passUsername = sc.next();
                    Passenger passenger = passengerDatabase.getPassengerByUserName(passUsername);

                    if (passenger == null) {
                        System.out.println("1.Register");
                        System.out.println("2.Exit");
                        int select = sc.nextInt();
                        switch (select) {
                            case 1: {
                                System.out.println("Enter your information: (userName, name, family, nationalCode, phoneNumber, age, balance)");
                                sc.nextLine();
                                String information = sc.nextLine();
                                String[] arrayInfo = information.split(",");
                                String userName = arrayInfo[0];
                                String name = arrayInfo[1];
                                String family = arrayInfo[2];
                                String nationalCode = arrayInfo[3];
                                String phoneNumber = arrayInfo[4];
                                String strAge = arrayInfo[5];
                                int age = Integer.parseInt(strAge);
                                String str1 = arrayInfo[6];
                                double balance = Double.parseDouble(str1);
                                Passenger pass = new Passenger(userName, name, family, nationalCode, phoneNumber, age, balance);
                                try {
                                    passengerDatabase.addPassenger(pass);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                                System.out.println("successfully added.");
                            }
                            break;
                            case 2:
                                break;
                            default:
                                System.out.println("Invalid input!");
                        }
                    } else {
                        System.out.println("1.Increase balance");
                        System.out.println("2.Exit");
                        int select = sc.nextInt();
                        switch (select) {
                            case 1: {
                                System.out.println("Enter amount: ");
                                sc.nextLine();
                                double increaseAccount = sc.nextDouble();
                                passengerDatabase.updatePassenger(passUsername, increaseAccount);
                                System.out.println("balance updated.");
                            }
                            break;
                            case 2:
                                break;
                            default:
                                System.out.println("Invalid input!!");
                        }
                    }
                }
                break;
                case 5: {
                    System.out.println(driverDatabase.getAllDriver());
                }
                break;
                case 6: {
                    System.out.println(passengerDatabase.getAllPassenger());
                }
                break;
                default:
                    System.out.println("Invalid input!");
            }
        }

    }
}
