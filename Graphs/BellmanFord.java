/*Given a weighted, directed and connected graph of V vertices and E edges, 
Find the shortest distance of all the vertex's from the source vertex S. 
If a vertices can't be reach from the S then marking the distance as 10^8. 
If the Graph contains a negative cycle then return an array consisting of only -1.
Implemented the Bellman-Ford Algorithm which gives distance from source to all the vertex(containing neg edge wt)
*/

import java.util.*;
public class BellmanFord {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int nodes=sc.nextInt(); //enter no of nodes in the graph
        int edges=sc.nextInt(); //enter no of edges in the graph
        int source=sc.nextInt(); //enter the source
        for(int i=0;i<edges;i++){
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<3;j++)l.add(sc.nextInt());
            adj.add(new ArrayList<>(l));
        }
        int distn[]=bellman_ford(nodes,adj,source);
        for(int i=0;i<distn.length;i++){
            System.out.println("Shortest Distance from "+source+" to "+i+" is: "+distn[i]);
        }
        
    }
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int s) {
        int distn[]=new int[V];
        Arrays.fill(distn,(int)1e8);
        distn[s]=0;
        for(int i=0;i<V-1;i++){
            for(List<Integer> p:edges){
                int u=p.get(0);
                int v=p.get(1);
                int wt=p.get(2);
                if(distn[u]!=(int)1e8 && distn[u]+wt<distn[v]){
                    distn[v]=distn[u]+wt;
                }
            }
        }
        for(List<Integer> p:edges){
           int u=p.get(0);
                int v=p.get(1);
                int wt=p.get(2);
                if(distn[u]!=(int)1e8 && distn[u]+wt<distn[v]){
                    return new int[]{-1};
                }
        }
        return distn;
    }
}

/*
for i/p-->
3
4
2
0 1 5   //u v w means there is an edge from u to v with weight of w
1 0 3 
1 2 -1
2 0 1

--graph intution--
0--(5)-->1
0<--(3)---1--(-1)-->2--(1)-->0


o/p-->
Shortest Distance from 2 to 0 is: 1
Shortest Distance from 2 to 1 is: 6
Shortest Distance from 2 to 2 is: 0

Time Complexity: O(V*E) where V and E are no of vertices and edges respectively
Space Complexity: O(V)

*/