package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.davicamargo.taxascom.data.entities.common.BaseEntity;
import java.util.UUID;

@Entity(
    tableName = "empresas",
    foreignKeys = {
        @ForeignKey(
                entity = RamoAtuacao.class,
                parentColumns = "cod",
                childColumns = "cod_ramo"
        ),
        @ForeignKey(
                entity = Endereco.class,
                parentColumns = "cod",
                childColumns = "cod_endereco"
        )
    },
    indices = {
        @Index("cod_ramo"),
        @Index(value = "cod_endereco"),
        @Index(value = {"cod"}, unique = true),
        @Index(value = "contato_email", unique = true)
    })
public class Empresa extends BaseEntity {
    public Empresa(@NonNull String nome,
                   @NonNull UUID codRamo,
                   @NonNull String cnpj,
                   @NonNull String senha,
                   @NonNull UUID codEndereco,
                   @NonNull String contatoEmail,
                   String contatoTelefone){
        this.nome = nome;
        this.codRamo = codRamo;
        this.cnpj = cnpj;
        this.senha = senha;
        this.codEndereco = codEndereco;
        this.contatoEmail = contatoEmail;
        this.contatoTelefone = contatoTelefone;
    }

    @NonNull
    public String nome;
    @NonNull
    @ColumnInfo(name = "cod_ramo")
    public UUID codRamo;
    @NonNull
    public String cnpj;
    @NonNull
    public String senha;
    @NonNull
    @ColumnInfo(name = "cod_endereco")
    public UUID codEndereco;
    @NonNull
    @ColumnInfo(name = "contato_email")
    public String contatoEmail;
    @ColumnInfo(name = "contato_telefone")
    public String contatoTelefone;
}
