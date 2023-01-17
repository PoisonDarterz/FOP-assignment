import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotExample extends ApplicationFrame {

    public ScatterPlotExample(String title) {
        super(title);

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("First");

        series1.add(6, 1.0);
        series1.add(7, 4.0);
        series1.add(8, 3.0);
        series1.add(9, 3.0);
        series1.add(10, 3.0);
        series1.add(11, 3.0);
        series1.add(12, 3.0);

        dataset.addSeries(series1);
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Scatter Plot Example",
                "Months", "Number", dataset);
        return chart;
    }

    public static void main(String[] args) {
        ScatterPlotExample example = new ScatterPlotExample("Number of Uncompleted Jobs Per Month");
        example.pack();
        RefineryUtilities.centerFrameOnScreen(example);
        example.setVisible(true);
    }
}