package idni.jbc.forfree.hex;

import idni.jbc.forfree.hex.UnitConversion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitConversionTest {

    @Test
    public void testConstructor() { }

    @Test
    public void testToByte() {
        Assert.assertEquals(Long.valueOf(1024), (Long)UnitConversion.toByte(1, "k"));
        Assert.assertEquals(Long.valueOf(1024), (Long)UnitConversion.toByte(1, "K"));
        Assert.assertEquals(Long.valueOf(1024 * 1024), (Long)UnitConversion.toByte(1, "m"));
        Assert.assertEquals(Long.valueOf(1024 * 1024), (Long)UnitConversion.toByte(1, "M"));
        Assert.assertEquals(Long.valueOf(1024 * 1024 * 1024), (Long)UnitConversion.toByte(1, "g"));
        Assert.assertEquals(Long.valueOf(1024 * 1024 * 1024), (Long)UnitConversion.toByte(1, "G"));
    }
}
