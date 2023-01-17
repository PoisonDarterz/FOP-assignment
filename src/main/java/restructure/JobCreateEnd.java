package restructure;

import java.time.LocalDateTime;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class JobCreateEnd {
    static Scanner sc = new Scanner(System.in);
    public static void totalMonthJobCreateEnd(String fileName) {
        String data;
        String month = "";
        String day = "";
        double ave = 0.0;
        int m=0;
        int d=0;
        ArrayList<Create> jobCreate = new ArrayList<>();
        ArrayList<End> jobEnd = new ArrayList<>();
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while (data != null) {

                int num = data.split(" ").length;
                String[] content = new String[num];
                content = data.split(" ");
                LocalDateTime dateTime = Main.convertToLDT(content[0]);

                for (String content2 : content) {
                    if (content2.equals("done")) {
                        End end = new End(dateTime, content[2].substring(6));
                        jobEnd.add(end);
                    }
                    if (content2.equals("Allocate")) {
                        Create create = new Create(dateTime, content[3].substring(6));
                        jobCreate.add(create);
                    }
                }
                data = read.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error occurs while editing file");
        }

        do {
            int command = 0;
            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("1 . Search month data");
            System.out.println("2 . Search data  within given time range");
            System.out.println("-1. Exit");
            System.out.print("command -> ");
            command = sc.nextInt();

            //output amount of jobs created and completed every day in a month
            int rangeCreate = 0;
            int rangeEnd = 0;
            if (command == 1) {      
                System.out.print("\nEnter month (6-12): ");
                m = sc.nextInt();
                if (m < 6 || m > 12) {
                    System.out.println("Invalid month");
                    continue;
                }
                int dayInMonth = 0;
                switch (m) {
                    case 6 -> dayInMonth = 30;
                    case 7 -> dayInMonth = 31;
                    case 8 -> dayInMonth = 31;
                    case 9 -> dayInMonth = 30;
                    case 10 -> dayInMonth = 31;
                    case 11 -> dayInMonth = 30;
                    case 12 -> dayInMonth = 16;
                }
                int dayCreate = 0;
                int monthCreate = 0;
                int dayEnd = 0;
                int monthEnd = 0;
                int dayCMax = 0, dayCMin = 0, dayEMax = 0, dayEMin = 0;
                int dayCMaxAmt = -1, dayCMinAmt = Integer.MAX_VALUE, dayEMaxAmt = -1, dayEMinAmt = Integer.MAX_VALUE;
                int[] dayCreateArr = new int[dayInMonth];
                int[] dayEndArr = new int[dayInMonth];
                
                System.out.println();
                
                System.out.println("Month: " + m);
                //System.out.printf("%-10s%-10s%-10s%n", "Day", "Create", "End");
                
                for(int j=1;j<=3;j++){
                for (int i = 1; i <= dayInMonth; i++) {
                    for (Create c : jobCreate) {
                        if (c.getTime().getDayOfMonth() == i && c.getTime().getMonthValue() == m) {
                            dayCreate++;
                            monthCreate++;
                        }
                    }
                    for (End e : jobEnd) {
                        if (e.getTime().getDayOfMonth() == i && e.getTime().getMonthValue() == m) {
                            dayEnd++;
                            monthEnd++;
                        }
                    }

                    //System.out.printf("%-10d%-10d%-10d%n", i, dayCreate, dayEnd);

                    if(j == 1){
                        if(i == 1){
                            System.out.printf("%-30s","Day                     |");}
                        System.out.printf("%-5d" , i);
                    }
                          
                    if(j == 2){
                        if(i == 1){
                            System.out.printf("\n%-30s","Total completed job     |");}
                        System.out.printf("%-5d" , dayCreate);
                    }
                    
                    if(j == 3){
                        if(i == 1){
                            System.out.printf("\n%-30s","Total ended     job     |");}
                        System.out.printf("%-5d" , dayEnd);
                    }
                    
                  
                    
                    dayCreateArr[i - 1] = dayCreate;
                    dayEndArr[i - 1] = dayEnd;
                    if (dayCreate > dayCMaxAmt) {
                        dayCMaxAmt = dayCreate;
                        dayCMax = i;
                    }
                    if (dayEnd > dayEMaxAmt) {
                        dayEMaxAmt = dayEnd;
                        dayEMax = i;
                    }
                    if (dayCreate < dayCMinAmt) {
                        dayCMinAmt = dayCreate;
                        dayCMin = i;
                    }
                    if (dayEnd < dayEMinAmt) {
                        dayEMinAmt = dayEnd;
                        dayEMin = i;
                    }
                    dayCreate = 0;
                    dayEnd = 0;
                }
                
                }   // END TO PRINT DATA
                
                System.out.println();
                
                double aveCreate = (double) monthCreate / dayInMonth;
                double aveEnd = (double) monthEnd / dayInMonth;
                //get median day of job created in month
                Arrays.sort(dayCreateArr);
                int medianCreate = 0;
                if (dayInMonth % 2 == 0) {
                    medianCreate = (dayCreateArr[dayInMonth / 2] + dayCreateArr[dayInMonth / 2 - 1]) / 2;
                } else {
                    medianCreate = dayCreateArr[dayInMonth / 2];
                }
                //get median day of job ended in month
                Arrays.sort(dayEndArr);
                int medianEnd = 0;
                if (dayInMonth % 2 == 0) {
                    medianEnd = (dayEndArr[dayInMonth / 2] + dayEndArr[dayInMonth / 2 - 1]) / 2;
                } else {
                    medianEnd = dayEndArr[dayInMonth / 2];
                }
                //first quartile number of jobs created
                int firstQuartileCreate = 0;
                if (dayInMonth % 4 == 0) {
                    firstQuartileCreate = (dayCreateArr[dayInMonth / 4] + dayCreateArr[dayInMonth / 4 - 1]) / 2;
                } else {
                    firstQuartileCreate = dayCreateArr[dayInMonth / 4];
                }
                //first quartile number of jobs ended
                int firstQuartileEnd = 0;
                if (dayInMonth % 4 == 0) {
                    firstQuartileEnd = (dayEndArr[dayInMonth / 4] + dayEndArr[dayInMonth / 4 - 1]) / 2;
                } else {
                    firstQuartileEnd = dayEndArr[dayInMonth / 4];
                }
                //third quartile number of jobs created
                int thirdQuartileCreate = 0;
                if (dayInMonth % 4 == 0) {
                    thirdQuartileCreate = (dayCreateArr[dayInMonth * 3 / 4] + dayCreateArr[dayInMonth * 3 / 4 - 1]) / 2;
                } else {
                    thirdQuartileCreate = dayCreateArr[dayInMonth * 3 / 4];
                }
                //third quartile number of jobs ended
                int thirdQuartileEnd = 0;
                if (dayInMonth % 4 == 0) {
                    thirdQuartileEnd = (dayEndArr[dayInMonth * 3 / 4] + dayEndArr[dayInMonth * 3 / 4 - 1]) / 2;
                } else {
                    thirdQuartileEnd = dayEndArr[dayInMonth * 3 / 4];
                }

                System.out.println("\nTotal jobs created in month " + m + " : " + monthCreate);
                System.out.println("Total jobs ended   in month " + m + " : " + monthEnd);
                System.out.printf("Average jobs created per day : %.2f\n", aveCreate);
                System.out.printf("Average jobs ended per day   : %.2f\n", aveEnd);
                
                System.out.println();
                
                System.out.println("Day with most jobs created  : Day " + dayCMax + " with " + dayCMaxAmt + " jobs created");
                System.out.println("Day with most jobs ended    : Day " + dayEMax + " with " + dayEMaxAmt + " jobs ended");
                System.out.println("Day with least jobs created : Day " + dayCMin + " with " + dayCMinAmt + " jobs created");
                System.out.println("Day with least jobs ended   : Day " + dayEMin + " with " + dayEMinAmt + " jobs ended");
                
                System.out.println();
                
                System.out.println("First quartile number of jobs created : " + firstQuartileCreate);
                System.out.println("Median day of jobs created            : " + medianCreate);
                System.out.println("Third quartile number of jobs created : " + thirdQuartileCreate);
                
                System.out.println();
                
                System.out.println("First quartile number of jobs ended   : " + firstQuartileEnd);
                System.out.println("Median day of jobs ended              : " + medianEnd);
                System.out.println("Third quartile number of jobs ended   : " + thirdQuartileEnd);

            }
            //output amount of jobs created and completed every day within given time range
            else if (command == 2) {
                System.out.println("\n       User's input        ");
                System.out.println("---------------------------");
                System.out.print("Enter start month (6-12): ");
                int startMonth = sc.nextInt();
                System.out.print("Enter start day         : ");
                int startDay = sc.nextInt();
                
                System.out.println();
                
                System.out.print("Enter end month (6-12)  : ");
                int endMonth = sc.nextInt();
                System.out.print("Enter end day           : ");
                int endDay = sc.nextInt();

                if (startMonth < 6 || startMonth > 12 || endMonth < 6 || endMonth > 12) {
                    System.out.println("Error found       : Invalid month");
                    continue;
                }
                if (endMonth < startMonth || (endMonth == startMonth && endDay <= startDay)) {
                    System.out.println("Error found       : Invalid date range");
                    continue;
                }

                int dayInMonth = 0;
                switch (startMonth) {
                    case 6 -> dayInMonth = 30;
                    case 7 -> dayInMonth = 31;
                    case 8 -> dayInMonth = 31;
                    case 9 -> dayInMonth = 30;
                    case 10 -> dayInMonth = 31;
                    case 11 -> dayInMonth = 30;
                    case 12 -> dayInMonth = 16;
                }
                if (startDay < 1 || startDay > dayInMonth || endDay < 1 || endDay > dayInMonth) {
                    System.out.println("Error found       : Invalid day");
                    continue;
                }
                int dayCreate = 0;
                rangeCreate = 0;
                int dayEnd = 0;
                rangeEnd = 0;
                int dayCMax = 0, dayCMin = 0, dayEMax = 0, dayEMin = 0, monCMax = 0, monCMin = 0, monEMax = 0, monEMin = 0;
                int dayCMaxAmt = -1, dayCMinAmt = Integer.MAX_VALUE, dayEMaxAmt = -1, dayEMinAmt = Integer.MAX_VALUE;
                ArrayList<Integer> dayCreateArr = new ArrayList<>();
                ArrayList<Integer> dayEndArr = new ArrayList<>();
                int totalDays = 0;

                //// START THE ORIGINAL LOOP 
                for (int i = startMonth; i <= endMonth; i++) {
                    if (i == endMonth) {
                        dayInMonth = endDay;
                    }
                    System.out.println("\n\nMonth: " + i);
                    ///ORIGINAL PRINTING STATEMENT 
                    ///System.out.printf("%-10s%-10s%-10s%n", "Day", "Create", "End");
                    
                    for(int k=1;k<=3;k++){
                        for (int j = startDay; j <= dayInMonth; j++) {
                        for (Create c : jobCreate) {
                            if (c.getTime().getDayOfMonth() == j && c.getTime().getMonthValue() == i) {
                                dayCreate++;
                                rangeCreate++;
                            }
                        }
                        for (End e : jobEnd) {
                            if (e.getTime().getDayOfMonth() == j && e.getTime().getMonthValue() == i) {
                                dayEnd++;
                                rangeEnd++;
                            }
                        }

                        ///ORIGINAL PRINTING STATEMENT
                        ///System.out.printf("%-10d%-10d%-10d%n", j, dayCreate, dayEnd);

                        if (k == 1) {
                            if (j == startDay) {
                                System.out.printf("%-30s", "Day                     |");
                            }
                            System.out.printf("%-5d", j);
                        } else if (k == (startDay + 1)) {
                            if (j == 1) {
                                System.out.printf("\n%-30s", "Total completed job     |");
                            }
                            System.out.printf("%-5d", dayCreate);
                        } else if (k == (startDay + 2)) {
                            if (j == 1) {
                                System.out.printf("\n%-30s", "Total ended     job     |");
                            }
                            System.out.printf("%-5d", dayEnd);
                        }


                        ///////////////////////////////////////

                        totalDays++;
                        dayCreateArr.add(totalDays - 1, dayCreate);
                        dayEndArr.add(totalDays - 1, dayEnd);
                        if (dayCreate > dayCMaxAmt) {
                            dayCMaxAmt = dayCreate;
                            dayCMax = j;
                            monCMax = i;
                        }
                        if (dayEnd > dayEMaxAmt) {
                            dayEMaxAmt = dayEnd;
                            dayEMax = j;
                            monEMax = i;
                        }
                        if (dayCreate < dayCMinAmt) {
                            dayCMinAmt = dayCreate;
                            dayCMin = j;
                            monCMin = i;
                        }
                        if (dayEnd < dayEMinAmt) {
                            dayEMinAmt = dayEnd;
                            dayEMin = j;
                            monEMin = i;
                        }
                        dayCreate = 0;
                        dayEnd = 0;
                    }
                    startDay = 1;
                
                
                    }   //// End the original for loop
            
            }/////////// END PRINT TABLES
                
                
                    System.out.println("\nTotal days: " + totalDays);
                    double aveCreate = (double) rangeCreate / totalDays;
                    double aveEnd = (double) rangeEnd / totalDays;
                    //get median day of job created in month
                    Collections.sort(dayCreateArr);
                    int medianCreate = 0;
                    if (totalDays % 2 == 0) {
                        medianCreate = (dayCreateArr.get(totalDays / 2) + dayCreateArr.get(totalDays / 2 - 1)) / 2;
                    } else {
                        medianCreate = dayCreateArr.get(totalDays / 2);
                    }
                    //get median day of job ended in month
                    Collections.sort(dayEndArr);
                    int medianEnd = 0;
                    if (totalDays % 2 == 0) {
                        medianEnd = (dayEndArr.get(totalDays / 2) + dayEndArr.get(totalDays / 2 - 1)) / 2;
                    } else {
                        medianEnd = dayEndArr.get(totalDays / 2);
                    }
                    //first quartile number of jobs created
                    int firstQuartileCreate = 0;
                    if (totalDays % 4 == 0) {
                        firstQuartileCreate = (dayCreateArr.get(totalDays / 4) + dayCreateArr.get(totalDays / 4 - 1)) / 2;
                    } else {
                        firstQuartileCreate = dayCreateArr.get(totalDays / 4);
                    }
                    //first quartile number of jobs ended
                    int firstQuartileEnd = 0;
                    if (totalDays % 4 == 0) {
                        firstQuartileEnd = (dayEndArr.get(totalDays / 4) + dayEndArr.get(totalDays / 4 - 1)) / 2;
                    } else {
                        firstQuartileEnd = dayEndArr.get(totalDays / 4);
                    }
                    //third quartile number of jobs created
                    int thirdQuartileCreate = 0;
                    if (totalDays % 4 == 0) {
                        thirdQuartileCreate = (dayCreateArr.get(totalDays * 3 / 4) + dayCreateArr.get(totalDays * 3 / 4 - 1)) / 2;
                    } else {
                        thirdQuartileCreate = dayCreateArr.get(totalDays * 3 / 4);
                    }
                    //third quartile number of jobs ended
                    int thirdQuartileEnd = 0;
                    if (totalDays % 4 == 0) {
                        thirdQuartileEnd = (dayEndArr.get(totalDays * 3 / 4) + dayEndArr.get(totalDays * 3 / 4 - 1)) / 2;
                    } else {
                        thirdQuartileEnd = dayEndArr.get(totalDays * 3 / 4);
                    }

                    System.out.println("\nTotal jobs created in range: " + rangeCreate);
                    System.out.println("Total jobs ended in range: " + rangeEnd);
                    System.out.printf("Average jobs created per day: %.2f\n", aveCreate);
                    System.out.printf("Average jobs ended per day: %.2f\n", aveEnd);
                    System.out.println();
                    System.out.println("Day with most jobs created: Month " + monCMax + " Day " + dayCMax + " with " + dayCMaxAmt + " jobs created");
                    System.out.println("Day with most jobs ended: Month " + monEMax + " Day " + dayEMax + " with " + dayEMaxAmt + " jobs ended");
                    System.out.println("Day with least jobs created: Month " + monCMin + " Day " + dayCMin + " with " + dayCMinAmt + " jobs created");
                    System.out.println("Day with least jobs ended: Month " + monEMin + " Day " + dayEMin + " with " + dayEMinAmt + " jobs ended");
                    System.out.println();
                    System.out.println("First quartile number of jobs created: " + firstQuartileCreate);
                    System.out.println("Median day of jobs created: " + medianCreate);
                    System.out.println("Third quartile number of jobs created: " + thirdQuartileCreate);
                    System.out.println();
                    System.out.println("First quartile number of jobs ended: " + firstQuartileEnd);
                    System.out.println("Median day of jobs ended: " + medianEnd);
                    System.out.println("Third quartile number of jobs ended: " + thirdQuartileEnd);
            }
            else if (command == -1) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        } while (true);
    }

}

class Create {
    private LocalDateTime time;
    private String jobID;

    public Create(LocalDateTime time, String jobID){
        this.time = time;
        this.jobID = jobID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getJobID() {
        return jobID;
    }
}

class End {
    private LocalDateTime time;
    private String jobID;

    public End(LocalDateTime time, String jobID){
        this.time = time;
        this.jobID = jobID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getJobID() {
        return jobID;
    }
}