package ir.maktab.model;

import ir.maktab.enums.UserStatus;
public class User {

    protected String username;
    protected String name;
    protected String family;
    protected String nationalCode;
    protected String phoneNumber;
    protected int age;
    protected UserStatus userStatus;


    public User() {

    }

    public User(String username, String name, String family, String nationalCode, String phoneNumber, int age, UserStatus userStatus) {
        this.username = username;
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.userStatus = userStatus;

    }
    public User(String username, String name, String family, String nationalCode, String phoneNumber, int age) {
        this.username = username;
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
        this.age = age;

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", userStatus=" + userStatus +
                '}';
    }
}
