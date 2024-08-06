public class TravelSalesman {
    static int n = 5;
    static int[][] dist = {
       {0, 2, 0, 12, 5},
       {2, 0, 4, 8, 0},
       {0, 4, 0, 3, 3},
       {12, 8, 3, 0, 10},
       {5, 0, 3, 10, 0}
    };
    static int visited = (1 << n) - 1;
    static int[][] DP = new int[32][8];
    static int TSP(int mark, int pos) {
       if (mark == visited) {
          return dist[pos][0];
       }
       if (DP[mark][pos] != -1) {
          return DP[mark][pos];
       }
       int ans = Integer.MAX_VALUE;
       for (int city = 0; city < n; city++) {
          if ((mark & (1 << city)) == 0) {
             int newAns = dist[pos][city] + TSP(mark | (1 << city), city); //(1 << city) = 2^city
             ans = Math.min(ans, newAns);
          }
       }
       DP[mark][pos] = ans;
       return ans;
    }
    public static void main(String[] args) {
       for (int i = 0; i < (1 << n); i++) { // (1 << n) = 2^n
          for (int j = 0; j < n; j++) {
              DP[i][j] = -1;
          }
       }
       System.out.println("Minimum Distance Travelled -> " + TSP(1, 0));
    }
}
