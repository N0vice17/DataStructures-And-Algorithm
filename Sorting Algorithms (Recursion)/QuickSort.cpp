#include<iostream>
using namespace std;

int partition(int* arr, int s, int e){

    int temp = arr[s];
    int count = 0;
    for (size_t x = s+1; x <= e; x++)
    {
        if(arr[x] <= temp) count++;
    }
    int pivot = s + count;
    // cout<< arr[pivot] << " ";
    swap(arr[pivot],arr[s]);
    int i = s, j = e;
    while(i < pivot && j > pivot){
        while(arr[i] <= arr[pivot]) 
        {
            i++;
        }

        while(arr[j] > arr[pivot]) {
            j--;
        }
        if(i < pivot && j > pivot){
             swap(arr[i++], arr[j--]);
        } 
    } 
    return pivot;
}

void QuickSort(int* arr, int s, int e){

    if(s>=e) return;

    int p = partition(arr,s,e);
    // cout << endl;

    QuickSort(arr,s,p-1);
    QuickSort(arr,p+1,e);
}


int main(int argc, char const *argv[])
{
    int arr[] = {1,5,3,8,6,9,4};
    for (size_t i = 0; i < 7; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl << endl;
    QuickSort(arr, 0, 6);
    for (size_t i = 0; i < 7; i++)
    {   
        cout << arr[i] << " ";
    }
    return 0;
}