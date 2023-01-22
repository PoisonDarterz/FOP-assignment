package izdecode;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import restructure.Partition;

import javax.swing.*;

public class PieChart3D extends JFrame {

    public PieChart3D(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("GPU-V100s", Partition.v100s);
        dataset.setValue("GPU-K10", Partition.k10);
        dataset.setValue("GPU-Titan ", Partition.titan);
        dataset.setValue("GPU-K40c ", Partition.k40c);
        dataset.setValue("CPU-Opteron", Partition.opte);
        dataset.setValue("CPU-EPYC", Partition.epyc);
        // based on the dataset we create the chart
        JFreeChart chart = ChartFactory.createPieChart3D(chartTitle, dataset, true, true, false);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
    }

    public static void main(String[] args) {
        PieChart3D chart = new PieChart3D("Doughnut Chart", "Number of jobs by partitions");
        chart.pack();
        chart.setVisible(true);
    }
}