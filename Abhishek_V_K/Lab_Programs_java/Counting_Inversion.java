public class countinversion {
    public static int merge(int[] arr, int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si, j = mid + 1, cnt = 0, k=0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else{
                temp[k++] = arr[j++];
                cnt += (mid - i + 1); }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= ei) temp[k++] = arr[j++];
        for( k= 0, i = si; k < temp.length; k++, i++) arr[i] = temp[k];
        return cnt;
    }
    public static int mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) return 0;
        int mid = si + (ei-si)/2, cnt = 0;
        cnt += mergeSort(arr, si, mid);
        cnt += mergeSort(arr, mid + 1, ei);
        cnt += merge(arr, si, mid, ei);
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 5, 6, 8, 7};
        int numberOfInversions = mergeSort(arr, 0, arr.length-1);
        System.out.println("The number of inversions are: " + numberOfInversions);
    }
}
