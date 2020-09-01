package com.example.hotelbooking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Home extends AppCompatActivity {

    ListView listView;

    String namaa[] = {"NEO+", "Horison", "Grand Setiabudi"};
    String alamatt[] = {"Kebayoran", "Ciledug", "Jakarta"};
    String hargaa[] = {"Rp.364.000/night", "Rp. 500.000/night", "Rp. 650.000/night"};
    String hargaa2[] = {"364000","500000","650000"};
    String latitudee[] = {"-6.2377162","-6.2364611","-6.8748216"};
    String longitudee[] = {"106.77609","106.744531","107.5949251"};
    String notell[] = {"02122777888","02130487700","0222044002"};
    int gambarr[] = {R.drawable.hotel1,R.drawable.hotel2,R.drawable.hotel3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {

                    Intent intent = new Intent(getApplicationContext(),DetailHotel.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("gambar",gambarr[0]);
                    intent.putExtras(bundle);

                    intent.putExtra("nama",namaa[0]);
                    intent.putExtra("alamat",alamatt[0]);
                    intent.putExtra("notel",notell[0]);
                    intent.putExtra("latitude",latitudee[0]);
                    intent.putExtra("longitude",longitudee[0]);
                    intent.putExtra("harga",hargaa2[0]);
                    intent.putExtra("position", ""+0);
                    startActivity(intent);

                }

                if (position ==  1) {

                    Intent intent = new Intent(getApplicationContext(),DetailHotel.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("gambar",gambarr[1]);
                    intent.putExtras(bundle);

                    intent.putExtra("nama",namaa[1]);
                    intent.putExtra("alamat",alamatt[1]);
                    intent.putExtra("notel",notell[1]);
                    intent.putExtra("latitude",latitudee[1]);
                    intent.putExtra("longitude",longitudee[1]);
                    intent.putExtra("harga",hargaa2[1]);
                    intent.putExtra("position", ""+1);
                    startActivity(intent);

                }
                if (position ==  2) {

                    Intent intent = new Intent(getApplicationContext(),DetailHotel.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("gambar",gambarr[0]);
                    intent.putExtras(bundle);

                    intent.putExtra("nama",namaa[2]);
                    intent.putExtra("alamat",alamatt[2]);
                    intent.putExtra("notel",notell[2]);
                    intent.putExtra("latitude",latitudee[2]);
                    intent.putExtra("longitude",longitudee[2]);
                    intent.putExtra("harga",hargaa2[2]);
                    intent.putExtra("position", ""+2);
                    startActivity(intent);

                }
            }
        });


        class MyAdapter extends ArrayAdapter<String> {

            Context context;
            String namaaa[];
            String alamattt[];
            String hargaaa[];
            int gambarrr[];


            MyAdapter(Context c, String nama[], String alamat[], String harga[], int gambar[]) {
                super(c, R.layout.activity_layout, R.id.nama, nama);
                this.context = c;
                this.namaaa = nama;
                this.alamattt = alamat;
                this.hargaaa = harga;
                this.gambarrr = gambar;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View a = layoutInflater.inflate(R.layout.activity_layout, parent, false);
                ImageView gambar = a.findViewById(R.id.gambar);
                TextView nama = a.findViewById(R.id.nama);
                TextView alamat = a.findViewById(R.id.alamat);
                TextView harga = a.findViewById(R.id.harga);

                gambar.setImageResource(gambarrr[position]);
                nama.setText(namaaa[position]);
                alamat.setText(alamattt[position]);
                harga.setText(hargaaa[position]);

                return a;
            }
        }

        MyAdapter adapter = new MyAdapter(this, namaa, alamatt, hargaa,gambarr);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mybooking:
                Intent intent = new Intent(Home.this,MyBooking.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Toast.makeText(this,"Silahkan masuk kembali",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Home.this,MainActivity.class);
                startActivity(intent2);
                return true;

                default: return super.onOptionsItemSelected(item);
        }
    }
}
