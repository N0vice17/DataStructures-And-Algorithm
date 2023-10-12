def mergeSort(arr):
	if len(arr) > 1:
		mid = len(arr)//2   # Finding the mid of the array
		L = arr[:mid] 		# Dividing the array elements
		R = arr[mid:] 		# Into 2 halves
		mergeSort(L) 		# Sorting the first half
		mergeSort(R) 		# Sorting the second half
		i = j = k = 0
		while i < len(L) and j < len(R): 		# Copy data to temp arrays L[] and R[]
			if L[i] <= R[j]:
				arr[k] = L[i]
				i += 1
			else:
				arr[k] = R[j]
				j += 1
			k += 1
		while i < len(L):			# Checking if any element was left
			arr[k] = L[i]
			i += 1
			k += 1
		while j < len(R):
			arr[k] = R[j]
			j += 1
			k += 1

# Code to print the list
def printList(arr):
	for i in range(len(arr)):
		print(arr[i], end=" ")
	print()

# Driver Code
if __name__ == '__main__':
	arr = [12, 11, 13, 5, 6, 7]
	print("Given array is")
	printList(arr)
	mergeSort(arr)
	print("\nSorted array is ")
	printList(arr)

"""
Output:
Given array is
12 11 13 5 6 7 

Sorted array is 
5 6 7 11 12 13 
"""