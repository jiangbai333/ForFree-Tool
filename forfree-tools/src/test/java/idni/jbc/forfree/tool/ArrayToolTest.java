package idni.jbc.forfree.tool.date;

import java.util.Calendar;
import java.util.Date;

import idni.jbc.forfree.tool.ArrayTool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayToolTest {

    @Test
    public void testConstructor() { }

    @Test
    public void testReverse() {
        //int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int[] reverseArr1 = ArrayTool.reverse(arr1);
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayTool.reverse(ArrayTool::reverse, arr1);
        for (int i = 0, j = arr1.length - 1; i < arr1.length; i++, j--) {
            System.out.print("arr1-" + i + " : ");
            System.out.println(arr1[i]);
            //System.out.print("reverseArr1-" + j + " : ");
            //System.out.println(reverseArr1[j]);
            //Assert.assertEquals(arr1[i], reverseArr1[j]);
        }
    }
}
