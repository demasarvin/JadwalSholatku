package com.example.jadwalsholat.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.jadwalsholat.data.dao.UserDao;
import com.example.jadwalsholat.data.model.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile AppDatabase appDatabase;
    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(4);

    public static AppDatabase getDatabase(final Context context){
        if(appDatabase == null){
            synchronized (AppDatabase.class){
                appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "JadwalSholat.db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return appDatabase;
    }
}
