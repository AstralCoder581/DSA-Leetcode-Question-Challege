public class rotatedbinSerch {
    
    public static int search(int arr[], int si, int tar, int ei){
        int mid = si + (ei-si)/2;
        if (si > ei){
            return -1;
        }

        if(arr[mid] == tar){
            return mid;
        }

        if (arr[si] <= arr[mid]){
            if (arr[si]<=tar && tar<=arr[mid]){
                return search(arr, si, tar, mid-1);
            }else{
                return search(arr, mid+1, tar, ei);
            }
        }else{
            if (arr[mid]<=tar && tar<=arr[ei]){
                return search(arr, mid+1, tar, ei);
            }else{
                return search(arr, si, tar, mid-1);
            }
        }
        
    }

    public static void main(String args[]){
        int arr[] = {1,8,3,10,9,7};
        int tar = 9;
        int tInx = search(arr, 0, tar, arr.length-1);
        System.out.println(tInx);
    }
}
