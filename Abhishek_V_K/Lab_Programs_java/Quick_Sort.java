public class quicksortProg {
    public static void printArr(int arr[]){
		for (int i=0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void quicksort(int arr[], int si, int ei){
		if(si >= ei){
			return;
		}
		int pIdx = partition(arr,si,ei);
		quicksort(arr,si,pIdx-1); //left part
		quicksort(arr,pIdx+1,ei); //right part
	}

	public static int partition(int arr[], int si, int ei){
		int pivot = arr[ei]; // pivot = last element
		int i = si-1; // initialize to -1 

        for( int j=si; j<ei; j++){
            if (arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //swap the pivot with the element next to the index
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
	}

	public static void main(String args[]){
		int arr[] = {5,9,8,6,7,3};
		quicksort(arr,0,arr.length-1);
		printArr(arr);
	}
}

