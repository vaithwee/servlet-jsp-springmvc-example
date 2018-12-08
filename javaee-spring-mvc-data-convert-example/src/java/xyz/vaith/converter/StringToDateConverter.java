package xyz.vaith.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    private String datePatten;

    public StringToDateConverter(String datePatten) {
        this.datePatten = datePatten;
        System.out.println("instantiating .... converter with pattern: *" + datePatten);
    }

    @Override
    public Date convert(String s) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(datePatten);
            format.setLenient(false);
            return format.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date format. Please use this pattern \"" + datePatten + "\"");
        }
    }
}
