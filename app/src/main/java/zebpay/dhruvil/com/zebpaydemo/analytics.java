package zebpay.dhruvil.com.zebpaydemo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.BasicStroke;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import zebpay.dhruvil.com.zebpaydemo.models.TickerModel;


public class analytics extends Activity {

    private View mChart;
    private String[] timeprice;
    private int pYear;
    private int pMonth;
    private int pDay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analytics);


        // Getting reference to the button btn_chart

        // Setting event click listener for the button btn_chart of the
        // MainActivity layout

        Calendar cal = Calendar.getInstance();

        pYear = cal.get(Calendar.YEAR);

        pDay = cal.get(Calendar.DAY_OF_MONTH);

        pMonth = cal.get(Calendar.MONTH);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        Log.w("main", "day is:" + dayOfWeek);
        try {
            openChart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openChart() {
        TickerModel ticker = new TickerModel();
        List<TickerModel> tickers = ticker.findWithQuery(TickerModel.class, "Select * from " + ticker.getTableName(TickerModel.class) + " GROUP BY buy ORDER BY ctime DESC ");//, (System.currentTimeMillis() - 720000) + "");
        int[] bitrates = new int[tickers.size()];
        timeprice = new String[tickers.size()];
        for (int j = 0; j < tickers.size(); j++) {
            bitrates[j] = (int) tickers.get(j).getBuy();
            timeprice[j] = getformateddate(tickers.get(j).getCtime());
        }
        int maxy = findmax(bitrates);

        // Creating an XYSeries for bitrates
        XYSeries bitratesSeries = new XYSeries("Rates Latest");
        // Creating an XYSeries for Expense
        // Adding data to bitrates and Expense Series
        for (int i = 0; i < bitrates.length; i++) {
            bitratesSeries.add(i, bitrates[i]);
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding bitrates Series to the dataset
        dataset.addSeries(bitratesSeries);
        // Adding Expense Series to dataset
        // dataset.addSeries(expenseSeries);

        // Creating XYSeriesRenderer to customize bitratesSeries
        XYSeriesRenderer bitratesRenderer = new XYSeriesRenderer();
        bitratesRenderer.setColor(R.color.colorPrimary); // color of the graph

        bitratesRenderer.setFillPoints(true);
        bitratesRenderer.setLineWidth(2f);
        bitratesRenderer.setDisplayChartValues(true);
        // setting chart value distance
        bitratesRenderer.setDisplayChartValuesDistance(10);
        // setting line graph point style to circle
        bitratesRenderer.setPointStyle(PointStyle.CIRCLE);
        // setting stroke of the line chart to solid
        bitratesRenderer.setStroke(BasicStroke.SOLID);
        bitratesRenderer.setChartValuesTextSize(20);
        // Creating XYSeriesRenderer to customize expenseSeries
        bitratesRenderer.setDisplayChartValuesDistance(10);
        // setting line graph point style to circle

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("");
        multiRenderer.setXTitle("Time");
        multiRenderer.setYTitle("Buy Rates");
        // multiRenderer.setAxesColor(color.available);
        /***
         * Customizing graphs
         */
        // setting text size of the title
        multiRenderer.setChartTitleTextSize(28);
        // setting text size of the axis title
        multiRenderer.setAxisTitleTextSize(24);
        // setting text size of the graph lable
        multiRenderer.setLabelsTextSize(24);
        // setting zoom buttons visiblity
        multiRenderer.setZoomButtonsVisible(true);
        // setting pan enablity which uses graph to move on both axis
        multiRenderer.setPanEnabled(false, false);
        // setting click false on graph
        multiRenderer.setClickEnabled(false);
        // setting zoom to false on both axis
        multiRenderer.setZoomEnabled(true, true);
        // setting lines to display on y axis
        multiRenderer.setShowGridY(true);
        // setting lines to display on x axis
        multiRenderer.setShowGridX(true);
        // setting legend to fit the screen size
        multiRenderer.setFitLegend(true);
        // setting displaying line on grid
        multiRenderer.setShowGrid(true);
        // setting zoom to false
        multiRenderer.setZoomEnabled(true);
        // setting external zoom functions to false
        multiRenderer.setExternalZoomEnabled(false);
        // setting displaying lines on graph to be formatted(like using
        // graphics)
        multiRenderer.setAntialiasing(true);

        // setting to in scroll to false
        multiRenderer.setInScroll(true);
        // setting to set legend height of the graph
        multiRenderer.setLegendHeight(55);
        // setting x axis label align
        multiRenderer.setXLabelsAlign(Align.CENTER);

        // setting y axis label to align
        multiRenderer.setYLabelsAlign(Align.LEFT);
        // setting text style
        multiRenderer.setTextTypeface("sans_serif", Typeface.BOLD);
        // setting no of values to display in y axis
        multiRenderer.setYLabels(0);

        // setting y axis max value, Since i'm using static values inside the
        // graph so i'm setting y max value to 4000.
        // if you use dynamic values then get the max y value and set here
        multiRenderer.setYAxisMax((maxy + 10) * 2);

        multiRenderer.setYAxisMin(0);
        // setting used to move the graph on xaxiz to .5 to the right
        multiRenderer.setXAxisMin(-0.5);
        // setting used to move the graph on xaxiz to .5 to the right
        multiRenderer.setXAxisMax(6);
        // setting bar size or space between two bars
        // multiRenderer.setBarSpacing(0.5);
        // Setting background color of the graph to transparent
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        // Setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(getResources().getColor(
                R.color.transparent));
        multiRenderer.setApplyBackgroundColor(true);
        multiRenderer.setScale(2f);
        // setting x axis point size
        multiRenderer.setPointSize(4f);
        // setting the margin size for the graph in the order top, left, bottom,
        // right

        for (int i = 0; i < bitrates.length; i++) {
            multiRenderer.addXTextLabel(i, timeprice[i]);
        }

        // Adding bitratesRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to
        // multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(bitratesRenderer);
        // multiRenderer.addSeriesRenderer(expenseRenderer);

        // this part is used to display graph on the xml
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart);
        // remove any views before u paint the chart
        chartContainer.removeAllViews();
        // drawing bar chart
        mChart = ChartFactory.getLineChartView(analytics.this, dataset,
                multiRenderer);
        // adding the view to the linearlayout
        chartContainer.addView(mChart);

    }

    int findmax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;

    }


    String getformateddate(long timemilli) {
        Date date = new Date(timemilli);
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateFormatted = formatter.format(date);
        return dateFormatted;

    }
}