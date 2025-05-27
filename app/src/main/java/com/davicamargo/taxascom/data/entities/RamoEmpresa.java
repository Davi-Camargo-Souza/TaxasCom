package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import com.davicamargo.taxascom.data.entities.common.BaseEntity;

@Entity(tableName = "ramo_empresa")
public class RamoEmpresa extends BaseEntity {
    @NonNull
    public String descricao;

    public RamoEmpresa(@NonNull String descricao) {
        this.descricao = descricao;
    }
}
