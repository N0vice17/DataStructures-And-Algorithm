def ternary_search(arr, target):
    left, right = 0, len(arr) - 1

    while left <= right:
    
        third = (right - left) // 3
        mid1 = left + third
        mid2 = right - third

        if arr[mid1] == target:
            return mid1
        if arr[mid2] == target:
            return mid2

        if target < arr[mid1]:
            right = mid1 - 1
        elif target > arr[mid2]:
            left = mid2 + 1
        else:
            left = mid1 + 1
            right = mid2 - 1

    return -1  # Target not found


arr = [1, 2, 36, 54, 59, 60, 77, 88, 93, 1000]
target = 93
result = ternary_search(arr, target)

if result != -1:
    print(f"Element {target} found at index {result}")
else:
    print(f"Element {target} not found in the array")
