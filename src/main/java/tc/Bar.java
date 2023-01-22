package tc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import restructure.Err_Inv;

public class Bar {
    public static void main(String[] args) {

        // Create a dataset for the bar chart
        // Create a dataset for the bar chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(Err_Inv.numErr, "Users", "Errors");
        dataset.setValue(Err_Inv.numInvalid, "Users", "Invalid");

        // Create a chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Number of Users with Errors and Invalidity", // Chart title
                "Type of Errors",             // X-Axis Label
                "Number of Users",             // Y-Axis Label
                dataset              // Chart Data
        );

        // Create a frame to display the chart
        ChartFrame frame = new ChartFrame("Number of Users with Errors and Invalidity", chart);
        frame.pack();
        frame.setVisible(true);
    }
}











