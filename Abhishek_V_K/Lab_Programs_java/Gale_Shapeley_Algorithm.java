import java.util.Arrays;

public class GaleShapley {
    static int N = 3; // Number of men or women

    static boolean prefers(int[][] prefer, int w, int m1, int m) {
        for (int i = 0; i < N; i++) {
            if (prefer[w][i] == m1) // If m1 comes before m in list of w, then w prefers m1
                return true;
            if (prefer[w][i] == m) // If m comes before m1 in list of w, then w prefers m
                return false;
        }
        return false;
    }

    static void stableMatching(int[][] menPref, int[][] womenPref) {
        int[] womenPartner = new int[N];
        boolean[] freeMen = new boolean[N];// Keep track of free men
        Arrays.fill(freeMen, true);
        Arrays.fill(womenPartner, -1); // Initialize all women as free
        int freeCount = N;

        while (freeCount > 0) { // While there are free men who still have a woman to propose to
            int m;
            for (m = 0; m < N; m++) {
                if (freeMen[m]) {
                    break; }
            }
            for (int i = 0; i < N && freeMen[m]; i++) { // Find the first woman on this man's list who hasn't been proposed to yet
                int w = menPref[m][i];

                if (womenPartner[w] == -1) { // If the woman is free, pair m and w
                    womenPartner[w] = m;
                    freeMen[m] = false;
                    freeCount--;
                } else {
                    int m1 = womenPartner[w];
                    if (prefers(womenPref, w, m, m1)) { // If w prefers m over her current partner m1,
                        womenPartner[w] = m; // then break the match between w and m1 and pair w with m
                        freeMen[m] = false;
                        freeMen[m1] = true; }
                }
            }
        }
        System.out.println("Woman   Man");
        for (int i = 0; i < N; i++) {
            System.out.println(" " + i + "      " + womenPartner[i]);}
    }
    public static void main(String[] args) {
        int[][] menPref = {
            {0, 1, 2},
            {1, 0, 2},
            {0, 1, 2},
        };
        int[][] womenPref = {
            {0, 1, 2},
            {1, 2, 0},
            {2, 0, 1},
        };
        stableMatching(menPref, womenPref);
    }
}
