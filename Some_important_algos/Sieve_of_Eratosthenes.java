package Some_important_algos;
import java.util.*;
public class Sieve_of_Eratosthenes{
    /*  This is one of the efficient way to find the number of prime numbers between 1 and n(as given by the user)
        The time complexity of this solution is O(Nlog(logN))
    */
    public static boolean sieve(int num){
        int[]arr=new int[10000001];
        arr[1]=1;
        for(int i=2;i*i<=arr.length;i++){
            if(arr[i]==0){
                for(int j=2*i;j<=arr.length-1;j+=i){
                    arr[j]=1;
                }
            }
        }
        if(arr[num]==1){
            return false;
        }
        else{
            return true;
        }
    }
    public static void main(String[]args){
        System.out.println(sieve(7));
    }
}