#include <iostream>
using namespace std;

void bubbleSort(int *, int);

int main()
{
    int n; // size
    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++) // input elements
        cin >> arr[i];

    bubbleSort(arr, n);

    for (auto i : arr) // output
        cout << i << " ";

    cout << endl;

    return 0;
}

void bubbleSort(int *arr, int n)
{
    for (int pass = 1; pass <= n - 1; pass++) // running passes
    {
        bool flag = false; // no swapping happened

        for (int i = 0; i <= n - pass - 1; i++) // traversing
        {
            if (arr[i] > arr[i + 1]) // for ascending order sorting
            {
                flag = true; // swapping happened

                // swap
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        if (!flag) // if (false == flag) i.e. if there is no swapping
            break; // no need for any more passes
    }
}