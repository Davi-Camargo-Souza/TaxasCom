package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import com.davicamargo.taxascom.data.entities.common.BaseEntity;

@Entity(tableName = "enderecos")
public class Endereco extends BaseEntity {
    public Endereco(@NonNull String rua,
                    @NonNull String pais,
                    @NonNull String cep,
                    @NonNull String cidade,
                    @NonNull String bairro,
                    String complemento,
                    int numero,
                    @NonNull String estado) {
        this.rua = rua;
        this.pais = pais;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
        this.estado = estado;
    }
    @NonNull
    public String rua;
    public int numero;
    public String complemento;
    @NonNull
    public String bairro;
    @NonNull
    public String cidade;
    @NonNull
    public String estado;
    @NonNull
    public String cep;
    @NonNull
    public String pais;
}

