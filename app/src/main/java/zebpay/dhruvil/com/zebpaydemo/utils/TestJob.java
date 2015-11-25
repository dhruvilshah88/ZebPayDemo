package zebpay.dhruvil.com.zebpaydemo.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.google.gson.Gson;
import com.orm.SugarRecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import zebpay.dhruvil.com.zebpaydemo.R;
import zebpay.dhruvil.com.zebpaydemo.analytics;
import zebpay.dhruvil.com.zebpaydemo.models.TickerModel;
import zebpay.dhruvil.com.zebpaydemo.models.User;

/**
 * Created by dhruvil on 25/11/15.
 */
public class TestJob extends Job {

    public static final String TAG = "TestJobTag";

    @Override
    @NonNull
    protected Result onRunJob(final Params params) {

        Log.w(TAG, TAG + " " + System.currentTimeMillis());
        new getticker().execute();

        if (isCanceled()) {
            return params.isPeriodic() ? Result.FAILURE : Result.RESCHEDULE;
        } else {
            return Result.SUCCESS;
        }
    }

    void getdifference() {
        long timenow = System.currentTimeMillis();
        TickerModel ticker = new TickerModel();
        List<TickerModel> tickers = SugarRecord.findWithQuery(TickerModel.class, "Select max(buy), buy,sell,ctime from " + SugarRecord.getTableName(TickerModel.class) + " WHERE ctime > ? ", (timenow - 3600000) + "");
        TickerModel maxmbuy = tickers.get(0);
        Date datemax = new Date(maxmbuy.getCtime());
        DateFormat formattermax = new SimpleDateFormat("HH:mm:ss:SSS");
        String dateFormattedmax = formattermax.format(datemax);
        // Gson gson = new Gson();
        //       Log.w("fields", " firlds=" + gson.toJson(maxmbuy) + " ..." + tickers.size());

        tickers = SugarRecord.findWithQuery(TickerModel.class, "Select min(buy), buy,sell,ctime from " + SugarRecord.getTableName(TickerModel.class) + " WHERE ctime > ? ", (timenow - 3600000) + "");
        TickerModel minbuy = tickers.get(0);
        Date date = new Date(minbuy.getCtime());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        String dateFormatted = formatter.format(date);
        int difference = (int) (maxmbuy.getBuy() - minbuy.getBuy());
        Log.w("test job", "min:" + minbuy.getBuy() + " " + dateFormatted + " max:" + dateFormattedmax + " " + maxmbuy.getBuy() + " diff=" + (difference));
        User user = ApplicationClass.getInstance().getsharedprefs();

        if (user.isNotify()) {
            if (user.getVariance() < difference && user.getLastdifference() != difference) {

                Log.w("test job", " sent user is " + user.getVariance() + " and diff is " + difference);

                user.setLastdifference(difference);
                ApplicationClass.getInstance().setsharedprefs(user);
                sendnotification(difference);
            } else {
                Log.w("test job", "user is " + user.getVariance() + " and diff is " + difference + " and last is " + user.getLastdifference());
            }
        }
    }

    void sendnotification(int change) {
        // prepare intent which is triggered if the
// notification is selected
        Context context = ApplicationClass.getInstance();
        Intent intent = new Intent(context, analytics.class);
// use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

// build notification
// the addAction re-use the same intent to keep the example short
        Notification n = new Notification.Builder(context)
                .setContentTitle("ZebPay Price Change")
                .setContentText("Variance Price " + change)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .build();


        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
    }

    class getticker extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... args) {

            String respose = "error";
            try {
                respose = new CustomHttpClient().get("https://api.zebpay.com/api/v1/ticker?currencyCode=INR");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return respose;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s.equals("error") || s == null) {

            } else {
                try {
                    //       Log.w("res", s + ";");
                    Gson gson = new Gson();
                    TickerModel ticker = gson.fromJson(s, TickerModel.class);
                    //     Log.w("time", ticker.getCtime() + ";");
                    ticker.save();
                    getdifference();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}