package com.example.dedsec.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.dedsec.dao.UserDao;
import com.example.dedsec.entity.User;

@Database(entities = User.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
