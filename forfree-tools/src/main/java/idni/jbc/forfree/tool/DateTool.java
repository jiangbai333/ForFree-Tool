package idni.jbc.forfree.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import idni.jbc.forfree.tool.date.DateConver;

public final class DateTool {

    private DateTool() { }

    /**
     * 获取当前时间对应的{@link DateConver}对象
     *
     * @return DateConver
     *
     * @since 1.01
     *
     * @see DateConver
     */
    public static DateConver now() {
        return new DateConver();
    }

    /**
     * 获取当前年份 以四位整形表示
     *
     * @return int 以四位整数表示的年份
     *
     * @since 1.01
     *
     * @see DateConver
     * @see java.util.Date
     */
    public static int year() {
        return DateConver.of(new Date()).year();
    }

    /**
     * 通过指定参数获取当前年份 以四位整形表示<br>
     * 可以从时间戳、{java.util.Date}、{java.util.Calendar}提取年份信息
     *
     * @param obj 指定的待转换参数
     * @return int 以四位整数表示的年份
     *
     * @since 1.01
     *
     * @see java.util.Date
     * @see java.util.Calendar
     */
    public static int year(Object obj) {
        int year;
        if ( null == obj ) {
            throw new RuntimeException("无法从【null】构建DateConver");
        }
        if ( obj instanceof Date ) {
            year = DateConver.of((Date)obj).year();
        } else if ( obj instanceof Long ) {
            year = DateConver.of((Long)obj).year();
        } else if ( obj instanceof Calendar ) {
            year = DateConver.of((Calendar)obj).year();
        } else {
            throw new RuntimeException("不可被处理的类型");
        }
        return year;
    }






    /**
     * 获取当前年份 以二位整形表示
     *
     * @return int 以二位整数表示的年份
     *
     * @since 1.01
     */
    public static int sortYear() {
        return year() % 100;
    }

    public static <T> int sortYear(T t) {
        return year(t) % 100;
    }

    /**
     * 获取当前月份
     *
     * @return int
     *
     * @since 1.01
     *
     * @see DateConver
     * @see java.util.Date
     */
    public static int month() {
        return DateConver.of(new Date()).month();
    }

    /**
     * 通过指定的{@link java.util.Date}获取当前月份
     *
     * @param date 指定的{@link java.util.Date}
     * @return int 1-12 1代表一月，12代表十二月
     *
     * @since 1.01
     *
     * @see DateConver
     */
    public static int month(Date date) {
        return DateConver.of(date).month();
    }

    /**
     * 通过指定的时间戳获取当前月份
     *
     * @param timestamp 指定的时间戳
     * @return int 1-12 1代表一月，12代表十二月
     *
     * @since 1.01
     *
     * @see DateConver
     */
    public static int month(long timestamp) {
        return DateConver.of(timestamp).month();
    }

    /**
     * 通过指定的{@link java.util.Calendar}获取当前月份
     *
     * @param calendar 指定的{@link java.util.Calendar}
     * @return int 1-12 1代表一月，12代表十二月
     *
     * @since 1.01
     *
     * @see DateConver
     * @see java.util.Calendar
     */
    public static int month(Calendar calendar) {
        return DateConver.of(calendar).month();
    }

    /*
     *获取当前时间的格式化日期
     *
     */
    public static String dateTime() {
        return dateTime(new DateConver());
    }
    public static String dateTime(Object obj) {
        return dateTime(obj, "yyyy年MM月dd日 hh:mm:ss SSS");
    }
    public static String dateTime(String pattern) {
        return dateTime(new Date(), pattern);
    }

    public static String dateTime(Object obj, String pattern) {
        DateConver dateConver;
        if ( obj instanceof Date ) { dateConver = DateConver.of((Date)obj); }
        else if ( obj instanceof Long ) { dateConver = DateConver.of((Long)obj); }
        else if ( obj instanceof Calendar ) { dateConver = DateConver.of((Calendar)obj); }
        else { throw new RuntimeException("不可被处理的类型"); }

        return (new SimpleDateFormat(pattern)).format(dateConver);
    }

}
