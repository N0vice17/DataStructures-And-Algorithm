#include <iostream>
using namespace std;

int binarySearch(int *, int, int);

int main()
{
    int n; // size of array
    cin >> n;
    int arr[n]; // array declaration

    for (int i = 0; i < n; i++) // input array elements
        cin >> arr[i];

    int key; // element we want to find
    cin >> key;

    cout << binarySearch(arr, n, key);

    return 0;
}

int binarySearch(int *arr, int n, int key)
{
    int low = 0, high = n - 1;

    while (low <= high)
    {
        int mid = low + (high - low) / 2; // calculating the mid index

        if (arr[mid] == key)
            return mid; // key found
        else if (key < arr[mid])
            high = mid - 1; // updating the high pointer
        else
            low = mid + 1; // updating the low pointer
    }

    return -1; // key not found
}