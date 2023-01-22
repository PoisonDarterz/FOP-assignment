package izdecode;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import restructure.Err_Inv;

public class BarError extends ApplicationFrame {

    public BarError(String title) {
        super(title);
        CategoryDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createBarChart("Number of Errors Caused by Users", "Name of Users", "Number of Errors", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 250));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String code : Err_Inv.errorCount.keySet()) {
            dataset.addValue((double)Err_Inv.errorCount.get(code), " ", code);
        }

        return dataset;
    }

    public static void main(String[] args) {
        BarError chart = new BarError("Number of Errors Caused by Users");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}