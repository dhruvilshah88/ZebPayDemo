package zebpay.dhruvil.com.zebpaydemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.squareup.okhttp.RequestBody;

import zebpay.dhruvil.com.zebpaydemo.models.ActivityFeedPojo;
import zebpay.dhruvil.com.zebpaydemo.utils.CustomHttpClient;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFeeds;
    private ActivityFeedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewFeeds = (RecyclerView) findViewById(R.id.recyclerViewfeeds);
        recyclerViewFeeds.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        new gethomefeed().execute();

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
}
