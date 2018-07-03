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

/**
 * Created by Battosai on 3/27/2017.
 */

public class DownloaderKuliner extends AsyncTask<Void,Void,String> {



    Context c;
    String urlAddess;
    ListView lv;

    ProgressDialog pd;

    public DownloaderKuliner(Context c, String urlAddess, ListView lv) {
        this.c = c;
        this.urlAddess = urlAddess;
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
    protected String doInBackground(Void... params) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        pd.dismiss();

        if(jsonData==null)
        {
            Toast.makeText(c,"Network Error",Toast.LENGTH_SHORT).show();
        }else {
            //PARSER
            new data_parseKuliner(c,jsonData,lv).execute();


        }
    }

    private String downloadData()
    {
        HttpURLConnection con=conector.connect(urlAddess);
        if(con==null)
        {
            return null;
        }

        try {
            InputStream is=new BufferedInputStream(con.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuffer jsonData=new StringBuffer();

            while ((line=br.readLine()) != null)
            {
                jsonData.append(line+"\n");

            }

            br.close();
            is.close();

            return jsonData.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
