package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    List<MemberData> memberDataList;

    int position;
    EditText email,password;
    Button login,register;

    void init(){
        email = findViewById(R.id.txtemail);
        password = findViewById(R.id.txtpassword);
        login = findViewById(R.id.btnnlogin);
        register = findViewById(R.id.btnnregister);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        memberDataList = new ArrayList<>();


        memberDataList.add(new MemberData("1","New Admin","admin@gmail.com","Pika123","087880373678"));
        memberDataList.add(new MemberData("2","Lala Luna","lala@gmail.com","Luna345","081362112321"));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em = email.getText().toString();
                String pass = password.getText().toString();

                final String[] dataemail = getResources().getStringArray(R.array.email);
                final String[] datapassword = getResources().getStringArray(R.array.password);

                if(em.isEmpty()) {
                    email.setError("Email belum diisi");
                }else if(!Arrays.asList(dataemail).contains(em)) {
                    email.setError("Email tidak terdaftar");
                }else if(pass.isEmpty()) {
                    password.setError("Password belum diisi");
                }else if(!Arrays.asList(datapassword).contains(pass)) {
                password.setError("Password salah");
                }else{
                    Intent intent = new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }
}
