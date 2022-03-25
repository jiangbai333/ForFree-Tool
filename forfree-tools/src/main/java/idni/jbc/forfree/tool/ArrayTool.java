package idni.jbc.forfree.tool;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import com.google.common.collect.ImmutableMap;

public final class ArrayTool {

    private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS = new ImmutableMap.Builder<Class<?>, Class<?>>()
      .put(boolean.class, Boolean.class)
      .put(byte.class, Byte.class)
      .put(char.class, Character.class)
      .put(double.class, Double.class)
      .put(float.class, Float.class)
      .put(int.class, Integer.class)
      .put(long.class, Long.class)
      .put(short.class, Short.class)
      .put(void.class, Void.class)
      .build();

    private ArrayTool() { }

    public static int[] reverse(int[] arr) {
        int length = arr.length;
        int[] rt = new int[length--];
        for (int i = 0, j = length; i <= j; ) {
            rt[j] = arr[i];
            rt[i++] = arr[j--];
        }
        return rt;
    }

    /*public static int[] reverse(int[] arr) {
        Object[] transformArr = Array.newInstance(PRIMITIVES_TO_WRAPPERS.get(arr.getClass().getComponentType()), arr.length);
        return arr;
    }

    public static <T> T[] reverse(T[] arr, Class<? extends T[]> type) {
        T[] rt = ((Object) type == (Object) Object[].class)
            ? (T[]) new Object[arr.length]
            : (T[]) Array.newInstance(type.getComponentType(), arr.length);

        for ( int i = 0, j = arr.length - 1; i <= j; ) {
            rt[i] = arr[j];
            rt[j--] = arr[i++];
        }

        return rt;
    }*/

    public static <T> void reverse(Consumer<T[]> handle, T[] arr) {
        handle.accept(arr);
    }

    public static <T, R> R[] reverse(Function<T[], R[]> handle, T[] arr) {
        handle.apply(arr);
    }

    public static <T> void reverse(T[] a) {
        for (int i = 0, j = a.length; i <= j; ) {
            T t = a[i];
            a[i++] = a[j];
            a[j++] = t;
        }
    }

    /*public static <T> T[] reverse(T[] arr) {
        T[] rt = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
        for ( int i = 0, j = arr.length - 1; i <= j; ) {
            rt[i] = arr[j];
            rt[j--] = arr[i++];
        }
        return rt;
    }*/

    /**
     * 翻转给定的数组, 此方法会改变原始数组(形参引用的原始数组)
     *
     * @param <T> 传入数组类型
     * @param arr 需要翻转的数组
     *
     * @since 1.01
     */
    //public static <T> void reverse(T[] arr) {
        //[>* i 小于 j 时, 如果数组长度为奇数，则最中间的元素不会被操作 <]
        //[>* i 小于等于 j 时, 如果数组长度为奇数，则最中间的元素会被操作两次<]
        //for ( int i = 0, j = arr.length - 1; i <= j; ) {
            //T temp = arr[i];
            //arr[i++] = arr[j];
            //arr[j--] = temp;
        //}
    //}
}
