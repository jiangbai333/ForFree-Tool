package idni.jbc.forfree.struct.space;

import java.util.List;

public class Plane<T extends Number> {
    private List<? extends Point<? extends T>> points;

    public Plane() { }

    public Plane(List<? extends Point<? extends T>> points) throws Exception {
        setPoints(points);
    }

    public void setPoints(List<? extends Point<? extends T>> points) throws Exception {
        if (points.size() < 3) throw new Exception("坐标点数量过少");
    }
}
