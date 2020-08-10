package idni.jbc.forfree.tool.date;

import java.util.Calendar;
import java.util.Date;

import idni.jbc.forfree.tool.date.DateConver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateConverTest {

    private DateConver dateConver;

    @Before
    public void init() {
        dateConver = new DateConver();
    }

    @Test
    public void testConstructor() {
        
    }
    @Test
    public void testMonth() {
        Assert.assertEquals(2020, dateConver.year());
        Assert.assertEquals(2020, DateConver.of(dateConver).year());
        Assert.assertEquals(2020, DateConver.of(new Date()).year());
        Assert.assertEquals(8, DateConver.of(dateConver.getTime()).month());
        Assert.assertEquals(7, DateConver.of(Calendar.getInstance()).julianMonth());
    }
}
