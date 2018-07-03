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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.battosai.tesaplikasi001.R;
import com.example.battosai.tesaplikasi001.UI.PicassoClient;

public class DetailPenginapan extends AppCompatActivity {


    TextView namaTxt,alamatTxt,jumlahTxt,hargaTxt,fasilitasTxt,telponTxt;
    ImageView gambar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penginapan);


        namaTxt =(TextView)findViewById(R.id.namapenginapan);
        alamatTxt =(TextView)findViewById(R.id.alamatkuliner);
        jumlahTxt =(TextView)findViewById(R.id.jumlah_kamar);
        hargaTxt =(TextView)findViewById(R.id.harga);
        fasilitasTxt =(TextView)findViewById(R.id.fasilitas);
        telponTxt =(TextView)findViewById(R.id.notelp);
        gambar= (ImageView)findViewById(R.id.gambarkuliner);


        //Menerima data
        Intent i=this.getIntent();
        String nama=i.getExtras().getString("nama");
        String alamat=i.getExtras().getString("alamat");
        String jumlah_kamar=i.getExtras().getString("jumlah");
        String harga=i.getExtras().getString("harga");
        String fasilitas=i.getExtras().getString("fasilitas");
        final String telpon=i.getExtras().getString("no_telp");
        String gambarurl=i.getExtras().getString("gambar");



        //BIND
        namaTxt.setText(nama);
        alamatTxt.setText(alamat);
        jumlahTxt.setText(jumlah_kamar);
        hargaTxt.setText(harga);
        fasilitasTxt.setText(fasilitas);
        telponTxt.setText(telpon);
        hargaTxt.setText(harga);
        PicassoClient.downloadImage(this,gambarurl,gambar);


            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+telpon));
                startActivity(intent);
                }
            });

//        floatingActionButton= (FloatingActionButton) findViewById(R.id.bottomNavigationView);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse(telpon));
//                startActivity(intent);

//                // Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
//              // Uri number = Uri.parse("telpon");
//               //Intent callIntent=new Intent(Intent.ACTION_DIAL,number);
//               //startActivity(callIntent);
//
//
//              // Uri webpage= Uri.parse("http://www.android.com");
//             //   Intent webInten=new Intent(Intent.ACTION_VIEW,webpage);
//               // startActivity(webInten);
//
//            }
//        });




    }
}