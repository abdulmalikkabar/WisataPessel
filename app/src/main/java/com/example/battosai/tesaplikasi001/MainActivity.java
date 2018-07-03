package com.example.battosai.tesaplikasi001;

import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //button wisata
        Button button = (Button) findViewById(R.id.wisata);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // TODO Auto-generated method stub

                Intent i =new Intent(getApplicationContext(),Main2ActivityWisata.class);
                startActivity(i);


            }

        });


        //button event
        Button buttonEvent = (Button) findViewById(R.id.event);
        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Main2ActivityEvent.class);

                startActivity(intent);

            }
        });


        //button kuliner
        Button buttonKuliner = (Button) findViewById(R.id.kuliner);
        buttonKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),Main2ActivityKuliner.class);

                startActivity(intent);

            }
        });

        //button penginapan
        Button buttonPenginapan = (Button) findViewById(R.id.penginapan);
        buttonPenginapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),Main2ActivityPenginapan.class);

                startActivity(intent);

            }
        });



        //button exit
        Button buttonExit = (Button) findViewById(R.id.exit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertexit = new AlertDialog.Builder(MainActivity.this);
                alertexit.setMessage("Apakah Anda Akan Keluar Dari Aplikasi ini?")
                        .setIcon(R.mipmap.ic_exit)
                        .setTitle("Keluar")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new AlertDialog.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                System.exit(0);

                            }
                        }).setNegativeButton("Tidak", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog , int which) {

                        dialog.cancel();
                    }
                });
                AlertDialog a=alertexit.create();
                a.show();

            }
        });



        //button about
        Button buttonabout = (Button) findViewById(R.id.about);
        buttonabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),Main2ActivityAbout.class);

                startActivity(intent);

            }
        });


    }











}