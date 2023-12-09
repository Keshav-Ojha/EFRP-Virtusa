package com.keshav.employeemanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class DateToStringConverter implements Converter<Date, String>{

	@Override
	public String convert(MappingContext<Date, String> context) {
		Date source = context.getSource();
        if (source == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(source);

	}

}
