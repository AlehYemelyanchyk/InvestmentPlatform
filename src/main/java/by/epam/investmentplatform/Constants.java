package by.epam.investmentplatform;

public final class Constants {
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
    public static final String ERROR_ATTRIBUTE = "ERROR_ATTRIBUTE";
    public static final String REDIRECT_LINK = "REDIRECT_LINK";
    public static final String REDIRECT_URL_AFTER_LOGIN = "REDIRECT_URL_AFTER_LOGIN";
    public static final String SECURITY_TRANSACTIONS = "SECURITY_TRANSACTIONS";
    public static final String PORTFOLIO = "PORTFOLIO";
    public static final String PORTFOLIO_ID = "PORTFOLIO_ID";
    public static final String PORTFOLIOS_LIST = "PORTFOLIOS_LIST";
    public static final String PORTFOLIO_NAME = "PORTFOLIO_NAME";
    public static final String PORTFOLIO_SECURITIES = "PORTFOLIO_SECURITIES";
    public static final String PORTFOLIO_TRANSACTIONS = "PORTFOLIO_TRANSACTIONS";
    public static final String PORTFOLIO_USER_ID = "PORTFOLIO_USER_ID";
    public static final String SECURITY_NAME = "SECURITY_NAME";
    public static final String SECURITY_SYMBOL = "SECURITY_SYMBOL";
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
