#include<iostream>
using namespace std;

void InsertionSort(int *arr, int size){
    for (size_t i = 1; i < size; i++)
    {
        int temp = arr[i];
        int j = i -1;
        while(arr[j] > temp){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;
    }
    
}

void InsertionSortRecursive(int * arr, int size){

    if(size == 0 || size == 1) return;
    InsertionSortRecursive(arr,size-1);
        int temp = arr[size-1];
        int j = size -2;
        while(arr[j] > temp){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;

}

int main(int argc, char const *argv[])
{
    int arr[] = {1,5,3,8,6,9,4};
    for (size_t i = 0; i < 7; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl << endl;
    InsertionSortRecursive(arr, 7);
    for (size_t i = 0; i < 7; i++)
    {   
        cout << arr[i] << " ";
    }
    return 0;
}
