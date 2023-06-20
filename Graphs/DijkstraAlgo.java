package Graphs;
import java.util.*;
public class DijkstraAlgo{
    public static int minvertex(Boolean visited[],int distance[]){
        int minvertex=Integer.MAX_VALUE;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]&&(minvertex==Integer.MAX_VALUE||distance[i]<distance[minvertex])){
                minvertex=i;
            }
        }
        return minvertex;
    }
    public static void Dijkstra(int[][]arr){
        Boolean visited[]=new Boolean[arr.length];
        int distance[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            visited[i]=false;
            distance[i]=Integer.MAX_VALUE;
        }
        distance[0]=0;
        for(int i=0;i<arr.length;i++){
            int minvert=minvertex(visited,distance);
            visited[minvert]=true;
            for(int j=0;j<arr.length;j++){
                if(!visited[j]&&arr[minvert][j]!=0&&distance[minvert]+arr[minvert][j]<distance[j]){
                    distance[j]=distance[minvert]+arr[minvert][j];
                }
            }
        }
        System.out.println("Printing the minimum Distance From the Source of Every vertex");
        for(int i=0;i<arr.length;i++){
            System.out.println(i+" "+distance[i]);
        }
    }
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int v=input.nextInt();
        int e=input.nextInt();
        int arr[][]=new int[v][v];
        for(int i=0;i<e;i++){
            int vertex1=input.nextInt();
            int vertex2=input.nextInt();
            int weight=input.nextInt();
            arr[vertex1][vertex2]=weight;
            arr[vertex2][vertex1]=weight;
        }
        Dijkstra(arr);
    }
}