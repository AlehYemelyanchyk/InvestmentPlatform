package by.epam.investmentplatform.entity;

import java.io.Serializable;
import java.util.Objects;

public class Security implements Serializable {
    private static final long serialVersionUID = 2590962254936183355L;

    private String symbol;
    private String name;
    private String exchange;
    private double currentPrice;
    private double yearChangePercents;
    private double dividends;
    private String securityType;
    private String stopTradeDate;

    protected Security() {
    }

    public Security(String symbol, String name, String exchange, double currentPrice, double yearChangePercents, double dividends, String securityType) {
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.currentPrice = currentPrice;
        this.yearChangePercents = yearChangePercents;
        this.dividends = dividends;
        this.securityType = securityType;
    }

    public Security(String symbol, String name, String exchange, double currentPrice, double yearChangePercents, double dividends, String securityType, String stopTradeDate) {
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.currentPrice = currentPrice;
        this.yearChangePercents = yearChangePercents;
        this.dividends = dividends;
        this.securityType = securityType;
        this.stopTradeDate = stopTradeDate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getYearChangePercents() {
        return yearChangePercents;
    }

    public void setYearChangePercents(double yearChangePercents) {
        this.yearChangePercents = yearChangePercents;
    }

    public double getDividends() {
        return dividends;
    }

    public void setDividends(double dividends) {
        this.dividends = dividends;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public String getStopTradeDate() {
        return stopTradeDate;
    }

    public void setStopTradeDate(String stopTradeDate) {
        this.stopTradeDate = stopTradeDate;
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
                " symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", exchange='" + exchange + '\'' +
                ", currentPrice='" + currentPrice + '\'' +
                ", yearChangePercents='" + yearChangePercents + '\'' +
                ", dividends='" + dividends + '\'' +
                ", securityType='" + securityType + '\'' +
                ", stopTradeDate='" + stopTradeDate + '\'' +
                '}';
    }
}
