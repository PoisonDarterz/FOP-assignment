package restructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MJCE {
    public static void totalMonthJobCreateEnd(String fileName){
        String data;
        String month = "";
        String day = "";
        double ave = 0.0;
        int m=0;
        int d=0;

//        for (int monthtrack = 6; monthtrack <=12; monthtrack++) {
//            String monstr = "";
//            switch(monthtrack){
//                case 6 -> monstr = "Jun";
//                case 7 -> monstr = "Jul";
//                case 8 -> monstr = "Aug";
//                case 9 -> monstr = "Sep";
//                case 10 -> monstr = "Oct";
//                case 11 -> monstr = "Nov";
//                case 12 -> monstr = "Dec";
//            }
//
//            int sumCreate = 0;
//            int sumEnd = 0;
//            ArrayList<Integer> numJobCreate = new ArrayList<>();
//            ArrayList<Integer> numJobEnd = new ArrayList<>();
//
//
//            try {
//                BufferedReader read = new BufferedReader(new FileReader(fileName));
//                data = read.readLine();
//                while (data != null) {
//
//
//                    int num = data.split(" ").length;
//                    String[] content = new String[num];
//                    content = data.split(" ");
//
//                    //ALLOCATE NUMBER OF JOBS CREATED AND ENDED BY DAYS AND MONTHS
//                    month = data.substring(6, 8);
//                    day = data.substring(9, 11);
//                    d = Integer.parseInt(day);
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'['yyyy-MM-dd'T'HH:mm:ss.SSS']'");
//                    LocalDateTime dateTime = LocalDateTime.parse(content[0], formatter);
//                    if (dateTime.getMonthValue() == monthtrack) {
//                        for (String content2 : content) {
//
//                            if (content2.equals("done")) {
//
//                                numJobCreate.add(d - 1, numJobCreate.get(d - 1) + 1);
//                            }
//
//                            if (content2.equals("Allocate")) {
//
//                                numJobEnd.add(d - 1, numJobEnd.get(d - 1) + 1);
//                            }
//                        }
//                    }
//                    data = read.readLine();
//                }
//            } catch (FileNotFoundException e) {
//                System.out.println("File Not Found");
//            } catch (IOException e) {
//                System.out.println("Error occurs while editing file");
//            }
//
//            System.out.println("\nMonth : " + monthtrack);
//            System.out.printf("%-20s", "Day           |");
//            for (int i = 0; i < 30; i++) {
//                System.out.printf("%-5d", (i + 1));
//            }
//            System.out.printf("\n%-20s", "Completed job |");
//            for (int i = 0; i < 30; i++) {
//                sumCreate += numJobCreate.get(i);
//                System.out.printf("%-5d", numJobCreate.get(i));
//            }
//            System.out.printf("\n%-20s", "Ended job     |");
//            for (int i = 0; i < 30; i++) {
//                sumEnd += numJobEnd.get(i);
//                System.out.printf("%-5d", numJobEnd.get(i));
//            }
//
//            int minCreate = 9999, dayMinCreate = 0;
//            int maxCreate = -1, dayMaxCreate = 0;
//            int minEnd = 9999, dayMinEnd = 0;
//            int maxEnd = -1, dayMaxEnd = 0;
//
//            System.out.println("\nTotal job created in " + monstr +   ": " + sumCreate);
//            System.out.println("Total job ended in  " + monstr +   ": " + sumEnd);
//            ave = sumCreate / 30.0;
//            System.out.printf("Average job created in %s: %.1f\n", monstr, ave);
//            ave = sumEnd / 30.0;
//            System.out.printf("Average job ended in %s  : %.1f\n", monstr, ave);
//            for (int i = 0; i < 30; i++) {
//                if (numJobCreate.get(i) > maxCreate) {
//                    maxCreate = numJobCreate.get(i);
//                    dayMaxCreate = i + 1;
//                }
//                if (numJobCreate.get(i) < minCreate) {
//                    minCreate = numJobCreate.get(i);
//                    dayMinCreate = i + 1;
//                }
//                if (numJobEnd.get(i) > maxEnd) {
//                    maxEnd = numJobEnd.get(i);
//                    dayMaxEnd = i + 1;
//                }
//                if (numJobEnd.get(i) < minCreate) {
//                    minEnd = numJobEnd.get(i);
//                    dayMinEnd = i + 1;
//                }
//            }
//            System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//            System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//            System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//            System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//        }



        //-----------------------------------------------------------------------------------------------------//


        int sumCreateJun = 0;
        int sumEndJun = 0;
        int [] numJobCreateJun = new int[30];
        int [] numJobEndJun = new int[30];

        int sumCreateJuly = 0;
        int sumEndJuly = 0;
        int [] numJobCreateJuly = new int[31];
        int [] numJobEndJuly = new int[31];

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
                System.out.println(content[0]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'['yyyy-MM-dd'T'HH:mm:ss.SSS']'");
                LocalDateTime dateTime = LocalDateTime.parse(content[0], formatter);
                if(dateTime.getMonthValue() == 6){
                    for(String content2 : content){
                        if(content2.equals("done")){
                            numJobCreateJun[d-1]+=1;}
                        if(content2.equals("Allocate")){
                            numJobEndJun[d-1]+=1;}
                    }
                }

                if(dateTime.getMonthValue() == 7){
                    for(String content2 : content){
                        if(content2.equals("done")){
                            numJobCreateJuly[d-1]+=1;}
                        if(content2.equals("Allocate")){
                            numJobEndJuly[d-1]+=1;}
                    }
                }

                if(dateTime.getMonthValue() == 8){
                    for(String content2 : content){
                        if(content2.equals("done")){
                            numJobCreateAus[d-1]+=1;}
                        if(content2.equals("Allocate")){
                            numJobEndAus[d-1]+=1;}
                    }
                }

                if(dateTime.getMonthValue() == 9){
                    for(String content2 : content){
                        if(content2.equals("done")){
                            numJobCreateSep[d-1]+=1;}
                        if(content2.equals("Allocate")){
                            numJobEndSep[d-1]+=1;}
                    }
                }

                if(dateTime.getMonthValue() == 10){
                    for(String content2 : content){
                        if(content2.equals("done")){
                            numJobCreateOct[d-1]+=1;}
                        if(content2.equals("Allocate")){
                            numJobEndOct[d-1]+=1;}
                    }
                }

                if(dateTime.getMonthValue() == 11){
                    for(String content2 : content){
                        if(content2.equals("done")){
                            numJobCreateNov[d-1]+=1;}
                        if(content2.equals("Allocate")){
                            numJobEndNov[d-1]+=1;}
                    }
                }

                if(dateTime.getMonthValue() == 12){
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
        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

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
            sumCreateJuly+=numJobCreateJuly[i];
            System.out.printf("%-5d",numJobCreateJuly[i]);
        }
        System.out.printf("\n%-20s","Ended job     |");
        for(int i=0;i<31;i++){
            sumEndJuly+=numJobEndJuly[i];
            System.out.printf("%-5d",numJobEndJuly[i]);
        }
        System.out.println("\nTotal job created in June   : " + sumCreateJuly);
        System.out.println("Total job ended in June     : " + sumEndJuly);
        ave=sumCreateJuly/31.0;
        System.out.printf("Average job created in June : %.1f\n" , ave);
        ave=sumEndJuly/31.0;
        System.out.printf("Average job ended in June   : %.1f\n" , ave);
        for(int i=0;i<31;i++){
            if(numJobCreateJuly[i]>maxCreate){
                maxCreate = numJobCreateJuly[i];dayMaxCreate = i+1;}
            if(numJobCreateJuly[i]<minCreate){
                minCreate = numJobCreateJuly[i];dayMinCreate = i+1;}
            if(numJobEndJuly[i]>maxEnd){
                maxEnd = numJobEndJuly[i];dayMaxEnd = i+1;}
            if(numJobEndJuly[i]<minCreate){
                minEnd = numJobEndJuly[i];dayMinEnd = i+1;}
        }
        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

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
        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");

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
        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");


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
        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");


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
        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");


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
        System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
        System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
        System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
        System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
    }

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
}
