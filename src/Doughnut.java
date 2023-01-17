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
        JFreeChart chart = ChartFactory.createRingChart("Types of Invalid", dataset, true, true, false);
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setSeparatorStroke(new BasicStroke(2));
        plot.setSeparatorPaint(Color.white);
        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private  PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Invalid Qos Specification ", 157);
        dataset.setValue("Invalid Account", 52);
        dataset.setValue("Invalid Job Id Specified   ", 50);
        dataset.setValue("Invalid Partition Name Specified  ", 47);
        dataset.setValue("Invalid Node Name Specified", 4);
        dataset.setValue("Invalid User Id ", 4);
        dataset.setValue("Invalid Group Id ", 1);
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Doughnut chart = new Doughnut("Types of Invalid");
            chart.setSize(1000, 800);
            chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            chart.setVisible(true);
        });
    }
}
