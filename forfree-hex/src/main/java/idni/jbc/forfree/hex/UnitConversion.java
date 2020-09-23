package idni.jbc.forfree.hex;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UnitConversion {

    private static class Association {
        private static Map<String, Function<Integer, Long>> dic = new HashMap() {{
            Function<Integer, Long> kByte = (x) -> 1L * 1024 * x;
            Function<Integer, Long> mByte = (x) -> 1L * 1024 * 1024 * x;
            Function<Integer, Long> gByte = (x) -> 1L * 1024 * 1024 * 1024 * x;
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
}
