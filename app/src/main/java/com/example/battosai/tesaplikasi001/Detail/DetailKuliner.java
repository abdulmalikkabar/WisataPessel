package com.example.battosai.tesaplikasi001.Detail;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.battosai.tesaplikasi001.R;
import com.example.battosai.tesaplikasi001.UI.PicassoClient;

public class DetailKuliner extends AppCompatActivity {


    TextView namaTxt,alamatTxt,telponTxt,ketTxt;
    ImageView gambar;


    private BottomNavigationView bottomNavigationView;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String koma=",";
    /*Deklarasi variable*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuliner);

        namaTxt =(TextView)findViewById(R.id.namadetailkuliner);
        alamatTxt =(TextView)findViewById(R.id.alamatdetailkuliner);
        telponTxt =(TextView)findViewById(R.id.telpondetailkuliner);
        ketTxt =(TextView)findViewById(R.id.ketdetailkuliner);

        gambar= (ImageView)findViewById(R.id.gambardetairestoran);


        //Menerima data
        Intent i=this.getIntent();
        String namakuliner=i.getExtras().getString("NAMA_KEY");
        String alamatkuliner=i.getExtras().getString("ALAMAT_KEY");
        String telponkuliner=i.getExtras().getString("TELPON_KEY");
        String ketkuliner=i.getExtras().getString("KET_KEY");
        String gambarkuliner=i.getExtras().getString("GAMBAR_KEY");
        final Double lat=i.getExtras().getDouble("LAT_KEY");
        final Double lng=i.getExtras().getDouble("LNG_KEY");



        //BIND
        namaTxt.setText(namakuliner);
        telponTxt.setText(telponkuliner);
        alamatTxt.setText(alamatkuliner);
        ketTxt.setText(ketkuliner);
        PicassoClient.downloadImage(this,gambarkuliner,gambar);








        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.ButtonWisata){
                    // Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
                    gmmIntentUri = Uri.parse("google.navigation:q=" + lat + koma + lng);
                    mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage(goolgeMap);
                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    } else {
                        Toast.makeText(DetailKuliner.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                                Toast.LENGTH_LONG).show();
                    }

                }

                return false;
            }
        });





    }
}