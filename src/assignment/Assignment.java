/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;


import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Scanner;
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
                    if (content1.equals("Allocate"))
                        numCompleteJob++;
                    if(content1.equals("done"))
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

    public static void totalMonthJobCreateEnd(String fileName) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        
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
        
         int searchMonthStart =0,searchMonthEnd =0;
         int searchDayStart   =0,searchDayEnd =0;
         int searchHourStart  =0,searchHourEnd =0;
         int searchMinStart   =0,searchMinEnd =0;
         int searchSecStart=0,searchSecEnd =0;
         int searchMilliSecStart=0,searchMilliSecEnd=0;
        
         int MonthStart =0,MonthEnd =0;
         int DayStart   =0,DayEnd =0;
         int HourStart  =0,HourEnd =0;
         int MinStart   =0,MinEnd =0;
         int SecStart=0,SecEnd =0;
         int MilliSecStart=0,MilliSecEnd=0;
                
         boolean foundStart = false;
         boolean foundEnd = false;
         boolean count = true; 
          
         int numSearchStart = 0;
         int numSearchEnd = 0;
         
        int command = 0;
        System.out.println("1 . Search month data ");
        System.out.println("2 . Search data  within given time range");
        System.out.println("-1. Exit");
        System.out.print("command -> ");
        command = input.nextInt();
        
        ArrayList date = new ArrayList();
        
        if(command == 2){
           
 
            System.out.println("\nStart Time");
            System.out.println("-----------------------");
            System.out.print("Start month        : ");
            searchMonthStart = input.nextInt();
            System.out.print("Start day          : ");
            searchDayStart = input.nextInt();
//            System.out.print("Start hour         : ");
//            searchHourStart = input.nextInt();
//            System.out.print("Start minute       : ");
//            searchMinStart = input.nextInt();
//            System.out.print("Start second       : ");
//            searchSecStart = input.nextInt();
//            System.out.print("Start millisecond   : ");
//            searchMilliSecStart = input.nextInt();
//            
            System.out.println("");
            
            System.out.println("End Time");
            System.out.println("-----------------------");
            System.out.print("End month          : ");
            searchMonthEnd = input.nextInt();
            System.out.print("End day            : ");
            searchDayEnd = input.nextInt();
//            System.out.print("End hour         : ");
//            searchHourEnd = input.nextInt();
//            System.out.print("End minute       : ");
//            searchMinEnd = input.nextInt();
//            System.out.print("End second       : ");
//            searchSecEnd = input.nextInt();
//            System.out.print("End millisecond  : ");
//            searchMilliSecEnd = input.nextInt();
            
            System.out.println();
            
            System.out.println("User's input");
            System.out.println("-------------------------------------------");
            System.out.println("Start Time - [ 2022-" + searchMonthStart + "-" + searchDayStart + " ]");
            System.out.println("End   Time - [ 2022-" + searchMonthEnd + "-" + searchDayEnd  + " ]");

        }
   
        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while(data!=null){

                int num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");
                
                date.add(content[0]);
                
                //ALLOCATE NUMBER OF JOBS CREATED AND ENDED BY DAYS AND MONTHS
                month = data.substring(6,8);
                day = data.substring(9,11);
                d = Integer.parseInt(day);
                if(month.equals("06")){
                    for(String content2 : content){
                        if(content2.equals("Allocate")){
                            numJobCreateJun[d-1]+=1;}
                        if(content2.equals("done")){
                            numJobEndJun[d-1]+=1;}
                    }
                }

                if(month.equals("07")){
                    for(String content2 : content){
                        if(content2.equals("Allocate")){
                            numJobCreateJune[d-1]+=1;}
                        if(content2.equals("done")){
                            numJobEndJune[d-1]+=1;}
                    }
                }

                if(month.equals("08")){
                    for(String content2 : content){
                        if(content2.equals("Allocate")){
                            numJobCreateAus[d-1]+=1;}
                        if(content2.equals("done")){
                            numJobEndAus[d-1]+=1;}
                    }
                }

                if(month.equals("09")){
                    for(String content2 : content){
                        if(content2.equals("Allocate")){
                            numJobCreateSep[d-1]+=1;}
                        if(content2.equals("done")){
                            numJobEndSep[d-1]+=1;}
                    }
                }

                if(month.equals("10")){
                    for(String content2 : content){
                        if(content2.equals("Allocate")){
                            numJobCreateOct[d-1]+=1;}
                        if(content2.equals("done")){
                            numJobEndOct[d-1]+=1;}
                    }
                }

                if(month.equals("11")){
                    for(String content2 : content){
                        if(content2.equals("Allocate")){
                            numJobCreateNov[d-1]+=1;}
                        if(content2.equals("done")){
                            numJobEndNov[d-1]+=1;}
                    }
                }

                if(month.equals("12")){
                    for(String content2 : content){
                        if(content2.equals("Allocate")){
                            numJobCreateDec[d-1]+=1;}
                        if(content2.equals("done")){
                            numJobEndDec[d-1]+=1;}
                    }
                }
/////////////////// COMMAND 2
            if(command == 2){
                    
            /////////////CHECK WHETHER THE INPUT START DATE EXIST OR NOT   
            MonthStart = Integer.parseInt(content[0].substring(6,8));
            DayStart = Integer.parseInt(content[0].substring(9,11));

            MonthEnd = Integer.parseInt(content[0].substring(6,8));
            DayEnd = Integer.parseInt(content[0].substring(9,11));
            
            if(count){
            if(searchMonthStart == MonthStart && searchDayStart == DayStart){
                foundStart = true;
            }
            if(foundStart){
            for(String content2 : content){
                        if(content2.equals("Allocate")){
                           numSearchStart++;}
                        if(content2.equals("done")){
                           numSearchEnd++;}
            }
            if(searchMonthEnd == MonthEnd && searchDayEnd == DayEnd){
                foundEnd = true;
                count = false;  
              }
            }   ////// END THE SEARCH MONTH START IF
            }   ////// END WHETHER NEED TO END COUNT IF  
             
        }             ////////////////////////////// END COMMAND 2    
            
          
            data = read.readLine();
            }
        }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}
     
////////COMMAND 2 OUTSIDE THE READ FILE CLASS
 
    if(command == 2){
           System.out.println("\nSystem search");
            System.out.println("-------------------------------------------");
            if(foundStart){
                 System.out.println("Start Time [ 2022-" + searchMonthStart + "-" + searchDayStart + " ]    : FOUND");
            }
            else if(!foundStart){
                 System.out.println("Start Time [2022-" + searchMonthStart + "-" + searchDayStart + " ]   : NOT FOUND");
            }
            
            if(foundEnd){
                 System.out.println("End   Time [ 2022-" + searchMonthEnd + "-" + searchDayEnd + " ]    : FOUND");
            }
            else if(!foundEnd){
                 System.out.println("End   Time [ 2022-" + searchMonthEnd + "-" + searchDayEnd + " ]  : NOT FOUND");
            }
            
            if(foundStart && foundEnd){
                 System.out.println("\n");
                 System.out.println("Total number of job created within the given time range : " + numSearchStart);
                 System.out.println("Total number of job endeed  within the given time range : " + numSearchEnd);
                 
                 System.out.println();
                
/////////////////Search day start                 
                 for(int i=0;i<=(searchMonthEnd - searchMonthStart);i++){
                 
                 if(searchMonthEnd - searchMonthStart == 0){
                 System.out.println("Month : " + searchMonthStart);
                 System.out.printf("%-30s","Day                      |");

////////////////INCOMPLETED
////////////////Month 6,9,11 got 30 days
//////////////// **** 3 Conditions
//////////////// **** 1.same month
//////////////// **** 2.cross 2 months
//////////////// **** 2.cross 2 months above

                 for(int j=searchDayStart;j<=searchDayEnd;j++){
                     System.out.printf("%-5d",j);
                 }
                 
                 System.out.println();
/////////////////COMPLETED JOB == 0

                 System.out.printf("%-30s","Number of completed job  |");
                 if(searchMonthStart == 6){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateJun[k-1]);
                     }
                 }
                 else if(searchMonthStart == 7){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateJune[k-1]);
                     }
                 }
                  else if(searchMonthStart == 8){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateAus[k-1]);
                     }
                 }
                 else if(searchMonthStart == 9){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateSep[k-1]);
                     }
                 }
                  else if(searchMonthStart == 10){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateOct[k-1]);
                     }
                 }
                 else if(searchMonthStart == 11){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateNov[k-1]);
                     }
                 }
                  else if(searchMonthStart == 12){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateDec[k-1]);
                     }
                 }
                 System.out.printf("\n%-30s","Number of ended    job   |");
                 if(searchMonthStart == 6){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndJun[k-1]);
                     }
                 }
                 else if(searchMonthStart == 7){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndJune[k-1]);
                     }
                 }
                 else if(searchMonthStart == 8){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndAus[k-1]);
                     }
                 }
                 else if(searchMonthStart == 9){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndSep[k-1]);
                     }
                 }
                 else if(searchMonthStart == 10){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndOct[k-1]);
                     }
                 }
                 else if(searchMonthStart == 11){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                 }
                  else if(searchMonthStart == 12){
                     for(int k = searchDayStart;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                 }

                 }    //////////////// End searchTImeStart - searchTimeEnd = 0
                 
                 
   //////////////// End searchTImeStart - searchTimeEnd = 1    
                 
                 else if(searchMonthEnd - searchMonthStart == 1){
                 if(i == 0){
                 System.out.println("Month : " + searchMonthStart);
                 System.out.printf("%-30s","Day                      |");

                 if(searchMonthStart == 6 || searchMonthStart == 9 || searchMonthStart == 11 ){
                     for(int j=searchDayStart;j<=30;j++){
                         System.out.printf("%-5d" , j);
                 }}    
                     
                 //////////////////Month 7,8,10 got 31 days                 
                 else if(searchMonthStart == 7 || searchMonthStart == 8 || searchMonthStart == 10 ){
                 for(int j=searchDayStart;j<=31;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
//////////////////Month 12 got 16 days                 
                 else if(searchMonthStart == 12){
                 for(int j=searchDayStart;j<=16;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
                 System.out.printf("\n%-30s","Number of completed job  |");
                 if(searchMonthStart == 6){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateJun[k-1]);
                     }
                 }
                 else if(searchMonthStart == 7){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateJune[k-1]);
                     }
                 }
                  else if(searchMonthStart == 8){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateAus[k-1]);
                     }
                 }
                 else if(searchMonthStart == 9){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateSep[k-1]);
                     }
                 }
                  else if(searchMonthStart == 10){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateOct[k-1]);
                     }
                 }
                 else if(searchMonthStart == 11){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateNov[k-1]);
                     }
                 }
                  else if(searchMonthStart == 12){
                     for(int k = searchDayStart;k<=16;k++){
                             System.out.printf("%-5d",numJobCreateDec[k-1]);
                     }
                 }
                 System.out.printf("\n%-30s","Number of ended    job   |");
                 if(searchMonthStart == 6){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobEndJun[k-1]);
                     }
                 }
                 else if(searchMonthStart == 7){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobEndJune[k-1]);
                     }
                 }
                 else if(searchMonthStart == 8){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobEndAus[k-1]);
                     }
                 }
                 else if(searchMonthStart == 9){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobEndSep[k-1]);
                     }
                 }
                 else if(searchMonthStart == 10){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobEndOct[k-1]);
                     }
                 }
                 else if(searchMonthStart == 11){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                 }
                  else if(searchMonthStart == 12){
                     for(int k = searchDayStart;k<=16;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                  }
                   
                 }    /////// i == 0 searchTimeStart - searchTimeEnd == 1
                 
                 else if(i == 1){
                 System.out.println("\n\nMonth : " + searchMonthEnd);
                 System.out.printf("%-30s","Day                      |");
                 
                 if(searchMonthEnd == 6 || searchMonthEnd == 9 || searchMonthEnd == 11 ){
                     for(int j=1;j<=searchDayEnd;j++){
                     System.out.printf("%-5d" , j);
                 }}    
                     
                 //////////////////Month 7,8,10 got 31 days                 
                 else if(searchMonthEnd == 7 || searchMonthEnd == 8 || searchMonthEnd == 10 ){
                 for(int j=1;j<=searchDayEnd;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
//////////////////Month 12 got 16 days                 
                 else if(searchMonthEnd == 12){
                 for(int j=1;j<=searchDayEnd;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
                  System.out.printf("\n%-30s","Number of completed job  |");
                 if(searchMonthEnd == 6){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateJun[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 7){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateJune[k-1]);
                     }
                 }
                  else if(searchMonthEnd == 8){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateAus[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 9){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateSep[k-1]);
                     }
                 }
                  else if(searchMonthEnd == 10){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateOct[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 11){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateNov[k-1]);
                     }
                 }
                  else if(searchMonthEnd == 12){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateDec[k-1]);
                     }
                 }
                 System.out.printf("\n%-30s","Number of ended    job   |");
                 if(searchMonthEnd == 6){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndJun[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 7){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndJune[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 8){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndAus[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 9){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndSep[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 10){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndOct[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 11){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                 }
                  else if(searchMonthEnd == 12){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                  }
                 }    /////////////// END FOR (i == 1) searchTimeStart - searchTimeEnd = 1
                 
   /////////////// START FOR searchTimeStart - searchTimeEnd >= 1     
    
              
//////////////////  THIS PART UNABLE TO RUN *******************                  
                 else if((searchMonthEnd - searchMonthStart) > 1){
                     System.out.println(searchMonthEnd - searchMonthStart);  
                 /////// (i = 0) searchMonthEnd - searchMonthStart > 1                    
                 
                 if(i == 0){                        
                 System.out.println("Month : " + searchMonthStart);
                 System.out.printf("%-30s","Day                      |");

                 if(searchMonthStart == 6 || searchMonthStart == 9 || searchMonthStart == 11 ){
                     for(int j=searchDayStart;j<=30;j++){
                         System.out.printf("%-5d" , j);
                 }}    
                     
                 //////////////////Month 7,8,10 got 31 days                 
                 else if(searchMonthStart == 7 || searchMonthStart == 8 || searchMonthStart == 10 ){
                 for(int j=searchDayStart;j<=31;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
//////////////////Month 12 got 16 days                 
                 else if(searchMonthStart == 12){
                 for(int j=searchDayStart;j<=16;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
                 System.out.printf("\n%-30s","Number of completed job  |");
                 if(searchMonthStart == 6){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateJun[k-1]);
                     }
                 }
                 else if(searchMonthStart == 7){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateJune[k-1]);
                     }
                 }
                  else if(searchMonthStart == 8){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateAus[k-1]);
                     }
                 }
                 else if(searchMonthStart == 9){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateSep[k-1]);
                     }
                 }
                  else if(searchMonthStart == 10){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateOct[k-1]);
                     }
                 }
                 else if(searchMonthStart == 11){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateNov[k-1]);
                     }
                 }
                  else if(searchMonthStart == 12){
                     for(int k = searchDayStart;k<=16;k++){
                             System.out.printf("%-5d",numJobCreateDec[k-1]);
                     }
                 }
                 System.out.printf("\n%-30s","Number of ended    job   |");
                 if(searchMonthStart == 6){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobEndJun[k-1]);
                     }
                 }
                 else if(searchMonthStart == 7){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobEndJune[k-1]);
                     }
                 }
                 else if(searchMonthStart == 8){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobEndAus[k-1]);
                     }
                 }
                 else if(searchMonthStart == 9){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobEndSep[k-1]);
                     }
                 }
                 else if(searchMonthStart == 10){
                     for(int k = searchDayStart;k<=31;k++){
                             System.out.printf("%-5d",numJobEndOct[k-1]);
                     }
                 }
                 else if(searchMonthStart == 11){
                     for(int k = searchDayStart;k<=30;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                 }
                  else if(searchMonthStart == 12){
                     for(int k = searchDayStart;k<=16;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                  }
                     }      /////// END (i = 0) searchMonthEnd - searchMonthStart >= 1 
                    
                    
                /////// (i = 0) searchMonthEnd - searchMonthStart >= 1  
                else if(i > 0 && i < searchMonthEnd){
                        
 /////////////// START FOR
                for(int n = 1;n < searchMonthEnd;n++){
                 int temptMonthStart = searchMonthStart + n; 
                   
                 System.out.println("\n\nMonth : " + (temptMonthStart));
                 System.out.printf("%-30s","Day                      |");
                 
                 if(temptMonthStart == 6 || temptMonthStart == 9 || temptMonthStart == 11 ){
                     for(int j=1;j<=30;j++){
                     System.out.printf("%-5d" , j);
                 }}    
                     
                 //////////////////Month 7,8,10 got 31 days                 
                 else if(temptMonthStart == 7 || temptMonthStart == 8 || temptMonthStart == 10 ){
                 for(int j=1;j<=31;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
//////////////////Month 12 got 16 days                 
                 else if(temptMonthStart == 12){
                 for(int j=1;j<=16;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
                 System.out.printf("\n%-30s","Number of completed job  |");
                 if(temptMonthStart == 6){
                     for(int k = 1;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateJun[k-1]);
                     }
                 }
                 else if(temptMonthStart == 7){
                     for(int k = 1;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateJune[k-1]);
                     }
                 }
                  else if(temptMonthStart == 8){
                     for(int k = 1;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateAus[k-1]);
                     }
                 }
                 else if(temptMonthStart == 9){
                     for(int k = 1;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateSep[k-1]);
                     }
                 }
                  else if(temptMonthStart == 10){
                     for(int k = 1;k<=31;k++){
                             System.out.printf("%-5d",numJobCreateOct[k-1]);
                     }
                 }
                 else if(temptMonthStart == 11){
                     for(int k = 1;k<=30;k++){
                             System.out.printf("%-5d",numJobCreateNov[k-1]);
                     }
                 }
                  else if(temptMonthStart == 12){
                     for(int k = 1;k<=16;k++){
                             System.out.printf("%-5d",numJobCreateDec[k-1]);
                     }
                 }
                 System.out.printf("\n%-30s","Number of ended    job   |");
                 if(temptMonthStart == 6){
                     for(int k =1;k<=30;k++){
                             System.out.printf("%-5d",numJobEndJun[k-1]);
                     }
                 }
                 else if(temptMonthStart == 7){
                     for(int k =1;k<=31;k++){
                             System.out.printf("%-5d",numJobEndJune[k-1]);
                     }
                 }
                 else if(temptMonthStart == 8){
                     for(int k =1;k<=31;k++){
                             System.out.printf("%-5d",numJobEndAus[k-1]);
                     }
                 }
                 else if(temptMonthStart == 9){
                     for(int k =1;k<=30;k++){
                             System.out.printf("%-5d",numJobEndSep[k-1]);
                     }
                 }
                 else if(temptMonthStart== 10){
                     for(int k =1;k<=31;k++){
                             System.out.printf("%-5d",numJobEndOct[k-1]);
                     }
                 }
                 else if(temptMonthStart == 11){
                     for(int k =1;k<=30;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                 }
                  else if(temptMonthStart == 12){
                     for(int k =1;k<=16;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                  }
                            
                        }
                         /////////////// END FOR LOOP
                        
                    }      /////// END (i = 0) searchMonthEnd - searchMonthStart >= 1 
                    
                    
                    
                 /////// (i = 0) searchMonthEnd - searchMonthStart >= 1            
                 else if(i == searchMonthEnd){
                     
                 System.out.println("\n\nMonth : " + searchMonthEnd);
                 System.out.printf("%-30s","Day                      |");
                 
                 if(searchMonthEnd == 6 || searchMonthEnd == 9 || searchMonthEnd == 11 ){
                     for(int j=1;j<=searchDayEnd;j++){
                     System.out.printf("%-5d" , j);
                 }}    
                     
                 //////////////////Month 7,8,10 got 31 days                 
                 else if(searchMonthEnd == 7 || searchMonthEnd == 8 || searchMonthEnd == 10 ){
                 for(int j=1;j<=searchDayEnd;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
//////////////////Month 12 got 16 days                 
                 else if(searchMonthEnd == 12){
                 for(int j=1;j<=searchDayEnd;j++){
                     System.out.printf("%-5d" , j);
                 }}
                 
                  System.out.printf("\n%-30s","Number of completed job  |");
                 if(searchMonthEnd == 6){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateJun[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 7){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateJune[k-1]);
                     }
                 }
                  else if(searchMonthEnd == 8){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateAus[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 9){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateSep[k-1]);
                     }
                 }
                  else if(searchMonthEnd == 10){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateOct[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 11){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateNov[k-1]);
                     }
                 }
                  else if(searchMonthEnd == 12){
                     for(int k = 1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobCreateDec[k-1]);
                     }
                 }
                 System.out.printf("\n%-30s","Number of ended    job   |");
                 if(searchMonthEnd == 6){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndJun[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 7){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndJune[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 8){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndAus[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 9){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndSep[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 10){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndOct[k-1]);
                     }
                 }
                 else if(searchMonthEnd == 11){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                 }
                  else if(searchMonthEnd == 12){
                     for(int k =1;k<=searchDayEnd;k++){
                             System.out.printf("%-5d",numJobEndNov[k-1]);
                     }
                  }
                    }       /////// END (i = 0) searchMonthEnd - searchMonthStart >= 1 
                
                 }          /////// END searchMonthEnd - searchMonthStart >= 1
                 
                 }    /////////////// END FOR DISPLAYING TABLE
            }
                 }
                 
            
        }
    
//////// SEARCH INPUT = 1 (BY MONTH)        
        int searchMonth =0;
           
        if(command == 1){
        System.out.print("\nEnter month : ");
        searchMonth = input.nextInt();
        
        while(!(searchMonth>=6 && searchMonth <=12)){
            System.out.println("Invalid time range");
            System.out.print("\nEnter month : ");
            searchMonth = input.nextInt();
        }
       
        if(searchMonth == 6){     /// Month 6 start //////////////
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

        int minCreate =9999,dayMinCreate=0;
        int maxCreate =-1,dayMaxCreate=0;
        int minEnd =9999,dayMinEnd=0;
        int maxEnd =-1,dayMaxEnd=0;
        
       
        System.out.println("\nTotal job created in Jun   : " + sumCreateJun);
        System.out.println("Total job ended in Jun     : " + sumEndJun);
        ave=sumCreateJun/30.0;
        System.out.printf("Average job created in Jun : %.1f\n" , ave);
        ave=sumEndJun/30.0;
        System.out.printf("Average job ended in Jun   : %.1f\n" , ave);
        for(int i=0;i<30;i++){
            if(numJobCreateJun[i]>maxCreate){
                maxCreate = numJobCreateJun[i];dayMaxCreate = i+1;}
            if(numJobCreateJun[i]<minCreate){
                minCreate = numJobCreateJun[i];dayMinCreate = i+1;}
            if(numJobEndJun[i]>maxEnd){
                maxEnd = numJobEndJun[i];dayMaxEnd = i+1;}
            if(numJobEndJun[i]<minCreate){
                minEnd = numJobEndJun[i];dayMinEnd = i+1;}
        }

        System.out.println("\nRange of number of job created in Jun     : " + minCreate + " - " + maxCreate);
        System.out.println("Range of number of job ended   in Jun     : " + minEnd + " - " + maxEnd);

        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

        
////////THE DATA IS SORTED
        
        Arrays.sort(numJobCreateJun);
        Arrays.sort(numJobEndJun);

        if(numJobCreateJun.length%2 == 0){
            System.out.println("\nMedian of the job created in Jun : " + ((numJobCreateJun[((numJobCreateJun.length)/2)] + numJobCreateJun[((numJobCreateJun.length)/2)-1])/2));
        }
        else if(numJobCreateJun.length%2 == 1){
            System.out.println("\nMedian of the job created in Jun : " + numJobCreateJun[(numJobCreateJun.length/2)-1]);
        }
        if(numJobEndJun.length%2 == 0){
            System.out.println("Median of the job ended   in Jun : " + ((numJobEndJun[((numJobEndJun.length)/2)] + numJobEndJun[((numJobEndJun.length)/2)-1])/2));
        }
        else if(numJobEndJun.length%2 == 1){
            System.out.println("Median of the job ended   in Jun : " + numJobEndJun[(numJobEndJun.length/2)-1]);
        }
        }
////////////////////////DELETED A } NOT SURE                                 
        int minCreate =9999,dayMinCreate=0;
        int maxCreate =-1,dayMaxCreate=0;
        int minEnd =9999,dayMinEnd=0;
        int maxEnd =-1,dayMaxEnd=0;
        
        if(searchMonth == 7){                      ///// End month 7
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
        for(int i=0;i<31;i++){
            if(numJobCreateJune[i]>maxCreate){
                maxCreate = numJobCreateJune[i];dayMaxCreate = i+1;}
            if(numJobCreateJune[i]<minCreate){
                minCreate = numJobCreateJune[i];dayMinCreate = i+1;}
            if(numJobEndJune[i]>maxEnd){
                maxEnd = numJobEndJune[i];dayMaxEnd = i+1;}
            if(numJobEndJune[i]<minCreate){
                minEnd = numJobEndJune[i];dayMinEnd = i+1;}
        }

        System.out.println("\nRange of number of job created in June     : " + minCreate + " - " + maxCreate);
        System.out.println("Range of number of job ended   in June     : " + minEnd + " - " + maxEnd);

        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

        Arrays.sort(numJobCreateJune);
        Arrays.sort(numJobEndJune);

        if(numJobCreateJune.length%2 == 0){
            System.out.println("\nMedian of the job created in June : " + ((numJobCreateJune[((numJobCreateJune.length)/2)] + numJobCreateJune[((numJobCreateJune.length)/2)-1])/2));
        }
        else if(numJobCreateJune.length%2 == 1){
            System.out.println("\nMedian of the job created in June : " + numJobCreateJune[(numJobCreateJune.length/2)-1]);
        }
        if(numJobEndJune.length%2 == 0){
            System.out.println("Median of the job ended   in June : " + ((numJobEndJune[((numJobEndJune.length)/2)] + numJobEndJune[((numJobEndJune.length)/2)-1])/2));
        }
        else if(numJobEndJune.length%2 == 1){
            System.out.println("Median of the job ended   in June : " + numJobEndJune[(numJobEndJune.length/2)-1]);
        }
        }
                                                      // END MONTH 7
        minCreate =9999;dayMinCreate=0;
        maxCreate =-1;dayMaxCreate=0;
        minEnd =9999;dayMinEnd=0;
        maxEnd =-1;dayMaxEnd=0;
        if(searchMonth == 8){
        
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
        for(int i=0;i<31;i++){
            if(numJobCreateAus[i]>maxCreate){
                maxCreate = numJobCreateAus[i];dayMaxCreate = i+1;}
            if(numJobCreateAus[i]<minCreate){
                minCreate = numJobCreateAus[i];dayMinCreate = i+1;}
            if(numJobEndAus[i]>maxEnd){
                maxEnd = numJobEndAus[i];dayMaxEnd = i+1;}
            if(numJobEndAus[i]<minCreate){
                minEnd = numJobEndAus[i];dayMinEnd = i+1;}
        }

        System.out.println("\nRange of number of job created in Ausgust     : " + minCreate + " - " + maxCreate);
        System.out.println("Range of number of job ended   in Ausgust     : " + minEnd + " - " + maxEnd);

        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

        Arrays.sort(numJobCreateAus);
        Arrays.sort(numJobEndAus);

        if(numJobCreateAus.length%2 == 0){
            System.out.println("\nMedian of the job created in Ausgust : " + ((numJobCreateAus[((numJobCreateAus.length)/2)] + numJobCreateAus[((numJobCreateAus.length)/2)-1])/2));
        }
        else if(numJobCreateAus.length%2 == 1){
            System.out.println("\nMedian of the job created in Ausgust : " + numJobCreateAus[(numJobCreateAus.length/2)-1]);
        }
        if(numJobEndAus.length%2 == 0){
            System.out.println("Median of the job ended   in Ausgust : " + ((numJobEndAus[((numJobEndAus.length)/2)] + numJobEndAus[((numJobEndAus.length)/2)-1])/2));
        }
        else if(numJobEndAus.length%2 == 1){
            System.out.println("Median of the job ended   in Ausgust : " + numJobEndAus[(numJobEndAus.length/2)-1]);
        }
        }         //END MONTH 8
                                         
        
        if (searchMonth == 9){
        minCreate =9999;dayMinCreate=0;
        maxCreate =-1;dayMaxCreate=0;
        minEnd =9999;dayMinEnd=0;
        maxEnd =-1;dayMaxEnd=0;

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
        for(int i=0;i<30;i++){
            if(numJobCreateSep[i]>maxCreate){
                maxCreate = numJobCreateSep[i];dayMaxCreate = i+1;}
            if(numJobCreateSep[i]<minCreate){
                minCreate = numJobCreateSep[i];dayMinCreate = i+1;}
            if(numJobEndSep[i]>maxEnd){
                maxEnd = numJobEndSep[i];dayMaxEnd = i+1;}
            if(numJobEndSep[i]<minCreate){
                minEnd = numJobEndSep[i];dayMinEnd = i+1;}
        }

        System.out.println("\nRange of number of job created in September     : " + minCreate + " - " + maxCreate);
        System.out.println("Range of number of job ended   in September     : " + minEnd + " - " + maxEnd);

        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

        Arrays.sort(numJobCreateSep);
        Arrays.sort(numJobEndSep);

        if(numJobCreateSep.length%2 == 0){
            System.out.println("\nMedian of the job created in September : " + ((numJobCreateSep[((numJobCreateSep.length)/2)] + numJobCreateSep[((numJobCreateSep.length)/2)-1])/2));
        }
        else if(numJobCreateSep.length%2 == 1){
            System.out.println("\nMedian of the job created in September : " + numJobCreateSep[(numJobCreateSep.length/2)-1]);
        }
        if(numJobEndSep.length%2 == 0){
            System.out.println("Median of the job ended   in September : " + ((numJobEndSep[((numJobEndSep.length)/2)] + numJobEndSep[((numJobEndSep.length)/2)-1])/2));
        }
        else if(numJobEndSep.length%2 == 1){
            System.out.println("Median of the job ended   in September : " + numJobEndSep[(numJobEndSep.length/2)-1]);
        }
        }                                     //END MONTH 9
        
        if(searchMonth == 10){
        minCreate =9999;dayMinCreate=0;
        maxCreate =-1;dayMaxCreate=0;
        minEnd =9999;dayMinEnd=0;
        maxEnd =-1;dayMaxEnd=0;

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
        for(int i=0;i<31;i++){
            if(numJobCreateOct[i]>maxCreate){
                maxCreate = numJobCreateOct[i];dayMaxCreate = i+1;}
            if(numJobCreateOct[i]<minCreate){
                minCreate = numJobCreateOct[i];dayMinCreate = i+1;}
            if(numJobEndOct[i]>maxEnd){
                maxEnd = numJobEndOct[i];dayMaxEnd = i+1;}
            if(numJobEndOct[i]<minCreate){
                minEnd = numJobEndOct[i];dayMinEnd = i+1;}
        }

        System.out.println("\nRange of number of job created in October     : " + minCreate + " - " + maxCreate);
        System.out.println("Range of number of job ended   in October     : " + minEnd + " - " + maxEnd);

        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

        Arrays.sort(numJobCreateOct);
        Arrays.sort(numJobEndOct);

        if(numJobCreateOct.length%2 == 0){
            System.out.println("\nMedian of the job created in October : " + ((numJobCreateOct[((numJobCreateOct.length)/2)] + numJobCreateOct[((numJobCreateOct.length)/2)-1])/2));
        }
        else if(numJobCreateOct.length%2 == 1){
            System.out.println("\nMedian of the job created in October : " + numJobCreateOct[(numJobCreateOct.length/2)-1]);
        }
        if(numJobEndOct.length%2 == 0){
            System.out.println("Median of the job ended   in October : " + ((numJobEndOct[((numJobEndOct.length)/2)] + numJobEndOct[((numJobEndOct.length)/2)-1])/2));
        }
        else if(numJobEndOct.length%2 == 1){
            System.out.println("Median of the job ended   in October : " + numJobEndOct[(numJobEndOct.length/2)-1]);
        }
        }                                     // END MONTH 10
        
        if(searchMonth == 11){
        minCreate =9999;dayMinCreate=0;
        maxCreate =-1;dayMaxCreate=0;
        minEnd =9999;dayMinEnd=0;
        maxEnd =-1;dayMaxEnd=0;

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
        for(int i=0;i<30;i++){
            if(numJobCreateNov[i]>maxCreate){
                maxCreate = numJobCreateNov[i];dayMaxCreate = i+1;}
            if(numJobCreateNov[i]<minCreate){
                minCreate = numJobCreateNov[i];dayMinCreate = i+1;}
            if(numJobEndNov[i]>maxEnd){
                maxEnd = numJobEndNov[i];dayMaxEnd = i+1;}
            if(numJobEndNov[i]<minCreate){
                minEnd = numJobEndNov[i];dayMinEnd = i+1;}
        }

        System.out.println("\nRange of number of job created in November     : " + minCreate + " - " + maxCreate);
        System.out.println("Range of number of job ended   in November     : " + minEnd + " - " + maxEnd);

        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

        Arrays.sort(numJobCreateNov);
        Arrays.sort(numJobEndNov);

        if(numJobCreateNov.length%2 == 0){
            System.out.println("\nMedian of the job created in November : " + ((numJobCreateNov[((numJobCreateNov.length)/2)] + numJobCreateNov[((numJobCreateNov.length)/2)-1])/2));
        }
        else if(numJobCreateNov.length%2 == 1){
            System.out.println("\nMedian of the job created in November : " + numJobCreateNov[(numJobCreateNov.length/2)-1]);
        }
        if(numJobEndNov.length%2 == 0){
            System.out.println("Median of the job ended   in November : " + ((numJobEndNov[((numJobEndNov.length)/2)] + numJobEndNov[((numJobEndNov.length)/2)-1])/2));
        }
        else if(numJobEndNov.length%2 == 1){
            System.out.println("Median of the job ended   in November : " + numJobEndNov[(numJobEndNov.length/2)-1]);
        }
        }                                      ///////  END MONTH 11
        
        if(searchMonth == 12){
        minCreate =9999;dayMinCreate=0;
        maxCreate =-1;dayMaxCreate=0;
        minEnd =9999;dayMinEnd=0;
        maxEnd =-1;dayMaxEnd=0;

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
        for(int i=0;i<16;i++){
            if(numJobCreateDec[i]>maxCreate){
                maxCreate = numJobCreateDec[i];dayMaxCreate = i+1;}
            if(numJobCreateDec[i]<minCreate){
                minCreate = numJobCreateDec[i];dayMinCreate = i+1;}
            if(numJobEndDec[i]>maxEnd){
                maxEnd = numJobEndDec[i];dayMaxEnd = i+1;}
            if(numJobEndDec[i]<minCreate){
                minEnd = numJobEndDec[i];dayMinEnd = i+1;}
        }

        System.out.println("\nRange of number of job created in December     : " + minCreate + " - " + maxCreate);
        System.out.println("Range of number of job ended   in December     : " + minEnd + " - " + maxEnd);

        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

        Arrays.sort(numJobCreateDec);
        Arrays.sort(numJobEndDec);

        if(numJobCreateDec.length%2 == 0){
            System.out.println("\nMedian of the job created in December : " + ((numJobCreateDec[((numJobCreateDec.length)/2)] + numJobCreateDec[((numJobCreateDec.length)/2)-1])/2));
        }
        else if(numJobCreateDec.length%2 == 1){
            System.out.println("\nMedian of the job created in December : " + numJobCreateDec[(numJobCreateDec.length/2)-1]);
        }
        if(numJobEndDec.length%2 == 0){
            System.out.println("Median of the job ended   in December : " + ((numJobEndDec[((numJobEndDec.length)/2)] + numJobEndDec[((numJobEndDec.length)/2)-1])/2));
        }
        else if(numJobEndDec.length%2 == 1){
            System.out.println("Median of the job ended   in December : " + numJobEndDec[(numJobEndDec.length/2)-1]);
        }
        }                                 // END MONTH 12
        }      // END COMMENT       
        }            // END METHOD
        

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
                    //System.out.println(data);
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
        HashSet <String> user = new HashSet<String>();
        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();
            while(data!=null){
                int num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                for(int i=0;i<content.length;i++){
                    if(content[i].equals("error:")){
                        System.out.println(data);
                        if(content[i+2].equals("association")){
                            user.add(content[i+4]);
                        }
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
                    }
                }
                data=read.readLine();
            }
        }
        catch(FileNotFoundException e){System.out.println("File Not Found");}
        catch(IOException e){System.out.println("Error occurs while editing file");}

        numInvalid = numQosSpec + numAccount + numGroup + numUser + numNode + numJob + numPartition;
        System.out.println("\nNumber of errors  : " + numErr);
        System.out.println("Number of invalid : " + numInvalid);

        System.out.println("\n---------------------------------------------------------------------");
        System.out.printf("%-50s%-20s\n","Types of Invalid","Number of Cases");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-50s%-20s\n","Invalid Qos Specification",numQosSpec);
        System.out.printf("%-50s%-20d\n","Invalid Account",numAccount);
        System.out.printf("%-50s%-20d\n","Invalid Job Id Specified",numJob);
        System.out.printf("%-50s%-20d\n","Invalid Partition Name Specified",numPartition);
        System.out.printf("%-50s%-20d\n","Invalid Node Name Specified",numNode);
        System.out.printf("%-50s%-20d\n","Invalid User Id",numUser);
        System.out.printf("%-50s%-20d\n","Invalid Group Id",numGroup);

        int d=0;
        int numErrUser=1;
        System.out.println("\n");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("%60s","Name of Users Causing Errors\n");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for(String users : user){
            System.out.printf("%-2d) %-30s", numErrUser,users.substring(6,users.length()-2));
            numErrUser++;
            d++;
            if(d == 3){
                System.out.println();
                d=0;
            }
        }
        System.out.println("\n\nTotal number of users causing errors : " + (numErrUser-1));
    }

    public static void averageExecutionTime(String fileName){

        Scanner input = new Scanner(System.in);

        String data = "";

        int nom = 0;

        double totalExecutionTime = 0.0;

        ArrayList createJobTime = new ArrayList();
        ArrayList createJobId = new ArrayList();
        ArrayList endJobTime = new ArrayList();
        ArrayList endJobId = new ArrayList();
        ArrayList<Double> exeTime = new ArrayList<>();

        ArrayList compare = new ArrayList();

        ArrayList NoCreateJobId = new ArrayList<>();

        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            data = read.readLine();

            while(data!=null){

                int num = data.split(" ").length;
                String [] content = new String[num];
                content = data.split(" ");

                // Create Job
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

        int command = 0;
        System.out.println("1. Display all the completed job ids");
        System.out.println("2. Display all the not completed job ids");
        System.out.println("3. Search for particular job id(s)");
        System.out.println("###Any number to display Statistical data of execution time");
        System.out.print("command -> ");
        command = input.nextInt();

        int num = 0;

        ArrayList jobId = new ArrayList();

        System.out.println();

        ///////////SEARCHING COMPLETED JOB
        if(command == 3){

            System.out.print("Enter the number of completed Job Id for searching : ");
            num = input.nextInt();

            System.out.println("\nEnter the completed Job Id for searching : ");

            for(int i=0;i<num;i++){
                System.out.print(i+1 + ". : ");
                String inp = input.next();
                String toAdd = "JobId=" + inp;
                jobId.add(toAdd);
            }
        }
        String [] createJobTime2 = new String[createJobTime.size()];
        String [] endJobTime2 = new String[endJobTime.size()];
        createJobTime.toArray(createJobTime2);
        endJobTime.toArray(endJobTime2);

        String maxJobId = null;
        String minJobId = null;

        double max = -1;
        double min = 9999;

        int No = 0;

        if(command !=2){
            System.out.printf("\n%-8s%-20s%-20s%-30s%-30s%-30s\n","No.","Completed Job ID","Ended Job ID","Job Completed Time","Job Ended Time","Execution Time (mins)");
            System.out.print("--------------------------------------------------------------------------------------------------------------------------------------");
        }

        for(int i=0;i<createJobId.size();i++){

            for(int j=0;j<endJobId.size();j++){
                if(createJobId.get(i).equals(endJobId.get(j))){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'['yyyy-MM-dd'T'HH:mm:ss.SSS']'");
                    LocalDateTime createTime = LocalDateTime.parse(createJobTime2[i],formatter);
                    LocalDateTime endTime = LocalDateTime.parse(endJobTime2[j],formatter);

                    long milliBetween = ChronoUnit.MILLIS.between(createTime,endTime);

                    if(milliBetween < 0)
                        milliBetween *=-1;

                    double milli = (double)milliBetween;

                    exeTime.add(milli);

                    double output = (double)((milliBetween/1000.0)/60);
                    No++;

                    ///////// DISPLAY ALL THE INFO OF JOBID
                    if(command == 1){
                        System.out.printf("\n%-8d%-20s%-20s%-30s%-30s",No,createJobId.get(i),endJobId.get(j),createJobTime2[i],endJobTime2[j]);
                        System.out.printf("%.3f",output);}

                    else if(command == 3){
                        ////////////////SEARCH FOR COMPLETED  JOB

                        String [] jobId2 = new String[num];
                        jobId.toArray(jobId2);


                        for(int k=0;k<num;k++){
                            nom++;
                            if(createJobId.get(i).equals(jobId2[k])){
                                System.out.printf("\n%-8d%-20s%-20s%-30s%-30s",nom,createJobId.get(i),endJobId.get(j),createJobTime2[i],endJobTime2[j]);
                                System.out.printf("%.3f",output);
                                compare.add(createJobId.get(i));}

                        } // END FOR VARIABLE K LOOP
                    }  // END FOR COMMAND 3
                    if((milliBetween/1000)>max){
                        max = milliBetween/1000;maxJobId = (String) createJobId.get(i);}

                    if((milliBetween)<min){
                        min = milliBetween;minJobId = (String) createJobId.get(i);}

                    totalExecutionTime += (double)((milliBetween/1000.0));
                }
                ////////// PART OF DISPLAY OF INCOMPLETED JOBID
//                        String [] noCreateJobId = new String[createJobId.size()];
//                        createJobId.toArray(noCreateJobId);
                //numNoCreateJobId.add(i);
            }

        }

        ///////// DISPLAY ALL THE INFO OF INCOMPLETED JOBID
        if(command == 2 || command==3){
            int numNoJob=0;

            String [] noCreateJobId = new String[createJobId.size()];
            createJobId.toArray(noCreateJobId);
            for(int i=0;i<createJobId.size();i++){
                for(int j=0;j<endJobId.size();j++){
                    if(createJobId.get(i).equals(endJobId.get(j))){
                        noCreateJobId[i] = "null";
                    }
                }
            }

            for(int u=0;u<noCreateJobId.length;u++){
                if(!(noCreateJobId[u].equals("null"))){
                    NoCreateJobId.add(noCreateJobId[u]);
                }
            }

            if(command == 2){
                System.out.printf("\n%-8s%-30s%-30s","No.","Job Assigned Time","Not Completed Job ID");
                System.out.println("\n------------------------------------------------------------");
//                      }


//                       for(int e=0;e<createJobId.size();e++){
//                           if(numNoCreateJobId.contains(e) == false){
//                                numNoJob++;
//                                System.out.printf("\n%-8d%-30s%-30s",numNoJob,createJobTime2[e],createJobId.get(e));
//                           }
//                       }


                for(int e=0;e<noCreateJobId.length;e++){
                    if(!noCreateJobId[e].equals("null")){
                        nom++;
                        System.out.printf("%-8d%-30s%-30s\n",nom,createJobTime2[e],createJobId.get(e));
                    }
                }
                System.out.println("\n-----------------------------------------------------------");
                System.out.println("The total number of incompleted job id : " + numNoJob);

            }   // END OFR SUB COMMAND 2

            ///////// RESULT OF SEARCHING INCOMPLETED JOB
            else if(command == 3){

                int x = 0;
                for(int i=0;i<num;i++){
                    for(int j=0;j<noCreateJobId.length;j++){
                        if(noCreateJobId[j].equals(jobId.get(i))){
                            x++;
                            System.out.printf("\n%-8d%-20s%-30s%-30s",x,createJobId.get(j),createJobTime2[j],"JOB IS NOT COMPLETED");
                        }
                    } // second for loop
                }// first for loop (i)
            }   // END FOR SUB COMMAND 3


        }     // END COMMAND 2 AND 3



        // Searching Not Found
        //HashSet noEqual = new HashSet();
        String [] jobId3 = new String[num];
        jobId.toArray(jobId3);

        for(int m=0;m<num;m++){
            for(int n=0;n<compare.size();n++){
                if((jobId.get(m).equals(compare.get(n)))){
                    jobId3[m] = "null";
                }
            }}

        //System.out.println(NoCreateJobId);

        for(int m=0;m<jobId3.length;m++){
            for(int n=0;n<NoCreateJobId.size();n++){
                if((jobId3[m].equals(NoCreateJobId.get(n)))){
                    jobId3[m] = "null";
                }
            }}

        System.out.println();

        for (String jobIdNull : jobId3) {
            if (!(jobIdNull.equals("null"))) {
                System.out.println(jobIdNull + " Not Found");
            }
        }
        ///////////Statistical data
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        if(command !=2){
            System.out.println("Total number of completed Job : " + No);

            System.out.println();

            System.out.printf("Total execution time : %.2f Days\n" , ((totalExecutionTime/3600)/24));
            System.out.printf("Total execution time : %.2f Hours\n" , totalExecutionTime/3600 );
            System.out.printf("Total execution time : %.2f Mins\n" , totalExecutionTime/60 );
            System.out.printf("Total execution time : %.2f Seconds\n" , totalExecutionTime );

            System.out.println();

            System.out.printf("Average execution time : %.2f Days\n" , (((totalExecutionTime/3600)/24)/No));
            System.out.printf("Average execution time : %.2f Hours\n" , (totalExecutionTime/3600)/No );
            System.out.printf("Average execution time : %.2f Mins\n" , (totalExecutionTime/60)/No );
            System.out.printf("Average execution time : %.2f Seconds\n" , (totalExecutionTime)/No );

            System.out.println();

            System.out.println("Highest Execution Time " + maxJobId);
            System.out.printf("Highest execution time : %.2f Days\n" , (((max/3600)/24)));
            System.out.printf("Highest execution time : %.2f Hours\n" , (max/3600) );
            System.out.printf("Highest execution time : %.2f Mins\n" , (max/60) );
            System.out.printf("Highest execution time : %.2f Seconds\n" , (max) );

            System.out.println();

            System.out.println("Lowest Execution Time " + minJobId);
            System.out.printf("Lowest execution time : %.2f milliseconds\n" , min );

            System.out.println();

            Collections.sort(exeTime);
            double median = 0;
            double firstQuartile = 0;
            double thirdQuartile = 0;

            firstQuartile = exeTime.size()*0.25;
            thirdQuartile = exeTime.size()*0.75;

            double firQuartile = (exeTime.get((int)firstQuartile) + exeTime.get((int)firstQuartile+1))/2/1000/60;

            System.out.printf("First Quartile of execution time : %.1f mins\n" , firQuartile);

            if(exeTime.size()%2 == 0){
                median =(exeTime.get((int) Math.floor(exeTime.size()/2))+  exeTime.get(((int)Math.floor(exeTime.size()/2)+1)) )/2;
            }

            else if(exeTime.size()%2==1){
                median = exeTime.get((int) Math.ceil(exeTime.size()/2));
            }
            median = (median / 1000)/60;
            System.out.printf("Median of execution time         : %.1f mins\n", median);

            double thiQuartile = (exeTime.get((int)thirdQuartile) + exeTime.get((int)thirdQuartile+1))/2/1000/60;
            System.out.printf("Third Quartile of execution time : %.1f mins\n" , thiQuartile);

            System.out.println();

            double iqr = thiQuartile - firQuartile;
            double lowerLimit = firQuartile - (1.5 * iqr);
            double upperLimit = thiQuartile + (1.5 * iqr);
            System.out.printf("Interquartile range of execution time : %.1f mins\n" ,iqr);
            System.out.printf("Lower limit of execution time         : %.1f mins\n" ,lowerLimit);
            System.out.printf("Upper limit of execution time         : %.1f mins\n" ,upperLimit);

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }   // END ALL COMMAND EXCEPT COMMAND 3
    } // End method

    public static void display(String fileName) throws IOException,InterruptedException{
        Scanner input = new Scanner(System.in);
        fileName = "C:/Users/USER/Downloads/Documents/UM Data Science/FUNDAMENTAL OF PROGRAMMING/assignment.txt";

        int command = 0;

        System.out.println("                   FOP Assignment                       ");
        System.out.println("--------------------------------------------------------");
        System.out.println("1. Total number of completed and ended jobs");
        System.out.println("2. Total number of completed and ended jobs by months");
        System.out.println("3. Total number of job by partition");
        System.out.println("4. Total number of errors and invalids");
        System.out.println("5. Execution time");
        System.out.println("###Any number to QUIT");
        System.out.print("Command -> ");
        command = input.nextInt();

        //new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

        while(command >0 && command <= 5){

            System.out.println();

            if(command == 1){
                totalCompletedAndEndedJob(fileName);System.out.println("\n");}
            else if(command == 2){
                totalMonthJobCreateEnd(fileName);System.out.println("\n");}
            else if(command == 3){
                jobByPartitions(fileName);System.out.println("\n");}
            else if(command == 4){
                ErrorAndInvalid(fileName);System.out.println("\n");}
            else if(command == 5){
                averageExecutionTime(fileName);System.out.println("\n");}


            System.out.println("\n                   FOP Assignment                       ");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Total number of completed and ended jobs");
            System.out.println("2. Total number of completed and ended jobs by months");
            System.out.println("3. Total number of job by partition");
            System.out.println("4. Total number of errors and invalids");
            System.out.println("5. Execution time");
            System.out.println("###Any number to QUIT");
            System.out.print("Command -> ");
            command = input.nextInt();
            //new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        System.out.println("\nThank you");
    }

    public static void main(String[] args) throws IOException,InterruptedException{

        String fileName = "C:/Users/USER/Downloads/Documents/UM Data Science/FUNDAMENTAL OF PROGRAMMING/assignment.txt";

        //totalCompletedAndEndedJob(fileName);
        //totalMonthJobCreateEnd(fileName);
        //jobByPartitions(fileName);
        //ErrorAndInvalid(fileName);
        //averageExecutionTime(fileName);
        display(fileName);
    }
}
