import java.util.*;

public class chocolaProblem {
    public static void main(String[] args) {
        int n=4, m = 6;
        Integer cosVer[] = {2,1,3,1,4}; //m-1
        Integer cosHor[] = {4,1,2}; //n-1
        Arrays.sort(cosVer, Collections.reverseOrder());
        Arrays.sort(cosHor, Collections.reverseOrder());
        int h=0, v=0, hp=1, vp=1;
        int cost = 0;

        while(h < cosHor.length && v < cosVer.length){
            if(cosVer[v] <= cosHor[h]){
                cost += (cosHor[h] * vp);
                hp++;
                h++;
            }else{
                cost += (cosVer[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < cosHor.length) {
            cost += (cosHor[h] * vp);
            hp++;
            h++;
        }

        while (v < cosVer.length) {
            cost += (cosVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("min cost of cuts = "+ cost);

    }
}
