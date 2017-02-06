class QuickSort {
    public void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length-1);
    }
    public void quicksort(int[] arr, int start, int end) {
        int index = partition(arr, start, end);
        if(start < index) {
           quicksort(arr, start, index-1); 
        }
        if(index < end) {
            quicksort(arr, index, end);
        }
    }
    public int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];
        while(left < right) {
            while(arr[left] < pivot) left++;
            while(pivot < arr[right]) right--;
            if(left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
