#include <iostream>
#include <vector>
#include <algorithm>
void bucketSort(std::vector<double>& arr) {
    int n = arr.size();
    if (n <= 0) return;

    //minimum and maximum values 
    double min_val = *std::min_element(arr.begin(), arr.end());
    double max_val = *std::max_element(arr.begin(), arr.end());

    // Create buckets
    int num_buckets = n;
    std::vector<std::vector<double>> buckets(num_buckets);

    // Distribute elements into buckets
    for (int i = 0; i < n; i++) {
        int bucket_index = static_cast<int>((arr[i] - min_val) / (max_val - min_val) * (num_buckets - 1));
        buckets[bucket_index].push_back(arr[i]);
    }

    // Sort  bucket 
    for (int i = 0; i < num_buckets; i++) {
        std::sort(buckets[i].begin(), buckets[i].end());
    }

    // Concatenate sorted buckets 
    int index = 0;
    for (int i = 0; i < num_buckets; i++) {
        for (int j = 0; j < buckets[i].size(); j++) {
            arr[index++] = buckets[i][j];
        }
    }
}

int main() {
    std::vector<double> arr = {2,4,46,3,14,56,24};
    
    std::cout << "Original array: ";
    for (double num : arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    bucketSort(arr);

    std::cout << "Sorted array: ";
    for (double num : arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}
