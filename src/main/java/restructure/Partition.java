package restructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Partition {
    static LinkedHashMap<String,Integer> partition = new LinkedHashMap<>();
    static int epyc=0,opte=0,v100s=0,k40c=0,titan=0,k10=0;

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
//                        numEPYC++;
                        partition.put(jobID, 1);
                    }
                    if(content[6].equals("cpu-opteron")) {
//                        numOpteron++;
                        partition.put(jobID, 2);
                    }
                    if(content[6].equals("gpu-v100s")){
//                        numV100++;
                        partition.put(jobID, 3);
                    }
                    if(content[6].equals("gpu-k40c")) {
//                        numK40c++;
                        partition.put(jobID, 4);
                    }
                    if(content[6].equals("gpu-titan")) {
//                        numTitan++;
                        partition.put(jobID, 5);
                    }
                    if(content[6].equals("gpu-k10")) {
//                        numK10++;
                        partition.put(jobID, 6);
                    }
                }

                for (String content1 : content) {
                    String jobID = "";
                    if (content1.equals("Partition=cpu-epyc")) {
//                        numEPYC++;
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 1);
                    }
                    if (content1.equals("Partition=cpu-opteron")) {
//                        numOpteron++;
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 2);
                    }
                    if (content1.equals("Partition=gpu-v100s")) {
//                        numV100++;
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 3);
                    }
                    if (content1.equals("Partition=gpu-k40c")) {
//                        numK40c++;
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 4);
                    }
                    if (content1.equals("Partition=gpu-titan")) {
//                        numTitan++;
                        for(String content2 : content){
                            if(content2.contains("JobId=")){
                                jobID=content2.substring(6);
                            }
                        }
                        partition.put(jobID, 5);
                    }
                    if (content1.equals("Partition=gpu-k10")) {
//                        numK10++;
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

//        int numEPYC=0;
//        int numOpteron=0;
//        int numV100=0;
//        int numK40c=0;
//        int numK10=0;
//        int numTitan=0;

        System.out.printf("\n\n%-15s%-15s%-15s%-15s%-15s%-20s%-15s","","GPU-V100s","GPU-K10","GPU-Titan","GPU-K40c","CPU-Opteron","CPU-EPYC");
        System.out.println("\n--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15d%-15d%-15d%-15d%-20d%-15d\n","TOTAL",v100s,k10,titan,k40c,opte,epyc);

        System.out.println();
        int arr[] = {v100s,k10,titan,k40c,opte,epyc};
        String arrname[] = {"GPU-V100s","GPU-K10","GPU-Titan","GPU-K40c","CPU-Opteron","CPU-EPYC"};
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
