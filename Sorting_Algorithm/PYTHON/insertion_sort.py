'''
@Author: hariom09090
'''

def insertion_sort(arr):
    n = len(arr)

    # Traverse through the unsorted part
    for i in range(1, n):
        key = arr[i]  
        j = i - 1

        # Move elements of arr[0..i-1] that are greater than key one position ahead
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = key 

if __name__ == "__main__":
    input_list = input("Enter a list of numbers separated by spaces: ").split()
    input_list = [int(x) for x in input_list]
    
    insertion_sort(input_list)
    
    print("Sorted list:", input_list)
