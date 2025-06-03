package com.davicamargo.taxascom.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.davicamargo.taxascom.data.entities.Freelancer;

@Dao
public interface FreelancerDao {
    @Insert
    void inserir(Freelancer freelancer);

    @Query("SELECT * FROM freelancers WHERE email = :email")
    Freelancer obter(String email);
}
