package idni.jbc.forfree.tool.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 负责针对显示格式对{@link DateConver}进行格式化
 * @author 姜柏超
 * @version 1.01
 *
 * @since 1.01
 *
 * @see DateConver
 * @see java.util.Date
 * @see java.util.TimeZone
 * @see java.util.Calendar
 * @see java.text.SimpleDateFormat
 */
public final class FreeFormat {
    /** 返回中文形式24小时制日期、时间,如:2020年08月11日 星期二 14:09:51 */
    public final static String FULL_DATETIME_INDAY_ZH = "yyyy年MM月dd日 E kk:mm:ss";

    /** 返回中文形式日期、时间,如:2020年08月11日 日期二 下午 02:09:51 */
    public final static String FULL_DATETIME_ZH = "yyyy年MM月dd日 E a hh:mm:ss";

    /** 返回日期、时间,如:2020-08-11 02:09:51 */
    public final static String FULL_DATETIME = "yyyy-MM-dd hh:mm:ss";

    /** 缓存{@link java.text.SimpleDateFormat}对象 */
    public static SimpleDateFormat sdf;

    private static FreeFormat freeFormat = null;

    private FreeFormat() {
        sdf = new SimpleDateFormat();
    }

    /**
     * 获取{@link FreeFormat}单例
     *
     * @return {@link FreeFormat}
     */
    public static FreeFormat getInstance() {
        if ( freeFormat.equals(null) ) {
            freeFormat = new FreeFormat();
        }
        return freeFormat;
    }

    public void applyPattern(String pattern) {
        try {
            FreeFormat.sdf.applyPattern(pattern);
        } catch( NullPointerException e ){
            e.printStackTrace();
        } catch( IllegalArgumentException e ) {
            e.printStackTrace();
        }
    }

    public String dateTimt(Date date) {
        return sdf.format(FULL_DATETIME_INDAY_ZH);
    }
}
