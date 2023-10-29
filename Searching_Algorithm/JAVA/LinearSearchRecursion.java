public class LinearSearchRecursion {

    public static int linearSearch(int[] array, int target, int index) {
        // Base case: if the index goes out of bounds, return -1 (element not found)
        if (index >= array.length) {
            return -1;
        }
        // If the element at the current index matches the target, return the index
        if (array[index] == target) {
            return index;
        }
        // Recursive case: search in the rest of the array (increment index)
        return linearSearch(array, target, index + 1);
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 9, 5, 3};
        int target = 5;

        // Start the search from index 0
        int result = linearSearch(array, target, 0);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
