package tc;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class MultiplePieCharts {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Statistics for Average Execution Time.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold all of the pie charts
        JPanel chartPanel = new JPanel();
        chartPanel.setLayout(new GridLayout(2, 2));

        // Create the data sets for the pie charts
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        dataset1.setValue("Days", 2416.68);
        dataset1.setValue("Hours", 58000.31);
        dataset1.setValue("Minutes", 3480018.68);

        DefaultPieDataset dataset2 = new DefaultPieDataset();
        dataset2.setValue("Days", 0.32);
        dataset2.setValue("Hours", 7.70);
        dataset2.setValue("Minutes", 462.03);


        DefaultPieDataset dataset3 = new DefaultPieDataset();
        dataset3.setValue("Days", 14.17);
        dataset3.setValue("Hours", 340.18);
        dataset3.setValue("Minutes", 20410.70);

        DefaultPieDataset dataset4 = new DefaultPieDataset();
        dataset4.setValue("Days", 2.1875e-6);
        dataset4.setValue("Hours", 5.25e-5);
        dataset4.setValue("Minutes", 0.00315);

        // Create the pie charts
        JFreeChart chart1 = ChartFactory.createPieChart("Total number of completed Job : 7532", dataset1);
        JFreeChart chart2 = ChartFactory.createPieChart("Average execution time", dataset2);
        JFreeChart chart3 = ChartFactory.createPieChart("Highest Execution Time JobId=49723", dataset3);
        JFreeChart chart4 = ChartFactory.createPieChart("Lowest Execution Time JobId=52182", dataset4);

        // Add the pie charts to the chart panel
        chartPanel.add(new ChartPanel(chart1));
        chartPanel.add(new ChartPanel(chart2));
        chartPanel.add(new ChartPanel(chart3));
        chartPanel.add(new ChartPanel(chart4));

        // Add the chart panel to the frame
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}



//Total number of completed Job : 7532
//Total execution time : 2416.68 Days
//Total execution time : 58000.31 Hours
//Total execution time : 3480018.68 Mins
//Total execution time : 208801121.02 Seconds
//
//Average execution time : 0.32 Days
//Average execution time : 7.70 Hours
//Average execution time : 462.03 Mins
//Average execution time : 27721.87 Seconds
//
//Highest Execution Time JobId=49723
//Highest execution time : 14.17 Days
//Highest execution time : 340.18 Hours
//Highest execution time : 20410.70 Mins
//Highest execution time : 1224642.00 Seconds
//
//Lowest Execution Time JobId=52182
//Lowest execution time : 189.00 milliseconds
