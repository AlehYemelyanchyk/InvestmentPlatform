package by.epam.investmentplatform.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class BalanceTransaction implements Serializable {
    private static final long serialVersionUID = -8018955451379188309L;

    private int id;
    private int userId;
    private int type;
    private double amount;
    private LocalDate date;

    public BalanceTransaction() {
    }

    public BalanceTransaction(int userId, int type, double amount, LocalDate date) {
        this.userId = userId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public BalanceTransaction(int id, int userId, int type, double amount, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        BalanceTransaction transaction = (BalanceTransaction) object;
        return getId() == transaction.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
