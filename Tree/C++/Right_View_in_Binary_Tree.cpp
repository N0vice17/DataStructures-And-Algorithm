// Title: 199. Binary Tree Right Side View
// Difficulty: Medium
// Problem: https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75

// Definition for a binary tree node.
// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        dfs(root, 1, result);
        return result;
    }

private:
    void dfs(TreeNode* node, int currLevel, vector<int>& result) {
        if (node) {
            if (currLevel > result.size()) {
                result.push_back(node->val);
            }
            dfs(node->right, currLevel + 1, result);
            dfs(node->left, currLevel + 1, result);
        }
    }
};
