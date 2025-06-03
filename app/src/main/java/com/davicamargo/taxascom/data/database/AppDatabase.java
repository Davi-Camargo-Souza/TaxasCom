package com.davicamargo.taxascom.data.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.davicamargo.taxascom.data.converters.BigDecimalConverter;
import com.davicamargo.taxascom.data.converters.ETipoPronomeConverter;
import com.davicamargo.taxascom.data.converters.LocalDateConverter;
import com.davicamargo.taxascom.data.converters.LocalDateTimeConverter;
import com.davicamargo.taxascom.data.dao.EmpresaDao;
import com.davicamargo.taxascom.data.dao.EnderecoDao;
import com.davicamargo.taxascom.data.dao.FreelancerDao;
import com.davicamargo.taxascom.data.dao.RamoAtuacaoDao;
import com.davicamargo.taxascom.data.entities.Avaliacao;
import com.davicamargo.taxascom.data.entities.Beneficio;
import com.davicamargo.taxascom.data.entities.Empresa;
import com.davicamargo.taxascom.data.entities.Endereco;
import com.davicamargo.taxascom.data.entities.Freelancer;
import com.davicamargo.taxascom.data.entities.Funcao;
import com.davicamargo.taxascom.data.entities.Pagamento;
import com.davicamargo.taxascom.data.entities.RamoAtuacao;
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
                RamoAtuacao.class,
                Taxa.class
        },
        version = 2)
@TypeConverters({
        LocalDateTimeConverter.class,
        BigDecimalConverter.class,
        ETipoPronomeConverter.class,
        LocalDateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract FreelancerDao freelancerDao();
    public abstract EmpresaDao empresaDao();
    public abstract RamoAtuacaoDao ramoAtuacaoDao();
    public abstract EnderecoDao enderecoDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "taxascom.db"
                    )
                    .fallbackToDestructiveMigration()
                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
