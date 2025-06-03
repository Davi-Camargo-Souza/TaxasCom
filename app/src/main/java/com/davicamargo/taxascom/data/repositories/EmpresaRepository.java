package com.davicamargo.taxascom.data.repositories;

import com.davicamargo.taxascom.App;
import com.davicamargo.taxascom.data.dao.EmpresaDao;
import com.davicamargo.taxascom.data.entities.Empresa;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EmpresaRepository {
    private final EmpresaDao empresaDao;
    private final Executor executor;

    public EmpresaRepository(){
        var db = App.getDatabase();
        empresaDao = db.empresaDao();
        executor = Executors.newSingleThreadExecutor();
    }

    public void inserir(Empresa empresa){
        executor.execute(() -> empresaDao.inserir(empresa));
    }
}
