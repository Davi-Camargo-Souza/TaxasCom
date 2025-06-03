package com.davicamargo.taxascom.data.converters;

import androidx.room.TypeConverter;
import org.threeten.bp.LocalDate;

public class LocalDateConverter {
    @TypeConverter
    public static LocalDate fromTimestamp(String value) {
        return value == null ? null : LocalDate.parse(value);
    }

    @TypeConverter
    public static String dateToTimestamp(LocalDate date) {
        return date == null ? null : date.toString();
    }
}
