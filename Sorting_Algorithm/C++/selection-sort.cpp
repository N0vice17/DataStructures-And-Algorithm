#include <iostream>
using namespace std;

void selectionSort(int *, int);

int main()
{
    int n;
    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    selectionSort(arr, n);

    for (int i : arr)
        cout << i << " ";

    return 0;
}

void selectionSort(int arr[], int n)
{
    for (int i = 0; i < n - 1; i++)     // selecting the first element of the unsorted array
        for (int j = i + 1; j < n; j++) // traversing the remaining array
            if (arr[j] < arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[j]; // swapping
                arr[j] = temp;
            }
}