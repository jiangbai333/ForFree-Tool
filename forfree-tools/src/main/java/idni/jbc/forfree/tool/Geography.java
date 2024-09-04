package idni.jbc.forfree.tool;

/**
 * 经度： 英文longitude 缩写lng；纬度：英文latitude 缩写lat
 */
public final class Geography {

    /** 地球平均半径 */
    public final static double RADIUS = 6371000;

    private Geography() { }

    /**
     * 获取地理位置.
     *
     * @param lng1 坐标1的经度
     * @param lat1 坐标1的纬度
     * @param lng2 坐标2的经度
     * @param lat2 坐标2的纬度
     *
     * @return 坐标1与坐标2的距离 单位【米】
     */
    public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
        // 纬度角转弧度
        double latRadian1 = Math.toRadians(lat1), latRadian2 = Math.toRadians(lat2);
        // 纬度 d𝒓
        double dLatRadian = latRadian1 - latRadian2;
        // 经度 d𝒓
        double dLngRadian = Math.toRadians(lng1) - Math.toRadians(lng2);
        return Math.round(RADIUS * 2 * Math.asin(Math.sqrt((1 - Math.cos(dLatRadian)) / 2 + Math.cos(latRadian1) * Math.cos(latRadian2) * (1 - Math.cos(dLngRadian)) / 2)) * 10000D) / 10000D;
    }
}
