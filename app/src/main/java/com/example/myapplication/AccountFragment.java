package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AccountFragment extends Fragment {
    EditText edtEmail, edtPass, edtUsername, editName;
    RadioButton radioMale, radioFemale;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public AccountFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_account, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtUsername = view.findViewById(R.id.editText2);
        edtPass = view.findViewById(R.id.editText3);
        edtEmail = view.findViewById(R.id.editText);
        editName = view.findViewById(R.id.editName);
        radioMale = view.findViewById(R.id.radiobutton1);
        radioFemale = view.findViewById(R.id.radiobutton2);



        sharedPreferences = getContext().getSharedPreferences("dtLogin",Context.MODE_PRIVATE);
        SharedPreferences sp = getContext().getSharedPreferences("dtLogin", Context.MODE_PRIVATE);

        String uname = sp.getString("taikhoan", "");
        String pass = sp.getString("matkhau", "");
        String email = sp.getString("email", "");
        String name = sp.getString("name","");


        edtEmail.setText(email);
        edtUsername.setText(uname);
        edtPass.setText(pass);
        editName.setText(name);
        radioMale.setChecked(sp.getBoolean("check1",false));
        radioFemale.setChecked(sp.getBoolean("check2",false));

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        editor = sharedPreferences.edit();
        if (id == R.id.mnuSave) {
            String name = editName.getText().toString().trim();
            String username=edtUsername.getText().toString().trim();
            String password=edtPass.getText().toString().trim();
            String email=edtEmail.getText().toString().trim();
            if (radioMale.isChecked()){
                editor.putBoolean("check1",true);
                editor.putBoolean("check2",false);
            }
            if (radioFemale.isChecked()){
                editor.putBoolean("check2",true);
                editor.putBoolean("check1",false);
            }

            editor.putString("taikhoan",username);
            editor.putString("matkhau",password);
            editor.putString("email",email);
            editor.putString("name",name);
            editor.commit();
            Toast.makeText(getActivity(),"Saved", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

