package com.davicamargo.taxascom.ui.empresa;

import androidx.lifecycle.ViewModel;
import com.davicamargo.taxascom.data.entities.Empresa;
import com.davicamargo.taxascom.data.repositories.EmpresaRepository;

public class EmpresaViewModel extends ViewModel {
    private final EmpresaRepository empresaRepository;

    public EmpresaViewModel(){
        empresaRepository = new EmpresaRepository();
    }

    public void inserir(Empresa empresa){
        empresaRepository.inserir(empresa);
    }
}
