package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText editUsername, editPassword;
    Button btnLogin, btnRegister, btnOk, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername=findViewById(R.id.editText);
        editUsername=findViewById(R.id.editText1);

        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);

        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editUsername.getText().toString().isEmpty()||editPassword.getText().toString().isEmpty()){
                    final Dialog dialog=new Dialog(LoginActivity.this);
                    dialog.setContentView(R.layout.dialog_custom);
                    btnOK = dialog.findViewById(R.id.btnOK);
                    btnCancel = dialog.findViewById(R.id.btnCancel);
                    btnOK.setOnClickListener(new View.OnClickListener() {
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
                    startActivity(intent);
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


        });*/
    }
}
