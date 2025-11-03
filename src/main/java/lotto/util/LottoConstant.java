package lotto.util;

public class LottoConstant {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int COUNT = 6;
    public static final int PRICE = 1000;

    public static final String ERROR = "[ERROR] ";

    public static String toMessage(String message) {
        return ERROR + message;
    }

}
