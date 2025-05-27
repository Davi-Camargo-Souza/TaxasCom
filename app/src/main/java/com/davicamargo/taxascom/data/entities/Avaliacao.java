package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.davicamargo.taxascom.data.entities.common.BaseEntity;
import com.davicamargo.taxascom.data.enums.ETipoAvaliacao;
import java.util.UUID;

@Entity(tableName = "avaliacoes",
    foreignKeys = @ForeignKey(
            entity = Taxa.class,
            parentColumns = "cod",
            childColumns = "cod_taxa"
    ),
    indices = @Index("cod_taxa"))
public class Avaliacao extends BaseEntity {
    @NonNull
    @ColumnInfo(name = "cod_tipo")
    public ETipoAvaliacao tipoAvaliacao;
    public int nota;
    public String resumo;
    @NonNull
    @ColumnInfo(name = "cod_taxa")
    public UUID codTaxa;

    public Avaliacao(@NonNull ETipoAvaliacao tipoAvaliacao, int nota, String resumo, @NonNull UUID codTaxa) {
        this.tipoAvaliacao = tipoAvaliacao;
        this.nota = nota;
        this.resumo = resumo;
        this.codTaxa = codTaxa;
    }
}