import java.util.*;

public class Fractionalknapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;
        double ratio[][] = new double[val.length][2];

        for (int i = 0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        //Ascending order sorting
        Arrays.sort(ratio, Comparator.comparingDouble(o ->o[1]));

        int capacity = W;
        int finVal = 0;

        //decending order sorting
        for (int i=ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                capacity -= weight[idx];
                finVal += val[idx];
            }
            else{
                finVal += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("The total profit is "+finVal);

    }
}
