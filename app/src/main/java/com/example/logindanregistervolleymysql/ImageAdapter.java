package com.example.logindanregistervolleymysql;

import android.content.Context;
import android.graphics.Bitmap;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;
import android.util.LruCache; // Tambahkan impor ini

public class ImageAdapter {

    private static ImageAdapter imageAdapter;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    private ImageAdapter(Context context) {
        requestQueue = getRequestQueue(context);
        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<>(30);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public static ImageAdapter getInstance(Context context) {
        if (imageAdapter == null) {
            imageAdapter = new ImageAdapter(context);
        }
        return imageAdapter;
    }

    private RequestQueue getRequestQueue(Context context) {
        Cache cache = new DiskBasedCache(context.getCacheDir());
        Network network = new BasicNetwork(new HurlStack());
        return Volley.newRequestQueue(context);
    }
}
