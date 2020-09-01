package com.example.hotelbooking;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapterBooking extends ArrayAdapter<BookingData> {

    List<BookingData> bookingList;

    Context c;

    int res;

    public ListAdapterBooking(Context c, int res, List<BookingData> bookingList){
        super(c,res,bookingList);
        this.c = c;
        this.res = res;
        this.bookingList = bookingList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View view = layoutInflater.inflate(res, null, false);

        TextView txnama = view.findViewById(R.id.nama);
        TextView txalamat = view.findViewById(R.id.alamat);
        TextView txin = view.findViewById(R.id.chkin);
        TextView txout = view.findViewById(R.id.chkout);
        TextView txharga = view.findViewById(R.id.harga);
        Button del = view.findViewById(R.id.batalbtn);

        BookingData bd = bookingList.get(position);

        txnama.setText(bd.getNama());
        txalamat.setText(bd.getAlamat());
        txin.setText(bd.getCheckin());
        txout.setText(bd.getCheckout());
        txharga.setText(bd.getHarga());

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeList(position);
            }
        });
        return view;
    }

    private void removeList(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Batalkan pesanan?");

        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                bookingList.remove(position);
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
