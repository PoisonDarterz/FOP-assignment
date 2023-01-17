package izdecode;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.*;
import java.awt.*;

public class Doughnut extends JFrame {
    public Doughnut(String title) {
        super(title);

        // Create dataset
        PieDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createRingChart("Number of jobs by partitions", dataset, true, true, false);
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setSeparatorStroke(new BasicStroke(2));
        plot.setSeparatorPaint(Color.white);
        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private  PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("GPU-V100s", 618);
        dataset.setValue("GPU-K10", 439);
        dataset.setValue("GPU-Titan ", 673);
        dataset.setValue("GPU-K40c ", 301);
        dataset.setValue("CPU-Opteron", 4920);
        dataset.setValue("CPU-EPYC", 3015);
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Doughnut chart = new Doughnut("Doughnut Chart Example");
            chart.setSize(1000, 800);
            chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            chart.setVisible(true);
        });
    }
}
