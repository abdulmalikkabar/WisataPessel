package com.example.battosai.tesaplikasi001.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.battosai.tesaplikasi001.Detail.DetailWisata;
import com.example.battosai.tesaplikasi001.R;
import com.example.battosai.tesaplikasi001.Object.wisata;

import java.util.ArrayList;

/**
 * Created by Battosai on 3/14/2017.
 */

public class CustomAdapter extends BaseAdapter{

    Context c;
    ArrayList<wisata> wisatas;

    public CustomAdapter(Context c, ArrayList<wisata> wisatas) {
        this.c = c;
        this.wisatas = wisatas;
    }


    @Override
    public int getCount() {
        return wisatas.size();
    }

    @Override
    public Object getItem(int position) {
        return wisatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.modelwisata,parent,false);

        }

        

        TextView namaTxt= (TextView) convertView.findViewById(R.id.namawisata);
        ImageView gambar=(ImageView) convertView.findViewById(R.id.gambar);


        final wisata w=(wisata) this.getItem(position);
        namaTxt.setText(w.getNamawisata());

        PicassoClient.downloadImage(c,w.getGambar(),gambar);

        //klik item
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open detail activity
                openDetailActivity(w.getNamawisata(),w.getKategori(),w.getDesk(),w.getGambar(),w.getGambar2(),w.getGambar3(),w.getGambar4(),w.getLat(),w.getLng());

            }
        });


        return convertView;

    }

    //open detail activity
    private void openDetailActivity(String namawisata,String kategori, String desk,String gambar,String gambar2,String gambar3,String gambar4,Double lat, Double lng ) {


        Intent i=new Intent(c,DetailWisata.class);

        //data
        i.putExtra("NAMA_KEY", namawisata);
        i.putExtra("KET_KEY",kategori);
        i.putExtra("ISI_KEY",desk);
        i.putExtra("GAMBAR_KEY",gambar);
        i.putExtra("GAMBAR2",gambar2);
        i.putExtra("GAMBAR3",gambar3);
        i.putExtra("GAMBAR4",gambar4);
        i.putExtra("LAT_KEY",lat);
        i.putExtra("LNG_KEY",lng);

        c.startActivity(i);

    }

}


