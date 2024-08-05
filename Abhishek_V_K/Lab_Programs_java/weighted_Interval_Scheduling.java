import java.util.*;

class Job {
    int start, end, profit;

    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class weightedinterval {
    
    private static int findNonConflictingJob(Job[] jobs, int index) {
        for (int j = index - 1; j >= 0; j--) {
            if (jobs[j].end <= jobs[index].start) {
                return j;
            }
        }
        return -1;
    }

    public static int maximum(Job[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));
        int[] T = new int[jobs.length];
        T[0] = jobs[0].profit;

        for (int i = 1; i < jobs.length; i++) {
            int includeProfit = jobs[i].profit;
            int nonConflictingIndex = findNonConflictingJob(jobs, i);
            if (nonConflictingIndex != -1) {
                includeProfit += T[nonConflictingIndex];
            }
            T[i] = Math.max(includeProfit, T[i - 1]);
        }
        
        return Arrays.stream(T).max().orElse(0);
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 3, 5),
            new Job(2, 5, 6),
            new Job(4, 6, 5),
            new Job(6, 7, 4),
            new Job(5, 8, 11),
            new Job(7, 9, 2)
        };
        
        System.out.println(maximum(jobs));
    }
}
