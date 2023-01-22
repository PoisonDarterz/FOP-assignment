package restructure;

import java.time.LocalDateTime;

public class Error {
    private LocalDateTime time;
    private String username, errorType;

    public Error(LocalDateTime time, String username, String errorType) {
        this.time = time;
        this.username = username;
        this.errorType = errorType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getUser() {
        return username;
    }

    public String getError() {
        return errorType;
    }
}
