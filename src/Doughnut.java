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
        dataset.setValue("Total\n2416.68 (Day)\n58000.31 (Hour)\n3480018.68 (Min)\n208801121.02 (Sec)" , 2416.68);
        dataset.setValue("Average\n462.03 (Min)\n0.32 (Day)\n7.70 (Hour)\n27721.87 (Sec)" , 462.03);
        dataset.setValue("Highest\n340.18 (Hour)\n14.17 (Day)\n20410.70 (Min)\n1224642 (Sec)" , 340.18);
        dataset.setValue("Lowest\n189 (MilliSec)" , 189.00);
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Doughnut chart = new Doughnut("Execution Time By Days");
            chart.setSize(1000, 800);
            chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            chart.setVisible(true);
        });
    }
}
