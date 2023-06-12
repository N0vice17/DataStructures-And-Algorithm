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
    //------------------------------------------------------------------------------------------------------
    public static boolean isconnected(int[][]arr){
        if(arr.length==0&&arr[0].length==0){
            return true;
        }
        boolean visited[]=new boolean[arr.length];
        isconnectedhelper(arr, 0, visited);
        boolean check=true;
        for(boolean it:visited){
            if(!it){
                check=false;
                return check;
            }
        }
        return check;
    }
    public static void isconnectedhelper(int[][]arr,int source,boolean visited[]){
        visited[source]=true;
        for(int i=0;i<arr.length;i++){
            if(arr[source][i]==1&&!visited[i]){
                isconnectedhelper(arr,i,visited);
            }
        }
    }
    //----------------------------------------------------------------------------------------------------------
    public static void getpathBFS(int[][]arr,int source,int destination){
        boolean visited[]=new boolean[arr.length];
        ArrayList<Integer>ans=getpathBFShelper(arr, source, destination,visited);
        if(ans==null){
            System.out.println("No Path");
            return;
        }
        System.out.println("Path");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println( );
    }
    public static ArrayList<Integer> getpathBFShelper(int[][]arr,int source,int destination,boolean visited[]){
        Queue<Integer>pending=new LinkedList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        pending.add(source);
        map.put(source,-1);
        visited[source]=true;
        boolean check=false;
        while(!pending.isEmpty()){
            int currv=pending.poll();
            visited[currv]=true;
            for(int i=0;i<arr.length;i++){
                if(arr[currv][i]==1&&!visited[i]){
                    pending.add(i);
                    map.put(i,currv);
                    visited[i]=true;
                    if(i==destination){
                        check=true;
                        break;
                    }
                }
            }
            if(check){
                break;
            }
        }
        if(check){
            ArrayList<Integer>ans=new ArrayList<>();
            int ind=destination;
            while(map.get(ind)!=-1){
                ans.add(0, map.get(ind));
                ind=map.get(ind);
            }
            ans.add(destination);
            return ans;
        }
        return null;
    }
    //-------------------------------------------------------------------------------------------------------
    public static void getpathDFS(int[][]arr,int source,int destination){
        boolean visited[]=new boolean[arr.length];
        ArrayList<Integer>ans=getpathhelperDFS(arr,source,destination,visited);
        if(ans==null){
            System.out.println("No Path");
            return;
        }
        System.out.println("Path");
        for(int i=ans.size()-1;i>=0;i--){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }
    public static ArrayList<Integer> getpathhelperDFS(int[][]arr,int source,int destination,boolean[]visited){
        if(source==destination){
            ArrayList<Integer>ans=new ArrayList<Integer>();
            ans.add(source);
            return ans;
        }
        visited[source]=true;
        for(int i=0;i<arr.length;i++){
            if(arr[source][i]==1&&visited[i]==false){
                ArrayList<Integer>ans=getpathhelperDFS(arr, i, destination,visited);
                if(ans!=null){
                    ans.add(source);
                    return ans;
                }
            }
        }
        return null;
    }
    //---------------------------------------------------------------------------------------------------
    public static boolean hashpath(int[][]arr,int source,int destination){
        boolean visited[]=new boolean[arr.length];
        return hashpathhelper(arr, source, destination, visited);
    }
    public static boolean hashpathhelper(int[][]arr,int source,int destination,boolean visited[]){
        if(source==destination){
            visited[source]=true;
            return true;
        } 
        visited[source]=true;
        for(int i=0;i<arr.length;i++){
            if(visited[i]==false&&arr[source][i]==1){
                hashpathhelper(arr,i, destination, visited);
            }
        }
        return visited[destination];
    }
    //----------------------------------------------------------------------------------------------------------
    public static void BFS(int[][]arr){
        boolean visited[]=new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                BFShelper(arr,i,visited);
                System.out.println( );
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
    //--------------------------------------------------------------------------------------------------------------
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
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                helperdfs(arr,i,visited);
                System.out.println( );
            }
        }
    }
    //-----------------------------------------------------------------------------------------------------------
}
