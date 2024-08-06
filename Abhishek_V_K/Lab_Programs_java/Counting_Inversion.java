import java.util.ArrayList;

public class countinversion {

    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        int cnt = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
                cnt += (mid - left + 1); }
        }
        while (left <= mid) temp.add(arr[left++]);
        while (right <= high) temp.add(arr[right++]);
        for (int i = low; i <= high; i++) arr[i] = temp.get(i - low);
        return cnt;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int cnt = 0;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    public static int numberOfInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        System.out.println("The number of inversions are: " + numberOfInversions(a));
    }
}
