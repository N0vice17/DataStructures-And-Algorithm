#include <iostream>
using namespace std;

int findFirstOccurrence(int *, int, int);

int main()
{
    int n; // array size
    cin >> n;
    int arr[n]; // array declaration

    for (int i = 0; i < n; i++) // input array elements
        cin >> arr[i];

    int key; // element we want to find
    cin >> key;

    cout << findFirstOccurrence(arr, n, key) << endl;
    return 0;
}

int findFirstOccurrence(int arr[], int n, int key)
{
    int low = 0, high = n - 1, result = -1;
    while (low <= high)
    {
        int mid = low + (high - low) / 2; // calculating mid index
        if (arr[mid] == key)
        {
            result = mid; // key found
            high = mid - 1;
        }
        else if (key < mid)
            high = mid - 1; // updating high pointer
        else
            low = mid + 1; // updating low pointer
    }
    return result;
}
