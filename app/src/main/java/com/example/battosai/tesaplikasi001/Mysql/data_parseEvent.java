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
 * Created by Battosai on 3/27/2017.
 */

public class data_parseEvent extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<Event> events=new ArrayList<>();

    public data_parseEvent(Context c, String jsonData, ListView lv) {
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
            CustomAdapterEvent adapter=new CustomAdapterEvent(c,events);
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

            events.clear();
            Event event;

            for (int i=0;i<ja.length();i++)
            {

                jo=ja.getJSONObject(i);


                int id=jo.getInt("id_event");
                String nama_event=jo.getString("nama_event");
                String lokasi=jo.getString("lokasi");
                String desk=jo.getString("desk");
                String tgl_event=jo.getString("tgl_event");
                double lat=jo.getDouble("lat");
                double lng=jo.getDouble("log");
                String gambar=jo.getString("gambar");

                event=new Event();

                event.setId(id);
                event.setNamaevent(nama_event);
                event.setLokasi(lokasi);
                event.setDesk(desk);
                event.setTgl_event(tgl_event);
                event.setGambar(gambar);
                event.setLat(lat);
                event.setLng(lng);

                events.add(event);
            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }


}

