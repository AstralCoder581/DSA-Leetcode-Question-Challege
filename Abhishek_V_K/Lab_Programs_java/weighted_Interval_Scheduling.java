import java.util.*;

class Job implements Comparable<Job> {
    int start, finish, profit;
    Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
    @Override
    public int compareTo(Job other) {
        return this.finish - other.finish;
    }
}

public class weightedinterval {
    static int latestNonConflict(Job[] jobs, int index) {
        for (int j = index - 1; j >= 0; j--) {
            if (jobs[j].finish <= jobs[index].start) return j; 
        }return -1;
    }

    static int findMaxProfit(Job[] jobs) {
        Arrays.sort(jobs); // Sort jobs based on finish time
        int n = jobs.length;
        int[] dp = new int[n]; // dp[i] stores the maximum profit up to the i-th job
        dp[0] = jobs[0].profit; // Base case: profit of the first job
        for (int i = 1; i < n; i++) {
            int inclProfit = jobs[i].profit; // Include current job
            int l = latestNonConflict(jobs, i);
            if (l != -1) inclProfit += dp[l];
            dp[i] = Math.max(inclProfit, dp[i - 1]); // Store the maximum of including or excluding the current job
        }return dp[n - 1]; // The last entry in dp[] contains the result
    }
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 5, 200),
            new Job(3, 6, 300),
            new Job(4, 8, 400),
            new Job(5, 9, 500),
            new Job(6, 10, 100)
        };
        System.out.println(findMaxProfit(jobs));
    }
}
