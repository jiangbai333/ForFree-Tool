package idni.jbc.forfree.tool.date;

import java.util.Date;

/**
 * 封装 {@link Date} 添加部分工具方法
 * @since 1.01
 * @author 姜柏超
 * @version 1.01
 */
public class DateConver extends Date {

    /**
     * 通过指定Date 获取DateConver实例
     *
     * <pre>
     *{@code
    * Date d = new Date();
    * DateConver dc = DateConver.from(d);
    * }
     * </pre>
     *
     * @param date Date date
     * @return DateConver from Date
     */
    public static DateConver from (Date date) {
        return date instanceof DateConver ? (DateConver) date : new DateConver(date);
    }

    public DateConver(Date date) {
        this(date.getTime());
    }

    public DateConver(Long timeMillis) {
        super(timeMillis);
    }

}
