package zebpay.dhruvil.com.zebpaydemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.google.gson.Gson;
import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;
import java.util.List;

import zebpay.dhruvil.com.zebpaydemo.models.ActivityFeedPojo;
import zebpay.dhruvil.com.zebpaydemo.models.TickerModel;
import zebpay.dhruvil.com.zebpaydemo.utils.CustomHttpClient;
import zebpay.dhruvil.com.zebpaydemo.utils.RecyclerViewHeader;
import zebpay.dhruvil.com.zebpaydemo.utils.TestJob;

public class MainActivity extends AppCompatActivity {
    private static final String LAST_JOB_ID = "LAST_JOB_ID";
    RecyclerViewHeader header;
    List<ActivityFeedPojo.ActivityFeedEntity> feeds;
    private RecyclerView recyclerViewFeeds;
    private ActivityFeedAdapter adapter;
    private TextView tvbuy, tvsell;
    private JobManager mJobManager;
    private int mLastJobId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJobManager = JobManager.instance();

        if (savedInstanceState != null) {
            mLastJobId = savedInstanceState.getInt(LAST_JOB_ID, 0);
        }
        if (mJobManager.getAllJobRequests().size() > 0) {
            Log.w("abc", "not running");
            if (mJobManager.getAllJobRequests().size() > 1) {
                Log.w("abc", "cancelling");
                mJobManager.cancelAll();
                mLastJobId = new JobRequest.Builder(TestJob.TAG)
                        .setPeriodic(600000L)
                        .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                        .setPersisted(true)

                        .build()
                        .schedule();
            }
        } else {
            mLastJobId = new JobRequest.Builder(TestJob.TAG)
                    .setPeriodic(600000L)
                    .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                    .setPersisted(true)
                    .build()
                    .schedule();
        }

        recyclerViewFeeds = (RecyclerView) findViewById(R.id.recyclerViewfeeds);
        recyclerViewFeeds.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        header = RecyclerViewHeader.fromXml(MainActivity.this, R.layout.header);
        header.attachTo(recyclerViewFeeds);
        header.findViewById(R.id.buychart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, analytics.class);
                intent.putExtra("type", "buy");
                startActivity(intent);
            }
        });
        header.findViewById(R.id.sellchart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, analytics.class);
                intent.putExtra("type", "sell");
                startActivity(intent);
            }
        });

        tvbuy = (TextView) header.findViewById(R.id.tvbuy);
        tvsell = (TextView) header.findViewById(R.id.tvsell);
        feeds = new ArrayList<>();
        adapter = new ActivityFeedAdapter(MainActivity.this, feeds);
        recyclerViewFeeds.setAdapter(adapter);

        new gethomefeed().execute();
        new getticker().execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.refresh:
                Log.w("main", "refresh");

                new gethomefeed().execute();
                new getticker().execute();
                break;

            case R.id.settings:

                startActivity(new Intent(MainActivity.this, Settings.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    class gethomefeed extends AsyncTask<RequestBody, Void, String> {
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(MainActivity.this, "", "Please Wait", true, false);
            pd.show();
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
            if (pd != null)
                pd.dismiss();
            if (s.equals("error") || s == null) {

            } else {
                try {
                    Gson gson = new Gson();
                    ActivityFeedPojo feedspojo = gson.fromJson(s, ActivityFeedPojo.class);
                    if (feedspojo.getReturncode().equals("1")) {
                        feeds = feedspojo.getActivityFeed();

                        adapter.setdata(feeds);
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
                    //       Log.w("res", s + ";");
                    Gson gson = new Gson();
                    TickerModel ticker = gson.fromJson(s, TickerModel.class);
                    tvbuy.setText(ticker.getBuy() + " ₹");
                    tvsell.setText(ticker.getSell() + " ₹");
                    //     Log.w("time", ticker.getCtime() + ";");
                    ticker.save();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
