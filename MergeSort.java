
class MergeSort {
    public void mergesort(int[] arr) {
        int[] helper = new int[arr.length];
        mergesort(arr, helper, 0, arr.length-1);
    }
    private void mergesort(int[] arr, int[] helper, int start, int end) {
        if(start < end) {
            int mid = (start+end)/2;
            mergesort(arr, helper, start, mid);
            mergesort(arr, helper, mid+1, end);
            merge(arr, helper, start, mid, end);
        }
    }
    private void merge(int[] arr, int[] helper, int start, int mid, int end) {
        for(int i=start; i<=end; i++) {
            helper[i] = arr[i];
        }
        int leftIndex = start;
        int rightIndex = mid+1;
        int current = start;
        while(leftIndex <= mid && rightIndex <= end) {
            if(helper[leftIndex] <= helper[rightIndex]) {
                arr[current] = helper[leftIndex];
                leftIndex++;
            } else {
                arr[current] = helper[rightIndex];
                rightIndex++;
            }
            current++;
        }
        int remaining = mid - leftIndex;
        for(int i=0; i<=remaining; i++) {
            arr[i+current] = helper[i+leftIndex];
        }
        
    }
}
