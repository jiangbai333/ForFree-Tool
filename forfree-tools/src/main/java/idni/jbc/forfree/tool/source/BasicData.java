package idni.jbc.forfree.tool.source;

import java.util.function.Supplier;

public class BasicData {
    public static <T> T build(Supplier<T> action) {
        return action.get();
    }

}
