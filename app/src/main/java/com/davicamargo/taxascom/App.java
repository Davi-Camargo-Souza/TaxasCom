package com.davicamargo.taxascom;

import android.app.Application;
import androidx.room.Room;
import com.davicamargo.taxascom.data.database.AppDatabase;
import com.davicamargo.taxascom.data.entities.RamoAtuacao;
import com.jakewharton.threetenabp.AndroidThreeTen;

import java.util.concurrent.Executors;

public class App extends Application {
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidThreeTen.init(this);
        database = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "taxascom.db"
        )
        .fallbackToDestructiveMigration().build();
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
