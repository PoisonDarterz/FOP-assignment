/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
public class Assignment {
     
    public static void totalCompletedAndEndedJob(String fileName){
        String data;
       
        int numCompleteJob=0;
        int initiateJob=0;
       
        try{
           BufferedReader read = new BufferedReader(new FileReader(fileName));
           data = read.readLine();
           while(data!=null){
               
               //READ AND DISPLAY ALL THE CONTENTS OF THE FILE
               //System.out.println(data);
               
               //DIVIDE EACH LINE INTO ARRAY
               int num = data.split(" ").length;
               String [] content = new String[num];
               content = data.split(" ");
               
               //SHOW THE TOTAL NUMBER OF ENDED AND COMPLETED JOBS
               for (String content1 : content) {
                   if (content1.equals("done")) 
                       numCompleteJob++;
                   if(content1.equals("Allocate"))
                       initiateJob++;
               }
                 data = read.readLine();
           }     
    }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}
       
        //DISPLAY RESULT
        System.out.println("Number of job created : " + numCompleteJob);
        System.out.println("Number of job ended   : " + initiateJob);
       
    }
    
    public static void totalMonthJobCreateEnd(String fileName){
        String data; 
        String month = "";
        String day = "";
        double ave = 0.0;
        int m=0;
        int d=0;
        
        int sumCreateJun = 0;
        int sumEndJun = 0;
        int [] numJobCreateJun = new int[30];
        int [] numJobEndJun = new int[30];
        
        int sumCreateJune = 0;
        int sumEndJune = 0;
        int [] numJobCreateJune = new int[31];
        int [] numJobEndJune = new int[31];
        
        int sumCreateAus = 0;
        int sumEndAus = 0;
        int [] numJobCreateAus = new int[31];
        int [] numJobEndAus = new int[31];
        
        int sumCreateSep = 0;
        int sumEndSep = 0;
        int [] numJobCreateSep = new int[30];
        int [] numJobEndSep = new int[30];
        
        int sumCreateOct = 0;
        int sumEndOct = 0;
        int [] numJobCreateOct = new int[31];
        int [] numJobEndOct = new int[31];
        
        int sumCreateNov = 0;
        int sumEndNov = 0;
        int [] numJobCreateNov = new int[30];
        int [] numJobEndNov = new int[30];
        
        int sumCreateDec = 0;
        int sumEndDec = 0;
        int [] numJobCreateDec = new int[16];
        int [] numJobEndDec = new int[16];
       
        try{
           BufferedReader read = new BufferedReader(new FileReader(fileName));
           data = read.readLine();
           while(data!=null){

               int num = data.split(" ").length;
               String [] content = new String[num];
               content = data.split(" ");
               
               //ALLOCATE NUMBER OF JOBS CREATED AND ENDED BY DAYS AND MONTHS
               month = data.substring(6,8);
               day = data.substring(9,11);
               d = Integer.parseInt(day);
               if(month.equals("06")){
               for(String content2 : content){
                       if(content2.equals("done")){
                        numJobCreateJun[d-1]+=1;} 
                       if(content2.equals("Allocate")){
                        numJobEndJun[d-1]+=1;}
               }
               }
               
               if(month.equals("07")){
               for(String content2 : content){
                       if(content2.equals("done")){
                        numJobCreateJune[d-1]+=1;} 
                       if(content2.equals("Allocate")){
                        numJobEndJune[d-1]+=1;}
               }
               }
               
               if(month.equals("08")){
               for(String content2 : content){
                       if(content2.equals("done")){
                        numJobCreateAus[d-1]+=1;} 
                       if(content2.equals("Allocate")){
                        numJobEndAus[d-1]+=1;}
               }
               }
               
               if(month.equals("09")){
               for(String content2 : content){
                       if(content2.equals("done")){
                        numJobCreateSep[d-1]+=1;} 
                       if(content2.equals("Allocate")){
                        numJobEndSep[d-1]+=1;}
               }
               }
               
               if(month.equals("10")){
               for(String content2 : content){
                       if(content2.equals("done")){
                        numJobCreateOct[d-1]+=1;} 
                       if(content2.equals("Allocate")){
                        numJobEndOct[d-1]+=1;}
               }
               }
               
               if(month.equals("11")){
               for(String content2 : content){
                       if(content2.equals("done")){
                        numJobCreateNov[d-1]+=1;} 
                       if(content2.equals("Allocate")){
                        numJobEndNov[d-1]+=1;}
               }
               }
               
               if(month.equals("12")){
               for(String content2 : content){
                       if(content2.equals("done")){
                        numJobCreateDec[d-1]+=1;} 
                       if(content2.equals("Allocate")){
                        numJobEndDec[d-1]+=1;}
               }
               }
                 data = read.readLine();
           }     
    }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}
       
        System.out.println("\nMonth : 6");
        System.out.printf("%-20s","Day           |");
        for(int i=0;i<30;i++){
            System.out.printf("%-5d",(i+1));
        }
        System.out.printf("\n%-20s","Completed job |");
        for(int i=0;i<30;i++){
            sumCreateJun+=numJobCreateJun[i];
            System.out.printf("%-5d",numJobCreateJun[i]);
        }
        System.out.printf("\n%-20s","Ended job     |");
        for(int i=0;i<30;i++){
            sumEndJun+=numJobEndJun[i];
            System.out.printf("%-5d",numJobEndJun[i]);
        }
        System.out.println("\nTotal job created in Jun   : " + sumCreateJun);
        System.out.println("Total job ended in Jun     : " + sumEndJun);
        ave=sumCreateJun/30.0;
        System.out.printf("Average job created in Jun : %.1f\n" , ave);
        ave=sumEndJun/30.0;
        System.out.printf("Average job ended in Jun   : %.1f\n" , ave);
        
        
        System.out.println("\n\nMonth : 7");
        System.out.printf("%-20s","Day           |");
        for(int i=0;i<31;i++){
            System.out.printf("%-5d",(i+1));
        }
        System.out.printf("\n%-20s","Completed job |");
        for(int i=0;i<31;i++){
            sumCreateJune+=numJobCreateJune[i];
            System.out.printf("%-5d",numJobCreateJune[i]);
        }
        System.out.printf("\n%-20s","Ended job     |");
        for(int i=0;i<31;i++){
            sumEndJune+=numJobEndJune[i];
            System.out.printf("%-5d",numJobEndJune[i]);
        }
        System.out.println("\nTotal job created in June   : " + sumCreateJune);
        System.out.println("Total job ended in June     : " + sumEndJune);
        ave=sumCreateJune/31.0;
        System.out.printf("Average job created in June : %.1f\n" , ave);
        ave=sumEndJune/31.0;
        System.out.printf("Average job ended in June   : %.1f\n" , ave);
        
        
        
        System.out.println("\n\nMonth : 8");
        System.out.printf("%-20s","Day           |");
        for(int i=0;i<31;i++){
            System.out.printf("%-5d",(i+1));
        }
        System.out.printf("\n%-20s","Completed job |");
        for(int i=0;i<31;i++){
            sumCreateAus+=numJobCreateAus[i];
            System.out.printf("%-5d",numJobCreateAus[i]);
        }
        System.out.printf("\n%-20s","Ended job     |");
        for(int i=0;i<31;i++){
            sumEndAus+=numJobEndAus[i];
            System.out.printf("%-5d",numJobEndAus[i]);
        }
        System.out.println("\nTotal job created in August   : " + sumCreateAus);
        System.out.println("Total job ended in August     : " + sumEndAus);
        ave=sumCreateAus/31.0;
        System.out.printf("Average job created in August : %.1f\n" , ave);
        ave=sumEndAus/31.0;
        System.out.printf("Average job ended in August   : %.1f\n" , ave);
        
        
        
        System.out.println("\n\nMonth : 9");
        System.out.printf("%-20s","Day           |");
        for(int i=0;i<30;i++){
            System.out.printf("%-5d",(i+1));
        }
        System.out.printf("\n%-20s","Completed job |");
        for(int i=0;i<30;i++){
            sumCreateSep+=numJobCreateSep[i];
            System.out.printf("%-5d",numJobCreateSep[i]);
        }
        System.out.printf("\n%-20s","Ended job     |");
        for(int i=0;i<30;i++){
            sumEndSep+=numJobEndSep[i];
            System.out.printf("%-5d",numJobEndSep[i]);
        }
        System.out.println("\nTotal job created in September   : " + sumCreateSep);
        System.out.println("Total job ended in September     : " + sumEndSep);
        ave=sumCreateSep/30.0;
        System.out.printf("Average job created in September : %.1f\n" , ave);
        ave=sumEndSep/30.0;
        System.out.printf("Average job ended in September   : %.1f\n" , ave);
        
        
        System.out.println("\n\nMonth : 10");
        System.out.printf("%-20s","Day           |");
        for(int i=0;i<31;i++){
            System.out.printf("%-5d",(i+1));
        }
        System.out.printf("\n%-20s","Completed job |");
        for(int i=0;i<31;i++){
            sumCreateOct+=numJobCreateOct[i];
            System.out.printf("%-5d",numJobCreateOct[i]);
        }
        System.out.printf("\n%-20s","Ended job     |");
        for(int i=0;i<31;i++){
            sumEndOct+=numJobEndOct[i];
            System.out.printf("%-5d",numJobEndOct[i]);
        }
        System.out.println("\nTotal job created in October   : " + sumCreateOct);
        System.out.println("Total job ended in October     : " + sumEndOct);
        ave=sumCreateOct/31.0;
        System.out.printf("Average job created in October : %.1f\n" , ave);
        ave=sumEndOct/31.0;
        System.out.printf("Average job ended in October   : %.1f\n" , ave);
        
        
        System.out.println("\n\nMonth : 11");
        System.out.printf("%-20s","Day           |");
        for(int i=0;i<30;i++){
            System.out.printf("%-5d",(i+1));
        }
        System.out.printf("\n%-20s","Completed job |");
        for(int i=0;i<30;i++){
            sumCreateNov+=numJobCreateNov[i];
            System.out.printf("%-5d",numJobCreateNov[i]);
        }
        System.out.printf("\n%-20s","Ended job     |");
        for(int i=0;i<30;i++){
            sumEndNov+=numJobEndNov[i];
            System.out.printf("%-5d",numJobEndNov[i]);
        }
        System.out.println("\nTotal job created in November    : " + sumCreateNov);
        System.out.println("Total job ended in November      : " + sumEndNov);
        ave=sumCreateNov/30.0;
        System.out.printf("Average job created in November  : %.1f\n" , ave);
        ave=sumEndNov/30.0;
        System.out.printf("Average job ended in November    : %.1f\n" , ave);
        
        
        System.out.println("\n\nMonth : 12");
        System.out.printf("%-20s","Day           |");
        for(int i=0;i<16;i++){
            System.out.printf("%-5d",(i+1));
        }
        System.out.printf("\n%-20s","Completed job |");
        for(int i=0;i<16;i++){
            sumCreateDec+=numJobCreateDec[i];
            System.out.printf("%-5d",numJobCreateDec[i]);
        }
        System.out.printf("\n%-20s","Ended job     |");
        for(int i=0;i<16;i++){
            sumEndDec+=numJobEndDec[i];
            System.out.printf("%-5d",numJobEndDec[i]);
        }
        System.out.println("\nTotal job created in December   : " + sumCreateDec);
        System.out.println("Total job ended in December     : " + sumEndDec);
        ave=sumCreateDec/16.0;
        System.out.printf("Average job created in December : %.1f\n" , ave);
        ave=sumEndDec/16.0;
        System.out.printf("Average job ended in December   : %.1f\n" , ave);
        
    }
    
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
        
        if(numEPYC>numOpteron && numEPYC>numV100 && numEPYC>numK40c && numEPYC>numTitan && numEPYC>numK10)
            System.out.println("The highest number of partition : CPU-epyc (" + numEPYC + ")");
        else if(numOpteron>numEPYC && numOpteron>numV100 && numOpteron>numK40c && numOpteron>numTitan && numOpteron>numK10)
            System.out.println("The highest number of partition : CPU-opteron (" + numOpteron + ")");
        else if(numV100>numEPYC && numV100>numOpteron && numV100>numK40c && numV100>numTitan && numV100>numK10)
            System.out.println("The highest number of partition : GPU-v100s (" + numV100 + ")");
        else if(numK40c>numEPYC && numK40c>numV100 && numK40c>numOpteron && numK40c>numTitan && numK40c>numK10)
            System.out.println("The highest number of partition : GPU-k40c (" + numK40c + ")");
         else if(numTitan>numEPYC && numTitan>numV100 && numTitan>numK40c && numTitan>numOpteron && numTitan>numK10)
            System.out.println("The highest number of partition : GPU-titan (" + numTitan + ")");
         else if(numK10>numEPYC && numK10>numV100 && numK10>numK40c && numK10>numTitan && numK10>numOpteron)
            System.out.println("The highest number of partition : GPU-k10 (" + numK10 + ")");
        
        if(numEPYC<numOpteron && numEPYC<numV100 && numEPYC<numK40c && numEPYC<numTitan && numEPYC<numK10)
             System.out.println("The lowest number of partition  : CPU-epyc (" + numEPYC + ")");
        else if(numOpteron<numEPYC && numOpteron<numV100 && numOpteron<numK40c && numOpteron<numTitan && numOpteron<numK10)
             System.out.println("The lowest number of partition  : CPU-opteron (" + numOpteron + ")");
        else if(numV100<numEPYC && numV100<numOpteron && numV100<numK40c && numV100<numTitan && numV100<numK10)
             System.out.println("The lowest number of partition  : GPU-v100s (" + numV100 + ")");
        else if(numK40c<numEPYC && numK40c<numV100 && numK40c<numOpteron && numK40c<numTitan && numK40c<numK10)
             System.out.println("The lowest number of partition  : GPU-k40c (" + numK40c + ")");
         else if(numTitan<numEPYC && numTitan<numV100 && numTitan<numK40c && numTitan<numOpteron && numTitan<numK10)
             System.out.println("The lowest number of partition  : GPU-titan (" + numTitan + ")");
         else if(numK10<numEPYC && numK10<numV100 && numK10<numK40c && numK10<numTitan && numK10<numOpteron)
             System.out.println("The lowest number of partition  : GPU-k10 (" + numK10 + ")");
    }
    
    public static void ErrorAndInvalid(String fileName){
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
        
        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while(data!=null){
               int num = data.split(" ").length;
               String [] content = new String[num];
               content = data.split(" ");
               
               for(int i=0;i<content.length;i++){
                   if(content[i].equals("error:")){
                       numErr++;}
                   if(content[i].equals("Invalid")){
                       //System.out.println(data);
                       if(content[i+2].equals("specification"))
                           numQosSpec++;
                       if(content[i+1].equals("partition"))
                           numPartition++;
                       if(content[i+1].equals("job"))
                           numJob++;
                       if(content[i+1].equals("node"))
                           numNode++;
                       if(content[i+1].equals("user"))
                           numUser++;
                       if(content[i+1].equals("group"))
                           numGroup++;
                       if(content[i+1].equals("account"))
                           numAccount++;
                       numInvalid++;}
               }
               data=read.readLine();
           } 
        }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}
    
        System.out.println("Number of errors  : " + numErr);
        System.out.println("Number of invalid : " + numInvalid);
        
        System.out.printf("\n%-50s%-20s\n","Types of Invalid","Number of Cases");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-50s%-20s\n","Invalid Qos Specification",numQosSpec);
        System.out.printf("%-50s%-20d\n","Invalid Account",numAccount);
        System.out.printf("%-50s%-20d\n","Invalid Job Id Specified",numJob);
        System.out.printf("%-50s%-20d\n","Invalid Partition Name Specified",numPartition);
        System.out.printf("%-50s%-20d\n","Invalid Node Name Specified",numNode);
        System.out.printf("%-50s%-20d\n","Invalid User Id",numUser);
        System.out.printf("%-50s%-20d\n","Invalid Group Id",numGroup);
       
    }
    
    public static void main(String[] args) {
   
       String fileName = "C:/Users/USER/Downloads/Documents/UM Data Science/FUNDAMENTAL OF PROGRAMMING/assignment.txt";
       
       //totalCompletedAndEndedJob(fileName);
       //totalMonthJobCreateEnd(fileName);
      //jobByPartitions(fileName);
       //ErrorAndInvalid(fileName);
    }
}
