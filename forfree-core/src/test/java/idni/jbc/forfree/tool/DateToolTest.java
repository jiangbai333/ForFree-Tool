package idni.jbc.forfree.tool.date;

import java.util.Calendar;
import java.util.Date;

import idni.jbc.forfree.tool.DateTool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateToolTest {

    @Test
    public void testConstructor() { }

    @Test
    public void testMonth() {

        //Assert.assertEquals(11, DateTool.month());
        //Assert.assertEquals(11, DateTool.month(new Date()));
        //Assert.assertEquals(11, DateTool.month(Calendar.getInstance()));
    }

    @Test
    public void testDateTime() {
        //Assert.assertTrue(DateTool.dateTime().matches("\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}:\\d{2} \\d{3}"));
        //Assert.assertTrue(DateTool.dateTime(new Date()).matches("\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}:\\d{2} \\d{3}"));
        //Assert.assertTrue(DateTool.dateTime(1597818380424L).matches("\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}:\\d{2} \\d{3}"));
        //Assert.assertTrue(DateTool.dateTime(Calendar.getInstance()).matches("\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}:\\d{2} \\d{3}"));
        //Assert.assertTrue(DateTool.dateTime(0.1).matches("\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}:\\d{2} \\d{3}"));
    }

    @Test
    public void testYear() {
        //Assert.assertEquals(2020, DateTool.year());
        Assert.assertEquals(2024, DateTool.year(new Date()));
        //Assert.assertEquals(2020, DateTool.year(1597818380424L));
        Assert.assertEquals(2024, DateTool.year(Calendar.getInstance()));
        //Assert.assertEquals(2020, DateTool.year(0.1));
    }
}
