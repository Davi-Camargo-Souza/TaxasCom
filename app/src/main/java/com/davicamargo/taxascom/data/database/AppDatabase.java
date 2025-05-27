package com.davicamargo.taxascom.data.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.davicamargo.taxascom.data.entities.Avaliacao;
import com.davicamargo.taxascom.data.entities.Beneficio;
import com.davicamargo.taxascom.data.entities.Empresa;
import com.davicamargo.taxascom.data.entities.Endereco;
import com.davicamargo.taxascom.data.entities.Freelancer;
import com.davicamargo.taxascom.data.entities.Funcao;
import com.davicamargo.taxascom.data.entities.Pagamento;
import com.davicamargo.taxascom.data.entities.RamoEmpresa;
import com.davicamargo.taxascom.data.entities.Taxa;

@Database(
        entities = {
                Avaliacao.class,
                Beneficio.class,
                Empresa.class,
                Endereco.class,
                Freelancer.class,
                Funcao.class,
                Pagamento.class,
                RamoEmpresa.class,
                Taxa.class
        },
        version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "taxascom.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
