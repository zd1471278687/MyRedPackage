package app.zd.myredpackage.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * time util
 * Created by zhangdong on 2017/4/13.
 */
public class TimeUtil {
    private static final String LOG_TAG = TimeUtil.class.getSimpleName();
    public static String YYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static String YYMMDD = "yyyy-MM-dd";
    public static String MMDDHHMM = "MM-dd HH:mm";
    public static String HHMM = "HH:mm";

    /**
     * Don't let anyone instantiate this class
     */
    private TimeUtil() {
    }

    /**
     * string 转 date
     *
     * @param formatString 日期格式化
     * @param dateString   string
     * @return date
     */
    public static Date stringToDate(String formatString, String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formatString, new Locale("UTF-8"));
            return sdf.parse(dateString);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "string format to date ParseException");
        }
        return null;
    }

    /**
     * 获取当前时间String
     *
     * @param formatString 格式化
     * @return 当前时间
     */
    public static String getCurrentTime(String formatString) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(formatString, new Locale("UTF_8"));//设置日期格式
            return df.format(new Date());// new Date()为获取当前系统时间
        } catch (RuntimeException e) {
            Log.e(LOG_TAG, "date format RuntimeException");
        }
        return "";
    }

    /**
     * date 转 string
     *
     * @param formatString 日期格式化
     * @param formatDate   需要格式化的date
     * @return 格式化后的string
     */
    public static String dateFormat(String formatString, Date formatDate) {
        if (TextUtils.isEmpty(formatString) || formatDate == null) {
            return "";
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString, new Locale("UTF-8"));
            return simpleDateFormat.format(formatDate);
        } catch (RuntimeException e) {
            Log.e(LOG_TAG, "date format RuntimeException");
        }
        return "";
    }

    /**
     * 日期的格式转换
     *
     * @param sourceDate 源日期串
     * @param source     源日期格式
     * @param result     转换后的日期格式
     * @return 转换的结果
     */
    public static String changeTimeType(String sourceDate, String source, String result) {
        DateFormat dateFormat = new SimpleDateFormat(source, new Locale("UTF-8"));
        Date date = null;
        try {
            date = dateFormat.parse(sourceDate);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "date format error", e);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(result, new Locale("UTF-8"));
        if (date != null) {
            return simpleDateFormat.format(date);
        }
        return "";
    }

    /**
     * 比较2个日期大小
     *
     * @param format     时间格式
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return 大于等于1表示前面的时间大，小于等于-1表示前面的时间小，0表示一样大
     */
    public static int compareDate(String format, String firstDate, String secondDate) {
        SimpleDateFormat allTime = new SimpleDateFormat(format, new Locale("UTF-8"));
        if (TextUtils.isEmpty(firstDate)) {
            return -1;
        }
        if (TextUtils.isEmpty(secondDate)) {
            return 1;
        }
        String date1Time = "";
        String date2Time = "";
        try {
            date1Time = allTime.format(allTime.parse(firstDate));
            date2Time = allTime.format(allTime.parse(secondDate));
        } catch (ParseException e) {
            Log.e(LOG_TAG, "date format error", e);
        }
        return date1Time.compareTo(date2Time);
    }

    /**
     * 比较2个日期大小（忽略时分秒）
     *
     * @param date1 日期
     * @param date2 日期
     * @return 大于等于1表示前面的时间大，小于等于-1表示前面的时间小，0表示一样大
     */
    public static int compareDate(String formatString, Date date1, Date date2) {
        if (date1 == null) {
            return -1;
        }
        if (date2 == null) {
            return 1;
        }
        SimpleDateFormat format = new SimpleDateFormat(formatString, new Locale("UTF-8"));
        String date1Time = format.format(date1);
        String date2Time = format.format(date2);
        return date1Time.compareTo(date2Time);
    }

    /**
     * 两个日期间的间隔时间
     *
     * @param fromDate date
     * @param toDate   date
     * @return 间隔天数
     */
    public static int daysBetween(Date fromDate, Date toDate) {
        if (fromDate != null && toDate != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(toDate);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 59);
            long intervalMilli = cal.getTime().getTime() - fromDate.getTime();
            return (int) (intervalMilli / 86400000L);
        } else {
            return -1;
        }
    }

    /**
     * 两个日期间的间隔时间
     *
     * @param fromDate date
     * @param toDate   date
     * @return 间隔时长
     */
    public static long longBetweenDate(Date fromDate, Date toDate) {
        if (fromDate != null && toDate != null) {
            return toDate.getTime() - fromDate.getTime();
        } else {
            return -1;
        }
    }

    /**
     * 两个日期间的间隔时间
     *
     * @param fromDate date
     * @return 间隔时长
     */
    public static long longBetweenDate(long fromDate) {
        return (System.currentTimeMillis() - fromDate) / 1000;
    }

    /**
     * get time millis.
     *
     * @param time yyyy-MM-dd hh:mm:ss format time string
     * @return 0 if parsing error.
     */
    public static long getTimeOf24(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(YYMMDDHHMMSS, new Locale("UTF-8"));
            Date date = format.parse(time);
            return date.getTime();
        } catch (Exception e) {
            Log.e(LOG_TAG, "parsing error: ", e);
            return 0;
        }
    }

    public static String getTimeOnlyHourAndMinus(String time) {
        SimpleDateFormat format = new SimpleDateFormat(YYMMDDHHMMSS, new Locale("UTF-8"));
        SimpleDateFormat format2 = new SimpleDateFormat(HHMM, new Locale("UTF-8"));
        try {
            Date parse = format.parse(time);
            return format2.format(parse);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "parsing error: ", e);
            return null;
        }
    }

    public static String getDayOfWeek(String date) {
        return getDayOfWeek(date, YYMMDD);
    }

    public static String getDayOfWeek(String date, String formatString) {
        SimpleDateFormat format = new SimpleDateFormat(formatString, new Locale("UTF-8"));
        try {
            Date parse = format.parse(date);
            return getDayOfWeek(parse);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "parsing error: ", e);
            return null;
        }
    }

    public static String getDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        String result = null;
        switch (i) {
            case Calendar.SUNDAY:
                result = "周日";
                break;
            case Calendar.MONDAY:
                result = "周一";
                break;
            case Calendar.TUESDAY:
                result = "周二";
                break;
            case Calendar.WEDNESDAY:
                result = "周三";
                break;
            case Calendar.THURSDAY:
                result = "周四";
                break;
            case Calendar.FRIDAY:
                result = "周五";
                break;
            case Calendar.SATURDAY:
                result = "周六";
                break;
            default:
                break;
        }
        return result;
    }
}
