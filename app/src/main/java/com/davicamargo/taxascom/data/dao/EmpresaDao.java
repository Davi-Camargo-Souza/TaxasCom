package com.davicamargo.taxascom.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.davicamargo.taxascom.data.entities.Empresa;

@Dao
public interface EmpresaDao {
    @Insert
    public void inserir(Empresa empresa);
}
