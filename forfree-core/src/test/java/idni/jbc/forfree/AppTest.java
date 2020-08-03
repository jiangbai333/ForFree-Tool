package idni.jbc.forfree;

import idni.jbc.forfree.App;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private App app;

    @Before
    public void init() {
        app = new App();
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(2, app.add(1,1));
    }
}
