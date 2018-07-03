package com.example.battosai.tesaplikasi001.Mysql;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.sql.Connection;

/**
 * Created by Battosai on 3/27/2017.
 */

public class DownloaderEvent extends AsyncTask <Void, Void, String> { //Tambah di class extends AsyncTask <Void, Void, String>

    Context context;
    String urlAnddress;
    ListView listView;

    ProgressDialog progressDialog;

    //alt+insert +constructor , context , url, listview

    public DownloaderEvent(Context context, String urlAnddress, ListView listView) {
        this.context = context;
        this.urlAnddress = urlAnddress;
        this.listView = listView;
    }

    // Ketik onPrexe
    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Loading Data Mohon Tunggu");
        progressDialog.show();
    }

    // ketik doInBackg
    @Override
    protected String doInBackground(Void... params) {
//tambahan  return this.DownloadData();
        return this.DownloadData();
    }

    // Ketik onPostExecute

    @Override
    protected void onPostExecute(String JsonData) { //s ganti JsonData
        super.onPostExecute(JsonData);


        progressDialog.dismiss();

         if (JsonData==null){

             Toast.makeText(context,"Network Error",Toast.LENGTH_SHORT).show();

         } else {
             // data parse
           //  new data_parse(c,jsonData,lv).execute();
             new data_parseEvent(context,JsonData,listView).execute();

         }
    }

    //buat Private String Downloaddata

    private String DownloadData ()
    {
        //buat koneksi
        HttpURLConnection con=conector.connect(urlAnddress);
        if (con==null){

            return null;
        }


        try
        {
            InputStream inputStream=new BufferedInputStream(con.getInputStream());   //add Catc
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            String Line;
            StringBuffer jsonData=new StringBuffer();

            while ((Line=bufferedReader.readLine()) !=null)
            {
                jsonData.append(Line+"\n");
            }


            bufferedReader.close();
            inputStream.close();

            return jsonData.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
