#include <iostream>
using namespace std;

void merge(int *, int, int *, int, int *, int);
void mergeSort(int *, int);

int main()
{
    int n; // size of input array
    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++) // input elements
        cin >> arr[i];

    mergeSort(arr, n);

    for (auto i : arr) // output
        cout << i << " ";

    cout << endl;

    return 0;
}

void mergeSort(int *arr, int n)
{
    if (n < 2) // base condition
        return;

    int mid = n / 2;
    int left[mid];      // creating left array
    int right[n - mid]; // creating right array

    for (int i = 0; i < mid; i++) // filling left array
        left[i] = arr[i];
    for (int i = mid; i < n; i++) // filling right array
        right[i - mid] = arr[i];

    mergeSort(left, mid);      // merge sort left array
    mergeSort(right, n - mid); // merge sort right array

    merge(left, mid, right, n - mid, arr, n); // merge the sorted arrays back
}

void merge(int *left, int nL, int *right, int nR, int *arr, int n)
{
    int i = 0, j = 0, k = 0;

    while (i < nL && j < nR)
    {
        if (left[i] <= right[j])
        {
            arr[k] = left[i];
            i++;
            // k++;
        }
        else
        {
            arr[k] = right[j];
            j++;
            // k++;
        }
        k++; // irrespective of condititon
    }

    // to copy leftover element(s)
    while (i < nL) // to handle left array
    {
        arr[k] = left[i];
        i++;
        k++;
    }
    while (j < nR) // to handle right array
    {
        arr[k] = right[j];
        j++;
        k++;
    }
}