package com.davicamargo.taxascom.data.entities.common;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import org.threeten.bp.LocalDateTime;
import java.util.UUID;

public class BaseEntity {
    public BaseEntity(){
        dataHoraCadastro = LocalDateTime.now();
        cod = UUID.randomUUID();
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public UUID cod;

    @NonNull
    @ColumnInfo(name = "dta_hr_cadastro")
    public LocalDateTime dataHoraCadastro;

    @ColumnInfo(name = "dta_hr_ultima_modificacao")
    public LocalDateTime dataHoraUltimaModificacao;
}
