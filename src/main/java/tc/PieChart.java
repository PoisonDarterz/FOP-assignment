package tc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;



public class PieChart {
    public static void main(String[] args) {
        // Create a dataset for the pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Invalid Qos Specification", new Double(157));
        dataset.setValue("Invalid Account", new Double(52));
        dataset.setValue("Invalid Job Id Specified", new Double(50));
        dataset.setValue("Invalid Partition Name Specified", new Double(47));
        dataset.setValue("Invalid Node Name Specified", new Double(4));
        dataset.setValue("Invalid User Id", new Double(4));
        dataset.setValue("Invalid Group Id", new Double(1));

        // Create a chart
        JFreeChart chart = ChartFactory.createPieChart(
                "Invalidity",  // Chart title
                dataset,             // Chart data
                true,                // Include legend
                true,                // Use tooltips
                false                // Configure chart to generate URLs?
        );

        // Create a frame to display the chart
        ChartFrame frame = new ChartFrame("Types of Invalid and their numbers", chart);
        frame.pack();
        frame.setVisible(true);
    }
}











