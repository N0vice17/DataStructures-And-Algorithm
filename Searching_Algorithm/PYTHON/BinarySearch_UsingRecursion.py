def binarySearch(arr,num,start,end):
  if start > end:
    return -1
  mid = start + (end-start)//2
  if arr[mid] == num:
    return mid
  elif end > mid:
    return binarysearch(arr, num, mid + 1, end)
  else:
    return binarysearch(arr, num, start, mid - 1)

if __name__ == "__main__":
  n = int(input("Enter number of elements: "))
  array=[]
  print("Enter the elements:")
  for i in range(n):
    x = int(input(""))
    array.append(x)
  num = int(input("Enter the element to search: "))
  pos = binarySearch(array, num, 0, len(array)-1)
  if pos == -1:
    print("Element is not present in the array")
  else:
    print(f"Element found at position {pos} in the array")

  
