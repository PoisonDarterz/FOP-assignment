package izdecode;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import restructure.Create;
import restructure.End;
import restructure.JobCreateEnd;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MultipleLinesChart extends JFrame { // the class extends the JFrame class

    public MultipleLinesChart() {   // the constructor will contain the panel of a certain size and the close operations
        super("XY Line Chart Example with JFreechart"); // calls the super class constructor

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createChartPanel() { // this method will create the chart panel contain in the graph
        String chartTitle = "Number of jobs created/ended within a given time range";
        String xAxisLabel = "Days";
        String yAxisLabel = "Number of jobs";

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset);

        customizeChart(chart);

        // saves the chart as an image files
        File imageFile = new File("XYLineChart.png");
        int width = 640;
        int height = 480;

        try {
            ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return new ChartPanel(chart);
    }

    private XYDataset createDataset() {    // this method creates the data as time seris
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Object 1");
        XYSeries series2 = new XYSeries("Object 2");

        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> y = new ArrayList<>();

        int dayInMonth = 0;
        int dayEnd = 0, dayCreate = 0;
        int m = JobCreateEnd.gg;
        switch (m) {
            case 6 -> dayInMonth = 30;
            case 7 -> dayInMonth = 31;
            case 8 -> dayInMonth = 31;
            case 9 -> dayInMonth = 30;
            case 10 -> dayInMonth = 31;
            case 11 -> dayInMonth = 30;
            case 12 -> dayInMonth = 16;
        }
        for (int i = 1; i <= dayInMonth; i++) {
            for (Create c : JobCreateEnd.jobCreate) {
                if (c.getTime().getDayOfMonth() == i && c.getTime().getMonthValue() == m) {
                    dayCreate++;
                }
            }
            for (End e : JobCreateEnd.jobEnd) {
                if (e.getTime().getDayOfMonth() == i && e.getTime().getMonthValue() == m) {
                    dayEnd++;
                }
            }
            series1.add(i, dayCreate);
            series2.add(i, dayEnd);
            dayCreate = 0;
            dayEnd = 0;
        }

        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }

    private void customizeChart(JFreeChart chart) {   // here we make some customization
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // sets paint color for each series
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);

        // sets thickness for series (using strokes)
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));

        // sets paint color for plot outlines
        plot.setOutlinePaint(Color.BLUE);
        plot.setOutlineStroke(new BasicStroke(2.0f));

        // sets renderer for lines
        plot.setRenderer(renderer);

        // sets plot background
        plot.setBackgroundPaint(Color.DARK_GRAY);

        // sets paint color for the grid lines
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MultipleLinesChart().setVisible(true);
            }
        });
    }
}