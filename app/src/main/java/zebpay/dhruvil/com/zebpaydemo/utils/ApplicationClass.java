package zebpay.dhruvil.com.zebpaydemo.utils;

import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by dhruvil on 23/11/15.
 */
public class ApplicationClass extends Application {
    private ImageLoader loader;
    private static ApplicationClass mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    public static synchronized ApplicationClass getInstance() {
        return mInstance;
    }

    public ImageLoader getimageloader() {

        if (!ImageLoader.getInstance().isInited()) {
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                    .diskCacheExtraOptions(480, 800, null)
                    .denyCacheImageMultipleSizesInMemory()
                    .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                    .memoryCacheSize(2 * 1024 * 1024)
                    .diskCacheSize(50 * 1024 * 1024)
                    .diskCacheFileCount(100)
                    .build();
            ImageLoader.getInstance().init(config);
            loader = ImageLoader.getInstance();
        } else {
            loader = ImageLoader.getInstance();
        }
        return loader;
    }

}
