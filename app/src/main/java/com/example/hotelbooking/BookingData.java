package com.example.hotelbooking;

public class BookingData {

    String nama, alamat, checkin, checkout, harga;

    public BookingData(String nama,String alamat, String checkin, String checkout, String harga){
        this.nama = nama;
        this.alamat = alamat;
        this.checkin = checkin;
        this.checkout = checkout;
        this.harga = harga;
    }

    public String getNama(){

        return nama;
    }

    public String getAlamat(){

        return alamat;
    }

    public String getCheckin(){

        return checkin;
    }

    public String getCheckout(){

        return checkout;
    }

    public String getHarga(){

        return harga;
    }

}
