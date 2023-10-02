#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
#include <algorithm>

using namespace std;

// Define a structure to represent a node (state)
struct Node {
    int x, y; // Coordinates of the node
    int cost; // Cost to reach this node from the start
    int heuristic; // Heuristic estimate of the cost to reach the goal
    Node* parent; // Pointer to the parent node

    Node(int x, int y, int cost, int heuristic, Node* parent)
        : x(x), y(y), cost(cost), heuristic(heuristic), parent(parent) {}

    // Define a custom comparison operator for the priority queue
    bool operator>(const Node& other) const {
        // Compare the total estimated cost (cost + heuristic)
        return (cost + heuristic) > (other.cost + other.heuristic);
    }
};

// A* search algorithm
vector<pair<int, int>> astar(vector<vector<int>>& grid, pair<int, int> start, pair<int, int> goal) {
    int rows = grid.size();
    int cols = grid[0].size();

    // Define possible movement directions (up, down, left, right)
    vector<pair<int, int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Create a priority queue for open nodes
    priority_queue<Node, vector<Node>, greater<Node>> open;

    // Create a 2D vector to keep track of visited nodes
    vector<vector<bool>> visited(rows, vector<bool>(cols, false));

    // Initialize the start node
    Node startNode(start.first, start.second, 0, 0, nullptr);
    open.push(startNode);

    // A* search
    while (!open.empty()) {
        // Get the node with the lowest total cost
        Node current = open.top();
        open.pop();

        // Check if the current node is the goal
        if (current.x == goal.first && current.y == goal.second) {
            // Reconstruct the path from the goal to the start
            vector<pair<int, int>> path;
            while (current.parent != nullptr) {
                path.push_back({current.x, current.y});
                current = *(current.parent);
            }
            path.push_back({start.first, start.second});
            reverse(path.begin(), path.end());
            return path;
        }

        // Mark the current node as visited
        visited[current.x][current.y] = true;

        // Expand the current node by considering neighboring nodes
        for (const auto& dir : directions) {
            int newX = current.x + dir.first;
            int newY = current.y + dir.second;

            // Check if the new position is within the grid
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && grid[newX][newY] == 0) {
                // Calculate the cost to reach the new node from the start
                int newCost = current.cost + 1;

                // Calculate the heuristic estimate (e.g., Manhattan distance)
                int heuristic = abs(newX - goal.first) + abs(newY - goal.second);

                // Create a new node for the neighbor
                Node neighbor(newX, newY, newCost, heuristic, &current);

                // Add the neighbor to the open list
                open.push(neighbor);
            }
        }
    }

    // If no path is found, return an empty vector
    return vector<pair<int, int>>();
}

int main() {
    // Define the grid (0 represents an empty cell, 1 represents an obstacle)
    vector<vector<int>> grid = {
        {0, 0, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 1, 0, 1},
        {0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0}
    };

    // Define the start and goal positions
    pair<int, int> start = {0, 0};
    pair<int, int> goal = {4, 4};

    // Find the path using A* search
    vector<pair<int, int>> path = astar(grid, start, goal);

    // Display the path
    if (path.empty()) {
        cout << "No path found!" << endl;
    } else {
        cout << "Path found:" << endl;
        for (const auto& point : path) {
            cout << "(" << point.first << ", " << point.second << ")" << " -> ";
        }
        cout << "Goal" << endl;
    }

    return 0;
}
