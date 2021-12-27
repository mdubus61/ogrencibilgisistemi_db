package com.example.ogrencibilgisistemiodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SilActivity extends AppCompatActivity {

    private EditText editTextSilinecekNo;
    private Button btnSil;
    private DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sil);

        editTextSilinecekNo = (EditText) findViewById(R.id.editTextSilinecekOgrenciNo);
        btnSil = (Button)findViewById(R.id.buttonOgrenciSil);

    }

    public void SQLiteDelete(View v){
        DB = new DBHelper(this);

        String ogrenciNoTXT = editTextSilinecekNo.getText().toString();

        if(TextUtils.isEmpty(ogrenciNoTXT)){
            Toast.makeText(getApplicationContext(),"Öğrenci no giriniz",Toast.LENGTH_SHORT).show();
        }else{
            Boolean kontrolSil =DB.sil(ogrenciNoTXT);
            if(kontrolSil==true){
                Toast.makeText(SilActivity.this, "Silindi", Toast.LENGTH_SHORT).show();
                editTextSilinecekNo.setText("");
            }else{
                Toast.makeText(SilActivity.this, "Böyle bir Kullanıcı Yok", Toast.LENGTH_SHORT).show();
            }
        }
    }
}