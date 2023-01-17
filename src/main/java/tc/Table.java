package tc;
import javax.swing.*;
import javax.swing.table.*;

public class Table {
    public static void main(String[] args) {
        // Create a table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name of Users Causing Errors");
        model.addRow(new Object[] {"            htt_felicia "});
        model.addRow(new Object[] {"            shahreeza"});
        model.addRow(new Object[] {"            ongkuanhung"});
        model.addRow(new Object[] {"            kurk"});
        model.addRow(new Object[] {"            hass"});
        model.addRow(new Object[] {"            fairus"});
        model.addRow(new Object[] {"            aah"});
        model.addRow(new Object[] {"            chiuling"});
        model.addRow(new Object[] {"            noraini"});
        model.addRow(new Object[] {"            farhatabjani"});
        model.addRow(new Object[] {"            xinpeng"});
        model.addRow(new Object[] {"            fahmi8"});
        model.addRow(new Object[] {"            liew.wei.shiung"});
        model.addRow(new Object[] {"            han"});
        model.addRow(new Object[] {"            roland"});
        model.addRow(new Object[] {"            hva170037"});
        model.addRow(new Object[] {"            tingweijing"});
        model.addRow(new Object[] {"            lobbeytan"});
        model.addRow(new Object[] {"            f4ww4z"});
        model.addRow(new Object[] {"            janvik"});
        model.addRow(new Object[] {"            lin0618"});
        model.addRow(new Object[] {"            manoj"});
        model.addRow(new Object[] {"            aznul"});
        model.addRow(new Object[] {"            yatyuen.lim"});
        model.addRow(new Object[] {"            mk_98"});
        model.addRow(new Object[] {"            hongvin"});

        // Create a table
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);


        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a frame to hold the scroll pane
        JFrame frame = new JFrame("Name of Users Causing Errors");
        frame.add(scrollPane);
        frame.setSize(200, 500);
        frame.setVisible(true);
    }
}

