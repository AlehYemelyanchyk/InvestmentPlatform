package by.epam.investmentplatform.entity;

import by.epam.investmentplatform.Constants;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -299089265220451433L;

    private int id;
    private String role;
    private String login;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String country;
    private String banned;
    private String transactionBanned;

    protected User() {
    }

    public User(int id, String role, String login, String password, String email, String name, String surname, String country) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.banned = Constants.BAN_STATUS_INACTIVE;
        this.transactionBanned = Constants.BAN_STATUS_INACTIVE;
    }

    public User(String role, String login, String password, String email, String name, String surname, String country) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.banned = Constants.BAN_STATUS_INACTIVE;
        this.transactionBanned = Constants.BAN_STATUS_INACTIVE;
    }

    public User(int id, String role, String login, String password, String email, String name, String surname, String country, String banned, String transactionBanned) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.banned = banned;
        this.transactionBanned = transactionBanned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public String getTransactionBanned() {
        return transactionBanned;
    }

    public void setTransactionBanned(String transactionBanned) {
        this.transactionBanned = transactionBanned;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        User newUser = (User) object;
        return getLogin().equals(newUser.getLogin()) &&
                getEmail().equals(newUser.getEmail());
    }

    @Override
    public int hashCode() {
        return getLogin().hashCode() + getEmail().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " role='" + role + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", banned='" + banned + '\'' +
                ", transactionBanned='" + transactionBanned + '\'' +
                '}';
    }
}
