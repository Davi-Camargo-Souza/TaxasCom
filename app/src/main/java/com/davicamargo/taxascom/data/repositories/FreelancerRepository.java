package com.davicamargo.taxascom.data.repositories;

import com.davicamargo.taxascom.App;
import com.davicamargo.taxascom.data.dao.FreelancerDao;
import com.davicamargo.taxascom.data.database.AppDatabase;
import com.davicamargo.taxascom.data.entities.Freelancer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FreelancerRepository {
    private final FreelancerDao freelancerDao;
    private final Executor executor;

    public FreelancerRepository(){
        AppDatabase db = App.getDatabase();
        freelancerDao = db.freelancerDao();
        executor = Executors.newSingleThreadExecutor();
    }

    public void inserir(Freelancer freelancer) {
        executor.execute(() -> freelancerDao.inserir(freelancer));
    }

    public Freelancer obter(String email){
        return freelancerDao.obter(email);
    }
}
