package com.example.battosai.tesaplikasi001.Detail;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.battosai.tesaplikasi001.R;
import com.example.battosai.tesaplikasi001.UI.PicassoClient;

public class DetailWisata extends AppCompatActivity implements View.OnClickListener{


    TextView namaTxt,ketTxt,isiTxt;
    ImageView gambar1,gambar2,gambar3,gambar4;


    ViewFlipper viewFlipper;
    Button next;
    Button previus;


    private FloatingActionButton floatingActionButton;
   // private BottomNavigationView bottomNavigationView;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    //String masjid_agung_demak = "-6.894649906672214,110.63718136399984"; // koordinat Masjid Agung Demak
    String koma=",";
    /*Deklarasi variable*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        namaTxt =(TextView)findViewById(R.id.namadetail);
        ketTxt =(TextView)findViewById(R.id.ketdetail);
        isiTxt =(TextView)findViewById(R.id.isidetail);
        gambar1= (ImageView)findViewById(R.id.gambardetail);
        gambar2= (ImageView)findViewById(R.id.gambardetail2);
        gambar3= (ImageView)findViewById(R.id.gambardetail3);
        gambar4= (ImageView)findViewById(R.id.gambardetail4);

        //Menerima data
        Intent i=this.getIntent();
        String namawisata=i.getExtras().getString("NAMA_KEY");
        String ket=i.getExtras().getString("KET_KEY");
        String isi=i.getExtras().getString("ISI_KEY");
       String gambarur1=i.getExtras().getString("GAMBAR_KEY");
       String gambarurl2=i.getExtras().getString("GAMBAR2");
        String gambarurl3=i.getExtras().getString("GAMBAR3");
        String gambarurl4=i.getExtras().getString("GAMBAR4");
        final Double lat=i.getExtras().getDouble("LAT_KEY");
        final Double lng=i.getExtras().getDouble("LNG_KEY");

        //BIND
        namaTxt.setText(namawisata);
        ketTxt.setText("Kategori : "+ket);
        isiTxt.setText(isi);
      PicassoClient.downloadImage(this,gambarur1,gambar1);
      PicassoClient.downloadImage(this,gambarurl2,gambar2);
        PicassoClient.downloadImage(this,gambarurl3,gambar3);
        PicassoClient.downloadImage(this,gambarurl4,gambar4);


//GAMBAR NEXT
        viewFlipper = (ViewFlipper) findViewById(R.id.viewfliper);
        next = (Button) findViewById(R.id.next);
        previus = (Button) findViewById(R.id.previus);

        next.setOnClickListener(this);
        previus.setOnClickListener(this);


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
                    Toast.makeText(DetailWisata.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


//        nextImage = (Button) findViewById(R.id.next_image);
//        previousImage = (Button) findViewById(R.id.previous_image);
//        previousImage.setVisibility(View.VISIBLE);



    }


    public  void  onClick (View v){


        if (v==next){
            viewFlipper.showNext();
        }
        else if(v==previus){
            viewFlipper.showPrevious();
        }
    }



}