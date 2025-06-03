package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;

import com.davicamargo.taxascom.data.entities.common.BaseEntity;

@Entity(tableName = "ramo_atuacao",
        indices = {@Index(value = {"cod"}, unique = true)})
public class RamoAtuacao extends BaseEntity {
    @NonNull
    public String descricao;

    public RamoAtuacao(@NonNull String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao; // Para mostrar no Spinner
    }
}
