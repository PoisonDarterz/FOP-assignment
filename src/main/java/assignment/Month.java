//package restructure;
//
//import java.io.*;
//import java.util.Scanner;
//import java.util.Arrays;
//import java.util.ArrayList;
//
//public class Month {
//
//    public static void totalMonthJobCreateEnd(String fileName) throws FileNotFoundException{
//        Scanner input = new Scanner(System.in);
//
//        String data;
//        String month = "";
//        String day = "";
//        double ave = 0.0;
//        int m=0;
//        int d=0;
//
//        int sumCreateJun = 0;
//        int sumEndJun = 0;
//        int [] numJobCreateJun = new int[30];
//        int [] numJobEndJun = new int[30];
//
//        int sumCreateJune = 0;
//        int sumEndJune = 0;
//        int [] numJobCreateJune = new int[31];
//        int [] numJobEndJune = new int[31];
//
//        int sumCreateAus = 0;
//        int sumEndAus = 0;
//        int [] numJobCreateAus = new int[31];
//        int [] numJobEndAus = new int[31];
//
//        int sumCreateSep = 0;
//        int sumEndSep = 0;
//        int [] numJobCreateSep = new int[30];
//        int [] numJobEndSep = new int[30];
//
//        int sumCreateOct = 0;
//        int sumEndOct = 0;
//        int [] numJobCreateOct = new int[31];
//        int [] numJobEndOct = new int[31];
//
//        int sumCreateNov = 0;
//        int sumEndNov = 0;
//        int [] numJobCreateNov = new int[30];
//        int [] numJobEndNov = new int[30];
//
//        int sumCreateDec = 0;
//        int sumEndDec = 0;
//        int [] numJobCreateDec = new int[16];
//        int [] numJobEndDec = new int[16];
//
//        int searchMonthStart =0,searchMonthEnd =0;
//        int searchDayStart   =0,searchDayEnd =0;
//        int searchHourStart  =0,searchHourEnd =0;
//        int searchMinStart   =0,searchMinEnd =0;
//        int searchSecStart=0,searchSecEnd =0;
//        int searchMilliSecStart=0,searchMilliSecEnd=0;
//
//        int MonthStart =0,MonthEnd =0;
//        int DayStart   =0,DayEnd =0;
//        int HourStart  =0,HourEnd =0;
//        int MinStart   =0,MinEnd =0;
//        int SecStart=0,SecEnd =0;
//        int MilliSecStart=0,MilliSecEnd=0;
//
//        boolean foundStart = false;
//        boolean foundEnd = false;
//        boolean count = true;
//
//        int numSearchStart = 0;
//        int numSearchEnd = 0;
//
//        int command = 0;
//        System.out.println("1 . Search month data ");
//        System.out.println("2 . Search data  within given time range");
//        System.out.println("-1. Exit");
//        System.out.print("command -> ");
//        command = input.nextInt();
//
//        ArrayList date = new ArrayList();
//
//        if(command == 2){
//
//
//            System.out.println("\nStart Time");
//            System.out.println("-----------------------");
//            System.out.print("Start month        : ");
//            searchMonthStart = input.nextInt();
//            System.out.print("Start day          : ");
//            searchDayStart = input.nextInt();
//
//            System.out.println("");
//
//            System.out.println("End Time");
//            System.out.println("-----------------------");
//            System.out.print("End month          : ");
//            searchMonthEnd = input.nextInt();
//            System.out.print("End day            : ");
//            searchDayEnd = input.nextInt();
//
//            System.out.println();
//
//            System.out.println("User's input");
//            System.out.println("-------------------------------------------");
//            System.out.println("Start Time - [ 2022-" + searchMonthStart + "-" + searchDayStart + " ]");
//            System.out.println("End   Time - [ 2022-" + searchMonthEnd + "-" + searchDayEnd  + " ]");
//
//        }
//
//        try{
//            BufferedReader read = new BufferedReader(new FileReader(fileName));
//            data = read.readLine();
//            while(data!=null){
//
//                int num = data.split(" ").length;
//                String [] content = new String[num];
//                content = data.split(" ");
//
//                date.add(content[0]);
//
//                //ALLOCATE NUMBER OF JOBS CREATED AND ENDED BY DAYS AND MONTHS
//                month = data.substring(6,8);
//                day = data.substring(9,11);
//                d = Integer.parseInt(day);
//                if(month.equals("06")){
//                    for(String content2 : content){
//                        if(content2.equals("Allocate")){
//                            numJobCreateJun[d-1]+=1;}
//                        if(content2.equals("done")){
//                            numJobEndJun[d-1]+=1;}
//                    }
//                }
//
//                if(month.equals("07")){
//                    for(String content2 : content){
//                        if(content2.equals("Allocate")){
//                            numJobCreateJune[d-1]+=1;}
//                        if(content2.equals("done")){
//                            numJobEndJune[d-1]+=1;}
//                    }
//                }
//
//                if(month.equals("08")){
//                    for(String content2 : content){
//                        if(content2.equals("Allocate")){
//                            numJobCreateAus[d-1]+=1;}
//                        if(content2.equals("done")){
//                            numJobEndAus[d-1]+=1;}
//                    }
//                }
//
//                if(month.equals("09")){
//                    for(String content2 : content){
//                        if(content2.equals("Allocate")){
//                            numJobCreateSep[d-1]+=1;}
//                        if(content2.equals("done")){
//                            numJobEndSep[d-1]+=1;}
//                    }
//                }
//
//                if(month.equals("10")){
//                    for(String content2 : content){
//                        if(content2.equals("Allocate")){
//                            numJobCreateOct[d-1]+=1;}
//                        if(content2.equals("done")){
//                            numJobEndOct[d-1]+=1;}
//                    }
//                }
//
//                if(month.equals("11")){
//                    for(String content2 : content){
//                        if(content2.equals("Allocate")){
//                            numJobCreateNov[d-1]+=1;}
//                        if(content2.equals("done")){
//                            numJobEndNov[d-1]+=1;}
//                    }
//                }
//
//                if(month.equals("12")){
//                    for(String content2 : content){
//                        if(content2.equals("Allocate")){
//                            numJobCreateDec[d-1]+=1;}
//                        if(content2.equals("done")){
//                            numJobEndDec[d-1]+=1;}
//                    }
//                }
///////////////////// COMMAND 2
//                if(command == 2){
//
//                    /////////////CHECK WHETHER THE INPUT START DATE EXIST OR NOT
//                    MonthStart = Integer.parseInt(content[0].substring(6,8));
//                    DayStart = Integer.parseInt(content[0].substring(9,11));
//
//                    MonthEnd = Integer.parseInt(content[0].substring(6,8));
//                    DayEnd = Integer.parseInt(content[0].substring(9,11));
//
//                    if(count){
//                        if(searchMonthStart == MonthStart && searchDayStart == DayStart){
//                            foundStart = true;
//                        }
//                        if(foundStart){
//                            for(String content2 : content){
//                                if(content2.equals("Allocate")){
//                                    numSearchStart++;}
//                                if(content2.equals("done")){
//                                    numSearchEnd++;}
//                            }
//                            if(searchMonthEnd == MonthEnd && searchDayEnd == DayEnd){
//                                foundEnd = true;
//                                count = false;
//                            }
//                        }   ////// END THE SEARCH MONTH START IF
//                    }   ////// END WHETHER NEED TO END COUNT IF
//
//                }             ////////////////////////////// END COMMAND 2
//
//
//                data = read.readLine();
//            }
//        }
//        catch(FileNotFoundException e){System.out.println("File Not Found");}
//        catch(IOException e){System.out.println("Error occurs while editing file");}
//
//////////COMMAND 2 OUTSIDE THE READ FILE CLASS
//
//        if(command == 2){
//            System.out.println("\nSystem search");
//            System.out.println("-------------------------------------------");
//            if(foundStart){
//                System.out.println("Start Time [ 2022-" + searchMonthStart + "-" + searchDayStart + " ]    : FOUND");
//            }
//            else if(!foundStart){
//                System.out.println("Start Time [2022-" + searchMonthStart + "-" + searchDayStart + " ]   : NOT FOUND");
//            }
//
//            if(foundEnd){
//                System.out.println("End   Time [ 2022-" + searchMonthEnd + "-" + searchDayEnd + " ]    : FOUND");
//            }
//            else if(!foundEnd){
//                System.out.println("End   Time [ 2022-" + searchMonthEnd + "-" + searchDayEnd + " ]  : NOT FOUND");
//            }
//
//            if(foundStart && foundEnd){
//                System.out.println("\n");
//                System.out.println("Total number of job created within the given time range : " + numSearchStart);
//                System.out.println("Total number of job endeed  within the given time range : " + numSearchEnd);
//
//                System.out.println();
//
///////////////////Search day start
//                for(int i=0;i<=(searchMonthEnd - searchMonthStart);i++){
//
//                    if(searchMonthEnd - searchMonthStart == 0){
//                        System.out.println("Month : " + searchMonthStart);
//                        System.out.printf("%-30s","Day                      |");
//
//////////////////INCOMPLETED
//////////////////Month 6,9,11 got 30 days
////////////////// **** 3 Conditions
////////////////// **** 1.same month
////////////////// **** 2.cross 2 months
////////////////// **** 2.cross 2 months above
//
//                        for(int j=searchDayStart;j<=searchDayEnd;j++){
//                            System.out.printf("%-5d",j);
//                        }
//
//                        System.out.println();
///////////////////COMPLETED JOB == 0
//
//                        System.out.printf("%-30s","Number of completed job  |");
//                        if(searchMonthStart == 6){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobCreateJun[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 7){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobCreateJune[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 8){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobCreateAus[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 9){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobCreateSep[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 10){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobCreateOct[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 11){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobCreateNov[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 12){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobCreateDec[k-1]);
//                            }
//                        }
//                        System.out.printf("\n%-30s","Number of ended    job   |");
//                        if(searchMonthStart == 6){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobEndJun[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 7){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobEndJune[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 8){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobEndAus[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 9){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobEndSep[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 10){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobEndOct[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 11){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobEndNov[k-1]);
//                            }
//                        }
//                        else if(searchMonthStart == 12){
//                            for(int k = searchDayStart;k<=searchDayEnd;k++){
//                                System.out.printf("%-5d",numJobEndNov[k-1]);
//                            }
//                        }
//
//                    }    //////////////// End searchTImeStart - searchTimeEnd = 0
//
//
//                    //////////////// End searchTImeStart - searchTimeEnd = 1
//
//                    else if(searchMonthEnd - searchMonthStart == 1){
//                        if(i == 0){
//                            System.out.println("Month : " + searchMonthStart);
//                            System.out.printf("%-30s","Day                      |");
//
//                            if(searchMonthStart == 6 || searchMonthStart == 9 || searchMonthStart == 11 ){
//                                for(int j=searchDayStart;j<=30;j++){
//                                    System.out.printf("%-5d" , j);
//                                }}
//
//                            //////////////////Month 7,8,10 got 31 days
//                            else if(searchMonthStart == 7 || searchMonthStart == 8 || searchMonthStart == 10 ){
//                                for(int j=searchDayStart;j<=31;j++){
//                                    System.out.printf("%-5d" , j);
//                                }}
//
////////////////////Month 12 got 16 days
//                            else if(searchMonthStart == 12){
//                                for(int j=searchDayStart;j<=16;j++){
//                                    System.out.printf("%-5d" , j);
//                                }}
//
//                            System.out.printf("\n%-30s","Number of completed job  |");
//                            if(searchMonthStart == 6){
//                                for(int k = searchDayStart;k<=30;k++){
//                                    System.out.printf("%-5d",numJobCreateJun[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 7){
//                                for(int k = searchDayStart;k<=31;k++){
//                                    System.out.printf("%-5d",numJobCreateJune[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 8){
//                                for(int k = searchDayStart;k<=31;k++){
//                                    System.out.printf("%-5d",numJobCreateAus[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 9){
//                                for(int k = searchDayStart;k<=30;k++){
//                                    System.out.printf("%-5d",numJobCreateSep[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 10){
//                                for(int k = searchDayStart;k<=31;k++){
//                                    System.out.printf("%-5d",numJobCreateOct[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 11){
//                                for(int k = searchDayStart;k<=30;k++){
//                                    System.out.printf("%-5d",numJobCreateNov[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 12){
//                                for(int k = searchDayStart;k<=16;k++){
//                                    System.out.printf("%-5d",numJobCreateDec[k-1]);
//                                }
//                            }
//                            System.out.printf("\n%-30s","Number of ended    job   |");
//                            if(searchMonthStart == 6){
//                                for(int k = searchDayStart;k<=30;k++){
//                                    System.out.printf("%-5d",numJobEndJun[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 7){
//                                for(int k = searchDayStart;k<=31;k++){
//                                    System.out.printf("%-5d",numJobEndJune[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 8){
//                                for(int k = searchDayStart;k<=31;k++){
//                                    System.out.printf("%-5d",numJobEndAus[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 9){
//                                for(int k = searchDayStart;k<=30;k++){
//                                    System.out.printf("%-5d",numJobEndSep[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 10){
//                                for(int k = searchDayStart;k<=31;k++){
//                                    System.out.printf("%-5d",numJobEndOct[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 11){
//                                for(int k = searchDayStart;k<=30;k++){
//                                    System.out.printf("%-5d",numJobEndNov[k-1]);
//                                }
//                            }
//                            else if(searchMonthStart == 12){
//                                for(int k = searchDayStart;k<=16;k++){
//                                    System.out.printf("%-5d",numJobEndNov[k-1]);
//                                }
//                            }
//
//                        }    /////// i == 0 searchTimeStart - searchTimeEnd == 1
//
//                        else if(i == 1){
//                            System.out.println("\n\nMonth : " + searchMonthEnd);
//                            System.out.printf("%-30s","Day                      |");
//
//                            if(searchMonthEnd == 6 || searchMonthEnd == 9 || searchMonthEnd == 11 ){
//                                for(int j=1;j<=searchDayEnd;j++){
//                                    System.out.printf("%-5d" , j);
//                                }}
//
//                            //////////////////Month 7,8,10 got 31 days
//                            else if(searchMonthEnd == 7 || searchMonthEnd == 8 || searchMonthEnd == 10 ){
//                                for(int j=1;j<=searchDayEnd;j++){
//                                    System.out.printf("%-5d" , j);
//                                }}
//
////////////////////Month 12 got 16 days
//                            else if(searchMonthEnd == 12){
//                                for(int j=1;j<=searchDayEnd;j++){
//                                    System.out.printf("%-5d" , j);
//                                }}
//
//                            System.out.printf("\n%-30s","Number of completed job  |");
//                            if(searchMonthEnd == 6){
//                                for(int k = 1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobCreateJun[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 7){
//                                for(int k = 1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobCreateJune[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 8){
//                                for(int k = 1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobCreateAus[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 9){
//                                for(int k = 1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobCreateSep[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 10){
//                                for(int k = 1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobCreateOct[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 11){
//                                for(int k = 1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobCreateNov[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 12){
//                                for(int k = 1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobCreateDec[k-1]);
//                                }
//                            }
//                            System.out.printf("\n%-30s","Number of ended    job   |");
//                            if(searchMonthEnd == 6){
//                                for(int k =1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobEndJun[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 7){
//                                for(int k =1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobEndJune[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 8){
//                                for(int k =1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobEndAus[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 9){
//                                for(int k =1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobEndSep[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 10){
//                                for(int k =1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobEndOct[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 11){
//                                for(int k =1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobEndNov[k-1]);
//                                }
//                            }
//                            else if(searchMonthEnd == 12){
//                                for(int k =1;k<=searchDayEnd;k++){
//                                    System.out.printf("%-5d",numJobEndNov[k-1]);
//                                }
//                            }
//                        }    /////////////// END FOR (i == 1) searchTimeStart - searchTimeEnd = 1
//
//                        /////////////// START FOR searchTimeStart - searchTimeEnd >= 1
//
//
////////////////////  THIS PART UNABLE TO RUN *******************
//                        else if((searchMonthEnd - searchMonthStart) > 1){
//                            System.out.println(searchMonthEnd - searchMonthStart);
//                            /////// (i = 0) searchMonthEnd - searchMonthStart > 1
//
//                            if(i == 0){
//                                System.out.println("Month : " + searchMonthStart);
//                                System.out.printf("%-30s","Day                      |");
//
//                                if(searchMonthStart == 6 || searchMonthStart == 9 || searchMonthStart == 11 ){
//                                    for(int j=searchDayStart;j<=30;j++){
//                                        System.out.printf("%-5d" , j);
//                                    }}
//
//                                //////////////////Month 7,8,10 got 31 days
//                                else if(searchMonthStart == 7 || searchMonthStart == 8 || searchMonthStart == 10 ){
//                                    for(int j=searchDayStart;j<=31;j++){
//                                        System.out.printf("%-5d" , j);
//                                    }}
//
////////////////////Month 12 got 16 days
//                                else if(searchMonthStart == 12){
//                                    for(int j=searchDayStart;j<=16;j++){
//                                        System.out.printf("%-5d" , j);
//                                    }}
//
//                                System.out.printf("\n%-30s","Number of completed job  |");
//                                if(searchMonthStart == 6){
//                                    for(int k = searchDayStart;k<=30;k++){
//                                        System.out.printf("%-5d",numJobCreateJun[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 7){
//                                    for(int k = searchDayStart;k<=31;k++){
//                                        System.out.printf("%-5d",numJobCreateJune[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 8){
//                                    for(int k = searchDayStart;k<=31;k++){
//                                        System.out.printf("%-5d",numJobCreateAus[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 9){
//                                    for(int k = searchDayStart;k<=30;k++){
//                                        System.out.printf("%-5d",numJobCreateSep[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 10){
//                                    for(int k = searchDayStart;k<=31;k++){
//                                        System.out.printf("%-5d",numJobCreateOct[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 11){
//                                    for(int k = searchDayStart;k<=30;k++){
//                                        System.out.printf("%-5d",numJobCreateNov[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 12){
//                                    for(int k = searchDayStart;k<=16;k++){
//                                        System.out.printf("%-5d",numJobCreateDec[k-1]);
//                                    }
//                                }
//                                System.out.printf("\n%-30s","Number of ended    job   |");
//                                if(searchMonthStart == 6){
//                                    for(int k = searchDayStart;k<=30;k++){
//                                        System.out.printf("%-5d",numJobEndJun[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 7){
//                                    for(int k = searchDayStart;k<=31;k++){
//                                        System.out.printf("%-5d",numJobEndJune[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 8){
//                                    for(int k = searchDayStart;k<=31;k++){
//                                        System.out.printf("%-5d",numJobEndAus[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 9){
//                                    for(int k = searchDayStart;k<=30;k++){
//                                        System.out.printf("%-5d",numJobEndSep[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 10){
//                                    for(int k = searchDayStart;k<=31;k++){
//                                        System.out.printf("%-5d",numJobEndOct[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 11){
//                                    for(int k = searchDayStart;k<=30;k++){
//                                        System.out.printf("%-5d",numJobEndNov[k-1]);
//                                    }
//                                }
//                                else if(searchMonthStart == 12){
//                                    for(int k = searchDayStart;k<=16;k++){
//                                        System.out.printf("%-5d",numJobEndNov[k-1]);
//                                    }
//                                }
//                            }      /////// END (i = 0) searchMonthEnd - searchMonthStart >= 1
//
//
//                            /////// (i = 0) searchMonthEnd - searchMonthStart >= 1
//                            else if(i > 0 && i < searchMonthEnd){
//
//                                /////////////// START FOR
//                                for(int n = 1;n < searchMonthEnd;n++){
//                                    int temptMonthStart = searchMonthStart + n;
//
//                                    System.out.println("\n\nMonth : " + (temptMonthStart));
//                                    System.out.printf("%-30s","Day                      |");
//
//                                    if(temptMonthStart == 6 || temptMonthStart == 9 || temptMonthStart == 11 ){
//                                        for(int j=1;j<=30;j++){
//                                            System.out.printf("%-5d" , j);
//                                        }}
//
//                                    //////////////////Month 7,8,10 got 31 days
//                                    else if(temptMonthStart == 7 || temptMonthStart == 8 || temptMonthStart == 10 ){
//                                        for(int j=1;j<=31;j++){
//                                            System.out.printf("%-5d" , j);
//                                        }}
//
////////////////////Month 12 got 16 days
//                                    else if(temptMonthStart == 12){
//                                        for(int j=1;j<=16;j++){
//                                            System.out.printf("%-5d" , j);
//                                        }}
//
//                                    System.out.printf("\n%-30s","Number of completed job  |");
//                                    if(temptMonthStart == 6){
//                                        for(int k = 1;k<=30;k++){
//                                            System.out.printf("%-5d",numJobCreateJun[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 7){
//                                        for(int k = 1;k<=31;k++){
//                                            System.out.printf("%-5d",numJobCreateJune[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 8){
//                                        for(int k = 1;k<=31;k++){
//                                            System.out.printf("%-5d",numJobCreateAus[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 9){
//                                        for(int k = 1;k<=30;k++){
//                                            System.out.printf("%-5d",numJobCreateSep[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 10){
//                                        for(int k = 1;k<=31;k++){
//                                            System.out.printf("%-5d",numJobCreateOct[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 11){
//                                        for(int k = 1;k<=30;k++){
//                                            System.out.printf("%-5d",numJobCreateNov[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 12){
//                                        for(int k = 1;k<=16;k++){
//                                            System.out.printf("%-5d",numJobCreateDec[k-1]);
//                                        }
//                                    }
//                                    System.out.printf("\n%-30s","Number of ended    job   |");
//                                    if(temptMonthStart == 6){
//                                        for(int k =1;k<=30;k++){
//                                            System.out.printf("%-5d",numJobEndJun[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 7){
//                                        for(int k =1;k<=31;k++){
//                                            System.out.printf("%-5d",numJobEndJune[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 8){
//                                        for(int k =1;k<=31;k++){
//                                            System.out.printf("%-5d",numJobEndAus[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 9){
//                                        for(int k =1;k<=30;k++){
//                                            System.out.printf("%-5d",numJobEndSep[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart== 10){
//                                        for(int k =1;k<=31;k++){
//                                            System.out.printf("%-5d",numJobEndOct[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 11){
//                                        for(int k =1;k<=30;k++){
//                                            System.out.printf("%-5d",numJobEndNov[k-1]);
//                                        }
//                                    }
//                                    else if(temptMonthStart == 12){
//                                        for(int k =1;k<=16;k++){
//                                            System.out.printf("%-5d",numJobEndNov[k-1]);
//                                        }
//                                    }
//
//                                }
//                                /////////////// END FOR LOOP
//
//                            }      /////// END (i = 0) searchMonthEnd - searchMonthStart >= 1
//
//
//
//                            /////// (i = 0) searchMonthEnd - searchMonthStart >= 1
//                            else if(i == searchMonthEnd){
//
//                                System.out.println("\n\nMonth : " + searchMonthEnd);
//                                System.out.printf("%-30s","Day                      |");
//
//                                if(searchMonthEnd == 6 || searchMonthEnd == 9 || searchMonthEnd == 11 ){
//                                    for(int j=1;j<=searchDayEnd;j++){
//                                        System.out.printf("%-5d" , j);
//                                    }}
//
//                                //////////////////Month 7,8,10 got 31 days
//                                else if(searchMonthEnd == 7 || searchMonthEnd == 8 || searchMonthEnd == 10 ){
//                                    for(int j=1;j<=searchDayEnd;j++){
//                                        System.out.printf("%-5d" , j);
//                                    }}
//
////////////////////Month 12 got 16 days
//                                else if(searchMonthEnd == 12){
//                                    for(int j=1;j<=searchDayEnd;j++){
//                                        System.out.printf("%-5d" , j);
//                                    }}
//
//                                System.out.printf("\n%-30s","Number of completed job  |");
//                                if(searchMonthEnd == 6){
//                                    for(int k = 1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobCreateJun[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 7){
//                                    for(int k = 1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobCreateJune[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 8){
//                                    for(int k = 1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobCreateAus[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 9){
//                                    for(int k = 1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobCreateSep[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 10){
//                                    for(int k = 1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobCreateOct[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 11){
//                                    for(int k = 1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobCreateNov[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 12){
//                                    for(int k = 1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobCreateDec[k-1]);
//                                    }
//                                }
//                                System.out.printf("\n%-30s","Number of ended    job   |");
//                                if(searchMonthEnd == 6){
//                                    for(int k =1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobEndJun[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 7){
//                                    for(int k =1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobEndJune[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 8){
//                                    for(int k =1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobEndAus[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 9){
//                                    for(int k =1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobEndSep[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 10){
//                                    for(int k =1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobEndOct[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 11){
//                                    for(int k =1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobEndNov[k-1]);
//                                    }
//                                }
//                                else if(searchMonthEnd == 12){
//                                    for(int k =1;k<=searchDayEnd;k++){
//                                        System.out.printf("%-5d",numJobEndNov[k-1]);
//                                    }
//                                }
//                            }       /////// END (i = 0) searchMonthEnd - searchMonthStart >= 1
//
//                        }          /////// END searchMonthEnd - searchMonthStart >= 1
//
//                    }    /////////////// END FOR DISPLAYING TABLE
//                }
//            }
//
//
//        }
//
////////// SEARCH INPUT = 1 (BY MONTH)
//        int searchMonth =0;
//
//        if(command == 1){
//            System.out.print("\nEnter month : ");
//            searchMonth = input.nextInt();
//
//            while(!(searchMonth>=6 && searchMonth <=12)){
//                System.out.println("Invalid time range");
//                System.out.print("\nEnter month : ");
//                searchMonth = input.nextInt();
//            }
//
//            if(searchMonth == 6){     /// Month 6 start //////////////
//                System.out.println("\nMonth : 6");
//                System.out.printf("%-20s","Day           |");
//                for(int i=0;i<30;i++){
//                    System.out.printf("%-5d",(i+1));
//                }
//                System.out.printf("\n%-20s","Completed job |");
//                for(int i=0;i<30;i++){
//                    sumCreateJun+=numJobCreateJun[i];
//                    System.out.printf("%-5d",numJobCreateJun[i]);
//                }
//                System.out.printf("\n%-20s","Ended job     |");
//                for(int i=0;i<30;i++){
//                    sumEndJun+=numJobEndJun[i];
//                    System.out.printf("%-5d",numJobEndJun[i]);
//                }
//
//                int minCreate =9999,dayMinCreate=0;
//                int maxCreate =-1,dayMaxCreate=0;
//                int minEnd =9999,dayMinEnd=0;
//                int maxEnd =-1,dayMaxEnd=0;
//
//
//                System.out.println("\nTotal job created in Jun   : " + sumCreateJun);
//                System.out.println("Total job ended in Jun     : " + sumEndJun);
//                ave=sumCreateJun/30.0;
//                System.out.printf("Average job created in Jun : %.1f\n" , ave);
//                ave=sumEndJun/30.0;
//                System.out.printf("Average job ended in Jun   : %.1f\n" , ave);
//                for(int i=0;i<30;i++){
//                    if(numJobCreateJun[i]>maxCreate){
//                        maxCreate = numJobCreateJun[i];dayMaxCreate = i+1;}
//                    if(numJobCreateJun[i]<minCreate){
//                        minCreate = numJobCreateJun[i];dayMinCreate = i+1;}
//                    if(numJobEndJun[i]>maxEnd){
//                        maxEnd = numJobEndJun[i];dayMaxEnd = i+1;}
//                    if(numJobEndJun[i]<minCreate){
//                        minEnd = numJobEndJun[i];dayMinEnd = i+1;}
//                }
//
//                System.out.println("\nRange of number of job created in Jun     : " + minCreate + " - " + maxCreate);
//                System.out.println("Range of number of job ended   in Jun     : " + minEnd + " - " + maxEnd);
//
//                System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//                System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//                System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//                System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//
//////////THE DATA IS SORTED
//
//                Arrays.sort(numJobCreateJun);
//                Arrays.sort(numJobEndJun);
//
//                if(numJobCreateJun.length%2 == 0){
//                    System.out.println("\nMedian of the job created in Jun : " + ((numJobCreateJun[((numJobCreateJun.length)/2)] + numJobCreateJun[((numJobCreateJun.length)/2)-1])/2));
//                }
//                else if(numJobCreateJun.length%2 == 1){
//                    System.out.println("\nMedian of the job created in Jun : " + numJobCreateJun[(numJobCreateJun.length/2)-1]);
//                }
//                if(numJobEndJun.length%2 == 0){
//                    System.out.println("Median of the job ended   in Jun : " + ((numJobEndJun[((numJobEndJun.length)/2)] + numJobEndJun[((numJobEndJun.length)/2)-1])/2));
//                }
//                else if(numJobEndJun.length%2 == 1){
//                    System.out.println("Median of the job ended   in Jun : " + numJobEndJun[(numJobEndJun.length/2)-1]);
//                }
//            }
//////////////////////////DELETED A } NOT SURE
//            int minCreate =9999,dayMinCreate=0;
//            int maxCreate =-1,dayMaxCreate=0;
//            int minEnd =9999,dayMinEnd=0;
//            int maxEnd =-1,dayMaxEnd=0;
//
//            if(searchMonth == 7){                      ///// End month 7
//                System.out.println("\n\nMonth : 7");
//                System.out.printf("%-20s","Day           |");
//                for(int i=0;i<31;i++){
//                    System.out.printf("%-5d",(i+1));
//                }
//                System.out.printf("\n%-20s","Completed job |");
//                for(int i=0;i<31;i++){
//                    sumCreateJune+=numJobCreateJune[i];
//                    System.out.printf("%-5d",numJobCreateJune[i]);
//                }
//                System.out.printf("\n%-20s","Ended job     |");
//                for(int i=0;i<31;i++){
//                    sumEndJune+=numJobEndJune[i];
//                    System.out.printf("%-5d",numJobEndJune[i]);
//                }
//                System.out.println("\nTotal job created in June   : " + sumCreateJune);
//                System.out.println("Total job ended in June     : " + sumEndJune);
//                ave=sumCreateJune/31.0;
//                System.out.printf("Average job created in June : %.1f\n" , ave);
//                ave=sumEndJune/31.0;
//                System.out.printf("Average job ended in June   : %.1f\n" , ave);
//                for(int i=0;i<31;i++){
//                    if(numJobCreateJune[i]>maxCreate){
//                        maxCreate = numJobCreateJune[i];dayMaxCreate = i+1;}
//                    if(numJobCreateJune[i]<minCreate){
//                        minCreate = numJobCreateJune[i];dayMinCreate = i+1;}
//                    if(numJobEndJune[i]>maxEnd){
//                        maxEnd = numJobEndJune[i];dayMaxEnd = i+1;}
//                    if(numJobEndJune[i]<minCreate){
//                        minEnd = numJobEndJune[i];dayMinEnd = i+1;}
//                }
//
//                System.out.println("\nRange of number of job created in June     : " + minCreate + " - " + maxCreate);
//                System.out.println("Range of number of job ended   in June     : " + minEnd + " - " + maxEnd);
//
//                System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//                System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//                System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//                System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//                Arrays.sort(numJobCreateJune);
//                Arrays.sort(numJobEndJune);
//
//                if(numJobCreateJune.length%2 == 0){
//                    System.out.println("\nMedian of the job created in June : " + ((numJobCreateJune[((numJobCreateJune.length)/2)] + numJobCreateJune[((numJobCreateJune.length)/2)-1])/2));
//                }
//                else if(numJobCreateJune.length%2 == 1){
//                    System.out.println("\nMedian of the job created in June : " + numJobCreateJune[(numJobCreateJune.length/2)-1]);
//                }
//                if(numJobEndJune.length%2 == 0){
//                    System.out.println("Median of the job ended   in June : " + ((numJobEndJune[((numJobEndJune.length)/2)] + numJobEndJune[((numJobEndJune.length)/2)-1])/2));
//                }
//                else if(numJobEndJune.length%2 == 1){
//                    System.out.println("Median of the job ended   in June : " + numJobEndJune[(numJobEndJune.length/2)-1]);
//                }
//            }
//            // END MONTH 7
//            minCreate =9999;dayMinCreate=0;
//            maxCreate =-1;dayMaxCreate=0;
//            minEnd =9999;dayMinEnd=0;
//            maxEnd =-1;dayMaxEnd=0;
//            if(searchMonth == 8){
//
//                System.out.println("\n\nMonth : 8");
//                System.out.printf("%-20s","Day           |");
//                for(int i=0;i<31;i++){
//                    System.out.printf("%-5d",(i+1));
//                }
//                System.out.printf("\n%-20s","Completed job |");
//                for(int i=0;i<31;i++){
//                    sumCreateAus+=numJobCreateAus[i];
//                    System.out.printf("%-5d",numJobCreateAus[i]);
//                }
//                System.out.printf("\n%-20s","Ended job     |");
//                for(int i=0;i<31;i++){
//                    sumEndAus+=numJobEndAus[i];
//                    System.out.printf("%-5d",numJobEndAus[i]);
//                }
//                System.out.println("\nTotal job created in August   : " + sumCreateAus);
//                System.out.println("Total job ended in August     : " + sumEndAus);
//                ave=sumCreateAus/31.0;
//                System.out.printf("Average job created in August : %.1f\n" , ave);
//                ave=sumEndAus/31.0;
//                System.out.printf("Average job ended in August   : %.1f\n" , ave);
//                for(int i=0;i<31;i++){
//                    if(numJobCreateAus[i]>maxCreate){
//                        maxCreate = numJobCreateAus[i];dayMaxCreate = i+1;}
//                    if(numJobCreateAus[i]<minCreate){
//                        minCreate = numJobCreateAus[i];dayMinCreate = i+1;}
//                    if(numJobEndAus[i]>maxEnd){
//                        maxEnd = numJobEndAus[i];dayMaxEnd = i+1;}
//                    if(numJobEndAus[i]<minCreate){
//                        minEnd = numJobEndAus[i];dayMinEnd = i+1;}
//                }
//
//                System.out.println("\nRange of number of job created in Ausgust     : " + minCreate + " - " + maxCreate);
//                System.out.println("Range of number of job ended   in Ausgust     : " + minEnd + " - " + maxEnd);
//
//                System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//                System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//                System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//                System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//                Arrays.sort(numJobCreateAus);
//                Arrays.sort(numJobEndAus);
//
//                if(numJobCreateAus.length%2 == 0){
//                    System.out.println("\nMedian of the job created in Ausgust : " + ((numJobCreateAus[((numJobCreateAus.length)/2)] + numJobCreateAus[((numJobCreateAus.length)/2)-1])/2));
//                }
//                else if(numJobCreateAus.length%2 == 1){
//                    System.out.println("\nMedian of the job created in Ausgust : " + numJobCreateAus[(numJobCreateAus.length/2)-1]);
//                }
//                if(numJobEndAus.length%2 == 0){
//                    System.out.println("Median of the job ended   in Ausgust : " + ((numJobEndAus[((numJobEndAus.length)/2)] + numJobEndAus[((numJobEndAus.length)/2)-1])/2));
//                }
//                else if(numJobEndAus.length%2 == 1){
//                    System.out.println("Median of the job ended   in Ausgust : " + numJobEndAus[(numJobEndAus.length/2)-1]);
//                }
//            }         //END MONTH 8
//
//
//            if (searchMonth == 9){
//                minCreate =9999;dayMinCreate=0;
//                maxCreate =-1;dayMaxCreate=0;
//                minEnd =9999;dayMinEnd=0;
//                maxEnd =-1;dayMaxEnd=0;
//
//                System.out.println("\n\nMonth : 9");
//                System.out.printf("%-20s","Day           |");
//                for(int i=0;i<30;i++){
//                    System.out.printf("%-5d",(i+1));
//                }
//                System.out.printf("\n%-20s","Completed job |");
//                for(int i=0;i<30;i++){
//                    sumCreateSep+=numJobCreateSep[i];
//                    System.out.printf("%-5d",numJobCreateSep[i]);
//                }
//                System.out.printf("\n%-20s","Ended job     |");
//                for(int i=0;i<30;i++){
//                    sumEndSep+=numJobEndSep[i];
//                    System.out.printf("%-5d",numJobEndSep[i]);
//                }
//                System.out.println("\nTotal job created in September   : " + sumCreateSep);
//                System.out.println("Total job ended in September     : " + sumEndSep);
//                ave=sumCreateSep/30.0;
//                System.out.printf("Average job created in September : %.1f\n" , ave);
//                ave=sumEndSep/30.0;
//                System.out.printf("Average job ended in September   : %.1f\n" , ave);
//                for(int i=0;i<30;i++){
//                    if(numJobCreateSep[i]>maxCreate){
//                        maxCreate = numJobCreateSep[i];dayMaxCreate = i+1;}
//                    if(numJobCreateSep[i]<minCreate){
//                        minCreate = numJobCreateSep[i];dayMinCreate = i+1;}
//                    if(numJobEndSep[i]>maxEnd){
//                        maxEnd = numJobEndSep[i];dayMaxEnd = i+1;}
//                    if(numJobEndSep[i]<minCreate){
//                        minEnd = numJobEndSep[i];dayMinEnd = i+1;}
//                }
//
//                System.out.println("\nRange of number of job created in September     : " + minCreate + " - " + maxCreate);
//                System.out.println("Range of number of job ended   in September     : " + minEnd + " - " + maxEnd);
//
//                System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//                System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//                System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//                System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//                Arrays.sort(numJobCreateSep);
//                Arrays.sort(numJobEndSep);
//
//                if(numJobCreateSep.length%2 == 0){
//                    System.out.println("\nMedian of the job created in September : " + ((numJobCreateSep[((numJobCreateSep.length)/2)] + numJobCreateSep[((numJobCreateSep.length)/2)-1])/2));
//                }
//                else if(numJobCreateSep.length%2 == 1){
//                    System.out.println("\nMedian of the job created in September : " + numJobCreateSep[(numJobCreateSep.length/2)-1]);
//                }
//                if(numJobEndSep.length%2 == 0){
//                    System.out.println("Median of the job ended   in September : " + ((numJobEndSep[((numJobEndSep.length)/2)] + numJobEndSep[((numJobEndSep.length)/2)-1])/2));
//                }
//                else if(numJobEndSep.length%2 == 1){
//                    System.out.println("Median of the job ended   in September : " + numJobEndSep[(numJobEndSep.length/2)-1]);
//                }
//            }                                     //END MONTH 9
//
//            if(searchMonth == 10){
//                minCreate =9999;dayMinCreate=0;
//                maxCreate =-1;dayMaxCreate=0;
//                minEnd =9999;dayMinEnd=0;
//                maxEnd =-1;dayMaxEnd=0;
//
//                System.out.println("\n\nMonth : 10");
//                System.out.printf("%-20s","Day           |");
//                for(int i=0;i<31;i++){
//                    System.out.printf("%-5d",(i+1));
//                }
//                System.out.printf("\n%-20s","Completed job |");
//                for(int i=0;i<31;i++){
//                    sumCreateOct+=numJobCreateOct[i];
//                    System.out.printf("%-5d",numJobCreateOct[i]);
//                }
//                System.out.printf("\n%-20s","Ended job     |");
//                for(int i=0;i<31;i++){
//                    sumEndOct+=numJobEndOct[i];
//                    System.out.printf("%-5d",numJobEndOct[i]);
//                }
//                System.out.println("\nTotal job created in October   : " + sumCreateOct);
//                System.out.println("Total job ended in October     : " + sumEndOct);
//                ave=sumCreateOct/31.0;
//                System.out.printf("Average job created in October : %.1f\n" , ave);
//                ave=sumEndOct/31.0;
//                System.out.printf("Average job ended in October   : %.1f\n" , ave);
//                for(int i=0;i<31;i++){
//                    if(numJobCreateOct[i]>maxCreate){
//                        maxCreate = numJobCreateOct[i];dayMaxCreate = i+1;}
//                    if(numJobCreateOct[i]<minCreate){
//                        minCreate = numJobCreateOct[i];dayMinCreate = i+1;}
//                    if(numJobEndOct[i]>maxEnd){
//                        maxEnd = numJobEndOct[i];dayMaxEnd = i+1;}
//                    if(numJobEndOct[i]<minCreate){
//                        minEnd = numJobEndOct[i];dayMinEnd = i+1;}
//                }
//
//                System.out.println("\nRange of number of job created in October     : " + minCreate + " - " + maxCreate);
//                System.out.println("Range of number of job ended   in October     : " + minEnd + " - " + maxEnd);
//
//                System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//                System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//                System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//                System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//                Arrays.sort(numJobCreateOct);
//                Arrays.sort(numJobEndOct);
//
//                if(numJobCreateOct.length%2 == 0){
//                    System.out.println("\nMedian of the job created in October : " + ((numJobCreateOct[((numJobCreateOct.length)/2)] + numJobCreateOct[((numJobCreateOct.length)/2)-1])/2));
//                }
//                else if(numJobCreateOct.length%2 == 1){
//                    System.out.println("\nMedian of the job created in October : " + numJobCreateOct[(numJobCreateOct.length/2)-1]);
//                }
//                if(numJobEndOct.length%2 == 0){
//                    System.out.println("Median of the job ended   in October : " + ((numJobEndOct[((numJobEndOct.length)/2)] + numJobEndOct[((numJobEndOct.length)/2)-1])/2));
//                }
//                else if(numJobEndOct.length%2 == 1){
//                    System.out.println("Median of the job ended   in October : " + numJobEndOct[(numJobEndOct.length/2)-1]);
//                }
//            }                                     // END MONTH 10
//
//            if(searchMonth == 11){
//                minCreate =9999;dayMinCreate=0;
//                maxCreate =-1;dayMaxCreate=0;
//                minEnd =9999;dayMinEnd=0;
//                maxEnd =-1;dayMaxEnd=0;
//
//                System.out.println("\n\nMonth : 11");
//                System.out.printf("%-20s","Day           |");
//                for(int i=0;i<30;i++){
//                    System.out.printf("%-5d",(i+1));
//                }
//                System.out.printf("\n%-20s","Completed job |");
//                for(int i=0;i<30;i++){
//                    sumCreateNov+=numJobCreateNov[i];
//                    System.out.printf("%-5d",numJobCreateNov[i]);
//                }
//                System.out.printf("\n%-20s","Ended job     |");
//                for(int i=0;i<30;i++){
//                    sumEndNov+=numJobEndNov[i];
//                    System.out.printf("%-5d",numJobEndNov[i]);
//                }
//                System.out.println("\nTotal job created in November    : " + sumCreateNov);
//                System.out.println("Total job ended in November      : " + sumEndNov);
//                ave=sumCreateNov/30.0;
//                System.out.printf("Average job created in November  : %.1f\n" , ave);
//                ave=sumEndNov/30.0;
//                System.out.printf("Average job ended in November    : %.1f\n" , ave);
//                for(int i=0;i<30;i++){
//                    if(numJobCreateNov[i]>maxCreate){
//                        maxCreate = numJobCreateNov[i];dayMaxCreate = i+1;}
//                    if(numJobCreateNov[i]<minCreate){
//                        minCreate = numJobCreateNov[i];dayMinCreate = i+1;}
//                    if(numJobEndNov[i]>maxEnd){
//                        maxEnd = numJobEndNov[i];dayMaxEnd = i+1;}
//                    if(numJobEndNov[i]<minCreate){
//                        minEnd = numJobEndNov[i];dayMinEnd = i+1;}
//                }
//
//                System.out.println("\nRange of number of job created in November     : " + minCreate + " - " + maxCreate);
//                System.out.println("Range of number of job ended   in November     : " + minEnd + " - " + maxEnd);
//
//                System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//                System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//                System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//                System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//                Arrays.sort(numJobCreateNov);
//                Arrays.sort(numJobEndNov);
//
//                if(numJobCreateNov.length%2 == 0){
//                    System.out.println("\nMedian of the job created in November : " + ((numJobCreateNov[((numJobCreateNov.length)/2)] + numJobCreateNov[((numJobCreateNov.length)/2)-1])/2));
//                }
//                else if(numJobCreateNov.length%2 == 1){
//                    System.out.println("\nMedian of the job created in November : " + numJobCreateNov[(numJobCreateNov.length/2)-1]);
//                }
//                if(numJobEndNov.length%2 == 0){
//                    System.out.println("Median of the job ended   in November : " + ((numJobEndNov[((numJobEndNov.length)/2)] + numJobEndNov[((numJobEndNov.length)/2)-1])/2));
//                }
//                else if(numJobEndNov.length%2 == 1){
//                    System.out.println("Median of the job ended   in November : " + numJobEndNov[(numJobEndNov.length/2)-1]);
//                }
//            }                                      ///////  END MONTH 11
//
//            if(searchMonth == 12){
//                minCreate =9999;dayMinCreate=0;
//                maxCreate =-1;dayMaxCreate=0;
//                minEnd =9999;dayMinEnd=0;
//                maxEnd =-1;dayMaxEnd=0;
//
//                System.out.println("\n\nMonth : 12");
//                System.out.printf("%-20s","Day           |");
//                for(int i=0;i<16;i++){
//                    System.out.printf("%-5d",(i+1));
//                }
//                System.out.printf("\n%-20s","Completed job |");
//                for(int i=0;i<16;i++){
//                    sumCreateDec+=numJobCreateDec[i];
//                    System.out.printf("%-5d",numJobCreateDec[i]);
//                }
//                System.out.printf("\n%-20s","Ended job     |");
//                for(int i=0;i<16;i++){
//                    sumEndDec+=numJobEndDec[i];
//                    System.out.printf("%-5d",numJobEndDec[i]);
//                }
//                System.out.println("\nTotal job created in December   : " + sumCreateDec);
//                System.out.println("Total job ended in December     : " + sumEndDec);
//                ave=sumCreateDec/16.0;
//                System.out.printf("Average job created in December : %.1f\n" , ave);
//                ave=sumEndDec/16.0;
//                System.out.printf("Average job ended in December   : %.1f\n" , ave);
//                for(int i=0;i<16;i++){
//                    if(numJobCreateDec[i]>maxCreate){
//                        maxCreate = numJobCreateDec[i];dayMaxCreate = i+1;}
//                    if(numJobCreateDec[i]<minCreate){
//                        minCreate = numJobCreateDec[i];dayMinCreate = i+1;}
//                    if(numJobEndDec[i]>maxEnd){
//                        maxEnd = numJobEndDec[i];dayMaxEnd = i+1;}
//                    if(numJobEndDec[i]<minCreate){
//                        minEnd = numJobEndDec[i];dayMinEnd = i+1;}
//                }
//
//                System.out.println("\nRange of number of job created in December     : " + minCreate + " - " + maxCreate);
//                System.out.println("Range of number of job ended   in December     : " + minEnd + " - " + maxEnd);
//
//                System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//                System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//                System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//                System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//                Arrays.sort(numJobCreateDec);
//                Arrays.sort(numJobEndDec);
//
//                if(numJobCreateDec.length%2 == 0){
//                    System.out.println("\nMedian of the job created in December : " + ((numJobCreateDec[((numJobCreateDec.length)/2)] + numJobCreateDec[((numJobCreateDec.length)/2)-1])/2));
//                }
//                else if(numJobCreateDec.length%2 == 1){
//                    System.out.println("\nMedian of the job created in December : " + numJobCreateDec[(numJobCreateDec.length/2)-1]);
//                }
//                if(numJobEndDec.length%2 == 0){
//                    System.out.println("Median of the job ended   in December : " + ((numJobEndDec[((numJobEndDec.length)/2)] + numJobEndDec[((numJobEndDec.length)/2)-1])/2));
//                }
//                else if(numJobEndDec.length%2 == 1){
//                    System.out.println("Median of the job ended   in December : " + numJobEndDec[(numJobEndDec.length/2)-1]);
//                }
//            }                                 // END MONTH 12
//        }      // END COMMENT
//    }            // END METHOD
//
//}


//    public static void totalMonthJobCreateEnd(String fileName){
//        String data;
//        String month = "";
//        String day = "";
//        double ave = 0.0;
//        int m=0;
//        int d=0;
//
//        for (int monthtrack = 6; monthtrack <=12; monthtrack++) {
//            String monstr = "";
//            int numday = 0;
//            switch(monthtrack){
//                case 6 -> {
//                    monstr = "Jun";
//                    numday = 30;
//                }
//                case 7 -> {
//                    monstr = "Jul";
//                    numday = 31;
//                }
//                case 8 -> {
//                    monstr = "Aug";
//                    numday = 31;
//                }
//                case 9 -> {
//                    monstr = "Sep";
//                    numday = 30;
//                }
//                case 10 -> {
//                    monstr = "Oct";
//                    numday = 31;
//                }
//                case 11 -> {
//                    monstr = "Nov";
//                    numday = 30;
//                }
//                case 12 -> {
//                    monstr = "Dec";
//                    numday = 16;
//                }
//            }
//
//            numJobEnd.add(0);
//            numJobCreate.add(0);
//
//            try {
//                BufferedReader read = new BufferedReader(new FileReader(fileName));
//                data = read.readLine();
//                while (data != null) {
//
//                    int num = data.split(" ").length;
//                    String[] content = new String[num];
//                    content = data.split(" ");
//
//                    //ALLOCATE NUMBER OF JOBS CREATED AND ENDED BY DAYS AND MONTHS
//                    month = data.substring(6, 8);
//                    day = data.substring(9, 11);
//                    d = Integer.parseInt(day);
//                    LocalDateTime dateTime = Main.convertToLDT(content[0]);
//
//                    if (dateTime.getMonthValue() == monthtrack) {
//                        for (String content2 : content) {
//                            if (content2.equals("done")) {
//                                numJobCreate.add(d - 1, numJobCreate.get(d - 1) + 1);
//                            }
//                            if (content2.equals("Allocate")) {
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
//            for (int i = 0; i < numday; i++) {
//                System.out.printf("%-5d", (i + 1));
//            }
//            System.out.printf("\n%-20s", "Created job |");
//            for (int i = 0; i < numday; i++) {
//
//                if (i > 0) {
//                    sumEnd += numJobEnd.get(i)-numJobEnd.get(i-1)+1;
//                    System.out.printf("%-5d", numJobEnd.get(i)-numJobEnd.get(i-1)+1);
//                }
//                else{
//                    sumEnd += numJobEnd.get(i);
//                    System.out.printf("%-5d", numJobEnd.get(i));
//                }
//            }
//            System.out.printf("\n%-20s", "Ended job     |");
//            for (int i = 0; i < numday; i++) {
//                if (i > 0) {
//                    sumCreate += numJobCreate.get(i)-numJobCreate.get(i-1)+1;
//                    System.out.printf("%-5d", numJobCreate.get(i)-numJobCreate.get(i-1)+1);
//                }
//                else{
//                    sumCreate += numJobCreate.get(i);
//                    System.out.printf("%-5d", numJobCreate.get(i));
//                }
//            }
//
//            minCreate = numJobCreate.get(0); dayMinCreate = 1;
//            maxCreate = numJobCreate.get(0); dayMaxCreate = 1;
//            minEnd = numJobCreate.get(0); dayMinEnd = 1;
//            maxEnd = numJobCreate.get(0); dayMaxEnd = 1;
//
//            monthStart.add(sumCreate);
//            monthEnd.add(sumEnd);
//
//            System.out.println("\nTotal job created in " + monstr +   ": " + sumCreate);
//            System.out.println("Total job ended in  " + monstr +   ": " + sumEnd);
//            ave = sumCreate / (double) numday;
//            System.out.printf("Average job created in %s: %.1f\n", monstr, ave);
//            ave = sumEnd / (double) numday;
//            System.out.printf("Average job ended in %s  : %.1f\n", monstr, ave);
//            for (int i = 1; i < numday; i++) {
//                if (numJobCreate.get(i)-numJobCreate.get(i-1) > maxCreate) {
//                    maxCreate = numJobCreate.get(i)-numJobCreate.get(i-1)+1;
//                    dayMaxCreate = i + 1;
//                }
//                if (numJobCreate.get(i)-numJobCreate.get(i-1) < minCreate) {
//                    minCreate = numJobCreate.get(i)-numJobCreate.get(i-1)+1;
//                    dayMinCreate = i + 1;
//                }
//                if (numJobEnd.get(i)-numJobEnd.get(i-1) > maxEnd) {
//                    maxEnd = numJobEnd.get(i)-numJobEnd.get(i-1)+1;
//                    dayMaxEnd = i + 1;
//                }
//                if (numJobEnd.get(i)-numJobEnd.get(i-1) < minCreate) {
//                    minEnd = numJobEnd.get(i)-numJobEnd.get(i-1)+1;
//                    dayMinEnd = i + 1;
//                }
//            }
//            System.out.println("\nThe day has the highest job create is on day : " + dayMaxCreate + "( " + maxCreate + " )");
//            System.out.println("The day has the lowest  job create is on day : " + dayMinCreate + "( " + minCreate + " )");
//            System.out.println("The day has the highest job end    is on day : " + dayMaxEnd + "( " + maxEnd + " )");
//            System.out.println("The day has the lowest  job end    is on day : " + dayMinEnd + "( " + minEnd + " )");
//
//        }
//    }