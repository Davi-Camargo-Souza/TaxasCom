package com.davicamargo.taxascom.data.converters;

import androidx.room.TypeConverter;
import com.davicamargo.taxascom.data.enums.ETipoPronome;
import org.threeten.bp.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ETipoPronomeConverter {
    @TypeConverter
    public static String fromList(List<ETipoPronome> lista) {
        if (lista == null) return null;
        return lista.stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

    @TypeConverter
    public static List<ETipoPronome> toList(String value) {
        if (value == null || value.isEmpty()) return new ArrayList<>();
        return Arrays.stream(value.split(","))
                .map(ETipoPronome::valueOf)
                .collect(Collectors.toList());
    }
}
