package com.davicamargo.taxascom.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.davicamargo.taxascom.data.entities.RamoEmpresa;

import java.util.List;

@Dao
public interface RamoEmpresaDao {
    @Query("SELECT * FROM ramo_empresa")
    List<RamoEmpresa> getTodosRamos();
}
