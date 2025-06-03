package com.davicamargo.taxascom.data.repositories;

import androidx.lifecycle.LiveData;
import com.davicamargo.taxascom.App;
import com.davicamargo.taxascom.data.dao.RamoAtuacaoDao;
import com.davicamargo.taxascom.data.entities.RamoAtuacao;
import java.util.List;

public class RamoAtuacaoRepository {
    private final RamoAtuacaoDao dao;
    private final LiveData<List<RamoAtuacao>> todosRamos;

    public RamoAtuacaoRepository() {
        dao = App.getDatabase().ramoAtuacaoDao();
        todosRamos = dao.getTodosRamos();
    }

    public LiveData<List<RamoAtuacao>> getTodosRamos() {
        return todosRamos;
    }
}
