#include<iostream>
using namespace std;

void SortArray(int* arr , int size){
    //base case
    if(size == 0 || size == 1) return;

    for (size_t i = 0; i < size - 1; i++)
    {
        if(arr[i] > arr[i+1]){
            swap(arr[i], arr[i+1]);
        }
    }

    SortArray(arr,size-1);
    
}

int main(int argc, char const *argv[])
{
    int arr[] = {1,5,3,8,6,9,4};
    for (size_t i = 0; i < 7; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl << endl;
    SortArray(arr, 7);
    for (size_t i = 0; i < 7; i++)
    {
        cout << arr[i] << " ";
    }
    
    return 0;
}
