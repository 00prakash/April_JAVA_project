import java.util.*;

public class Stopwatch {

    private long startTime;
    private long elapsedTime;
    private boolean isRunning;
    private List<Long> laps;

    public Stopwatch() {
        startTime = 0;
        elapsedTime = 0;
        isRunning = false;
        laps = new ArrayList<>();
    }

    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
            System.out.println("Stopwatch Started");
        } else {
            System.out.println("Already Running");
        }
    }

    public void stop() {
        if (isRunning) {
            elapsedTime += System.currentTimeMillis() - startTime;
            isRunning = false;
            System.out.println("Stopwatch Stopped");
        } else {
            System.out.println("Not Running");
        }
    }

    public void reset() {
        startTime = 0;
        elapsedTime = 0;
        isRunning = false;
        laps.clear();
        System.out.println("Stopwatch Reset");
    }

    public long getTime() {
        if (isRunning) {
            return (System.currentTimeMillis() - startTime) + elapsedTime;
        }
        return elapsedTime;
    }

    public void lap() {
        if (isRunning) {
            long lapTime = getTime();
            laps.add(lapTime);
            System.out.println("Lap " + laps.size() + ": " + formatTime(lapTime));
        } else {
            System.out.println("Start stopwatch first!");
        }
    }

    public void showLaps() {
        if (laps.isEmpty()) {
            System.out.println("No laps recorded.");
        } else {
            System.out.println("\n--- Lap Times ---");
            for (int i = 0; i < laps.size(); i++) {
                System.out.println("Lap " + (i + 1) + ": " + formatTime(laps.get(i)));
            }
        }
    }

    public String formatTime(long ms) {
        long seconds = (ms / 1000) % 60;
        long minutes = (ms / (1000 * 60)) % 60;
        long hours = (ms / (1000 * 60 * 60));

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stopwatch sw = new Stopwatch();
        int choice;

        do {
            System.out.println("\n===== STOPWATCH MENU =====");
            System.out.println("1. Start");
            System.out.println("2. Stop");
            System.out.println("3. Reset");
            System.out.println("4. Show Time");
            System.out.println("5. Record Lap");
            System.out.println("6. Show Laps");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sw.start();
                    break;
                case 2:
                    sw.stop();
                    break;
                case 3:
                    sw.reset();
                    break;
                case 4:
                    System.out.println("Time: " + sw.formatTime(sw.getTime()));
                    break;
                case 5:
                    sw.lap();
                    break;
                case 6:
                    sw.showLaps();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 7);

        sc.close();
    }
}