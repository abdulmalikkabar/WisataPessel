package com.example.battosai.tesaplikasi001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.battosai.tesaplikasi001.Mysql.DownloaderPenginapan;

public class Main2ActivityPenginapan extends AppCompatActivity {

    //final static String urlAddress="http://10.0.2.2/wps/jsonpenginapan.php";
  // final static String urlAddress="http://wisatapessel.pe.hu/json/tb_penginapan.php";
    final static String urlAddress="http://10.0.2.2/NegriSejutaPesona/json/tb_penginapan.php";

   // final static String urlAddress="http://10.0.2.2/pesisirselatan/tb_penginapan.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_penginapan);

        final ListView listView= (ListView) findViewById(R.id.ListPenginapan);
        new DownloaderPenginapan(Main2ActivityPenginapan.this,urlAddress,listView).execute();
    }

}
