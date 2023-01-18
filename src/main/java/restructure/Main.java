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
            int command = 0;
            
            //JOptionPane.showMessageDialog(null,"This is some useless info","title",JOptionPane.PLAIN_MESSAGE);
            
//            do {
//                System.out.println("\n                   FOP Assignment                       ");
//                System.out.println("--------------------------------------------------------");
//                System.out.println("1. Total number of completed and ended jobs");
//                System.out.println("2. Total number of completed and ended jobs by months");
//                System.out.println("3. Total number of job by partition");
//                System.out.println("4. Total number of errors and invalids");
//                System.out.println("5. Execution time");
//                System.out.println("-1. QUIT");
//                System.out.print("Command -> ");
//                command = input.nextInt();
//                System.out.println();
//
////                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//                switch (command) {
//                    case 1 -> MJCE.totalCompletedAndEndedJob(fileName);
//                    case 2 -> JobCreateEnd.totalMonthJobCreateEnd(fileName);
//                    case 3 -> p.jobByPartitions(fileName);
//                    case 4 -> Err_Inv.ErrorAndInvalid(fileName);
//                    case 5 -> a.averageExecutionTime(fileName);
//                    case -1 -> {
//                        System.out.println("Thank you for using our program!");
//                        System.exit(0);
//                    }
//                    default -> System.out.println("Invalid command");
//                }
//            } while (true);
   
              String[] options = { "1", "2", "3","4","5","EXIT" };
              
              ImageIcon icon = new ImageIcon("C:/Users/USER/Pictures/java.png");    
              
              do {
             
              var selection = JOptionPane.showOptionDialog(null,
                      "\n                                 FOP Assignment\n-------------------------------------------------------------------------------\n1. Total number of completed and ended jobs\n2. Total number of completed and ended jobs by months\n3. Total number of job by partition\n4. Total number of errors and invalids\n5. Execution time\nSelect one : "       
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
                        System.out.println("\nThank you for using our program!");
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
