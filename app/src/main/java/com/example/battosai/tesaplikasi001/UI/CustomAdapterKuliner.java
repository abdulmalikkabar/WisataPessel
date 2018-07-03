package com.example.battosai.tesaplikasi001.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.battosai.tesaplikasi001.Detail.DetailKuliner;
import com.example.battosai.tesaplikasi001.Object.Kuliner;
import com.example.battosai.tesaplikasi001.R;

import java.util.ArrayList;

/**
 * Created by Battosai on 3/27/2017.
 */

public class CustomAdapterKuliner extends BaseAdapter {

    Context c;
    ArrayList<Kuliner> restoren;


    public CustomAdapterKuliner(Context c, ArrayList<Kuliner> restoren) {
        this.c = c;
        this.restoren = restoren;

    }

    @Override
    public int getCount() {
        return restoren.size();
    }

    @Override
    public Object getItem(int position) {
        return restoren.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.modelkuliner,parent,false);

        }

        TextView namaTxt= (TextView) convertView.findViewById(R.id.namakuliner);
        ImageView gambar=(ImageView) convertView.findViewById(R.id.gambarkuliner);
        TextView alamatTxt = (TextView)convertView.findViewById(R.id.alamatkuliner);
        TextView notelpTxt= (TextView) convertView.findViewById(R.id.telpkuliner);
        TextView deskTxt= (TextView) convertView.findViewById(R.id.deskkuliner);

        final Kuliner r=(Kuliner) this.getItem(position);
        namaTxt.setText(r.getNama_kuliner());
        notelpTxt.setText(r.getTelpon_kuliner());
        deskTxt.setText(r.getKet_kuliner());
        alamatTxt.setText(r.getAlamat_kuliner());

        // PicassoClient.downloadImage(c,w.getGambar(),gambar);
       PicassoClient.downloadImage(c,r.getGambar_kuliner(), gambar);

        //klik item


        return convertView;

    }

    //open detail activity


}

