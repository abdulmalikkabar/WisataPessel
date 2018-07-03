package com.example.battosai.tesaplikasi001.UI;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.battosai.tesaplikasi001.Detail.DetailEvent;
import com.example.battosai.tesaplikasi001.Detail.DetailPenginapan;
import com.example.battosai.tesaplikasi001.Object.Event;
import com.example.battosai.tesaplikasi001.Object.Penginapan;
import com.example.battosai.tesaplikasi001.R;

import java.util.ArrayList;

/**
 * Created by Battosai on 4/12/2017.
 */

public class CustomAdapterPenginapan  extends BaseAdapter {

    Context c;
    ArrayList<Penginapan> penginapen;


    public CustomAdapterPenginapan(Context c, ArrayList<Penginapan> penginapen) {
        this.c = c;
        this.penginapen = penginapen;
    }

    @Override
    public int getCount() {
        return penginapen.size();
    }

    @Override
    public Object getItem(int position) {
        return penginapen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.modelpenginapan,parent,false);

        }

        TextView namaTxt= (TextView) convertView.findViewById(R.id.nama);
        ImageView gambar=(ImageView) convertView.findViewById(R.id.Gambar);

        final Penginapan p=(Penginapan) this.getItem(position);
        namaTxt.setText(p.getNama_penginapan());


        // PicassoClient.downloadImage(c,w.getGambar(),gambar);
        PicassoClient.downloadImage(c,p.getGambar(), gambar );

        //klik item
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open detail activity

                // openDetailActivity(e.getNamawisata(),w.getKeterangan(),w.getIsi(),w.getGambar());
                //
                openDetailActivity(p.getNama_penginapan(),p.getAlamat(),p.getJumlah_kamar(),p.getHarga(),p.getFasilitas(),p.getNo_telp(),p.getGambar());
            }
        });


        return convertView;

    }

    //open detail activity
    private void openDetailActivity(String nama_penginapan,String alamat, String jumlah_kamar,String harga,String fasilitas, String no_telp, String gambar ) {


        Intent i=new Intent(c,DetailPenginapan.class);

        //data
        i.putExtra("nama", nama_penginapan);
        i.putExtra("alamat",alamat);
        i.putExtra("jumlah",jumlah_kamar);
        i.putExtra("harga",harga);
        i.putExtra("fasilitas",fasilitas);
        i.putExtra("no_telp",no_telp);
        i.putExtra("gambar",gambar);
        c.startActivity(i);

    }

}


