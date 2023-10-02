import java.util.*;

public class Cycle_Sort {
    // Author: Mohak Agrawal (github.com/manmohak07)


    // Description: Many sorting algorithms do take O(n^2) for worst case complexity, but cyclic sort helps to sort the array in a single pass O(n).
    // Efficient and can be used when the range is given as range ∈ (1, N).
    /* **IMPORTANT** */
    // Why do cylic sort and what is it signifance??
    // For worst case, total 2n-1 swaps will take place, and the complexity becomes O(n)
    // Also, questions like LeetCode 268(easy), 448(easy), 645(easy), 287(medium), 442(medium), 41(hard)
    public static void main(String[] args) {
        // For example, we take the array as [4, 1, 3, 5, 2]
        int[] arr = {4, 1, 3, 5, 2};
        sort(arr); // iterative fn call
        recursiveSort(arr, 0); //by passing index as 0 we call the recursive fn
        System.out.println(Arrays.toString(arr));
    }

    // ITERATIVE CODE
    static void sort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    // RECURSIVE CODE
    static void recursiveSort(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }

        int correctIndex = arr[index] - 1;
        if (arr[index] != arr[correctIndex]) {
            swap(arr, index, correctIndex);
            recursiveSort(arr, correctIndex);
        } else {
            recursiveSort(arr, index + 1);
        }
    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
