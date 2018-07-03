package com.example.battosai.tesaplikasi001.UI;

import android.content.Context;
import android.widget.ImageView;

import com.example.battosai.tesaplikasi001.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Battosai on 3/14/2017.
 */

public class PicassoClient {

    public static void downloadImage(Context c, String imagUrl, ImageView img)
    {
        if(imagUrl != null && imagUrl.length()>0)
        {
            Picasso.with(c).load(imagUrl).placeholder(R.mipmap.ic_loading).into(img);
        }else {
            Picasso.with(c).load(R.mipmap.add_btn).into(img);
        }
    }

}
