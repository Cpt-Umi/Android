package com.example.dedsec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dedsec.activities.LoginActivity;

import com.example.dedsec.dao.UserDao;
import com.example.dedsec.db.AppDatabase;
import com.example.dedsec.entity.User;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.rBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                loginFunction();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loginFunction() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "user-database")
                .allowMainThreadQueries()
                .build();

        user = findViewById(R.id.rUser);
        pass = findViewById(R.id.rPass);

        String username = user.getText().toString();
        String password = pass.getText().toString();

        UserDao userDao = db.userDao();
        User user = new User(username, password);
        userDao.insertUser(user);
        List<User> lst = userDao.getAll();

        System.out.println(userDao.getAll());
    }
}