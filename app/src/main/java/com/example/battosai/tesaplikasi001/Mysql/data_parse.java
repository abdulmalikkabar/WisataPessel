package com.example.battosai.tesaplikasi001.Mysql;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;


import com.example.battosai.tesaplikasi001.Object.Event;
import com.example.battosai.tesaplikasi001.Object.wisata;
import com.example.battosai.tesaplikasi001.UI.CustomAdapter;
import com.example.battosai.tesaplikasi001.UI.CustomAdapterEvent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Battosai on 3/14/2017.
 */
public class data_parse  extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<wisata> wisatas=new ArrayList<>();

    public data_parse(Context c, String jsonData, ListView lv) {
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
            CustomAdapter adapter=new CustomAdapter(c,wisatas);
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

            wisatas.clear();
            wisata wisata;

            for (int i=0;i<ja.length();i++)
            {

                jo=ja.getJSONObject(i);

                int id=jo.getInt("id_wisata");
                String namawisata=jo.getString("nama_wisata");
                String kategori=jo.getString("kategori");
                String desk=jo.getString("desk");
                String gambar=jo.getString("gambar");
                String gambar2=jo.getString("gambar2");
                String gambar3=jo.getString("gambar3");
                String gambar4=jo.getString("gambar4");
                double lat=jo.getDouble("lat");
                double lng=jo.getDouble("log");

                wisata=new wisata();

                wisata.setId(id);
                wisata.setNamawisata(namawisata);
                wisata.setKategori(kategori);
                wisata.setDesk(desk);
                wisata.setGambar(gambar);
                wisata.setGambar2(gambar2);
                wisata.setGambar3(gambar3);
                wisata.setGambar4(gambar4);
                wisata.setLat(lat);
                wisata.setLng(lng);

                wisatas.add(wisata);
            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }


}

