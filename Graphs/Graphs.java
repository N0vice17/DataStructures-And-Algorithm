package Graphs;
import java.util.*;
public class Graphs {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int vertices=input.nextInt();
        int edges=input.nextInt();
        int arr[][]=new int[vertices][vertices];
        for(int i=0;i<edges;i++){
            int vert1=input.nextInt();
            int vert2=input.nextInt();
            arr[vert1][vert2]=1;
            arr[vert2][vert1]=1;
        }
        BFS(arr);
    }
    public static void BFS(int[][]arr){
        boolean visited[]=new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            if(visited[i]==false){
                BFShelper(arr,i,visited);
            }
        }
    }
    public static void BFShelper(int[][]arr,int ind,boolean visited[]){
        Queue<Integer>pending=new LinkedList<>();
        pending.add(ind);
        visited[ind]=true;
        while(!pending.isEmpty()){
            int num=pending.poll();
            System.out.print(num+" ");
            for(int i=0;i<arr.length;i++){
                if(arr[num][i]==1&&visited[i]==false){
                    pending.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    public static void helperdfs(int[][]arr,int ind,boolean visited[]){
        visited[ind]=true;
        System.out.print(ind+" ");
        for(int i=0;i<arr.length;i++){
            if(arr[ind][i]==1&&visited[i]==false){
                helperdfs(arr,i,visited);
            }
        }
    }
    public static void DFS(int[][]arr){
        boolean visited[]=new boolean[arr.length];
        helperdfs(arr,0,visited);
    }
}
