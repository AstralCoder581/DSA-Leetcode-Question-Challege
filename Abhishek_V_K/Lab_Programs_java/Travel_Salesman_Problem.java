public class Main {
   static int n = 4;
   static int[][] distan = {
      {0, 22, 26, 30},
      {30, 0, 45, 35},
      {25, 45, 0, 60},
      {30, 35, 40, 0}
   };
   static int completed_visit = (1 << n) - 1;
   static int[][] DP = new int[32][8];
   static int TSP(int mark, int position) {
      if (mark == completed_visit) {
         return distan[position][0];
      }
      if (DP[mark][position] != -1) {
         return DP[mark][position];
      }
      int answer = Integer.MAX_VALUE;
      for (int city = 0; city < n; city++) {
         if ((mark & (1 << city)) == 0) {
            int newAnswer = distan[position][city] + TSP(mark | (1 << city), city);
            answer = Math.min(answer, newAnswer);
         }
      }
      DP[mark][position] = answer;
      return answer;
   }
   public static void main(String[] args) {
      for (int i = 0; i < (1 << n); i++) {
         for (int j = 0; j < n; j++) {
             DP[i][j] = -1;
         }
      }
      System.out.println("Minimum Distance Travelled -> " + TSP(1, 0));
   }
}
