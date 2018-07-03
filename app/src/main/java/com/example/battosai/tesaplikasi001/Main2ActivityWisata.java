package com.example.battosai.tesaplikasi001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.battosai.tesaplikasi001.Mysql.downloader;

public class Main2ActivityWisata extends AppCompatActivity {

    //final static String urlAddress="http://10.0.2.2/pesisirselatan/tb_wisata.php";
  final static String urlAddress="http://wisatapessel.pe.hu/json/tb_wisata.php";
 //   final static String urlAddress="http://10.0.2.2/NegriSejutaPesona/json/tb_wisata.php";
    //final static String urlAddress="http://10.0.2.2/pariwisata/json/tb_wisata.php";
    //final static String urlAddress="http://wisatapessel.pe.hu/restoran.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_wisata);


        final ListView listView= (ListView) findViewById(R.id.ListWisata);
        new downloader(Main2ActivityWisata.this,urlAddress,listView).execute();
    }
}
