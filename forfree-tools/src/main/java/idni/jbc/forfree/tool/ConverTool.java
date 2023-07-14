package idni.jbc.forfree.tool;

import idni.jbc.forfree.tool.converter.base.StringConverter;

public class ConverTool implements StringConverter<Object> {
    @Override
    public String convert(Object source) { 
        if ( source instanceof Number ||
             source instanceof char[] ||
             source instanceof Character ) {
            return String.valueOf(source);
        } else if ( source instanceof Object ) {
            return String.valueOf(source);
        }
        return null; 
    }
    @Override
    public String convert(String source, String format) { return null; }
}
