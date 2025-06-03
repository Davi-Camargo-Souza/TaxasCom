package com.davicamargo.taxascom.data.converters;

import androidx.room.TypeConverter;
import org.threeten.bp.LocalDateTime;

public class LocalDateTimeConverter {
    @TypeConverter
    public static LocalDateTime fromTimestamp(String value) {
        return value == null ? null : LocalDateTime.parse(value);
    }

    @TypeConverter
    public static String dateToTimestamp(LocalDateTime date) {
        return date == null ? null : date.toString();
    }
}