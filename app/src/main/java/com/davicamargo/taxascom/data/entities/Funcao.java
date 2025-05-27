package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import com.davicamargo.taxascom.data.entities.common.BaseEntity;

@Entity(tableName = "funcoes")
public class Funcao extends BaseEntity {
    public Funcao(@NonNull String descricao){
        this.descricao = descricao;
    }
    @NonNull
    public String descricao;
}
