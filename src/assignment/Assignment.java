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

        minCreate =9999;dayMinCreate=0;
        maxCreate =-1;dayMaxCreate=0;
        minEnd =9999;dayMinEnd=0;
        maxEnd =-1;dayMaxEnd=0;

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

        minCreate =9999;dayMinCreate=0;
        maxCreate =-1;dayMaxCreate=0;
        minEnd =9999;dayMinEnd=0;
        maxEnd =-1;dayMaxEnd=0;

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
                        //System.out.println(data);
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
