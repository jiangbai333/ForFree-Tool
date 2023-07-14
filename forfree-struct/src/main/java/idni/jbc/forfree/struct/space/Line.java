package idni.jbc.forfree.struct.space;

import idni.jbc.forfree.struct.space.Point;

public class Line<T extends Number> {

    private Point<T> start;
    private Point<T> end;

    private Line() { }

    public Line(Line<T> line) {
        this.start = line.getStart();
        this.end = line.getEnd();
    }

    public Line(Point<T> start, Point<T> end) {
        this.start = start;
        this.end = end;
    }

    public void setStart(Point<T> start) {
        this.start = start;
    }

    public Point<T> getStart() {
        return start;
    }

    public void setEnd(Point<T> end) {
        this.end = end;
    }

    public Point<T> getEnd() {
        return end;
    }

    public Double getDistance() {
        return this.start.getDistance(this.end);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Line{");
        sb.append("start = ").append(getStart());
        sb.append(", end = ").append(getEnd());
        return sb.append("}").toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line object = (Line) o;

        if (start != null ? !start.equals(object.start) : object.start != null) return false;
        return !(end != null ? !end.equals(object.end) : object.end != null);
    }

    /*private final Point<? extends Number>[] points = new Point<?>[2];

    private Line() { }

    public Line(Point<T> p1, Point<T> p2) {
        this.points[0] = p1;
        this.points[1] = p2;
    }

    public Point<? extends Number>[] getPoints() {
        return points;
    }*/
}
