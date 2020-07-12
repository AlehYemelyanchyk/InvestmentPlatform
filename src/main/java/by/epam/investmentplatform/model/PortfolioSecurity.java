package by.epam.investmentplatform.model;

import by.epam.investmentplatform.entity.Security;

import java.util.Objects;

public class PortfolioSecurity {

    private String symbol;
    private String name;
    private String exchange;
    private int amount;
    private double averagePrice;
    private double yearChangePercents;
    private double dividends;
    private String securityType;
    private String stopTradeDate;

    protected PortfolioSecurity() {
    }

    public PortfolioSecurity(String symbol, String name, String exchange, int amount, double averagePrice, double yearChangePercents, double dividends, String securityType, String stopTradeDate) {
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.amount = amount;
        this.averagePrice = averagePrice;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
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
                ", currentPrice='" + averagePrice + '\'' +
                ", yearChangePercents='" + yearChangePercents + '\'' +
                ", dividends='" + dividends + '\'' +
                ", securityType='" + securityType + '\'' +
                '}';
    }
}

