package com.example.quiz3androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quiz3androiddevelopment.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editUsername.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Username is required", Toast.LENGTH_SHORT).show();
                } else if (binding.editPassword.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Password is required", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(Login.this, MainActivity.class);;
                    startActivity(intent);
                    finish();
                }
            }
        });

        binding.registerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);;
                startActivity(intent);
            }
        });

    }
}