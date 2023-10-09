import java.util.Arrays;

public class MaxHeapImp {
    int[] arr;
    int maxSize;
    int heapSize;

    MaxHeapImp(int maxSize) {
        this.maxSize = maxSize;
        this.heapSize = 0;
        this.arr = new int[maxSize];
    }

    void maxHeapify(int i) {

        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * 2 + 2;
        int max = i;

        if (leftChildIndex < this.maxSize && arr[leftChildIndex] > arr[i]) {
            max = leftChildIndex;
        }
        if (rightChildIndex < this.maxSize && arr[rightChildIndex] > arr[i]) {
            max = rightChildIndex;
        }

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            maxHeapify(max);
        }

    }

    int removeMax() {

        if (this.heapSize <= 0) {
            return Integer.MIN_VALUE;
        }
        if (this.heapSize == 1) {
            this.heapSize--;
            return arr[0];
        }

        int max = arr[0];
        arr[0] = arr[this.heapSize - 1];
        this.heapSize--;
        this.maxHeapify(0);
        return max;
    }

    void increaseKey(int i, int newValue) {
        arr[i] = newValue;
        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }

    }

    void deleteElement(int i) {
        increaseKey(i, Integer.MAX_VALUE);
        removeMax();
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * @param key
     */
    void insertKey(int key) {
        if (heapSize == maxSize) {
            System.out.println("The heap is already full");
            return;
        }
        heapSize++;
        int i = heapSize - 1;
        arr[i] = key;

        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    int lChildIndex(int i) {
        return 2 * i + 1;
    }

    int rChildIndex(int i) {
        return 2 * i + 2;
    }

    int getMax() {
        return arr[0];
    }

    int currSize() {
        return this.heapSize;
    }

    void printHeap() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        MaxHeapImp h = new MaxHeapImp(15);

        h.insertKey(3);
        h.insertKey(10);
        h.insertKey(12);
        h.insertKey(8);
        h.insertKey(2);
        h.insertKey(14);

        h.printHeap();

        System.out.println("The current size of the heap is "
                + h.currSize() + "\n");
        System.out.println("The current maximum element is " + h.getMax()
                + "\n");
        h.deleteElement(2);

        h.printHeap();

        System.out.println("The current size of the heap is "
                + h.currSize() + "\n");
        h.insertKey(15);
        h.insertKey(5);
        System.out.println("The current size of the heap is "
                + h.currSize() + "\n");
        System.out.println("The current maximum element is " + h.getMax()
                + "\n");
    }

}
