package com.davicamargo.taxascom.ui.ramoAtuacao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.davicamargo.taxascom.data.entities.RamoAtuacao;
import com.davicamargo.taxascom.data.repositories.RamoAtuacaoRepository;
import java.util.List;

public class RamoAtuacaoViewModel extends ViewModel {
    private final RamoAtuacaoRepository repository;
    private final LiveData<List<RamoAtuacao>> todosRamos;

    public RamoAtuacaoViewModel() {
        repository = new RamoAtuacaoRepository();
        todosRamos = repository.getTodosRamos();
    }

    public LiveData<List<RamoAtuacao>> getTodosRamos() {
        return todosRamos;
    }
}
