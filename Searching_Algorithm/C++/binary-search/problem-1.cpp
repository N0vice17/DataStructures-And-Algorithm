#include <iostream>
using namespace std;

int findTotalOccurrence(int *, int, int, bool);

int main()
{
    int n; // size of array
    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++) // input array elements
        cin >> arr[i];

    int key; // element we want to find
    cin >> key;

    cout << findTotalOccurrence(arr, n, key, false) - findTotalOccurrence(arr, n, key, true) + 1 << endl;

    return 0;
}

int findTotalOccurrence(int arr[], int n, int key, bool check)
{
    int low = 0, high = n - 1, result = -1; 
    while (low <= high)
    {
        int mid = low + (high - low) / 2; // calculating the mid index
        if (arr[mid] == key)
        {
            result = mid; // key found
            if (check) // if check value is true 
                high = mid - 1;
            else  // if check value is false
                low = mid + 1;
        }
        else if (key < arr[mid])
            high = mid - 1; // updating the high pointer
        else
            low = mid + 1; // updating the low pointer
    }
    return result;
}
