package net_utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

public class LruBitmapCache extends LruCache<java.lang.String, Bitmap> implements ImageLoader.ImageCache {
    public static int getDefaultLruCacheSize(){
        final int maxMemory = (int) (java.lang.Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;
        return cacheSize;
    }

    public LruBitmapCache() {
        this(getDefaultLruCacheSize());
    }

    public LruBitmapCache(int sizeInKiloBytes) {
        super(sizeInKiloBytes);
    }

    @java.lang.Override
    protected int sizeOf(java.lang.String key, Bitmap value){
        return value.getRowBytes() * value.getHeight() / 1024;
    }

    @java.lang.Override
    public Bitmap getBitmap(java.lang.String url) {
        return get(url);
    }
    @java.lang.Override
    public void putBitmap(java.lang.String url, Bitmap bitmap) {
        put(url, bitmap);
    }

}
