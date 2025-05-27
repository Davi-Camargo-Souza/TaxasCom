package com.davicamargo.taxascom.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.davicamargo.taxascom.data.entities.common.BaseEntity;
import com.davicamargo.taxascom.data.enums.ETaxaStatus;
import org.threeten.bp.LocalDateTime;
import java.util.UUID;

@Entity(
    tableName = "taxas",
    foreignKeys = {
            @ForeignKey(
                    entity = Funcao.class,
                    parentColumns = "cod",
                    childColumns = "cod_funcao"
            ),
            @ForeignKey(
                    entity = Empresa.class,
                    parentColumns = "cod",
                    childColumns = "cod_empresa"
            ),
            @ForeignKey(
                    entity = Freelancer.class,
                    parentColumns = "cod",
                    childColumns = "cod_freelancer"
            ),
    },
    indices = {
            @Index("cod_funcao"),
            @Index("cod_empresa"),
            @Index("cod_freelancer")
    })
public class Taxa extends BaseEntity {
    public String descricao;
    @NonNull
    @ColumnInfo(name = "cod_funcao")
    public UUID codFuncao;
    @NonNull
    @ColumnInfo(name = "cod_empresa")
    public UUID codEmpresa;
    @ColumnInfo(name = "cod_freelancer")
    public UUID codFreelancer;
    @ColumnInfo(name = "dta_hr_inicio")
    public LocalDateTime dataHoraInicio;
    @ColumnInfo(name = "dta_hr_fim")
    public LocalDateTime dataHoraFim;
    @ColumnInfo(name = "horas_diarias")
    public int horasDiarias;
    @NonNull
    @ColumnInfo(name = "cod_status")
    public ETaxaStatus status;

    public Taxa(String descricao,
                @NonNull ETaxaStatus status,
                int horasDiarias,
                LocalDateTime dataHoraFim,
                UUID codFreelancer,
                @NonNull UUID codEmpresa,
                @NonNull UUID codFuncao,
                LocalDateTime dataHoraInicio) {
        this.descricao = descricao;
        this.status = status;
        this.horasDiarias = horasDiarias;
        this.dataHoraFim = dataHoraFim;
        this.codFreelancer = codFreelancer;
        this.codEmpresa = codEmpresa;
        this.codFuncao = codFuncao;
        this.dataHoraInicio = dataHoraInicio;
    }
}
