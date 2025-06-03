package com.davicamargo.taxascom.ui.endereco;

import androidx.lifecycle.ViewModel;

import com.davicamargo.taxascom.data.entities.Endereco;
import com.davicamargo.taxascom.data.repositories.EnderecoRepository;

public class EnderecoViewModel extends ViewModel {
    private final EnderecoRepository enderecoRepository;

    public EnderecoViewModel(){
        enderecoRepository = new EnderecoRepository();
    }

    public void inserir(Endereco endereco){
        enderecoRepository.inserir(endereco);
    }
}
