package restructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class AvExTime {
    static Scanner input = new Scanner(System.in);
    static ArrayList createJobTime = new ArrayList();
    static ArrayList createJobId = new ArrayList();
    static ArrayList endJobTime = new ArrayList();
    static ArrayList endJobId = new ArrayList();
    static ArrayList<Double> exeTime = new ArrayList<>();
    static ArrayList compare = new ArrayList();
    static double totalExecutionTime;


    public AvExTime(String fileName){
        String data = "";
        totalExecutionTime = 0.0;

        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();

            while(data!=null){

                int num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                // Create job
                for(int i=0;i<content.length;i++){
                    if(content[i].equals("Allocate")){
                        createJobTime.add(content[0]);
                        createJobId.add(content[i+1]);
                    }

                    // End job
                    if(content[i].equals("done")){
                        endJobTime.add(content[0]);
                        endJobId.add(content[i-1]);
                    }
                } // For loop

                data = read.readLine();
            } // WHILE(DATE)
        }   // TRY
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}
    }


    public static void averageExecutionTime(String fileName) {
        int command = 0;
        do {
            System.out.println("\n\n1. Display all the completed job ids");
            System.out.println("2. Display all the not completed job ids");
            System.out.println("3. Search for particular job id(s)");
            System.out.println("4. Display Statistical data of execution time again");
            System.out.println("-1. Exit");
            System.out.print("command -> ");
            command = input.nextInt();

            int num = 0;

            ArrayList jobId = new ArrayList();

            System.out.println();
            if (command == 3) {

                System.out.print("Enter the number of completed Job Id for searching : ");
                num = input.nextInt();

                System.out.println("\nEnter the completed Job Id for searching : ");

                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". : ");
                    String inp = input.next();
                    String toAdd = "JobId=" + inp;
                    jobId.add(toAdd);
                }
            }

            String[] createJobTime2 = new String[createJobTime.size()];
            String[] endJobTime2 = new String[endJobTime.size()];

            createJobTime.toArray(createJobTime2);
            endJobTime.toArray(endJobTime2);

            String maxJobId = null;
            String minJobId = null;

            double max = -1;
            double min = 9999;

            int No = 0;
            int nom = 0;

            if (command == 1 || command == 3 || command == 4) {
                System.out.printf("\n%-8s%-20s%-20s%-30s%-30s%-30s\n", "No.", "Completed Job ID", "Ended Job ID", "Job Completed Time", "Job Ended Time", "Execution Time (mins)");
                System.out.print("--------------------------------------------------------------------------------------------------------------------------------------");
            }

            for (int i = 0; i < createJobId.size(); i++) {

                for (int j = 0; j < endJobId.size(); j++) {
                    if (createJobId.get(i).equals(endJobId.get(j))) {
                        LocalDateTime createTime = Main.convertToLDT(createJobTime2[i]);
                        LocalDateTime endTime = Main.convertToLDT(endJobTime2[j]);

                        long milliBetween = ChronoUnit.MILLIS.between(createTime, endTime);

                        if (milliBetween < 0)
                            milliBetween *= -1;

                        double milli = (double) milliBetween;

                        exeTime.add(milli);

                        double output = (double) ((milliBetween / 1000.0) / 60);
                        No++;

                        ///////// DISPLAY ALL THE INFO OF JOBID
                        if (command == 1) {
                            System.out.printf("\n%-8d%-20s%-20s%-30s%-30s", No, createJobId.get(i), endJobId.get(j), createJobTime2[i], endJobTime2[j]);
                            System.out.printf("%.3f", output);
                        } else if (command == 3) {
                            ////////////////SEARCH FOR COMPLETED  JOB

                            String[] jobId2 = new String[num];
                            jobId.toArray(jobId2);


                            for (int k = 0; k < num; k++) {
                                nom++;
                                if (createJobId.get(i).equals(jobId2[k])) {
                                    System.out.printf("\n%-8d%-20s%-20s%-30s%-30s", nom, createJobId.get(i), endJobId.get(j), createJobTime2[i], endJobTime2[j]);
                                    System.out.printf("%.3f", output);
                                    compare.add(createJobId.get(i));
                                }

                            } // END FOR VARIABLE K LOOP
                        }  // END FOR COMMAND 3
                        if ((milliBetween / 1000) > max) {
                            max = milliBetween / 1000;
                            maxJobId = (String) createJobId.get(i);
                        }

                        if ((milliBetween) < min) {
                            min = milliBetween;
                            minJobId = (String) createJobId.get(i);
                        }

                        totalExecutionTime += (double) ((milliBetween / 1000.0));
                    }
                    ////////// PART OF DISPLAY OF INCOMPLETED JOBID
//                        String [] noCreateJobId = new String[createJobId.size()];
//                        createJobId.toArray(noCreateJobId);
                    //numNoCreateJobId.add(i);
                }

            }
            ArrayList NoCreateJobId = new ArrayList<>();


            ///////// DISPLAY ALL THE INFO OF INCOMPLETED JOBID
            if (command == 2 || command == 3) {
                int numNoJob = 0;

                String[] noCreateJobId = new String[createJobId.size()];
                createJobId.toArray(noCreateJobId);
                for (int i = 0; i < createJobId.size(); i++) {
                    for (int j = 0; j < endJobId.size(); j++) {
                        if (createJobId.get(i).equals(endJobId.get(j))) {
                            noCreateJobId[i] = "null";
                        }
                    }
                }

                for (int u = 0; u < noCreateJobId.length; u++) {
                    if (!(noCreateJobId[u].equals("null"))) {
                        NoCreateJobId.add(noCreateJobId[u]);
                    }
                }

                if (command == 2) {
                    System.out.printf("\n%-8s%-30s%-30s", "No.", "Job Assigned Time", "Not Completed Job ID");
                    System.out.println("\n------------------------------------------------------------");
//                      }


//                       for(int e=0;e<createJobId.size();e++){
//                           if(numNoCreateJobId.contains(e) == false){
//                                numNoJob++;
//                                System.out.printf("\n%-8d%-30s%-30s",numNoJob,createJobTime2[e],createJobId.get(e));
//                           }
//                       }


                    for (int e = 0; e < noCreateJobId.length; e++) {
                        if (!noCreateJobId[e].equals("null")) {
                            nom++;
                            System.out.printf("%-8d%-30s%-30s\n", nom, createJobTime2[e], createJobId.get(e));
                        }
                    }
                    System.out.println("\n-----------------------------------------------------------");
                    System.out.println("The total number of incompleted job id : " + numNoJob);

                }   // END OFR SUB COMMAND 2

                ///////// RESULT OF SEARCHING INCOMPLETED JOB
                else if (command == 3) {

                    int x = 0;
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < noCreateJobId.length; j++) {
                            if (noCreateJobId[j].equals(jobId.get(i))) {
                                x++;
                                System.out.printf("\n%-8d%-20s%-30s%-30s", x, createJobId.get(j), createJobTime2[j], "JOB IS NOT COMPLETED");
                            }
                        } // second for loop
                    }// first for loop (i)
                }   // END FOR SUB COMMAND 3


            }     // END COMMAND 2 AND 3
            // Searching Not Found
            //HashSet noEqual = new HashSet();
            String[] jobId3 = new String[num];
            jobId.toArray(jobId3);

            for (int m = 0; m < num; m++) {
                for (int n = 0; n < compare.size(); n++) {
                    if ((jobId.get(m).equals(compare.get(n)))) {
                        jobId3[m] = "null";
                    }
                }
            }

            System.out.println();

            for (String jobIdNull : jobId3) {
                if (!(jobIdNull.equals("null"))) {
                    System.out.println(jobIdNull + " Not Found");
                }
            }

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            if (command == 4) {
                System.out.println("Total number of completed Job : " + No);


                System.out.printf("Total execution time : %.2f Days\n", ((totalExecutionTime / 3600) / 24));
                System.out.printf("Total execution time : %.2f Hours\n", totalExecutionTime / 3600);
                System.out.printf("Total execution time : %.2f Mins\n", totalExecutionTime / 60);
                System.out.printf("Total execution time : %.2f Seconds\n", totalExecutionTime);

                System.out.println();

                System.out.printf("Average execution time : %.2f Days\n", (((totalExecutionTime / 3600) / 24) / No));
                System.out.printf("Average execution time : %.2f Hours\n", (totalExecutionTime / 3600) / No);
                System.out.printf("Average execution time : %.2f Mins\n", (totalExecutionTime / 60) / No);
                System.out.printf("Average execution time : %.2f Seconds\n", (totalExecutionTime) / No);

                System.out.println();

                System.out.println("Highest Execution Time " + maxJobId);
                System.out.printf("Highest execution time : %.2f Days\n", (((max / 3600) / 24)));
                System.out.printf("Highest execution time : %.2f Hours\n", (max / 3600));
                System.out.printf("Highest execution time : %.2f Mins\n", (max / 60));
                System.out.printf("Highest execution time : %.2f Seconds\n", (max));

                System.out.println();

                System.out.println("Lowest Execution Time " + minJobId);
                System.out.printf("Lowest execution time : %.2f milliseconds\n", min);

                System.out.println();

                Collections.sort(exeTime);
                double median = 0;
                double firstQuartile = 0;
                double thirdQuartile = 0;

                firstQuartile = exeTime.size() * 0.25;
                thirdQuartile = exeTime.size() * 0.75;

                double firQuartile = (exeTime.get((int) firstQuartile) + exeTime.get((int) firstQuartile + 1)) / 2 / 1000 / 60;
                System.out.printf("First Quartile of execution time : %.1f mins\n", firQuartile);


                if (exeTime.size() % 2 == 0) {
                    median = (exeTime.get((int) Math.floor(exeTime.size() / 2)) + exeTime.get(((int) Math.floor(exeTime.size() / 2) + 1))) / 2;
                } else if (exeTime.size() % 2 == 1) {
                    median = exeTime.get((int) Math.ceil(exeTime.size() / 2));
                }
                median = (median / 1000) / 60;
                System.out.printf("Median of execution time         : %.1f mins\n", median);

                double thiQuartile = (exeTime.get((int) thirdQuartile) + exeTime.get((int) thirdQuartile + 1)) / 2 / 1000 / 60;
                System.out.printf("Third Quartile of execution time : %.1f mins\n", thiQuartile);

                System.out.println();

                double iqr = thiQuartile - firQuartile;
                double lowerLimit = firQuartile - (1.5 * iqr);
                double upperLimit = thiQuartile + (1.5 * iqr);
                System.out.printf("Interquartile range of execution time : %.1f mins\n", iqr);
                System.out.printf("Lower limit of execution time         : %.1f mins\n", lowerLimit);
                System.out.printf("Upper limit of execution time         : %.1f mins\n", upperLimit);

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            }

            if (!(command >=1 && command <=4 || command == -1)){
                System.out.println("Invalid Command");
            }
        }while (command != -1);
    } // End method
}
