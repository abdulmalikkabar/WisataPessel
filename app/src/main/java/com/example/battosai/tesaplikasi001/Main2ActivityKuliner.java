package com.example.battosai.tesaplikasi001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.battosai.tesaplikasi001.Mysql.DownloaderKuliner;

public class Main2ActivityKuliner extends AppCompatActivity {


   // final static String urlAddress="http://10.0.2.2/wps/jsonkuliner.php";
   final static String urlAddress="http://wisatapessel.pe.hu/json/tb_kuliner.php";
    //final static String urlAddress="http://10.0.2.2/NegriSejutaPesona/json/haversine.php?lat=";
   // final static String urlAddress="http://10.0.2.2/pesisirselatan/tb_kuliner.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_kuliner);


        final ListView listView= (ListView) findViewById(R.id.ListRestoran);
        new DownloaderKuliner(Main2ActivityKuliner.this,urlAddress,listView).execute();
    }
}
