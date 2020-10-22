package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin, btnRegister, btnOk, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername=findViewById(R.id.editText);
        edtPassword=findViewById(R.id.editText1);

        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUsername.getText().toString().isEmpty()||edtPassword.getText().toString().isEmpty()){
                    final Dialog dialog=new Dialog(LoginActivity.this);
                    dialog.setContentView(R.layout.dialog_custom);
                    btnOk = dialog.findViewById(R.id.btnOk);
                    btnCancel = dialog.findViewById(R.id.btnCancel);
                    btnRegister.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(LoginActivity.this,
                                    RegisterActivity.class);
                            startActivityForResult(intent, 100);
                            dialog.dismiss();
                        }
                    });
                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });

                    dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                            WindowManager.LayoutParams.WRAP_CONTENT);
                    dialog.show();
                }else if(edtPassword.getText().toString().length() < 6){
                    edtPassword.setError("Minimum 6 number");
                }else {
                    Intent intent = new Intent(LoginActivity.this,
                            InfoActivity.class);
                    intent.putExtra("Username", edtUsername.getText().toString());
                    startActivityForResult(intent, 103);
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,
                        RegisterActivity.class);
                startActivityForResult(intent, 100);

                }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == 101){
            edtUsername.setText(data.getStringExtra("username"));
            edtPassword.setText(data.getStringExtra("password"));
        }
        if(requestCode == 103 && resultCode == 104){
            edtUsername.setText(data.getStringExtra("username"));
            edtPassword.setText(data.getStringExtra("password"));
        }
    }

}
