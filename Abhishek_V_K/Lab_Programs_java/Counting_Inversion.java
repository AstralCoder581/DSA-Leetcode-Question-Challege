import java.util.ArrayList;

public class countinversion {
    private static int merge(int[] arr, int si, int mid, int ei) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = si, j = mid + 1, cnt = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
                cnt += (mid - i + 1); }
        }
        while (i <= mid) temp.add(arr[i++]);
        while (j <= ei) temp.add(arr[j++]);
        for (int k = si; k <= ei; k++) arr[k] = temp.get(k - si);
        return cnt;
    }

    private static int mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) return 0;
        int mid = (si + ei) / 2;
        int cnt = 0;
        cnt += mergeSort(arr, si, mid);
        cnt += mergeSort(arr, mid + 1, ei);
        cnt += merge(arr, si, mid, ei);
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1, 5, 6, 8, 7};
        int numberOfInversions = mergeSort(a, 0, a.length - 1);
        System.out.println("The number of inversions are: " + numberOfInversions);
    }
}
