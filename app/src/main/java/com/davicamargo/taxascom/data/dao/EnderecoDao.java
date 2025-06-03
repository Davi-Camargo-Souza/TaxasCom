package com.davicamargo.taxascom.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.davicamargo.taxascom.data.entities.Endereco;

import java.util.List;

@Dao
public interface EnderecoDao {
    @Insert
    void inserir(Endereco endereco);

    @Query("SELECT * FROM enderecos WHERE cep = :cep")
    Endereco buscarPorCep(String cep);
}
