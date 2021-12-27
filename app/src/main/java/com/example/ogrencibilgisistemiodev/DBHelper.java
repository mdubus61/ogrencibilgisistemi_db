package com.example.ogrencibilgisistemiodev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,"Öğrenciler",null,1);
    }

    //TABLO OLUŞTURMA
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE IF NOT EXISTS Ogrenciler(isim TEXT ,soy_isim TEXT,ogrenci_no VARCHAR primary key,bolum VARCHAR )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("DROP TABLE IF EXISTS Ogrenciler");
    }

    public boolean ekle(String isim, String soyIsim, String ogrenciNo,String bolumAdi) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isim", isim);
        contentValues.put("soy_isim", soyIsim);
        contentValues.put("ogrenci_no", ogrenciNo);
        contentValues.put("bolum",bolumAdi);
        long result = DB.insert("Ogrenciler", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean guncelle(String isim, String soyIsim, String ogrenciNo,String bolumAdi) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isim", isim);
        contentValues.put("soy_isim", soyIsim);
        contentValues.put("bolum",bolumAdi);
        Cursor cursor = DB.rawQuery("Select * from  Ogrenciler where ogrenci_no = ? ", new String[]{ogrenciNo});
        if (cursor.getCount() > 0) {
            long result = DB.update("Ogrenciler", contentValues, "ogrenci_no=?", new String[]{ogrenciNo});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean sil(String ogrenciNo) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from  Ogrenciler where ogrenci_no = ? ", new String[]{ogrenciNo});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Ogrenciler","ogrenci_no=?", new String[]{ogrenciNo});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor listele() {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from  Ogrenciler",null);
        return cursor;
    }
}
