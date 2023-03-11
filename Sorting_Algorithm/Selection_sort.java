package Sorting_Algorithm;
import java.util.*;
public class Selection_sort {
    public static void main(String[]args){
        int[]arr={3,5,6,1,2};
        for(int i=0;i<arr.length;i++) {
			int min=Integer.MAX_VALUE;
			int index=0;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]<min) {
					min=arr[j];
					index=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[index];
			arr[index]=temp;
		}
		System.out.println(Arrays.toString(arr));
    }
}
