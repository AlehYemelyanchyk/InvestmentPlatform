package by.epam.investmentplatform.entity;

import java.io.Serializable;
import java.util.*;

public class Portfolio implements Serializable {
    private static final long serialVersionUID = -186095461441034514L;

    private int id;
    private int user_id;
    private String name;

    protected Portfolio() {
    }

    public Portfolio(int user_id, String name) {
        this.user_id = user_id;
        this.name = name;
    }

    public Portfolio(int id, int user_id, String name) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Portfolio newPortfolio = (Portfolio) object;
        return this.getUser_id() == newPortfolio.getUser_id() &&
                Objects.equals(this.getName(), newPortfolio.getName());
    }


    @Override
    public int hashCode() {
        return Objects.hash(user_id, name);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
