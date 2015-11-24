package zebpay.dhruvil.com.zebpaydemo.utils;

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

import zebpay.dhruvil.com.zebpaydemo.models.TickerModel;

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

        Log.w("fields", "min:" + minbuy.getBuy() + " " + dateFormatted + " max:" + dateFormattedmax + " " + maxmbuy.getBuy() + " diff=" + (maxmbuy.getBuy() - minbuy.getBuy()));

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