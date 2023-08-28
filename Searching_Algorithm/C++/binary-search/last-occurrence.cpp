#include <iostream>
using namespace std;

int findLastOccurrence(int *, int, int);

int main()
{
    int n;
    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    int key;
    cin >> key;

    cout << findLastOccurrence(arr, n, key) << endl;
    return 0;
}

int findLastOccurrence(int arr[], int n, int key)
{
    int low = 0, high = n - 1, result = -1;
    while (low <= high)
    {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key)
        {
            result = mid;
            low = mid + 1;
        }
        else if (key < mid)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return result;
}