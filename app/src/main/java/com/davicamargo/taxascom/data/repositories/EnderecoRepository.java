package com.davicamargo.taxascom.data.repositories;

import com.davicamargo.taxascom.App;
import com.davicamargo.taxascom.data.dao.EnderecoDao;
import com.davicamargo.taxascom.data.entities.Endereco;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EnderecoRepository {
    private final EnderecoDao enderecoDao;
    private final Executor executor;

    public EnderecoRepository(){
        executor = Executors.newSingleThreadExecutor();
        enderecoDao = App.getDatabase().enderecoDao();
    }

    public void inserir(Endereco endereco){
        executor.execute(() -> enderecoDao.inserir(endereco));
    }
}
