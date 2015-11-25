package zebpay.dhruvil.com.zebpaydemo.utils;

import android.content.SharedPreferences;

import com.crashlytics.android.Crashlytics;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.JobManager;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.orm.SugarApp;

import io.fabric.sdk.android.Fabric;
import zebpay.dhruvil.com.zebpaydemo.models.User;

/**
 * Created by dhruvil on 23/11/15.
 */
public class ApplicationClass extends SugarApp {
    private static ApplicationClass mInstance;
    private ImageLoader loader;

    public static synchronized ApplicationClass getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        mInstance = this;
        JobManager.create(this, new MyJobCreator());
    }

    public User getsharedprefs() {
        Gson gson = new Gson();
        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        String userpojostring = sp.getString("pojo", "error");
        if (userpojostring.equals("error")) {
            return new User();
        }
        User user = gson.fromJson(userpojostring, User.class);

        return user;
    }

    public void setsharedprefs(User user) {
        Gson gson = new Gson();
        String userpojostring = gson.toJson(user);
        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        edit.putString("pojo", userpojostring);
        edit.commit();

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

    private static class MyJobCreator implements JobCreator {

        @Override
        public Job create(String tag) {
            switch (tag) {

                case TestJob.TAG:

                    return new TestJob();
                default:
                    throw new RuntimeException("Cannot find job for tag " + tag);
            }
        }
    }

}
