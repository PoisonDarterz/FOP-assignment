package restructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Err_Inv {
    static Scanner sc = new Scanner(System.in);
    public static void ErrorAndInvalid(String fileName) {

        int numInvalid = 0;
        int numErr = 0;
        String data = null;

        int numQosSpec = 0;
        int numPartition = 0;
        int numJob = 0;
        int numNode = 0;
        int numUser = 0;
        int numGroup = 0;
        int numAccount = 0;

        //HashSet <String> invalid = new HashSet<String>();
        ArrayList<Error> user = new ArrayList<>();
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while (data != null) {
                int num = data.split(" ").length;
                String[] content = new String[num];
                content = data.split(" ");

                for (int i = 0; i < content.length; i++) {
                    if (content[i].equals("error:")) {
                        //System.out.println(data);
                        if (content[i + 2].equals("association")) {
                            LocalDateTime time = Main.convertToLDT(content[0]);
                            String uname = content[5].substring(6, content[5].length() - 2);
                            Error error = new Error(time, uname, content[content.length - 1]);
                            user.add(error);
                        }
                        numErr++;
                    }
                    if (content[i].equals("Invalid")) {
                        //System.out.println(data);
                        if (content[i + 2].equals("specification"))
                            numQosSpec++;
                        if (content[i + 1].equals("partition"))
                            numPartition++;
                        if (content[i + 1].equals("job"))
                            numJob++;
                        if (content[i + 1].equals("node"))
                            numNode++;
                        if (content[i + 1].equals("user"))
                            numUser++;
                        if (content[i + 1].equals("group"))
                            numGroup++;
                        if (content[i + 1].equals("account"))
                            numAccount++;
                    }
                }
                data = read.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error occurs while editing file");
        }

        numInvalid = numQosSpec + numAccount + numGroup + numUser + numNode + numJob + numPartition;
        System.out.println("\nNumber of errors  : " + numErr);
        System.out.println("Number of invalid : " + numInvalid);

        System.out.println("\n\n---------------------------------------------------------------------");
        System.out.printf("%-50s%-20s\n", "Types of Invalid", "Number of Cases");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-50s%-20s\n", "Invalid Qos Specification", numQosSpec);
        System.out.printf("%-50s%-20d\n", "Invalid Account", numAccount);
        System.out.printf("%-50s%-20d\n", "Invalid Job Id Specified", numJob);
        System.out.printf("%-50s%-20d\n", "Invalid Partition Name Specified", numPartition);
        System.out.printf("%-50s%-20d\n", "Invalid Node Name Specified", numNode);
        System.out.printf("%-50s%-20d\n", "Invalid User Id", numUser);
        System.out.printf("%-50s%-20d\n", "Invalid Group Id", numGroup);

        LinkedHashMap<String, Integer> errorCount = new LinkedHashMap<>();
        for (Error e : user) {
            if (errorCount.containsKey(e.getUser())) {
                errorCount.put(e.getUser(), errorCount.get(e.getUser()) + 1);
            } else {
                errorCount.put(e.getUser(), 1);
            }
        }
        
        String [] options = {"1","2","3","4","Back"};
        
        do {
            //int command = 0;
//            System.out.println("\n\n----------------------------------------------------------------------------------------------------------------");
//            System.out.println("1. Search for error by user name");
//            System.out.println("2. Search by error types");
//            System.out.println("3. Search error by month");
//            System.out.println("4. General error report");
//            System.out.println("-1. Exit");
//            System.out.print("command -> ");
//            command = sc.nextInt();
            
            var command = JOptionPane.showOptionDialog(null,
                      "\n                        Error and Invalid Analysis\n-------------------------------------------------------------------------------\n1. Search for error by user name\n2. Search by error types\n3. Search error by month \n4. Display general errors report\n5. Exit\nSelect one : "       
                      , "Error and Invalid Analysis",                               
                      0, 
                      3, 
                      null, 
                      options, 
                      options[0]);

            if (command == 0) {
                int count = 0;
                System.out.println("\n\nSearch errors by user's name");
                System.out.println("------------------------------");
                System.out.print("Enter username: ");
                sc.next();
                String name = sc.nextLine();
                System.out.println("\n---------------------------------------------------------------------");
                System.out.printf("%-30s %-30s %-30s\n", "Time", "User", "Error");
                System.out.println("---------------------------------------------------------------------");
                for (Error error : user) {
                    if (error.getUser().contains(name)) {
                        System.out.printf("%-30s %-30s %-30s\n", error.getTime(), error.getUser(), error.getError());
                        count++;
                    }
                }
                System.out.println("Total number of errors: " + count);
                if(count == 0) {
                    System.out.println("No error found, or no such user");
                }
            } else if (command == 1){
                int count = 0;
                System.out.println("\n\nSearch errors type");
                System.out.println("-----------------------------------------------------");
                System.out.print("Enter error type (normal / long / extended): ");
                String type = sc.next();
                System.out.println("\n---------------------------------------------------------------------");
                System.out.printf("%20s %20s %20s\n", "Time", "User", "Error");
                System.out.println("---------------------------------------------------------------------");
                for (Error error : user) {
                    if (error.getError().equalsIgnoreCase(type)) {
                        System.out.printf("%20s %20s %20s\n", error.getTime(), error.getUser(), error.getError());
                        count++;
                    }
                }
                System.out.println("Total number of errors: " + count);
                if (count == 0) {
                    System.out.println("Invalid error type");
                }
            } else if (command == 2){
                int count = 0;
                System.out.println("\n\nSearch errors by month");
                System.out.println("---------------------------");
                System.out.print("Enter month (6-12): ");
                int month = sc.nextInt();
                System.out.println("\n---------------------------------------------------------------------");
                System.out.printf("%-30s %-30s %-30s\n", "Time", "User", "Error");
                System.out.println("---------------------------------------------------------------------");

                for (Error error : user) {
                    if (error.getTime().getMonthValue() == month) {
                        System.out.printf("%-30s %-30s %-30s\n", error.getTime(), error.getUser(), error.getError());
                        count++;
                    }
                }
                System.out.println("Total number of errors: " + count);
                if (count == 0) {
                    System.out.println("Invalid input");
                }
            } else if (command == 3) {
                System.out.println("\n\n---------------------------------------------------------------------");
                System.out.printf("%-20s%-5s\n", "Username", "Number of Cases");
                System.out.println("---------------------------------------------------------------------");
                for (String code : errorCount.keySet()) {
                    System.out.printf("%-20s%-20s\n", code, errorCount.get(code));
                }
            } else if (command == 4){
                break;
            } 
        } while (true);
    }
}

class Error {
    private LocalDateTime time;
    private String username, errorType;
    public Error(LocalDateTime time, String username, String errorType){
        this.time = time;
        this.username = username;
        this.errorType = errorType;
    }

    public LocalDateTime getTime() {
        return time;
    }
    public String getUser() {
        return username;
    }
    public String getError() {
        return errorType;
    }
}
