def binarySearchIter(arr, value):
    start = 0
    end = len(arr)-1
    while start <= end:
        mid = int((start+end)/2)
        if arr[mid] < value:
            start = mid+1
        elif arr[mid] > value:
            end = mid-1
        else:
            return mid
        
    return -1

def binarySearchRec(arr,value, start, end):
    if start > end:
        return -1
    mid = int((start+end)/2)
    if arr[mid] < value:
        return binarySearchRec(arr,value, mid+1, end)
    elif arr[mid] > value:
        return binarySearchRec(arr,value, start, mid-1)
    else:
        return mid
    

if __name__ == "__main__" :
    arr = [1,3,6,7,8,9]
    print ("%d" %(binarySearchIter(arr,28)))
    print(binarySearchIter(arr,8))
