package com.au.loginsendsmsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editTextTextPersonName);
        password=findViewById(R.id.editTextTextPassword);

    }

    public void Login(View view) {
        String names="admin",passwords="123";
        SharedPreferences sp=getSharedPreferences("file",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("name",names);
        ed.putString("password",passwords);
        ed.commit();
        if (name.getText().toString().equals(sp.getString("name",null)) && password.getText().toString().equals(sp.getString("password",null))) {
            Intent i =new Intent(this,SendMessage.class);
            startActivity(i);
        } else
            Toast.makeText(this, "Password Error", Toast.LENGTH_SHORT).show();
    }
}