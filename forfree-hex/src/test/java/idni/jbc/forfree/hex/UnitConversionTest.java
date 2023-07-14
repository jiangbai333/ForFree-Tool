package idni.jbc.forfree.hex;

import idni.jbc.forfree.hex.UnitConversion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitConversionTest {

    @Test
    public void testConstructor() { }

    @Test
    public void testToHBO() {
        System.out.println(UnitConversion.normalToHBO("10.0.0.0"));
        System.out.println(UnitConversion.normalToHBO("10.255.255.255"));
        System.out.println(UnitConversion.normalToHBO("172.16.0.0"));
        System.out.println(UnitConversion.normalToHBO("172.31.255.255"));
        System.out.println(UnitConversion.normalToHBO("192.168.0.0"));
        System.out.println(UnitConversion.normalToHBO("192.168.255.255"));
    }

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
