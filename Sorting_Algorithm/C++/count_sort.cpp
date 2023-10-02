#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Function to perform Counting Sort
void countingSort(vector<int>& arr) {
    if (arr.empty()) {
        return; // Nothing to sort
    }

    // Find the maximum element in the array
    int max_val = *max_element(arr.begin(), arr.end());

    // Create a count array to store the count of each element
    vector<int> count(max_val + 1, 0);

    // Count the occurrences of each element
    for (int num : arr) {
        count[num]++;
    }

    // Reconstruct the sorted array
    int index = 0;
    for (int i = 0; i <= max_val; ++i) {
        while (count[i] > 0) {
            arr[index] = i;
            index++;
            count[i]--;
        }
    }
}

int main() {
    vector<int> arr = {4, 2, 2, 8, 3, 3, 1};
    
    cout << "Original array: ";
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;

    countingSort(arr);

    cout << "Sorted array: ";
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
