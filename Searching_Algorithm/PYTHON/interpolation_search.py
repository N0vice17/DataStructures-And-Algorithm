def interpolation_search(arr, target):
    """
    Perform interpolation search to find the target element in a sorted array.

    Args:
    arr (list): The sorted list to search in.
    target (int): The element to search for.

    Returns:
    int: The index of the target element in the array, or -1 if not found.
    """
    left, right = 0, len(arr) - 1

    while left <= right and arr[left] <= target <= arr[right]:
        if left == right:
            if arr[left] == target:
                return left
            return -1
        pos = left + ((target - arr[left]) * (right - left) // (arr[right] - arr[left]))

        if arr[pos] == target:
            return pos
        if arr[pos] < target:
            left = pos + 1
        else:
            right = pos - 1

    return -1

if __name__ == "__main__":
    
    # Test case
    test_array = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
    target_element = 11
    result = interpolation_search(test_array, target_element)

    if result == -1:
        print(f"Element {target_element} is not present in the array")
    else:
        print(f"Element {target_element} found at position {result} in the array")
