
#include <iostream>
#include <vector>

using namespace std;

const int INF = 1e9+7; // Represents infinity

// Define a structure to represent edges in the graph
struct Edge {
    int source, destination, weight;
};

// Function to perform Bellman-Ford algorithm
void bellmanFord(vector<Edge>& edges, int numVertices, int source) {
    vector<int> distance(numVertices, INF);
    distance[source] = 0;

    // Relax all edges |V| - 1 times, where |V| is the number of vertices
    for (int i = 0; i < numVertices - 1; ++i) {
        for (const Edge& edge : edges) {
            if (distance[edge.source] != INF && distance[edge.source] + edge.weight < distance[edge.destination]) {
                distance[edge.destination] = distance[edge.source] + edge.weight;
            }
        }
    }

    // Check for negative-weight cycles
    for (const Edge& edge : edges) {
        if (distance[edge.source] != INF && distance[edge.source] + edge.weight < distance[edge.destination]) {
            cout << "Graph contains a negative-weight cycle!" << endl;
            return;
        }
    }

    // Print the shortest distances
    cout << "Vertex   Distance from Source" << endl;
    for (int i = 0; i < numVertices; ++i) {
        cout << i << "\t\t" << distance[i] << endl;
    }
}

int main() {
    int numVertices = 5;
    vector<Edge> edges = {
        {0, 1, -1},
        {0, 2, 4},
        {1, 2, 3},
        {1, 3, 2},
        {1, 4, 2},
        {3, 2, 5},
        {3, 1, 1},
        {4, 3, -3}
    };

    int source = 0;

    bellmanFord(edges, numVertices, source);

    return 0;
}
