package Sorting_Algorithm;
import java.util.*;
public class HeapSort {
    public static void downheapify(int[]arr,int i,int n){
        int parentindex=i;
        int firstchild=2*parentindex+1;
        int secondchild=2*parentindex+2;
        while(firstchild<n){
            int minindex=parentindex;
            if(arr[firstchild]<arr[minindex]){
                minindex=firstchild;
            }
            if(secondchild<n&&arr[secondchild]<arr[minindex]){
                minindex=secondchild;
            }
            if(minindex==parentindex){
                return;
            }
            int temp=arr[parentindex];
            arr[parentindex]=arr[minindex];
            arr[minindex]=temp;
            parentindex=minindex;
            firstchild=2*parentindex+1;
            secondchild=2*parentindex+2;
        }
    }
    public static void Heapsort(int[]arr){
        for(int i=(arr.length/2)-1;i>=0;i--){
            downheapify(arr,i,arr.length);
        }
        for(int i=arr.length-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            downheapify(arr,0,i);
        }
    }
    public static void main(String[]args){
        int []arr={1,2,3,4,5};
        Heapsort(arr);
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println( );
    }
    
}
