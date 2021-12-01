package com.example.tugas7_1918104;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_kampus";
    private static final String tb_bank = "tb_mahasiswa";
    private static final String tb_bank_id = "id";
    private static final String tb_bank_nama = "nama";
    private static final String tb_bank_kelas = "kelas";
    private static final String CREATE_TABLE_BANK = "CREATE TABLE " +
    tb_bank +"("
            + tb_bank_id + " INTEGER PRIMARY KEY ,"
            + tb_bank_nama + " TEXT ,"
            + tb_bank_kelas + " TEXT " + ")";
    public MyDatabase(Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BANK);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateMahasiswa(Bank data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_bank_id, data.get_id());
        values.put(tb_bank_nama, data.get_nama());
        values.put(tb_bank_kelas, data.get_kelas());
        db.insert(tb_bank, null, values);
        db.close();
    }


    public List<Bank> ReadMahasiswa() {
        List<Bank> listMhs = new ArrayList<Bank>();
        String selectQuery = "SELECT * FROM " + tb_bank;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Bank data = new Bank();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_kelas(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateMahasiswa (Bank data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_bank_nama, data.get_nama());
        values.put(tb_bank_kelas, data.get_kelas());
        return db.update(tb_bank, values, tb_bank_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteMahasiswa(Bank data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_bank,tb_bank_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
