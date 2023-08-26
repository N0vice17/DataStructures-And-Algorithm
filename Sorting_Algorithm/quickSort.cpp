#include <iostream>
#include <algorithm> // to use swap()
using namespace std;

void quickSort(int[], int, int); 

int partition(int[], int, int);

int main()
{
    int n;
    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++)
        cin >> arr[i]; // input array elements

    quickSort(arr, 0, n - 1);

    for (int i : arr)
        cout << i << " "; // printing array elements

    return 0;
}

void quickSort(int arr[], int low, int high)
{
    if (low < high) // base condition
    {
        int PI = partition(arr, low, high);
        quickSort(arr, low, PI - 1); // recursive call
        quickSort(arr, PI + 1, high); // recursive call
    }
}

int partition(int arr[], int low, int high)
{
    int pivot = arr[high];
    int PI = low - 1;
    for (int i = low; i < high; i++)
        if (arr[i] < pivot)
            swap(arr[i], arr[++PI]);
    swap(arr[high], arr[++PI]);
    return PI;
}
