package com.example.battosai.tesaplikasi001.Detail;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.battosai.tesaplikasi001.R;
import com.example.battosai.tesaplikasi001.UI.PicassoClient;

public class DetailEvent extends AppCompatActivity {



    TextView namaTxt,tglTxt,lokasiTxt,deskTxt;
    ImageView gambar;



    private FloatingActionButton floatingActionButton;
   // Button btn_navigasi;
    //private BottomNavigationView bottomNavigationView;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String koma=",";
    /*Deklarasi variable*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);


        namaTxt =(TextView)findViewById(R.id.namaevent);
        tglTxt =(TextView)findViewById(R.id.tglevent);
        lokasiTxt =(TextView)findViewById(R.id.lokasievent);
        deskTxt =(TextView)findViewById(R.id.desk);
      gambar= (ImageView)findViewById(R.id.gambardetailevent);

        //Menerima data
        Intent i=this.getIntent();
        String namaevent=i.getExtras().getString("nama");
        String tglevent=i.getExtras().getString("tgl_event");
        String lokasievent=i.getExtras().getString("lokasi");
        String ketevent=i.getExtras().getString("desk");
        String gambarurl=i.getExtras().getString("gambar");
       final Double lat=i.getExtras().getDouble("LAT_KEY");
       final Double lng=i.getExtras().getDouble("LNG_KEY");



        //BIND
        namaTxt.setText(namaevent);
        tglTxt.setText(tglevent);
        lokasiTxt.setText(lokasievent);
        deskTxt.setText(ketevent);
        PicassoClient.downloadImage(this,gambarurl,gambar);




        floatingActionButton= (FloatingActionButton) findViewById(R.id.bottomNavigationView);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
                gmmIntentUri = Uri.parse("google.navigation:q=" + lat + koma + lng);
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(goolgeMap);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(DetailEvent.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


    }







}