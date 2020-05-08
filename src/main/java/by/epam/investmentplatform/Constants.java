package by.epam.investmentplatform;

public final class Constants {
    public static final String AMOUNT = "AMOUNT";
    public static final String COMMAND_ATTRIBUTE = "COMMAND_ATTRIBUTE";
    public static final String COMMON_SERVLET_PATH = "/controllerServlet";
    public static final String COUNTRIES_LIST = "COUNTRIES_LIST";
    public static final String CURRENT_PAGE = "CURRENT_PAGE";
    public static final String CURRENT_USER = "CURRENT_USER";
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";
    public static final String CURRENT_USER_LOGIN = "CURRENT_USER_LOGIN";
    public static final String CURRENT_USER_ROLE = "CURRENT_USER_ROLE";
    public static final String CURRENT_USER_PASSWORD = "CURRENT_USER_PASSWORD";
    public static final String CURRENT_USER_EMAIL = "CURRENT_USER_EMAIL";
    public static final String CURRENT_USER_NAME = "CURRENT_USER_NAME";
    public static final String CURRENT_USER_SURNAME = "CURRENT_USER_SURNAME";
    public static final String CURRENT_USER_COUNTRY = "CURRENT_USER_COUNTRY";
    public static final String DATE = "DATE";
    public static final String DATE_DELIMITER = "-";
    public static final int DATE_SPLIT_ARRAY_YEAR = 0;
    public static final int DATE_SPLIT_ARRAY_MONTH = 1;
    public static final int DATE_SPLIT_ARRAY_DAY = 2;
    public static final String ERROR_ATTRIBUTE = "ERROR_ATTRIBUTE";
    public static final int ITEMS_PER_PAGE = 20;
    public static final String MAX_ITEMS_PER_PAGE = "MAX_ITEMS_PER_PAGE";
    public static final String PAGES_AMOUNT = "PAGES_AMOUNT";
    public static final String PORTFOLIO = "PORTFOLIO";
    public static final String PORTFOLIO_ID = "PORTFOLIO_ID";
    public static final String PORTFOLIOS_LIST = "PORTFOLIOS_LIST";
    public static final String PORTFOLIO_NAME = "PORTFOLIO_NAME";
    public static final String PORTFOLIO_SECURITIES = "PORTFOLIO_SECURITIES";
    public static final String PORTFOLIO_TRANSACTIONS = "PORTFOLIO_TRANSACTIONS";
    public static final String PORTFOLIO_USER_ID = "PORTFOLIO_USER_ID";
    public static final String PRICE = "PRICE";
    public static final String REDIRECT_LINK = "REDIRECT_LINK";
    public static final String REDIRECT_URL_AFTER_LOGIN = "REDIRECT_URL_AFTER_LOGIN";
    public static final String SECURITIES_LIST = "SECURITIES_LIST";
    public static final String SECURITY_NAME = "SECURITY_NAME";
    public static final String SECURITY_PRICE = "SECURITY_PRICE";
    public static final String SECURITY_SYMBOL = "SECURITY_SYMBOL";
    public static final String SECURITY_TRANSACTIONS = "SECURITY_TRANSACTIONS";
    public static final String TRANSACTION = "TRANSACTION";
    public static final String TRANSACTION_ID = "TRANSACTION_ID";
    public static final String TRANSACTION_PORTFOLIO_ID = "TRANSACTION_PORTFOLIO_ID";
    public static final String TRANSACTION_SECURITY_SYMBOL = "TRANSACTION_SECURITY_SYMBOL";
    public static final String TRANSACTION_TYPE = "TRANSACTION_TYPE";
    public static final String USERS_LIST = "USERS_LIST";
    public static final int ZERO_LIST_ELEMENT = 0;

    public enum Cookie {

        SHOPPING_CART("iSCC", 60 * 60 * 24 * 365);

        private final String name;
        private final int lifeTime;

        private Cookie(String name, int lifeTime) {
            this.name = name;
            this.lifeTime = lifeTime;
        }

        public String getName() {
            return name;
        }

        public int getLifeTime() {
            return lifeTime;
        }
    }
}
