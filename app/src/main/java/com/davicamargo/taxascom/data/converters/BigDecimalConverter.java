package com.davicamargo.taxascom.data.converters;

import androidx.room.TypeConverter;
import java.math.BigDecimal;

public class BigDecimalConverter {
    @TypeConverter
    public static BigDecimal fromString(String value) {
        return value == null ? null : new BigDecimal(value);
    }

    @TypeConverter
    public static String toString(BigDecimal value) {
        return value == null ? null : value.toPlainString();
    }
}
