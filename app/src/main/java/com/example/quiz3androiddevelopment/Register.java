package com.example.quiz3androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.quiz3androiddevelopment.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.registerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editName.getText().toString().isEmpty()){
                    Toast.makeText(Register.this, "Full Name is required", Toast.LENGTH_SHORT).show();
                } else if (binding.editEmail.getText().toString().isEmpty()){
                    Toast.makeText(Register.this, "Email is required", Toast.LENGTH_SHORT).show();
                } else if (binding.editUsername.getText().toString().isEmpty()){
                    Toast.makeText(Register.this, "Username is required", Toast.LENGTH_SHORT).show();
                } else if (binding.editPassword.getText().toString().isEmpty()){
                    Toast.makeText(Register.this, "Password is required", Toast.LENGTH_SHORT).show();
                } else if (binding.editConfPass.getText().toString().isEmpty()){
                    Toast.makeText(Register.this, "Please confirm Password your password", Toast.LENGTH_SHORT).show();
                } else{
                    if (isValidEmail(binding.editEmail.getText().toString())) {
                        if (binding.editPassword.getText().toString().equals(binding.editConfPass.getText().toString())) {
                            Toast.makeText(Register.this, "Account registered", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(Register.this, "Confirm password and password must be equal", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(Register.this, "Please enter a valid E-mail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}