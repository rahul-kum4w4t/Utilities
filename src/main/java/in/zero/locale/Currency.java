package in.zero.locale;

import java.math.RoundingMode;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class Currency {

    private static Pattern INDIAN_CURR_DOUBLE = Pattern.compile("(?=(?!^)(?:\\d{2})*?\\d{3}\\.)");
    private static Pattern INDIAN_CURR_INT = Pattern.compile("(?=(?!^)(?:\\d{2})*?\\d{3}$)");
    static String RUPEE_SYMBOL = "₹";

    private static Pattern NON_NUMBERS = Pattern.compile("(?![-+.])\\D");
    private static Pattern NUMBER = Pattern.compile("^[-+]?\\d+(?:\\.\\d+)?$");

    public static String toINR(double curr) {
        DecimalFormat df = new DecimalFormat("#.#########");
        df.setMaximumFractionDigits(2);
        String currStr = df.format(curr);
        return RUPEE_SYMBOL + INDIAN_CURR_DOUBLE.matcher(currStr).replaceAll(",");
    }

    public static String toINR(long curr) {
        String currStr = String.valueOf(curr);
        return RUPEE_SYMBOL + INDIAN_CURR_INT.matcher(currStr).replaceAll(",");
    }

    public static String toINR(String curr) {
        if (NUMBER.matcher(curr).matches()) {
            if (curr.contains(".")) {
                return RUPEE_SYMBOL + INDIAN_CURR_DOUBLE.matcher(curr).replaceAll(",");
            } else {
                return RUPEE_SYMBOL + INDIAN_CURR_INT.matcher(curr).replaceAll(",");
            }
        } else if (NON_NUMBERS.matcher(curr).find()) {
            System.out.println("NON NUmber: " + curr);
            return toINR(NON_NUMBERS.matcher(curr).replaceAll(""));
        } else {
            throw new IllegalArgumentException("Provided string is not a number string");
        }
    }
}
