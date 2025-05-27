package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.davicamargo.taxascom.data.entities.common.BaseEntity;
import com.davicamargo.taxascom.data.enums.ETipoGenero;
import com.davicamargo.taxascom.data.enums.ETipoPronome;
import java.util.List;
import org.threeten.bp.LocalDate;

@Entity(tableName = "freelancers")
public class Freelancer extends BaseEntity {
    public Freelancer(@NonNull String nome,
                      List<ETipoPronome> tiposPronomes,
                      ETipoGenero tipoGenero,
                      @NonNull LocalDate dataNascimento,
                      @NonNull String senha,
                      String celular,
                      @NonNull String email) {
        this.nome = nome;
        Ativo = true;
        this.tiposPronomes = tiposPronomes;
        this.tipoGenero = tipoGenero;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.celular = celular;
        this.email = email;
    }
    @NonNull
    public String nome;
    @NonNull
    public String email;
    public String celular;
    @NonNull
    public String senha;
    @NonNull
    @ColumnInfo(name = "dta_nascimento")
    public LocalDate dataNascimento;
    @ColumnInfo(name = "tipo_genero")
    public ETipoGenero tipoGenero;
    @ColumnInfo(name = "tipos_pronomes")
    public List<ETipoPronome> tiposPronomes;
    @ColumnInfo(name = "flg_ativo")
    public boolean Ativo;
}
