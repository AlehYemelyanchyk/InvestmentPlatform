package by.epam.investmentplatform;

public final class Constants {
    public static final String BAN_STATUS_ACTIVE = "1";
    public static final String BAN_STATUS_INACTIVE = "0";
    public static final String DATE_DELIMITER = "-";
    public static final int DATE_SPLIT_ARRAY_YEAR = 0;
    public static final int DATE_SPLIT_ARRAY_MONTH = 1;
    public static final int DATE_SPLIT_ARRAY_DAY = 2;
    public static final int ITEMS_PER_PAGE = 20;
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    public static final String ROLE_ADMIN = "1";
    public static final String ROLE_GUEST = "3";
    public static final String ROLE_USER = "2";
    public static final String URL_DELIMITER = "/";
    public static final int ZERO_LIST_ELEMENT = 0;

    private Constants() {
        throw new UnsupportedOperationException();
    }
}
