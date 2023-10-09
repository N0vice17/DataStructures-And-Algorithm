# Title: 124. Binary Tree Maximum Path Sum
# Difficulty: Hard
# Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max = float('-inf')
        # transverse throught the tree and update the self.max value
        self.transverse(root)
        return self.max

    def transverse(self, node: Optional[TreeNode]) -> int:
        # no node means path sum is 0
        if not node:
            return 0

        # find the max sum for left and right nodes
        left = self.transverse(node.left)
        right = self.transverse(node.right)

        # compare the different paths
        self.max = max(self.max, left + right + node.val, node.val + max(left, right, 0))

        # return a path that starts at the node
        return node.val + max(left, right, 0)
