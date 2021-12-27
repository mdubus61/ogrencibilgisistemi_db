package com.example.ogrencibilgisistemiodev;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListeleActivity extends AppCompatActivity {

   private DBHelper DB;
   private ArrayList<String> listItem;
   private ArrayAdapter adapter;
   private ListView ogrenciList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);
        DB = new DBHelper(this);
        listItem = new ArrayList<>();

        ogrenciList = (ListView) findViewById(R.id.ogrencilerlist);

        listele();


    }

    public void listele(){
        Cursor cursor = DB.listele();

        if(cursor.getCount() ==0){
            Toast.makeText(this,"Listelenemedi",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(2));

            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem);
            ogrenciList.setAdapter(adapter);
        }
    }
}