package com.keshav.employeemanagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class StringToDateConverter implements Converter<String, Date>{

	@Override
    public Date convert(MappingContext<String, Date> context) {
        String source = context.getSource();
        if (source == null) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(source);
        } catch (ParseException e) {
            // Handle parsing exception if needed
            throw new IllegalArgumentException("Unable to parse date: " + source);
        }
    }
}
