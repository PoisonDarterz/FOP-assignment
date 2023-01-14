package restructure;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        String fileName = "./file-in/log.txt";

        MJCE.totalCompletedAndEndedJob(fileName);
        MJCE.totalMonthJobCreateEnd(fileName);
        Partition.jobByPartitions(fileName);
        Err_Inv.ErrorAndInvalid(fileName);
        AvExTime.averageExecutionTime(fileName);
    }

    public static LocalDateTime convertToLDT(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'['yyyy-MM-dd'T'HH:mm:ss.SSS']'");
        return LocalDateTime.parse(date, formatter);
    }
}
