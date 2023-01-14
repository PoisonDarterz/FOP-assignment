package restructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Partition {
    static LinkedHashMap<String,Integer> partition = new LinkedHashMap<>();
    public static void jobByPartitions(String fileName){
        int num;
        String data;
        String sub=null;
        int numEPYC=0;
        int numOpteron=0;
        int numV100=0;
        int numK40c=0;
        int numK10=0;
        int numTitan=0;

        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while(data!=null){

                num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                if(content[1].equals("sched/backfill:")){
                    String jobID = content[4].substring(6);
                    if(content[6].equals("cpu-epyc")) {
                        numEPYC++;
                        partition.put(jobID, 1);
                    }
                    if(content[6].equals("cpu-opteron")) {
                        numOpteron++;
                        partition.put(jobID, 2);
                    }
                    if(content[6].equals("gpu-v100s")){
                        numV100++;
                        partition.put(jobID, 3);
                    }
                    if(content[6].equals("gpu-k40c")) {
                        numK40c++;
                        partition.put(jobID, 4);
                    }
                    if(content[6].equals("gpu-titan")) {
                        numTitan++;
                        partition.put(jobID, 5);
                    }
                    if(content[6].equals("gpu-k10")) {
                        numK10++;
                        partition.put(jobID, 6);
                    }
                }

                for (String content1 : content) {
                    String jobID = content[content.length-1].substring(6);
                    if (content1.equals("Partition=cpu-epyc")) {
                        numEPYC++;
                        partition.put(jobID, 1);
                    }
                    if (content1.equals("Partition=cpu-opteron")) {
                        numOpteron++;
                        partition.put(jobID, 2);
                    }
                    if (content1.equals("Partition=gpu-v100s")) {
                        numV100++;
                        partition.put(jobID, 3);
                    }
                    if (content1.equals("Partition=gpu-k40c")) {
                        numK40c++;
                        partition.put(jobID, 4);
                    }
                    if (content1.equals("Partition=gpu-titan")) {
                        numTitan++;
                        partition.put(jobID, 5);
                    }
                    if (content1.equals("Partition=gpu-k10")) {
                        numK10++;
                        partition.put(jobID, 6);
                    }
                }
                data = read.readLine();
            }
        }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}

        System.out.printf("\n\n%-15s%-15s%-15s%-15s%-15s%-20s%-15s","","GPU-V100s","GPU-K10","GPU-Titan","GPU-K40c","CPU-Opteron","CPU-EPYC");
        System.out.println("\n--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15d%-15d%-15d%-15d%-20d%-15d\n","TOTAL",numV100,numK10,numTitan,numK40c,numOpteron,numEPYC);

        System.out.println();
        int arr[] = {numV100,numK10,numTitan,numK40c,numOpteron,numEPYC};
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
