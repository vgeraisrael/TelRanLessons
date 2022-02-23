import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
    private long timestamp = 1000;
    private String timeFormat = "HH:mm:ss";

    public Timer(){
        this.setDaemon(true);
    }

    public Timer(long timestamp, String timeFormat){
        this.setDaemon(true);
        this.timestamp =timestamp;
        this.timeFormat = timeFormat;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public void run() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timeFormat);
        LocalTime lt = null;
        while(true) {
            lt = LocalTime.now();
            System.out.println(lt.format(dtf));
            try {
                sleep(timestamp);
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
