package idni.jbc.forfree.tool.converter.base;

/**
 * 转换器根接口
 *
 * @param <S> source type 要转换的源数据类型
 * @param <T> target type 转换后的目标数据类型
 *
 * @author 姜柏超
 * @version 1.01
 *
 * @since 1.01
 */
public interface Converter<S, T> {

    /**
     * 定义转换行为
     *
     * @param source source type 要转换的源数据类型
     * @return T 按照给定类型T转换后的目标数据
     *
     * @since 1.01
     */
    public T convert(S source);
}
