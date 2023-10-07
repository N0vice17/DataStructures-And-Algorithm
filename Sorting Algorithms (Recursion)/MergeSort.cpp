#include<iostream>
using namespace std;

void merge(int* arr, int s, int e){
    int mid  = s + (e-s)/2;

    int len1 = mid - s + 1;
    int len2 = e - mid;

    int *first = new int[len1];
    int *second = new int[len2];

    //copy values
    int mainArrayIndex = s;
    for(int i=0; i<len1; i++) {
        first[i] = arr[mainArrayIndex++];
    }

    mainArrayIndex = mid+1;
    for(int i=0; i<len2; i++) {
        second[i] = arr[mainArrayIndex++];
    }


    //merge two sorted arrays
    int index1 = 0;
    int index2 = 0;
    mainArrayIndex = s;

     while(index1 < len1 && index2 < len2) {
        if(first[index1] < second[index2]) {
            arr[mainArrayIndex++] = first[index1++];
        }
        else{
            arr[mainArrayIndex++] = second[index2++];
        }
    }   

    while(index1 < len1) {
        arr[mainArrayIndex++] = first[index1++];
    }

    while(index2 < len2 ) {
        arr[mainArrayIndex++] = second[index2++];
    }

    delete []first;
    delete []second;

}

void MergeSort(int* arr,int s, int e){

    if(s>=e)
        return;

    int mid = s+(e-s)/2;
    MergeSort(arr,s,mid);    
    MergeSort(arr,mid + 1,e);

    merge(arr,s,e);  
    
}

int main(int argc, char const *argv[])
{
    int arr[] = {1,5,3,8,6,9,4};
    for (size_t i = 0; i < 7; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl << endl;
    MergeSort(arr, 0,7);
    for (size_t i = 0; i < 7; i++)
    {   
        cout << arr[i] << " ";
    }
    return 0;
}
