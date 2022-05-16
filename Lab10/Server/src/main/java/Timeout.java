import static java.lang.Thread.sleep;

public class Timeout implements Runnable {

    private int seconds = 120;
    public boolean connectionTimedOut = false;

    public Timeout() {
    }

    public Timeout(int seconds) {
        this.seconds = seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        while (seconds != 0) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds--;
        }
        connectionTimedOut = true;
    }
}