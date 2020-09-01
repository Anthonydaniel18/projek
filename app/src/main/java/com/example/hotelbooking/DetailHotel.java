package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DetailHotel extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    boolean startOrEnd = true;
    ImageView gambare;
    TextView namae,alamate,notele,latitudee,longitudee,hargae,chkintx,chkouttx;;
    int position,biaya;
    Button submite,chkinbtn,chkoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);

        gambare = findViewById(R.id.gambar);
        namae = findViewById(R.id.nama);
        alamate = findViewById(R.id.alamat);
        latitudee = findViewById(R.id.latitude);
        longitudee = findViewById(R.id.longitude);
        notele = findViewById(R.id.notel);
        hargae = findViewById(R.id.harga);
        submite = findViewById(R.id.submit);

        if(position == 0){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int gambar = bundle.getInt("gambar");
            String nama = intent.getStringExtra("nama");
            String alamat = intent.getStringExtra("alamat");
            String notel = intent.getStringExtra("notel");
            String latitude = intent.getStringExtra("latitude");
            String longitude = intent.getStringExtra("longitude");
            String harga = intent.getStringExtra("harga");

            gambare.setImageResource(gambar);
            namae.setText(nama);
            alamate.setText(alamat);
            notele.setText(notel);
            latitudee.setText(latitude);
            longitudee.setText(longitude);
            biaya = Integer.parseInt(harga);
        }

        init();

        chkinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kalender();
                startOrEnd = true;
            }
        });

        chkoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kalender();
                startOrEnd = false;
            }
        });

    }


    public void init(){
        chkinbtn = findViewById(R.id.chkin);
        chkoutbtn = findViewById(R.id.chkout);
        chkintx = findViewById(R.id.txchkin);
        chkouttx = findViewById(R.id.txchkout);
        hargae = findViewById(R.id.harga);
    }


    private void kalender() {
        DatePickerDialog dpd = new DatePickerDialog(this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month = month + 1;
        String date = dayOfMonth + "/" + month +  "/" + year;
        if (startOrEnd) {
            chkintx.setText(date);
        } else {
            chkouttx.setText(date);
        }

        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");

        try {
            Date masuk = df.parse(chkintx.getText().toString());
            Date keluar = df.parse(chkouttx.getText().toString());

            if(masuk.after(keluar)) {
               Toast.makeText(DetailHotel.this, "Tanggal check in harus lebih dulu dari tanggal check out", Toast.LENGTH_LONG).show();
            }else{
                long masukk = masuk.getTime();
                long keluarr = keluar.getTime();
                long selisih = keluarr - masukk;
                long jumlah = selisih / (24 * 60 * 60 * 1000) * biaya;
                String hargatotal = Long.toString(jumlah);

                hargae.setText(hargatotal);

                submite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DetailHotel.this, "Pesanan berhasil dibuat", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailHotel.this,Home.class);
                        startActivity(intent);
                    }
                });
            }

        }catch (ParseException e){
            e.printStackTrace();
        }

    }
}
