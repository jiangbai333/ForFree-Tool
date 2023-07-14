package idni.jbc.forfree.struct.space;

/**
 * 描述直角坐标系中的一个点
 *
 * @param <T> 坐标点值的数据类型
 */
public class Point<T extends Number> {

    private T x;
    private T y;

    public Point() { }

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point<T> point) {
        this(point.x, point.y);
    }

    public Double getDistance(Point<T> target) {
        Double dx = this.x.doubleValue() - target.getX().doubleValue();
        Double dy = this.y.doubleValue() - target.getY().doubleValue();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point object = (Point) o;

        if (x != null ? !x.equals(object.x) : object.x != null) return false;
        return !(y != null ? !y.equals(object.y) : object.y != null);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x = ").append(x);
        sb.append(", y = ").append(y);
        return sb.append("}").toString();
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }
}
