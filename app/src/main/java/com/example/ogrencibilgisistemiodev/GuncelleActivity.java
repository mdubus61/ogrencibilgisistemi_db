package com.example.ogrencibilgisistemiodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuncelleActivity extends AppCompatActivity {

    private EditText editTxtGuncellenecekNo, editTxtGuncellenecekIsim, editTxtGuncellenecekBolum, editTxtGuncellenecekSoyIsim;
    private Button btnGuncelleme;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        editTxtGuncellenecekIsim = (EditText) findViewById(R.id.GuncellenecekIsim);
        editTxtGuncellenecekSoyIsim = (EditText) findViewById(R.id.editTextGuncellenecekSoyIsim);
        editTxtGuncellenecekBolum = (EditText) findViewById(R.id.editTextGuncellenecekBolum);
        editTxtGuncellenecekNo = (EditText) findViewById(R.id.editTextGuncellenecekNo);
    }

    public void SQLiteUpdate(View v) {
        DB = new DBHelper(this);

        String isimTXT = editTxtGuncellenecekIsim.getText().toString();
        String soyIsimTXT = editTxtGuncellenecekSoyIsim.getText().toString();
        String ogrenciNoTXT = editTxtGuncellenecekNo.getText().toString();
        String bolumTXT = editTxtGuncellenecekBolum.getText().toString();

        Boolean kontrolGuncelle =DB.guncelle(isimTXT,soyIsimTXT,ogrenciNoTXT,bolumTXT);
        if(kontrolGuncelle==true){
            Toast.makeText(GuncelleActivity.this, "Güncellendi", Toast.LENGTH_SHORT).show();
            editTxtGuncellenecekBolum.setText("");
            editTxtGuncellenecekIsim.setText("");
            editTxtGuncellenecekSoyIsim.setText("");
            editTxtGuncellenecekNo.setText("");
        }else{
            Toast.makeText(GuncelleActivity.this, "Güncellenmedi", Toast.LENGTH_SHORT).show();
        }
    }

}