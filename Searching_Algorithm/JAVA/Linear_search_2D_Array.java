package Searching_Algorithm;
public class Linear_search_2D_Array {
    static int search(int[][] arr,int element){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==element){
                  return 1;
                }
            }
        } 
        return 0;
    }
    public static void main(String[] args){
        int[][] arr={{19,29,39,49},
                    {56,66,76,86},
                    {99,10,11,12}};
        int element=10;
        System.out.println(search(arr,element));
    }
}
