package com.davicamargo.taxascom.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.davicamargo.taxascom.data.entities.RamoAtuacao;
import java.util.List;

@Dao
public interface RamoAtuacaoDao {

    @Insert
    void inserir(RamoAtuacao ramoAtuacao);

    @Query("SELECT * FROM ramo_atuacao ORDER BY descricao ASC")
    LiveData<List<RamoAtuacao>> getTodosRamos();
}
