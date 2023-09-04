package my.edu.utar.jobsearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import my.edu.utar.jobsearchapp.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        databaseHelper = new DatabaseHelper(this);

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.editTextTextEmail.getText().toString();
                String password = binding.editTextPassword.getText().toString();
                String confirmPassword = binding.editTextCPW.getText().toString();

                if (email.equals("") || password.equals("") || confirmPassword.equals(""))
                    Toast.makeText(Login.this, "All field are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(confirmPassword)) {
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail == false) {
                            Boolean insert = databaseHelper.insertData(email, password);

                            if (insert == true) {
                                Toast.makeText(Login.this, "Register successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Login.this, "Fail registration", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Login.this, "User already exists, Please Login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
            }
        });
            }
        }
