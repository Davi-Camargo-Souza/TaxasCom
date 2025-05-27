package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.davicamargo.taxascom.data.entities.common.BaseEntity;
import java.util.UUID;

@Entity(tableName = "beneficios",
    foreignKeys = @ForeignKey(
            entity = Taxa.class,
            parentColumns = "cod",
            childColumns = "cod_taxa"
    ),
    indices = @Index("cod_taxa"))
public class Beneficio extends BaseEntity {
    @NonNull
    public String descricao;
    @NonNull
    @ColumnInfo(name = "cod_taxa")
    public UUID codTaxa;

    public Beneficio(@NonNull String descricao, @NonNull UUID codTaxa) {
        this.descricao = descricao;
        this.codTaxa = codTaxa;
    }
}
