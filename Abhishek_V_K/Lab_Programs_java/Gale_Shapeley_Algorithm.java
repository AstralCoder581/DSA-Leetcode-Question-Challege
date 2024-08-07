import java.util.*;

public class stablematching {
    static int N = 3; 
    static boolean wPrefersM1OverM(int prefer[][], int w, int m, int m1){ // This function returns true if woman 'w' prefers man 'm1' over man 'm' 
        for (int i = 0; i < N; i++){ // Check if w prefers m over her current engagement m1 
            if (prefer[w][i] == m1) return true; 
            if (prefer[w][i] == m) return false; 
        }
        return false;
    } 
 
    static void stableMarriage(int prefer[][]){ //Boys are numbered as 0 to N-1. Girls are numbered as N to 2N-1.
        int wPartner[] = new int[N]; 
        boolean mFree[] = new boolean[N]; // If mFree[i] is false, then man 'i' is free, otherwise engaged. 
        Arrays.fill(wPartner, -1); //Initialize all men and women as free
        int freeCount = N; 
        while (freeCount > 0) { // While there are free men  
            int m; 
            for (m = 0; m < N; m++) if (mFree[m] == false) break; 
            for (int i = 0; i < N && mFree[m] == false; i++) { 
                int w = prefer[m][i]; 
                if (wPartner[w - N] == -1) { 
                    wPartner[w - N] = m; 
                    mFree[m] = true; //m is engaged
                    freeCount--; 
                }else { // If w is not free
                    int m1 = wPartner[w - N]; 
                    if (wPrefersM1OverM(prefer, w, m, m1) == false){ 
                        wPartner[w - N] = m; 
                        mFree[m] = true; // m is engaged
                        mFree[m1] = false; //m1 is free
                    } 
                }
            } 
        }
        System.out.println("Woman Man"); 
        for (int i = 0; i < N; i++) System.out.println((i + N) + "	 " + wPartner[i]);
    } 
    public static void main(String[] args) { 
        int prefer[][] = new int[][]{{3, 4, 5}, 
                                     {4, 3, 5}, 
                                     {3, 4, 5}, 
                                      
                                     {0, 1, 2}, 
                                     {1, 2, 0}, 
                                     {2, 0, 1}, 
                                    }; 
        stableMarriage(prefer); 
    }
}



