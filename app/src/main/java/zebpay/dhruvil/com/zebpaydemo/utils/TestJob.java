package zebpay.dhruvil.com.zebpaydemo.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by dhruvil on 25/11/15.
 */
public class TestJob extends Job {

    public static final String TAG = "TestJobTag";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());


    @Override
    @NonNull
    protected Result onRunJob(final Params params) {

        Log.w(TAG, TAG + " " + DATE_FORMAT);
        if (isCanceled()) {
            return params.isPeriodic() ? Result.FAILURE : Result.RESCHEDULE;
        } else {
            return Result.SUCCESS;
        }
    }
}