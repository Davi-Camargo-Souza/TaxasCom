package com.davicamargo.taxascom.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.davicamargo.taxascom.data.entities.common.BaseEntity;
import com.davicamargo.taxascom.data.enums.EPagamentoStatus;
import org.threeten.bp.LocalDateTime;
import java.math.BigDecimal;

@Entity(tableName = "pagamentos")
public class Pagamento extends BaseEntity {
    public BigDecimal valor;
    public LocalDateTime dataHoraConclusao;
    @ColumnInfo(name = "cod_status")
    public EPagamentoStatus status;

    public Pagamento(BigDecimal valor, EPagamentoStatus status, LocalDateTime dataHoraConclusao) {
        this.valor = valor;
        this.status = status;
        this.dataHoraConclusao = dataHoraConclusao;
    }
}
