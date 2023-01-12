package restructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Partition {
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
                    if(content[6].equals("cpu-epyc"))
                        numEPYC++;
                    if(content[6].equals("cpu-opteron"))
                        numOpteron++;
                    if(content[6].equals("gpu-v100s"))
                        numV100++;
                    if(content[6].equals("gpu-k40c"))
                        numK40c++;
                    if(content[6].equals("gpu-titan"))
                        numTitan++;
                    if(content[6].equals("gpu-k10"))
                        numK10++;
                }

                for (String content1 : content) {
                    if (content1.equals("Partition=cpu-epyc")) {
                        numEPYC++;
                    }
                    if (content1.equals("Partition=cpu-opteron")) {
                        numOpteron++;
                    }
                    if (content1.equals("Partition=gpu-v100s")) {
                        numV100++;
                    }
                    if (content1.equals("Partition=gpu-k40c")) {
                        numK40c++;
                    }
                    if (content1.equals("Partition=gpu-titan")) {
                        numTitan++;
                    }
                    if (content1.equals("Partition=gpu-k10")) {
                        numK10++;
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


//        if(numEPYC>numOpteron && numEPYC>numV100 && numEPYC>numK40c && numEPYC>numTitan && numEPYC>numK10)
//            System.out.println("The highest number of partition : CPU-epyc (" + numEPYC + ")");
//        else if(numOpteron>numEPYC && numOpteron>numV100 && numOpteron>numK40c && numOpteron>numTitan && numOpteron>numK10)
//            System.out.println("The highest number of partition : CPU-opteron (" + numOpteron + ")");
//        else if(numV100>numEPYC && numV100>numOpteron && numV100>numK40c && numV100>numTitan && numV100>numK10)
//            System.out.println("The highest number of partition : GPU-v100s (" + numV100 + ")");
//        else if(numK40c>numEPYC && numK40c>numV100 && numK40c>numOpteron && numK40c>numTitan && numK40c>numK10)
//            System.out.println("The highest number of partition : GPU-k40c (" + numK40c + ")");
//        else if(numTitan>numEPYC && numTitan>numV100 && numTitan>numK40c && numTitan>numOpteron && numTitan>numK10)
//            System.out.println("The highest number of partition : GPU-titan (" + numTitan + ")");
//        else if(numK10>numEPYC && numK10>numV100 && numK10>numK40c && numK10>numTitan && numK10>numOpteron)
//            System.out.println("The highest number of partition : GPU-k10 (" + numK10 + ")");
//
//        if(numEPYC<numOpteron && numEPYC<numV100 && numEPYC<numK40c && numEPYC<numTitan && numEPYC<numK10)
//            System.out.println("The lowest number of partition  : CPU-epyc (" + numEPYC + ")");
//        else if(numOpteron<numEPYC && numOpteron<numV100 && numOpteron<numK40c && numOpteron<numTitan && numOpteron<numK10)
//            System.out.println("The lowest number of partition  : CPU-opteron (" + numOpteron + ")");
//        else if(numV100<numEPYC && numV100<numOpteron && numV100<numK40c && numV100<numTitan && numV100<numK10)
//            System.out.println("The lowest number of partition  : GPU-v100s (" + numV100 + ")");
//        else if(numK40c<numEPYC && numK40c<numV100 && numK40c<numOpteron && numK40c<numTitan && numK40c<numK10)
//            System.out.println("The lowest number of partition  : GPU-k40c (" + numK40c + ")");
//        else if(numTitan<numEPYC && numTitan<numV100 && numTitan<numK40c && numTitan<numOpteron && numTitan<numK10)
//            System.out.println("The lowest number of partition  : GPU-titan (" + numTitan + ")");
//        else if(numK10<numEPYC && numK10<numV100 && numK10<numK40c && numK10<numTitan && numK10<numOpteron)
//            System.out.println("The lowest number of partition  : GPU-k10 (" + numK10 + ")");
    }
}
