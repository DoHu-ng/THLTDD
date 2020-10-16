package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class InfoActivity extends AppCompatActivity {
    EditText edtName, edtEmail, edtPass, edtUsername;
    RadioGroup rdbGender;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);
//
        edtName = (EditText) findViewById(R.id.editText4);
        edtEmail = (EditText) findViewById(R.id.editText);
        edtUsername = (EditText) findViewById(R.id.editText2);
        edtPass = (EditText) findViewById(R.id.editText3);

        //lấy giá trị sharedPreferences
        edtUsername.setText(sharedPreferences.getString("taikhoan",""));
        edtPass.setText(sharedPreferences.getString("matkhau",""));

       // getSupportActionBar().setTitle("Account Info");
        Intent intent = getIntent();
        edtName.setText(intent.getStringExtra("Username"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String username=edtUsername.getText().toString().trim();
        String password=edtPass.getText().toString().trim();

        if(item.getItemId() == R.id.mnuSave){
            editor=sharedPreferences.edit();
            editor.putString("taikhoan",username);
            editor.putString("matkhau",password);
            editor.commit();
            Intent intent = new Intent(InfoActivity.this,
                    LoginActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            setResult(104, intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}