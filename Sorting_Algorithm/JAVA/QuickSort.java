package Sorting_Algorithm;
import java.util.*;
public class QuickSort{
    public static int partition(int arr[],int s,int e){
            int pivotelement=arr[s];
            int count=0;
            for(int i=s+1;i<=e;i++){
                if(arr[i]<pivotelement){
                    count++;
                }
            }
            int temp=arr[s+count];
            arr[s+count]=arr[s];
            arr[s]=temp;
            int i=s;
            int j=e;
            while(i<j){
                if(arr[i]<pivotelement){
                    i++;
                }
                else if(arr[j]>=pivotelement){
                    j--;
                }
                else{
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    i++;
                    j--;
                }
            }
            return s+count;
    }
    public static void quicksort(int[]arr,int s,int e){
        if(s>=e){
            return;
        }
        int pivotindex=partition(arr,s,e);
        quicksort(arr, s, pivotindex-1);
        quicksort(arr, pivotindex+1, e);
    }
    public static void main(String[]args){
        int[]arr={9,8,7,6,5,4,3,2,1};
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}