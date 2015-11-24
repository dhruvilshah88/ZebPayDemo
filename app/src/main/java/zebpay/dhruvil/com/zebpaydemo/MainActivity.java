package zebpay.dhruvil.com.zebpaydemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.RequestBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import zebpay.dhruvil.com.zebpaydemo.models.ActivityFeedPojo;
import zebpay.dhruvil.com.zebpaydemo.models.TickerModel;
import zebpay.dhruvil.com.zebpaydemo.utils.CustomHttpClient;
import zebpay.dhruvil.com.zebpaydemo.utils.RecyclerViewHeader;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFeeds;
    private ActivityFeedAdapter adapter;
    private TextView tvbuy, tvsell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewFeeds = (RecyclerView) findViewById(R.id.recyclerViewfeeds);
        recyclerViewFeeds.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(MainActivity.this, R.layout.header);

        header.attachTo(recyclerViewFeeds);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, analytics.class));
            }
        });
        tvbuy = (TextView) header.findViewById(R.id.tvbuy);
        tvsell = (TextView) header.findViewById(R.id.tvsell);
        new gethomefeed().execute();
        new getticker().execute();
    }

    class gethomefeed extends AsyncTask<RequestBody, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(RequestBody... params) {

            String respose = "error";
            try {
                respose = new CustomHttpClient().get("http://feed.zebpay.com/api/refreshactivity");
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
                    Gson gson = new Gson();
                    ActivityFeedPojo feeds = gson.fromJson(s, ActivityFeedPojo.class);
                    if (feeds.getReturncode().equals("1")) {
                        adapter = new ActivityFeedAdapter(MainActivity.this, feeds.getActivityFeed());
                        recyclerViewFeeds.setAdapter(adapter);

                    } else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

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
                    Log.w("res", s + ";");
                    Gson gson = new Gson();
                    TickerModel ticker = gson.fromJson(s, TickerModel.class);
                    tvbuy.setText(ticker.getBuy() + " ₹");
                    tvsell.setText(ticker.getSell() + " ₹");
                    Log.w("time", ticker.getCtime() + ";");

                    ticker.save();
                    long timenow = System.currentTimeMillis();
                    long interval = 600000;
                    List<TickerModel> tickers = ticker.findWithQuery(TickerModel.class, "Select max(buy), buy,sell from " + ticker.getTableName(TickerModel.class) + " where ctime - " + timenow + "  <= ?", interval + "");
                    TickerModel maxmbuy = tickers.get(0);
                    Log.w("fields", " firlds=" + gson.toJson(maxmbuy) + " ..." + tickers.size());

                    tickers = ticker.findWithQuery(TickerModel.class, "Select min(buy), buy,sell from " + ticker.getTableName(TickerModel.class) + " where ctime - " + timenow + "  <= ?", "600000");
                    TickerModel minbuy = tickers.get(0);
                    Date date = new Date(minbuy.getCtime());
                    DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
                    String dateFormatted = formatter.format(date);

                    Log.w("fields", "time:" + dateFormatted + " diff=" + (maxmbuy.getBuy() - minbuy.getBuy()) + " ..." + tickers.size());


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
