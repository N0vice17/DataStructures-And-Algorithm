package Searching_Algorithm;
public class Order_Agnoistic_Binary_search {
    static void order(int []arr,int element){
        int Start=0;
        int End=arr.length-1;
        if(arr[Start]>arr[End]){
            System.out.println(Descending(arr,element));
        }
        else{
          System.out.println(Ascending(arr, element));
        }
    }
    static int Ascending(int[]arr,int element){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==element){
                return mid;
            }
            else if(element>arr[mid]){
                low=mid+1;
            }
            else if(element<arr[mid]){
                high=mid-1;
            }
        }
        return -1;
    }
    static int Descending(int[]arr,int element){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==element){
                return mid;
            }
            else if(element>arr[mid]){
                high=mid-1;
            }
            else if(element<arr[mid]){
                low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int []arr={97,96,95,94,123,2,-13};
        int element=-13;
        order(arr,element);
    }
}
