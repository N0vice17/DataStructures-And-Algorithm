//What is Cycle sort 
//When we are given numbers from 1 to N (not necessarily exactly from 1 to N) we use cycle sort.
//It sorts the entire array in one single pass.
//The basic idea behind cycle sort is the sorted array will contain elements on their correct index.
//For eg. - elements from 1 to 5 will be on index 0 to 4 in the sorted array.
//Advantages are :- It sorts the array in-place and does not require additional memory for temporary variables.

//Here is the link for leetcode question which is solved using cycle sort.
//https://leetcode.com/problems/missing-number/


public class CycleSort {

    public static void swap(int arr[],int start,int end)
    {
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }

    public static void cycleSort(int arr[])
    {
        int i=0;
        while(i<arr.length)
        {
            int correctIndex=arr[i]-1;  //correctIndex is the index that has the value equal to correctIndex-1.
            if(arr[i]==arr[correctIndex]) //if value of index i is equal to the value at correctIndex i.e., equal to (value of index i) -1.
                //index number (arr[i]) should contain (arr[i]-1)
            {
                i++;
            }
            else
            {
                swap(arr,i,correctIndex);
            }
        }

        for(int x:arr)
        {
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args) {
        int arr[]={3,5,2,1,4};
        cycleSort(arr);
    }
}
