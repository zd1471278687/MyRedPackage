package app.zd.myredpackage.utils;

import android.text.TextUtils;
import android.util.Log;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * number util
 * Created by zhangdong on 2018/3/11.
 */

public class NumberUtil {
    private static final String LOG_TAG = NumberUtil.class.getSimpleName();
    public static final DecimalFormat NO_ZERO_FORMAT = new DecimalFormat("#.#");
    public static final DecimalFormat TWO_FORMAT = new DecimalFormat("0.00");

    /**
     * Don't let anyone instantiate this class
     */
    private NumberUtil() {
    }

    /**
     * Parses the specified string as a signed decimal integer value.
     * <p/>
     * return -1 if {@code intString} cannot be parsed as an integer value.
     */
    public static int stringToInteger(String intString) {
        return stringToInteger(intString, -1);
    }

    /**
     * Parses the specified string as a signed decimal integer value.
     * <p/>
     * return defaultValue if {@code intString} cannot be parsed as an integer value.
     */
    public static int stringToInteger(String intString, int defaultValue) {
        if (TextUtils.isEmpty(intString)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException ex) {
            Log.e(LOG_TAG, "{} is not integer format." + intString);
            return defaultValue;
        }
    }

    /**
     * Parses the specified string as a signed decimal long value.
     * <p/>
     * return -1 if {@code longString} cannot be parsed as a long value.
     */
    public static long stringToLong(String longString) {
        return stringToLong(longString, -1);
    }

    /**
     * Parses the specified string as a signed decimal long value.
     * <p/>
     * return defaultValue if {@code longString} cannot be parsed as a long value.
     */
    public static long stringToLong(String longString, long defaultValue) {
        if (TextUtils.isEmpty(longString)) {
            return defaultValue;
        }
        try {
            return Long.parseLong(longString);
        } catch (NumberFormatException ex) {
            Log.e(LOG_TAG, "{} is not long format." + longString);
            return defaultValue;
        }
    }

    /**
     * Parses the specified string as a signed decimal float value.
     * <p/>
     * return -1 if {@code floatString} cannot be parsed as a float value.
     */
    public static float stringToFloat(String floatString) {
        return stringToFloat(floatString, -1);
    }

    /**
     * Parses the specified string as a signed decimal float value.
     * <p/>
     * return defaultValue if {@code floatString} cannot be parsed as a float value.
     */
    public static float stringToFloat(String floatString, float defaultValue) {
        if (TextUtils.isEmpty(floatString)) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(floatString);
        } catch (NumberFormatException ex) {
            Log.e(LOG_TAG, "{} is not float format." + floatString);
            return defaultValue;
        }
    }

    /**
     * Parses the specified string as a signed decimal double value.
     * <p/>
     * return -1 if {@code floatString} cannot be parsed as a float value.
     */
    public static double stringToDouble(String doubleString) {
        return stringToDouble(doubleString, -1);
    }

    /**
     * Parses the specified string as a signed decimal double value.
     * <p/>
     * return defaultValue if {@code floatString} cannot be parsed as a float value.
     */
    public static double stringToDouble(String doubleString, double defaultValue) {
        if (TextUtils.isEmpty(doubleString)) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(doubleString);
        } catch (NumberFormatException ex) {
            Log.e(LOG_TAG, "{} is not double format." + doubleString);
            return defaultValue;
        }
    }

    /**
     * Parses the specified string as a bool value.
     * <p/>
     * return -1 if {@code boolString} cannot be parsed a bool value.
     */
    public static boolean stringToBoolean(String boolString) {
        return stringToBoolean(boolString, false);
    }

    /**
     * Parses the specified string as a bool value.
     * <p/>
     * return defaultValue if {@code boolString} cannot be parsed a bool value.
     */
    public static boolean stringToBoolean(String boolString, boolean defaultValue) {
        if (TextUtils.isEmpty(boolString)) {
            return defaultValue;
        }
        return Boolean.parseBoolean(boolString);
    }

    /**
     * 计算两个double相乘（防止多次运算导致损失精度）
     *
     * @param d1 第一个
     * @param d2 第二个
     * @return 相乘后的值
     */
    public static double doubleMul(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }

    /**
     * 计算两个float相乘（防止多次运算导致损失精度）
     *
     * @param d1 第一个
     * @param d2 第二个
     * @return 相乘后的值
     */
    public static float floatMul(float d1, float d2) {
        BigDecimal bd1 = new BigDecimal(Float.toString(d1));
        BigDecimal bd2 = new BigDecimal(Float.toString(d2));
        return bd1.multiply(bd2).floatValue();
    }

    /**
     * BigDecimal相乘（防止多次运算导致损失精度）
     *
     * @param down    接近0的舍入模式
     * @param half    向“最接近的”数字舍入
     * @param doubles 相乘的数据
     * @return 相乘后的值
     */
    public static BigDecimal bigDecimalMul(int down, int half, double... doubles) {
        if (doubles == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal result = BigDecimal.ONE;
        for (double number : doubles) {
            result = result.multiply(BigDecimal.valueOf(number));
        }
        return result.setScale(down, BigDecimal.ROUND_DOWN).setScale(half, BigDecimal.ROUND_HALF_EVEN);
    }
}
