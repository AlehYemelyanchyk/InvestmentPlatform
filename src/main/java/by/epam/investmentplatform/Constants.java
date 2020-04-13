package by.epam.investmentplatform;

public final class Constants {
    public static final String USERS_LIST = "USERS_LIST";
    public static final String PORTFOLIOS_LIST = "PORTFOLIOS_LIST";
    public static final String THE_PORTFOLIO = "THE_PORTFOLIO";
    public static final String COUNTRIES_LIST = "COUNTRIES_LIST";
    public static final String COMMON_SERVLET_PATH = "/controller";
    public static final String COMMAND_ATTRIBUTE = "command";
    public static final String ERROR_ATTRIBUTE = "error";
    public static final String REDIRECT_URL_AFTER_LOGIN = "redirectUrlAfterLogin";
    public static final String CURRENT_USER_ID = "id";
    public static final String CURRENT_USER_LOGIN = "login";
    public static final String CURRENT_USER_ROLE = "role";
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
