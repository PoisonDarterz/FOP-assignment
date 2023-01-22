package restructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MJCE {
    static int sumCreate = 0;
    static int sumEnd = 0;
    static ArrayList<Integer> numJobCreate = new ArrayList<>();
    static ArrayList<Integer> numJobEnd = new ArrayList<>();
    static int minCreate, maxCreate, minEnd, maxEnd;
    static int dayMinCreate, dayMaxCreate, dayMinEnd, dayMaxEnd;
    static int numCompleteJob, initiateJob;
    static ArrayList<Integer> monthStart = new ArrayList<>();
    static ArrayList<Integer> monthEnd = new ArrayList<>();

    public static void totalCompletedAndEndedJob(String fileName){
        String data;

        numCompleteJob=0;
        initiateJob=0;

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
