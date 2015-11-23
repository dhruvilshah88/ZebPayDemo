package zebpay.dhruvil.com.zebpaydemo.models;

import com.orm.SugarRecord;

/**
 * Created by dhruvil on 24/11/15.
 */
public class TickerModel extends SugarRecord<TickerModel> {
    /**
     * market : 19443.0
     * buy : 19443.0
     * sell : 18858.0
     * currency : INR
     */

    private double market;
    private double buy;
    private double sell;
    private String currency;
    private double ctime = System.currentTimeMillis();

    public double getCtime() {
        return ctime;
    }

    public void setCtime(double ctime) {
        this.ctime = ctime;
    }

    public void setMarket(double market) {
        this.market = market;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getMarket() {
        return market;
    }

    public double getBuy() {
        return buy;
    }

    public double getSell() {
        return sell;
    }

    public String getCurrency() {
        return currency;
    }
}
