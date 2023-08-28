package Sorting_Algorithm;
import java.util.*;
public class MergeSort{
    public static void merge(int a[],int b[],int c[]){
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length&&j<b.length){
            if(a[i]<=b[j]){
                c[k]=a[i];
                i++;
                k++;
            }
            else{
                c[k]=b[j];
                j++;
                k++;
            }
        }
        if(i<a.length){
            while(i<a.length){
                c[k]=a[i];
                i++;
                k++;
            }
        }
        if(j<b.length){
            while(j<b.length){
            c[k]=b[j];
            j++;
            k++;
            }
        }
    }
    public static void mergesort(int arr[]){
        if(arr.length<=1){
            return;
        }
        int[]a=new int[arr.length/2];
        int[]b=new int[arr.length-a.length];
        for(int i=0;i<arr.length/2;i++){
            a[i]=arr[i];
        }
        for(int i=arr.length/2;i<arr.length;i++){
            b[i-arr.length/2]=arr[i];
        }
        mergesort(a);
        mergesort(b);
        merge(a,b,arr);
    }
    public static void main(String[]args){
        int[]arr={9,8,7,6,5,4,3,2,1};
        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));
        mergesort(arr);
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}