#include<iostream>
#include<string.h>
using namespace std;

bool linearSearch(int arr[], int size, int key){

    if(size == 0) return false;

    if(arr[0] == key){
        return true;

    }
    else{
        bool rest = linearSearch(arr+1,size -1, key);
        return rest;
    }
}

int main(int argc, char const *argv[])
{
    int arr[5] = {3,5,1,2,6};
    int size = 5;
    int key = 26;
    bool ans = linearSearch(arr, size, key);

    if(ans ){
        cout << "Present " << endl;
    }
    else{
        cout << "absent " << endl;
    }

    return 0;
}
