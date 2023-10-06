#include<iostream>
using namespace std;

void SelectionSortRecursive(int *arr, int size){

    if(size == 0 || size == 1){
        return;
    }
    int min = INT16_MAX;
    for (size_t i = 0; i < size; i++)
    {
        if(arr[i] < arr[min]) min = i;
    }
    swap(arr[0],arr[min]);
    SelectionSortRecursive(arr+1,size-1);
    
}


int main(int argc, char const *argv[])
{
    int arr[] = {1,5,3,8,6,9,4};
    for (size_t i = 0; i < 7; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl << endl;
    SelectionSortRecursive(arr, 7);
    for (size_t i = 0; i < 7; i++)
    {   
        cout << arr[i] << " ";
    }
    return 0;
}
