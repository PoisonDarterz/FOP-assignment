import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartExample extends ApplicationFrame {

    public BarChartExample(String title) {
        super(title);
        CategoryDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createBarChart("Number of Errors Caused by Users", "Name of Users", "Number of Errors", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(25.0, "Series 1", "lobbeytan");
        dataset.addValue(34.0, "Series 2", "tingweijing");
        dataset.addValue(19.0, "Series 3", "f4ww4z");
        dataset.addValue(29.0, "Series 4", "xinpeng");
        dataset.addValue(29.0, "Series 4", "xinpeng");
        return dataset;
    }

    public static void main(String[] args) {
        BarChartExample chart = new BarChartExample("Number of Errors Caused by Users");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}