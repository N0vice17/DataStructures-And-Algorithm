'''
@Author: hariom09090
'''

def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2
    
    # If the left child exists and is greater than the root
    if left < n and arr[left] > arr[largest]:
        largest = left
    
    # If the right child exists and is greater than the largest so far
    if right < n and arr[right] > arr[largest]:
        largest = right
    
    # Change the root if needed
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # Swap
        heapify(arr, n, largest)

def heap_sort(arr):
    n = len(arr)
    
    # Max heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)
    
    # Extract elements one by one
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # Swap
        heapify(arr, i, 0)

if __name__ == "__main__":
    input_list = input("Enter a list of numbers separated by spaces: ").split()
    input_list = [int(x) for x in input_list]
    
    heap_sort(input_list)
    
    print("Sorted list:", input_list)
