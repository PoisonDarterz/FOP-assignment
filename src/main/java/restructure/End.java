package restructure;

import java.time.LocalDateTime;

public class End {
    private LocalDateTime time;
    private String jobID;

    public End(LocalDateTime time, String jobID) {
        this.time = time;
        this.jobID = jobID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getJobID() {
        return jobID;
    }
}
