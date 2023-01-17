package restructure;

import izdecode.PieChart3D;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Partition {
    static Scanner sc = new Scanner(System.in);
    static LinkedHashMap<String,Integer> partition = new LinkedHashMap<>();
    public static int epyc=0,opte=0,v100s=0,k40c=0,titan=0,k10=0;

    public Partition(String fileName){
        try{
            int num;
            String data;
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while(data!=null){

                num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                if(content[1].equals("sched/backfill:")){
                    String jobID = content[4].substring(6);
                    if(content[6].equals("cpu-epyc")) {
                        partition.put(jobID, 1);
                    }
                    if(content[6].equals("cpu-opteron")) {
                        partition.put(jobID, 2);
                    }
                    if(content[6].equals("gpu-v100s")){

                        partition.put(jobID, 3);
                    }
                    if(content[6].equals("gpu-k40c")) {
                        partition.put(jobID, 4);
                    }
                    if(content[6].equals("gpu-titan")) {
                        partition.put(jobID, 5);
                    }
                    if(content[6].equals("gpu-k10")) {
                        partition.put(jobID, 6);
                    }
                }

                for (String content1 : content) {
                    String jobID = "";
                    if (content1.equals("Partition=cpu-epyc")) {
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 1);
                    }
                    if (content1.equals("Partition=cpu-opteron")) {
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 2);
                    }
                    if (content1.equals("Partition=gpu-v100s")) {
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 3);
                    }
                    if (content1.equals("Partition=gpu-k40c")) {
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 4);
                    }
                    if (content1.equals("Partition=gpu-titan")) {
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 5);
                    }
                    if (content1.equals("Partition=gpu-k10")) {
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 6);
                    }
                }
                data = read.readLine();
            }
        }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}


        for(String code : partition.keySet()){
            if (partition.get(code)==1){
                epyc++;
            }
            else if(partition.get(code)==2){
                opte++;
            }
            else if(partition.get(code)==3){
                v100s++;
            }
            else if(partition.get(code)==4){
                k40c++;
            }
            else if(partition.get(code)==5){
                titan++;
            }
            else if(partition.get(code)==6){
                k10++;
            }
        }
    }

    public static void jobByPartitions(String fileName){
        printStatPart();
        //search function
        do {
            int command = 0;
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.println("\n1. Display job ID by partition");
            System.out.println("2. Search the partition used by job ID");
            System.out.println("3. Print statistics data");
            System.out.println("-1. Exit");
            System.out.print("command -> ");
            command = sc.nextInt();

            if (command == 1) {
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.println("Partition 1: CPU-EPYC");
                System.out.println("Partition 2: CPU-Opteron");
                System.out.println("Partition 3: GPU-V100s");
                System.out.println("Partition 4: GPU-K40c");
                System.out.println("Partition 5: GPU-Titan");
                System.out.println("Partition 6: GPU-K10");
                System.out.print("Enter partition number: ");
                int partSearch = sc.nextInt();
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.println("Job ID");
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                
                int n=0;
                for (String code : partition.keySet()) {
                    if (partition.get(code) == partSearch) {
                        System.out.println((n+1) + ", " + code);
                        n++;
                    }
                }
                
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
                System.out.println("Total : " + n);
               } 
            
                else if (command == 2) {
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.print("Enter job ID : ");
                String jobID = sc.next();
                if (partition.containsKey(jobID)) {
                    int part = partition.get(jobID);
                    switch(part) {
                    case 1 -> System.out.println("Partition : CPU-EPYC");
                    case 2 -> System.out.println("Partition : CPU-Opteron");
                    case 3 -> System.out.println("Partition : GPU-V100s");
                    case 4 -> System.out.println("Partition : GPU-K40c");
                    case 5 -> System.out.println("Partition : GPU-Titan");
                    case 6 -> System.out.println("Partition : GPU-K10");
                    }
                } else {
                    System.out.println("Job ID not found");
                }
            } else if (command == 3){
                printStatPart();
            } else if (command == -1) {
                System.out.println("Exit");
                break;
            } else if (command == 314) {
                PieChart3D.main(new String[]{""});
            } else {
                System.out.println("Invalid command");
            }
        }while(true);
    }

    public static void printStatPart(){

        System.out.printf("\n\n%-15s%-15s%-15s%-15s%-15s%-20s%-15s","","GPU-V100s","GPU-K10","GPU-Titan","GPU-K40c","CPU-Opteron","CPU-EPYC");
        System.out.println("\n--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15d%-15d%-15d%-15d%-20d%-15d\n","TOTAL",v100s,k10,titan,k40c,opte,epyc);

        System.out.println();
        int[] arr = {v100s,k10,titan,k40c,opte,epyc};
        String[] arrname = {"GPU-V100s","GPU-K10","GPU-Titan","GPU-K40c","CPU-Opteron","CPU-EPYC"};
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    String temp2 = arrname[j];
                    arrname[j] = arrname[j+1];
                    arrname[j+1] = temp2;
                }
            }
        }
        System.out.println("The highest number of partition : " + arrname[0] + " = " + arr[0]);
        System.out.println("The lowest number of partition : " + arrname[5] + " = " + arr[5]);
    }
}
