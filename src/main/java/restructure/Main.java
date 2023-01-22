package restructure;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.ImageIcon;

public class Main {
    public static void main(String[] args) throws IOException,InterruptedException {
            Scanner input = new Scanner(System.in);
            String fileName = "./file-in/log.txt";
            AvExTime a = new AvExTime(fileName);
            Partition p = new Partition(fileName);

              String[] options = { "1", "2", "3","4","5","EXIT" };

              ImageIcon icon = new ImageIcon("C:/Users/USER/Pictures/java.png");

              do {

              var selection = JOptionPane.showOptionDialog(null,
                      "\n                                 FOP Assignment\n-------------------------------------------------------------------------------\n1. Total number of created and ended jobs\n2. Total number of completed and ended jobs by months\n3. Total number of job by partition\n4. Total number of errors and invalids\n5. Execution time\nSelect one : "
                      , "FOP Assignment",
                      0,
                      3,
                       icon,
                       options,
                       options[0]);

            switch (selection) {
                    case 0 -> MJCE.totalCompletedAndEndedJob(fileName);
                    case 1 -> JobCreateEnd.totalMonthJobCreateEnd(fileName);
                    case 2 -> p.jobByPartitions(fileName);
                    case 3 -> Err_Inv.ErrorAndInvalid(fileName);
                    case 4 -> a.averageExecutionTime(fileName);
                    case 5 -> {
//                        System.out.println("\nThank you for using our program!");
//                        System.exit(0);

                      ImageIcon icons = new ImageIcon("C:/Users/USER/Pictures/end2.png");

                      String [] close = {"close"};
                      JOptionPane.showOptionDialog(null,
                      "Thank you for using our program"
                      , "End",
                      JOptionPane.PLAIN_MESSAGE,
                      3,
                       icons,
                       close,
                        close[0]);
                        System.exit(0);
                    }
                }
            } while (true);

    }

    public static LocalDateTime convertToLDT(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'['yyyy-MM-dd'T'HH:mm:ss.SSS']'");
        return LocalDateTime.parse(date, formatter);
    }

    private static void System(String cls) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
