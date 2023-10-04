'''
Author: hariom09090
'''

def merge_sort(arr):
    # Base case: if the list has more than one element 
    if len(arr) > 1:
        mid = len(arr) // 2

        # Divide the list into two halves
        left_half = arr[:mid]
        right_half = arr[mid:]

        # Recursively apply merge_sort to both halves
        merge_sort(left_half)
        merge_sort(right_half)

        i = j = k = 0

        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        # Check if any elements were left
        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1

if __name__ == "__main__":
    input_list = input("Enter a list of numbers separated by spaces: ").split()
    input_list = [int(x) for x in input_list]
    
    merge_sort(input_list)
    
    print("Sorted list:", input_list)
