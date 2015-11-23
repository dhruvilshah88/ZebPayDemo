package zebpay.dhruvil.com.zebpaydemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

import zebpay.dhruvil.com.zebpaydemo.models.ActivityFeedPojo;
import zebpay.dhruvil.com.zebpaydemo.utils.ApplicationClass;

/**
 * Created by dhruvil on 23/11/15.
 */
public class ActivityFeedAdapter extends RecyclerView.Adapter<ActivityFeedAdapter.MyHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<ActivityFeedPojo.ActivityFeedEntity> activityFeed;
    ImageLoader imageLoader;
    private DisplayImageOptions options;

    ActivityFeedAdapter(Context context, List<ActivityFeedPojo.ActivityFeedEntity> activityFeed) {
        this.context = context;
        this.activityFeed = activityFeed;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.circle_blue)
                .showImageForEmptyUri(R.drawable.circle_blue)

                .showImageOnFail(R.drawable.circle_blue).cacheInMemory(true).cacheOnDisk(true)
                .considerExifParams(true).build();
        imageLoader = ApplicationClass.getInstance().getimageloader();
    }

    @Override
    public ActivityFeedAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater != null) {

        } else {
            inflater = LayoutInflater.from(context);
        }
        View view = inflater.inflate(R.layout.home_feed_row, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ActivityFeedAdapter.MyHolder holder, int position) {
        final ActivityFeedPojo.ActivityFeedEntity entity = activityFeed.get(position);

        holder.textViewTitle.setText(entity.getTitle());
        holder.textViewDetail.setText(entity.getDescription());
        if (entity.getSourceImageUrl() == null || entity.getSourceImageUrl().length() < 5) {

            holder.resImagetext.setVisibility(View.VISIBLE);
            holder.resImagetext.setText(entity.getTitle().substring(0, 1));
            holder.imv.setImageResource(R.drawable.circle_blue);

        } else {
            holder.resImagetext.setText("");
            holder.resImagetext.setVisibility(View.GONE);
            imageLoader.displayImage(entity.getSourceImageUrl(), holder.imv, options, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {
                    holder.imv.setImageResource(R.drawable.circle_blue);
                }

                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {
                    holder.imv.setImageResource(R.drawable.circle_blue);
                }

                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    holder.resImagetext.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingCancelled(String s, View view) {
                    holder.imv.setImageResource(R.drawable.circle_blue);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return activityFeed.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewTitle;
        TextView textViewDetail;
        ImageView imv;
        TextView resImagetext;

        public MyHolder(final View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.tvtitle);
            textViewDetail = (TextView) itemView.findViewById(R.id.tvdesc);
            resImagetext = (TextView) itemView.findViewById(R.id.resImagetext);
            imv = (ImageView) itemView.findViewById(R.id.resImage);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

        }
    }
}
