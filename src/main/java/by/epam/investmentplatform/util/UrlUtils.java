package by.epam.investmentplatform.util;

public final class UrlUtils {
    private UrlUtils() {
    }

    public static boolean isAjaxUrl(String url) {
        return url.contains("/ajax/");
    }

    public static boolean isAjaxJsonUrl(String url) {
        return url.contains("/ajax/json/");
    }

    public static boolean isAjaxHtmlUrl(String url) {
        return url.contains("/ajax/html/");
    }

    public static boolean isStaticUrl(String url) {
        return url.contains("/static/");
    }

    public static boolean isMediaUrl(String url) {
        return url.contains("/media/");
    }
}
