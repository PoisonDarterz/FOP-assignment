package tc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import restructure.Err_Inv;


public class PieChart {
    public static void main(String[] args) {
        // Create a dataset for the pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue("Invalid Qos Specification", Err_Inv.amtInv[0]);
        dataset.setValue("Invalid Account", Err_Inv.amtInv[6]);
        dataset.setValue("Invalid Job Id Specified", Err_Inv.amtInv[2]);
        dataset.setValue("Invalid Partition Name Specified", Err_Inv.amtInv[1]);
        dataset.setValue("Invalid Node Name Specified", Err_Inv.amtInv[3]);
        dataset.setValue("Invalid User Id", Err_Inv.amtInv[4]);
        dataset.setValue("Invalid Group Id", Err_Inv.amtInv[5]);

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











