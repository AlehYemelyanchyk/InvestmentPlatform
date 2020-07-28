package by.epam.investmentplatform.model;

import by.epam.investmentplatform.entity.Security;

import java.util.Date;
import java.util.Objects;

public class SecurityPrice {

    private Date date;
    private String symbol;
    private double price;

    protected SecurityPrice() {
    }

    public SecurityPrice(Date date, String symbol, double price) {
        this.date = date;
        this.symbol = symbol;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Security security = (Security) object;
        return Objects.equals(getSymbol(), security.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol());
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " date='" + date + '\'' +
                " symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

