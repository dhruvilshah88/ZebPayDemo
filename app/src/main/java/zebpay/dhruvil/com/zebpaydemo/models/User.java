package zebpay.dhruvil.com.zebpaydemo.models;

/**
 * Created by dhruvil on 25/11/15.
 */
public class User {
    long lastupdated = 0;
    boolean notify = true;
    int variance = 100;
    int lastdifference = 0;

    public int getLastdifference() {
        return lastdifference;
    }

    public void setLastdifference(int lastdifference) {
        this.lastdifference = lastdifference;
    }

    public long getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(long lastupdated) {
        this.lastupdated = lastupdated;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public int getVariance() {
        return variance;
    }

    public void setVariance(int variance) {
        this.variance = variance;
    }
}
