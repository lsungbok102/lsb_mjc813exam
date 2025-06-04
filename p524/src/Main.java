import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd aHH:mm:ss");
        LocalDateTime stardateTime = LocalDateTime.of(2021, 1,1,0,0,0);
        System.out.println("시작일: " + startDateTime.format(dtf));

    }
}