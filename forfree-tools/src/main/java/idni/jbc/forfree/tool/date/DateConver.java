package idni.jbc.forfree.tool.date;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 封装 {@link java.util.Date} 添加部分工具方法
 * @author 姜柏超
 * @version 1.01
 *
 * @since 1.01
 *
 * @see java.util.Date
 * @see java.util.TimeZone
 * @see java.util.Calendar
 */
public class DateConver extends Date {

    private static final long serialVersionUID = 1L;

    /** 当前实例所指向的时间戳 */
    private Long timestamp;

    /** 当前实例所指向的时区 */
    private final TimeZone timeZone;

    /** 构造calendar */
    private final Calendar calendar = Calendar.getInstance();

    /**
     * 通过指定{@link java.util.Date}获取DateConver实例
     *
     * <pre>
     * Date d = new Date();
     * DateConver dc = DateConver.from(d);
     * </pre>
     *
     * @param date 指定的{@link java.util.Date}对象
     * @return {@link DateConver} 通过指定{@link java.util.Date}生成的DateConver对象
     *
     * @since 1.01
     *
     * @see java.util.Date
     */
    public static DateConver of(final Date date) {
        return date instanceof DateConver ? (DateConver) date : new DateConver(date);
    }

    /**
     * 通过指定时间戳获取DateConver实例
     *
     * <br>
     * 
     * <pre>
     * Long t1 = 1596524806462L;
     *
     * DateConver dc1 = DateConver.from(t1);
     * </pre>
     *
     * @param timestamp 指定的时间戳
     * @return {@link DateConver} 通过指定时间戳生成的DateConver对象
     *
     * @since 1.01
     *
     * @see java.util.Date
     */
    public static DateConver of(final long timestamp) {
        return new DateConver(timestamp);
        // throw new IllegalArgumentException("传入的时间戳有误");
    }

    /**
     * 通过指定{@link java.util.Calendar}获取DateConver实例
     *
     * <br>
     * 
     * <pre>
     * Calendar cal = Calendar.getInstance();
     *
     * DateConver dc = DateConver.from(cal);
     * </pre>
     *
     * @param calendar 指定的{@link java.util.Calendar}
     * @return {@link DateConver} 通过指定{@link java.util.Calendar}生成的DateConver对象
     *
     * @since 1.01
     *
     * @see java.util.Calendar
     */
    public static DateConver of(final Calendar calendar) {
        return new DateConver(calendar);
    }

    /**
     * 通过指定时间戳以及给定的时区 构造DateConver实例
     * 
     * @param timeMillis 指定的时间戳
     * @param timeZone   指定的{@link java.util.TimeZone}
     *
     * @since 1.01
     *
     * @see java.util.TimeZone
     */
    private DateConver(final long timeMillis, final TimeZone timeZone) {
        super(timeMillis);
        this.timeZone = timeZone;
        this.calendar.setTime(this);
    }

    /**
     * 通过指定{@link java.util.Date}以及给定的时区 构造DateConver实例
     * 
     * @param date     指定的{@link java.util.Date}
     * @param timeZone 指定的{@link java.util.TimeZone}
     *
     * @since 1.01
     *
     * @see java.util.Date
     * @see java.util.TimeZone
     */
    private DateConver(final Date date, final TimeZone timeZone) {
        this(date.getTime(), timeZone);
    }

    /**
     * 通过指定时间戳 构造DateConver实例
     *
     * @param timeMillis 指定的时间戳
     *
     * @since 1.01
     */
    private DateConver(final long timeMillis) {
        this(timeMillis, TimeZone.getDefault());
    }

    /**
     * 通过指定Date 构造DateConver实例
     *
     * @param date 指定的{@link java.util.Date}对象
     *
     * @since 1.01
     *
     * @see java.util.Date
     */
    private DateConver(final Date date) {
        this(date.getTime());
    }

    /**
     * 通过指定Calendar 构造DateConver实例
     *
     * @param calendar 指定的{@link java.util.Calendar}对象
     *
     * @since 1.01
     *
     * @see java.util.Calendar
     */
    private DateConver(final Calendar calendar) {
        this(calendar.getTime());
    }

    /**
     * 以当前时间为基准 构造DateConver实例
     *
     * @since 1.01
     *
     * @see java.util.TimeZone
     * @see java.util.Date
     */
    public DateConver() {
        this(new Date().getTime(), TimeZone.getDefault());
    }

    /**
     * 返回当前实例所指向时间的所属年
     *
     * @return int 以四位整数表示的年份
     *
     * @since 1.01
     *
     * @see java.util.Calendar
     */
    public int year() {
        return this.calendar.get(this.calendar.YEAR);
    }

    /**
     * 返回当前实例表示的月<br>
     *
     * @return int 返回值范围是1-12，1代表一月，12代表十二月
     *
     * @since 1.01
     *
     * @see java.util.Calendar
     */
    public int month() {
        return this.julianMonth() + 1;
    }

    /**
     * 返回当前实例以格列高利历(Gregorian) /朱利安历(Julian)表示的月<br>
     *
     * @return int 返回值范围是0-11，0代表一月，11代表十二月
     *
     * @since 1.01
     *
     * @see java.util.Calendar
     */
    public int julianMonth() {
        return this.calendar.get(this.calendar.MONTH);
    }
}
