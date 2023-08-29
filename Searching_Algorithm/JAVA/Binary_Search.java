package Searching_Algorithm;
public class Binary_Search {
    static int search(int []arr,int element){
        int Start=0;
        int End=arr.length-1;
        while(Start<=End){
            int mid = Start + (End - Start) / 2;
        if(arr[mid]==element){
            return mid;
        }
        else if(element<arr[mid]){
            End=mid-1;
        }
        else if(element>arr[mid]){
            Start=mid+1;
        }
    }
    return -1;
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9};
        int element=3;
        System.out.println(search(arr,element));
    }
}
