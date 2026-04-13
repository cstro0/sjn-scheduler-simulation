import java.util.*;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int deadline;

    int completionTime;
    boolean completed;

    Process(int id, int arrivalTime, int burstTime, int deadline) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.deadline = deadline;
        this.completed = false;
    }
}

public class SJN {

    public static void main(String[] args) {

        List<Process> processes = generateProcesses(100);

        int time = 0;
        int completed = 0;

        while (completed < processes.size()) {

            Process shortest = null;
            int minRemaining = Integer.MAX_VALUE;

            for (Process p : processes) {
                if (p.arrivalTime <= time && !p.completed && p.remainingTime > 0) {
                    if (p.remainingTime < minRemaining) {
                        minRemaining = p.remainingTime;
                        shortest = p;
                    }
                }
            }

            if (shortest == null) {
                time++;
                continue;
            }

            shortest.remainingTime--;
            time++;

            if (shortest.remainingTime == 0) {
                shortest.completed = true;
                shortest.completionTime = time;
                completed++;
            }
        }

        System.out.println("ID | Arrival | Burst | Deadline | Completion | Met Deadline");
        System.out.println("------------------------------------------------------------");

        for (Process p : processes) {
            boolean metDeadline = p.completionTime <= p.deadline;

            System.out.println(
                p.id + " | " +
                p.arrivalTime + " | " +
                p.burstTime + " | " +
                p.deadline + " | " +
                p.completionTime + " | " +
                (metDeadline ? "YES" : "NO")
            );
        }
    }

    public static List<Process> generateProcesses(int n) {

        List<Process> list = new ArrayList<>();

        int[] burstCycle = {5, 10, 20, 30, 40, 50};
        int[] deadlineCycle = {10, 20, 40, 60, 80, 100};

        int arrival = 0;

        for (int i = 0; i < n; i++) {

            int burst = burstCycle[i % burstCycle.length];
            int deadline = arrival + deadlineCycle[i % deadlineCycle.length];

            list.add(new Process(i, arrival, burst, deadline));

            if ((i + 1) % 5 == 0) {
                arrival += 5;
            }
        }

        return list;
    }
}
