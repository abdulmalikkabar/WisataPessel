package com.example.battosai.tesaplikasi001.Mysql;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.battosai.tesaplikasi001.Object.Event;
import com.example.battosai.tesaplikasi001.Object.Penginapan;
import com.example.battosai.tesaplikasi001.UI.CustomAdapterEvent;
import com.example.battosai.tesaplikasi001.UI.CustomAdapterPenginapan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Battosai on 4/12/2017.
 */

public class data_parsePenginapan  extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<Penginapan> penginapen=new ArrayList<>();

    public data_parsePenginapan (Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Loading");
        pd.setMessage("Loading Data Mohon Tunggu");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean parsed) {
        super.onPostExecute(parsed);

        pd.dismiss();

        if(parsed)
        {
            //BIND
            CustomAdapterPenginapan adapter=new CustomAdapterPenginapan(c,penginapen);
            lv.setAdapter(adapter);
        }else {
            Toast.makeText(c,"kesalahan pada parseData",Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            penginapen.clear();
            Penginapan penginapan;

            for (int i=0;i<ja.length();i++)
            {

                jo=ja.getJSONObject(i);


                int id=jo.getInt("id_penginapan");
                String nama=jo.getString("nama_penginapan");
                String alamat=jo.getString("alamat");
                String jumlah=jo.getString("jumlah_kamar");
                String harga=jo.getString("harga");
                String fasilitas=jo.getString("fasilitas");
                String no_telp=jo.getString("no_telpon");
                String gambar=jo.getString("gambar");

                penginapan=new Penginapan();

                penginapan.setId(id);
                penginapan.setNama_penginapan(nama);
                penginapan.setAlamat(alamat);
                penginapan.setJumlah_kamar(jumlah);
                penginapan.setHarga(harga);
                penginapan.setFasilitas(fasilitas);
                penginapan.setNo_telp(no_telp);
                penginapan.setGambar(gambar);

                penginapen.add(penginapan);
            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }


}

