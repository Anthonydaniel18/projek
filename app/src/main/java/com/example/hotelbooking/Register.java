package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private static final Pattern password_pattern = Pattern.compile("(?=.*[0-9])"+".{0,}");

    EditText txnama,txemail,txpassword,txnotel;
    Button btnregister;

    void init(){
        txnama = findViewById(R.id.txtnama);
        txemail = findViewById(R.id.txtemail);
        txpassword = findViewById(R.id.txtpassword);
        txnotel = findViewById(R.id.txtnotel);
        btnregister = findViewById(R.id.btnnregister);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = txnama.getText().toString();
                String email = txemail.getText().toString();
                String password = txpassword.getText().toString();
                String notel = txnotel.getText().toString();

                String emailpattern = "[A-Za-z0-9._]+@[a-z]+\\.[a-z]+";
                String notelpattern = "[+62]+[0-9]+";

                if (!nama.contains(" ")) {
                    txnama.setError("Masukan nama lengkap (terdiri dari minimal 2 kata");
                } else if (!email.matches(emailpattern)) {
                    txemail.setError("Format email salah");
                } else if (password.length() <= 4) {
                    txpassword.setError("Password minimal berisi 5 karakter");
                } else if (password.contains(password.toLowerCase()) || password.contains(email.toUpperCase())) {
                    txpassword.setError("Password harus menggunakan huruf besar dan kecil");
                } else if (!password_pattern.matcher(password).matches()) {
                    txpassword.setError("Password harus menggunakan minimal 1 angka");
                } else if (!notel.startsWith("+62")) {
                    txnotel.setError("Nomor telepon diawali dengan +62");
                }else if(!notel.matches(notelpattern)){
                    txnotel.setError("Nomor telepon hanya diisi angka");
                }else{
                    Toast.makeText(Register.this, "Registrasi sukses silahkan masuk kembali", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        }

        );
    }
}
