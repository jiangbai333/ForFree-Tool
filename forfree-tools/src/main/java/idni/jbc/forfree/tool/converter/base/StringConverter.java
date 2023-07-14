package idni.jbc.forfree.tool.converter.base;

import idni.jbc.forfree.tool.converter.base.Converter;

public interface StringConverter<S> extends Converter<S, String> {
    public String convert(S source);
    public String convert(String source, String format);
}
