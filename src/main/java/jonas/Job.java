package jonas;

import java.util.LinkedHashMap;
import java.io.*;

public class Job {
    protected int c1,c2,c3,c4,c5,c6;
    protected LinkedHashMap<String, Integer> submitJob = new LinkedHashMap<>();
    protected LinkedHashMap<String, Integer> doneJob = new LinkedHashMap<>();
    protected LinkedHashMap<String, Integer> time = new LinkedHashMap<>();
    protected LinkedHashMap<String, Integer> error = new LinkedHashMap<>();
}

class SubmitComplete extends Job {
    public void splitLogFile() {
        String[] submit = {};
        try {
            String sentence;
            BufferedReader inputStream = new BufferedReader(new FileReader("./file-in/log.txt"));

            // read file
            while ((sentence = inputStream.readLine()) != null) {
                // allocation into hashmap
                if (sentence.contains("_slurm_rpc_submit_batch_job")) { // a submitted job
                    submit = sentence.split(" ");
                    String[] temp = submit;
                    for (int i = 0; i < submit.length; i++) {
                        if (submit[i].contains("JobId")) {
                            String jobID = temp[i].substring(6);
                            submitJob.put(jobID, 1);
                        }
                    }
                } else if (sentence.contains("_job_complete")) { // a completed job
                    submit = sentence.split(" ");
                    String[] temp = submit;
                    String jobID = "";
                    for (int i = 0; i < submit.length; i++) {
                        if (submit[i].contains("JobId")) {
                            jobID = temp[i].substring(6);
                            submitJob.put(jobID, 2);
//                            if(submit[i+1].contains("WEXITSTATUS") || submit[i+1].contains("OOM") || submit[i+1].contains("done") || submit[i+1].contains("cancelled") || submit[i+1].contains("WTERMSIG") ||  submit[i+1].contains("per") ||  submit[i+1].contains("due")) {
//                                break;
//                            } else {
//                                doneJob.put(jobID, Integer.parseInt(submit[submit.length - 1]));
//                            }
                        }
                        if (submit[i].contains("WEXITSTATUS") || submit[i].contains("WTERMSIG")) {
                            doneJob.put(jobID, Integer.parseInt(submit[submit.length - 1]));
                        }
//                        if (submit[i].contains("OOM")) {
//                            doneJob.put(jobID, -1);
//                        }
                    }
                } else if (sentence.contains("_slurm_rpc_kill_job")) { // a killed job
                    submit = sentence.split(" ");
                    String[] temp = submit;
                    for (int i = 0; i < submit.length; i++) {
                        if (submit[i].contains("JobId")) {
                            String jobID = temp[i].substring(6);
                            submitJob.put(jobID, 3);
                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (String key : submitJob.keySet()) {
            if(submitJob.get(key) == 1) {
                c1++;
            }
        }
        for(String key : doneJob.keySet()) {
            c2++;
        }
        System.out.println(c1 + "   " + c2);
    }
}
