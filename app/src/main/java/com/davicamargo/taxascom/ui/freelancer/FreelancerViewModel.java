package com.davicamargo.taxascom.ui.freelancer;

import androidx.lifecycle.ViewModel;
import com.davicamargo.taxascom.data.repositories.FreelancerRepository;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.concurrent.Executors;
import com.davicamargo.taxascom.data.entities.Freelancer;

public class FreelancerViewModel extends ViewModel {
    private final FreelancerRepository repository;
    private final Executor executor;

    public FreelancerViewModel() {
        repository = new FreelancerRepository();
        executor = Executors.newSingleThreadExecutor();
    }

    public void inserir(Freelancer freelancer) {
        repository.inserir(freelancer);
    }

    public void verificarEmail(String email, Consumer<Boolean> callback) {
        executor.execute(() -> {
            Freelancer f = repository.obter(email);
            boolean existe = f != null;
            callback.accept(existe);
        });
    }
}
