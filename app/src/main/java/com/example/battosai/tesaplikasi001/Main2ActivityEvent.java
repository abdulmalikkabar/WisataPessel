package com.example.battosai.tesaplikasi001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.battosai.tesaplikasi001.Mysql.DownloaderEvent;

public class Main2ActivityEvent extends AppCompatActivity {


    //http://localhost/android/eventurl.php
    //final static String urlAddress="http://10.0.2.2/wps/jsonevent.php";
    //final static String urlAddress="http://10.0.2.2/android/eventurl.php";
   //final static String urlAddress="http://wisatapessel.pe.hu/event.php";
   final static String urlAddress="http://10.0.2.2/NegriSejutaPesona/json/haversine.php?lat=";

  //final static String urlAddress="http://wisatapessel.pe.hu/json/tb_event.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_event);

        final ListView listView= (ListView) findViewById(R.id.ListEvent);
        new DownloaderEvent(Main2ActivityEvent.this,urlAddress,listView).execute();
    }
}
