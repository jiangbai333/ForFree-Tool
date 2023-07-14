package idni.jbc.forfree.struct.space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import idni.jbc.forfree.struct.space.Plane;
import idni.jbc.forfree.struct.space.Point;
import idni.jbc.forfree.struct.tree.BinaryTree;

public class PointTest {

    @Test
    public void testConstructor() { }

    @Test
    public void testDepth()  throws Exception {
        Point<Float> p1 = new Point<>(0f, 3f);
        Point<Float> p2 = new Point<>(4f, 0f);
        Point<Float> p3 = new Point<>(8f, 5f);
        Line<Float> l = new Line<>(p1, p2);
        double ddd = l.getDistance();
        System.out.println(ddd);

        List<Point<Float>> lp = new ArrayList<Point<Float>>();
        lp.add(p1);
        lp.add(p2);
        lp.add(p3);

        Point<? extends Float> po = new Point<Float>(1f, 2f);

        Plane<Float> plane = new Plane<Float>(lp);
    }
}
