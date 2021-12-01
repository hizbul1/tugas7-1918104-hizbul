package com.example.tugas7_1918104;

public class Bank {
    private String _id, _nama, _antrian;
    public Bank(String id, String nama, String antrian) {
        this._id = id;
        this._nama = nama;
        this._antrian = antrian;
    }
    public Bank() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_kelas() {
        return _antrian;
    }
    public void set_kelas(String _kelas) {
        this._antrian = _antrian;
    }
}
