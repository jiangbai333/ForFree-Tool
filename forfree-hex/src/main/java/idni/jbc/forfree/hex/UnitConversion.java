package idni.jbc.forfree.hex;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UnitConversion {

    private static class Association {
        private static Map<String, Function<Integer, Long>> dic = new HashMap() {{
            Function<Integer, Long> kByte = (x) -> 1L * 1024 * x,
                                    mByte = (x) -> 1L * 1024 * 1024 * x,
                                    gByte = (x) -> 1L * 1024 * 1024 * 1024 * x;
            put("k", kByte);
            put("kb", kByte);
            put("m", mByte);
            put("mb", mByte);
            put("g", gByte);
            put("gb", gByte);
        }};
    }

    public static Long toByte(int origin, String unit) {
        return Association.dic.get(unit.toLowerCase()).apply(origin);
    }

    /**
     * 点分10进制ip 转为 主机字节顺序格式（HBO，Host Byte Order）
     *
     * @param ip 点分10进制ip，{@link java.lang.String}类型
     * @return int 主机子节序ip
     *
     * @since 1.0.1
     */
    public static long normalToHBO(String ip) {
        long i = 0;
        String[] nums = ip.split("\\.");
        for ( String num : nums ) {
            i = ( i << 8 ) + Integer.parseInt(num);
        }
        return i;
    }

    /**
    * 判断是否为内网ip
     */
    public static boolean isPrivateIp(String ip) {
        return isPrivateIp(normalToHBO(ip));
    }

    /**
    * 判断是否为内网ip
     */
    public static boolean isPrivateIp(long ip) {
        return ( ip > 167772160 && ip < 184549375 )
                || ( ip > 2886729728L && ip < 2887778303L )
                ||  ( ip > 3232235520L && ip < 3232301055L );
    }
}
