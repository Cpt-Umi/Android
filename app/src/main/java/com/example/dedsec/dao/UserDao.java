package com.example.dedsec.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.dedsec.entity.User;
import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);
    @Query("Select * From User")
    List<User> getAll();
}
