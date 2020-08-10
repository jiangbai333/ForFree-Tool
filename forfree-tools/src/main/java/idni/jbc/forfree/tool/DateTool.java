package idni.jbc.forfree.tool;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import idni.jbc.forfree.tool.date.DateConver;

public class DateTool {

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
     * 通过指定的{@link java.util.Date}获取当前年份 以四位整形表示
     *
     * @param date 指定的{@link java.util.Date}
     * @return int 以四位整数表示的年份
     *
     * @since 1.01
     *
     * @see DateConver
     * @see java.util.Date
     */
    public static int year(Date date) {
        return DateConver.of(date).year();
    }

    /**
     * 通过指定的时间戳获取当前年份 以四位整形表示
     *
     * @param timestamp 指定的时间戳
     * @return int 以四位整数表示的年份
     *
     * @since 1.01
     *
     * @see DateConver
     * @see java.util.Date
     */
    public static int year(long timestamp) {
        return DateConver.of(timestamp).year();
    }

    /**
     * 通过指定的{@link java.util.Calendar}获取当前年份 以四位整形表示
     *
     * @param calendar 指定的{@link java.util.Calendar}
     * @return int 以四位整数表示的年份
     *
     * @since 1.01
     *
     * @see java.util.Calendar
     */
    public static int year(Calendar calendar) {
        return DateConver.of(calendar).year();
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

    /**
     * 通过指定的{@link java.util.Date}获取当前年份 以二位整形表示
     *
     * @param date 指定的{@link java.util.Date}
     * @return int 以二位整数表示的年份
     *
     * @since 1.01
     *
     * @see java.util.Date
     */
    public static int sortYear(Date date) {
        return year(date) % 100;
    }

    /**
     * 通过指定的时间戳获取当前年份 以二位整形表示
     *
     * @param timestamp 指定的时间戳
     * @return int 以二位整数表示的年份
     *
     * @since 1.01
     */
    public static int sortYear(long timestamp) {
        return year(timestamp) % 100;
    }

    /**
     * 通过指定的{@link java.util.Calendar}获取当前年份 以二位整形表示
     *
     * @param calendar 指定的{@link java.util.Calendar}
     * @return int 以二位整数表示的年份
     *
     * @since 1.01
     *
     * @see java.util.Calendar
     */
    public static int sortYear(Calendar calendar) {
        return year(calendar) % 100;
    }

    /**
     * 获取当前月份
     *
     * @return int
     *
     * @since 1.01
     *
     * @see DateConver
     */
    public static int month() {
        return DateConver.of(new Date()).month();
    }

    /**
     * 通过指定的{@link java.util.Date}获取当前月份
     *
     * @return int 1-12 1代表一月，12代表十二月
     *
     * @since 1.01
     *
     * @see DateConver
     */
    public static int month(Date date) {
        return DateConver.of(date).month();
    }
}
