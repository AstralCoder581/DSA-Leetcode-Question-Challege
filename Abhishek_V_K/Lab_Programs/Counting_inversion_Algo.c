#include <stdio.h>
#include <stdlib.h>

int merge_and_count(int arr[], int temp[], int left, int mid, int right) {
    int i, j, k;
    int inv_count = 0;

    i = left;    // Starting index for left subarray
    j = mid + 1; // Starting index for right subarray
    k = left;    // Starting index to be sorted

    while ((i <= mid) && (j <= right)) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
            inv_count += (mid - i + 1);
        }
    }

    while (i <= mid)
        temp[k++] = arr[i++];

    while (j <= right)
        temp[k++] = arr[j++];

    for (i = left; i <= right; i++)
        arr[i] = temp[i];

    return inv_count;
}

int merge_sort_and_count(int arr[], int temp[], int left, int right) {
    int mid, inv_count = 0;
    if (right > left) {
        mid = (right + left) / 2;

        inv_count += merge_sort_and_count(arr, temp, left, mid);
        inv_count += merge_sort_and_count(arr, temp, mid + 1, right);

        inv_count += merge_and_count(arr, temp, left, mid, right);
    }
    return inv_count;
}

int main() {
    int arr[] = {8, 4, 2, 1};
    int n = sizeof(arr) / sizeof(arr[0]);
    int *temp = (int *)malloc(sizeof(int) * n);
    int inv_count = merge_sort_and_count(arr, temp, 0, n - 1);
    printf("Number of inversions are %d \n", inv_count);
    free(temp);
    return 0;
}
