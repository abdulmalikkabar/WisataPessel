package com.example.battosai.tesaplikasi001.Mysql;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.battosai.tesaplikasi001.Object.Kuliner;

import com.example.battosai.tesaplikasi001.UI.CustomAdapterKuliner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Battosai on 3/28/2017.
 */

public class data_parseKuliner extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<Kuliner> restoren=new ArrayList<>();

    public data_parseKuliner(Context c, String jsonData, ListView lv) {
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
            CustomAdapterKuliner adapter=new CustomAdapterKuliner(c,restoren);
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

            restoren.clear();
            Kuliner kuliner;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);


                int id=jo.getInt("id_kuliner");
                String nama=jo.getString("nama_kuliner");
                String alamat=jo.getString("alamat");
                String telpon=jo.getString("no_telp");
                String ket=jo.getString("desk");
                String gambar=jo.getString("gambar");



                kuliner =new Kuliner();

                kuliner.setId(id);
                kuliner.setNama_kuliner(nama);
                kuliner.setAlamat_kuliner(alamat);
                kuliner.setTelpon_kuliner(telpon);
                kuliner.setKet_kuliner(ket);
                kuliner.setGambar_kuliner(gambar);


                restoren.add(kuliner);
            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }


}



