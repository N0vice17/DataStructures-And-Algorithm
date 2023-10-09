
import java.util.*;

public class PrimsAlgo {
    public static int minvertex(boolean[] visited, int weight[]) {
        int minvertex = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && (minvertex == -1 || weight[i] < weight[minvertex])) {
                minvertex = i;
            }
        }
        return minvertex;
    }

    public static void Prim(int[][] arr) {
        boolean visited[] = new boolean[arr.length];
        int parent[] = new int[arr.length];
        int weight[] = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        parent[0] = -1;
        weight[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            int minvert = minvertex(visited, weight);
            visited[minvert] = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[minvert][j] != 0 && !visited[j]) {
                    if (weight[j] > arr[minvert][j]) {
                        parent[j] = minvert;
                        weight[j] = arr[minvert][j];
                    }
                }
            }
        }
        System.out.println("Printing the MST");
        for (int i = 1; i < arr.length; i++) {
            System.out.println(i + " " + parent[i] + " " + weight[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int e = input.nextInt();
        int[][] arr = new int[v][v];
        for (int i = 0; i < e; i++) {
            int vertex1 = input.nextInt();
            int vertex2 = input.nextInt();
            int weight = input.nextInt();
            arr[vertex1][vertex2] = weight;
            arr[vertex2][vertex1] = weight;
        }
        Prim(arr);
    }
}
