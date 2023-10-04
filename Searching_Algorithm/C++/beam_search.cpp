#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// Define a structure to represent states in the search
struct State {
    int value;
    vector<int> path;

    State(int val) : value(val) {}
};

// Define a custom comparison operator for the priority queue
struct CompareStates {
    bool operator()(const State& a, const State& b) const {
        return a.value < b.value;
    }
};

// Beam search algorithm
vector<int> beamSearch(vector<vector<int>>& graph, int start, int goal, int beamWidth) {
    int numNodes = graph.size();

    // Priority queue to store the current states
    priority_queue<State, vector<State>, CompareStates> currentStates;
    currentStates.push(State(start));

    // List to store the final paths
    vector<vector<int>> finalPaths;

    while (!currentStates.empty()) {
        // Expand the states with the highest values (up to beamWidth)
        vector<State> nextStates;
        while (!currentStates.empty() && nextStates.size() < beamWidth) {
            State currentState = currentStates.top();
            currentStates.pop();

            // Check if we reached the goal state
            if (currentState.value == goal) {
                finalPaths.push_back(currentState.path);
            } else {
                // Expand the current state and add the next states to the list
                for (int neighbor = 0; neighbor < numNodes; ++neighbor) {
                    if (graph[currentState.value][neighbor] > 0) {
                        State nextState(neighbor);
                        nextState.path = currentState.path;
                        nextState.path.push_back(neighbor);
                        nextState.value = currentState.value + graph[currentState.value][neighbor];
                        nextStates.push_back(nextState);
                    }
                }
            }
        }

        // Replace the current states with the next states
        currentStates = priority_queue<State, vector<State>, CompareStates>(nextStates.begin(), nextStates.end());
    }

    // Return the best path found
    if (!finalPaths.empty()) {
        return finalPaths[0];
    } else {
        return vector<int>(); // No path found
    }
}

int main() {
    // Example graph represented as an adjacency matrix
    vector<vector<int>> graph = {
        {0, 10, 0, 30, 100},
        {0, 0, 50, 0, 0},
        {0, 0, 0, 0, 10},
        {0, 0, 20, 0, 60},
        {0, 0, 0, 0, 0}
    };

    int startNode = 0;
    int goalNode = 4;
    int beamWidth = 2;

    vector<int> bestPath = beamSearch(graph, startNode, goalNode, beamWidth);

    if (!bestPath.empty()) {
        cout << "Best Path: ";
        for (int node : bestPath) {
            cout << node << " ";
        }
        cout << endl;
    } else {
        cout << "No path found!" << endl;
    }

    return 0;
}
