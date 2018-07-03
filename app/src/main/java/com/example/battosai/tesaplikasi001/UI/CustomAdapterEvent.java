package com.example.battosai.tesaplikasi001.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.battosai.tesaplikasi001.Detail.DetailEvent;
import com.example.battosai.tesaplikasi001.Detail.DetailWisata;
import com.example.battosai.tesaplikasi001.Object.Event;
import com.example.battosai.tesaplikasi001.Object.wisata;
import com.example.battosai.tesaplikasi001.R;

import java.util.ArrayList;

/**
 * Created by Battosai on 3/27/2017.
 */

public class CustomAdapterEvent extends BaseAdapter {

    Context c;
    ArrayList<Event> events;


    public CustomAdapterEvent(Context c, ArrayList<Event> events) {
        this.c = c;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.modelevent,parent,false);

        }

        TextView namaTxt= (TextView) convertView.findViewById(R.id.Eventwisata);
        ImageView gambar=(ImageView) convertView.findViewById(R.id.GambarEvent);

        final Event e=(Event) this.getItem(position);
        namaTxt.setText(e.getNamaevent());


       // PicassoClient.downloadImage(c,w.getGambar(),gambar);
        PicassoClient.downloadImage(c,e.getGambar(), gambar );

        //klik item
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open detail activity

               // openDetailActivity(e.getNamawisata(),w.getKeterangan(),w.getIsi(),w.getGambar());

                openDetailActivity(e.getNamaevent(),e.getLokasi(),e.getDesk(),e.getTgl_event(),e.getGambar(),e.getLat(),e.getLng());
            }
        });


        return convertView;

    }

    //open detail activity
    private void openDetailActivity(String namaevent,String lokasi, String desk,String tglevent, String gambarevant, Double lat, Double lng ) {


        Intent i=new Intent(c,DetailEvent.class);

        //data
        i.putExtra("nama", namaevent);
        i.putExtra("lokasi",lokasi);
        i.putExtra("desk",desk);
        i.putExtra("tgl_event",tglevent);
        i.putExtra("gambar",gambarevant);
        i.putExtra("LAT_KEY",lat);
        i.putExtra("LNG_KEY",lng);

        c.startActivity(i);

    }

}


