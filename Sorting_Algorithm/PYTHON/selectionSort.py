def sort(arr):
  '''
  Method to perform selection sort to sort an array in ascending order.

  Args: arr (List)

  Returns: Sorted array (List)
  '''
  for i in range (len(arr)):
    for j in range(i+1,len(arr)):
      if arr[i] > arr[j] :
        arr[i],arr[j] = arr[j],arr[i]
  return arr

if __name__ == "__main__":
  n = int(input("Enter number of elements: "))
  array=[]
  print("Enter the elements:")
  for i in range(n):
    x = int(input())
    array.append(x)
  print(f"Original array: {array}")
  array = sort(array)
  print(f"Array after selection sort: {array}")


"""
Output:

Enter number of elements: 5
Enter the elements:
1
6
10
4
3
Original array: [1, 6, 10, 4, 3]
Array after selection sort: [1, 3, 4, 6, 10]
"""
