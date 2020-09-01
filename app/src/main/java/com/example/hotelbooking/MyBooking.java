package com.example.hotelbooking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyBooking extends AppCompatActivity {

    List<BookingData>  bookingDataList;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        bookingDataList = new ArrayList<>();
        listView = findViewById(R.id.listView);

        bookingDataList.add(new BookingData("Grand Setiabudi","Jakarta","23-11-2019","24-11-2019","3.509.000"));
        bookingDataList.add(new BookingData("Horison","Ciledug","24-12-2019","28-12-2019","12.105.260"));
        bookingDataList.add(new BookingData("NEO+","Kemayoran","24-12-2019","25-12-2019","2.896.341"));

        ListAdapterBooking adapter = new ListAdapterBooking(this, R.layout.my_booking_layout,bookingDataList);
        listView.setAdapter(adapter);

    }
}