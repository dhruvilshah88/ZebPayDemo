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
        try {
            new getticker().execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        // Gson gson = new Gson();
        //       Log.w("fields", " firlds=" + gson.toJson(maxmbuy) + " ..." + tickers.size());

        tickers = SugarRecord.findWithQuery(TickerModel.class, "Select min(buy), buy,sell,ctime from " + SugarRecord.getTableName(TickerModel.class) + " WHERE ctime > ? ", (timenow - 3600000) + "");
        TickerModel minbuy = tickers.get(0);
        Date date = new Date(minbuy.getCtime());
        int difference = (int) (maxmbuy.getBuy() - minbuy.getBuy());
        User user = ApplicationClass.getInstance().getsharedprefs();

        if (user.isNotify()) {

            //check if new differnece is not very close to last value
            if (user.getVariance() < difference && !isinrange(difference, user.getLastdifferencebuy() - user.getVariance(), user.getLastdifferencebuy() + user.getVariance())) {

                Log.w("test job", " sent user is " + user.getVariance() + " and diff is " + difference + " and last is " + user.getLastdifferencebuy());

                user.setLastdifferencebuy(difference);
                ApplicationClass.getInstance().setsharedprefs(user);
                sendnotification(difference, "buy");
            } else {
                Log.w("test job", "user is " + user.getVariance() + " and diff is " + difference + " and last is " + user.getLastdifferencebuy());
            }
        }
        getdifferencesell();
    }

    boolean isinrange(int value, int min, int max) {
        boolean isinrange = value > min && value < max;

        Log.w("test job", "Value " + value + " is in " + min + " " + max + " " + isinrange);
        return isinrange;
    }

    void getdifferencesell() {
        long timenow = System.currentTimeMillis();
        TickerModel ticker = new TickerModel();
        List<TickerModel> tickers = SugarRecord.findWithQuery(TickerModel.class, "Select max(sell), buy,sell,ctime from " + SugarRecord.getTableName(TickerModel.class) + " WHERE ctime > ? ", (timenow - 3600000) + "");
        TickerModel maxmsell = tickers.get(0);
        // Gson gson = new Gson();
        //       Log.w("fields", " firlds=" + gson.toJson(maxmbuy) + " ..." + tickers.size());

        tickers = SugarRecord.findWithQuery(TickerModel.class, "Select min(sell), buy,sell,ctime from " + SugarRecord.getTableName(TickerModel.class) + " WHERE ctime > ? ", (timenow - 3600000) + "");
        TickerModel minsell = tickers.get(0);
        int difference = (int) (maxmsell.getSell() - minsell.getSell());
        User user = ApplicationClass.getInstance().getsharedprefs();
        Log.w("test job", "min:" + minsell.getSell() + "  " + maxmsell.getSell() + " diff=" + (difference) + " last is " + user.getLastdifferencesell());

        if (user.isNotify()) {
            if (user.getVariance() < difference && !isinrange(difference, user.getLastdifferencesell() - user.getVariance(), user.getLastdifferencesell() + user.getVariance())) {

                Log.w("test job", " sent user is " + user.getVariance() + " and diff is " + difference + " and last is " + user.getLastdifferencesell());
                user.setLastdifferencesell(difference);
                ApplicationClass.getInstance().setsharedprefs(user);
                sendnotification(difference, "sell");
            } else {
                Log.w("test job", "user is " + user.getVariance() + " and diff is " + difference + " and last is " + user.getLastdifferencesell());
            }
        }
    }

    void sendnotification(int change, String buysell) {

        Context context = ApplicationClass.getInstance();
        Intent intent = new Intent(context, analytics.class);
        intent.putExtra("type", buysell);
        PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

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