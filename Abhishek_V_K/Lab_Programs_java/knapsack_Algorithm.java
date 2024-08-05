public class knapsack{ 
    static int knapSack(int W, int wt[], int val[], int n){
        int K[][] = new int[n+1][W+1];
        for (int i = 0; i <= n; i++){
            for (int w = 0; w <= W; w++){
                if (i==0 || w==0) K[i][w] = 0;
                else if (wt[i-1] <= w) K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else K[i][w] = K[i-1][w];
            }
        }return K[n][W];
    }
    public static void main(String args[]){ 
        int weight[] = new int[] {3, 5, 6, 2};
        int profit[] = new int[] {10, 4, 9, 11};   
        System.out.println(knapSack(7, weight, profit, profit.length)); 
    } 
} 
