public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
        this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
        this.second = (second >= 0 && second <= 59) ? second : 0;
    }

    public void addSeconds(int seconds) {
        if (seconds < 0) {
            subtractSeconds(Math.abs(seconds));
            return;
        }

        long totalSeconds = (long) this.hour * 3600 + (long) this.minute * 60 + this.second;
        totalSeconds += seconds;

        long secondsInDay = 24 * 3600;
        totalSeconds = (totalSeconds % secondsInDay + secondsInDay) % secondsInDay;

        // Recalculate hour, minute, second
        this.hour = (int) (totalSeconds / 3600);
        this.minute = (int) ((totalSeconds % 3600) / 60);
        this.second = (int) (totalSeconds % 60);
    }

    public void subtractSeconds(int seconds) {
        if (seconds < 0) {
            addSeconds(Math.abs(seconds));
            return;
        }

        long totalSeconds = (long) this.hour * 3600 + (long) this.minute * 60 + this.second;
        totalSeconds -= seconds;

        long secondsInDay = 24 * 3600;
        totalSeconds = (totalSeconds % secondsInDay + secondsInDay) % secondsInDay;

        this.hour = (int) (totalSeconds / 3600);
        this.minute = (int) ((totalSeconds % 3600) / 60);
        this.second = (int) (totalSeconds % 60);
    }

    public void display() {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Time Class ---");

        Time t1 = new Time(23, 59, 50);
        System.out.print("Initial Time: ");
        t1.display();

        System.out.print("Adding 20 seconds -> ");
        t1.addSeconds(20);
        t1.display();

        System.out.println();

        Time t2 = new Time(0, 0, 10);
        System.out.print("Initial Time: ");
        t2.display();

        System.out.print("Subtracting 20 seconds -> ");
        t2.subtractSeconds(20);
        t2.display();
    }
}