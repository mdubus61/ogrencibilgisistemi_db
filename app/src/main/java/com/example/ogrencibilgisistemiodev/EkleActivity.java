package com.example.ogrencibilgisistemiodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EkleActivity extends AppCompatActivity {

    private EditText editTxtIsim, editTxtSoyIsim, editTxtOgrenciNo, editTxtBolum;
    private Button btnKaydet;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        editTxtIsim = (EditText) findViewById(R.id.editTextIsim);
        editTxtSoyIsim = (EditText) findViewById(R.id.editTextSoyIsim);
        editTxtOgrenciNo = (EditText) findViewById(R.id.editTextOgrenciNo);
        editTxtBolum = (EditText) findViewById(R.id.editTextBolumAdi);

    }

    public void SQLiteInsert(View v) {

        DB = new DBHelper(this);

        String isimTXT = editTxtIsim.getText().toString();
        String soyIsimTXT = editTxtSoyIsim.getText().toString();
        String ogrenciNoTXT = editTxtOgrenciNo.getText().toString();
        String bolumAdiTXT = editTxtBolum.getText().toString();

        if (TextUtils.isEmpty(isimTXT) || TextUtils.isEmpty(soyIsimTXT) || TextUtils.isEmpty(ogrenciNoTXT) || TextUtils.isEmpty(bolumAdiTXT)) {
            Toast.makeText(getApplicationContext(), "Bütün bilgileri doldurun", Toast.LENGTH_SHORT).show();
        }else{
            Boolean kontrolEkle =DB.ekle(isimTXT,soyIsimTXT,ogrenciNoTXT,bolumAdiTXT);
            if(kontrolEkle==true){
                Toast.makeText(EkleActivity.this, "Eklendi", Toast.LENGTH_SHORT).show();
                editTxtIsim.setText("");
                editTxtSoyIsim.setText("");
                editTxtBolum.setText("");
                editTxtOgrenciNo.setText("");
            }else{
                Toast.makeText(EkleActivity.this, "Eklenemedi", Toast.LENGTH_SHORT).show();
            }
        }
    }
}