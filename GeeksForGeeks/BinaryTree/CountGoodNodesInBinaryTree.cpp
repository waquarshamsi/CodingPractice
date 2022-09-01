#include <bits/stdc++.h>
using namespace std;
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
class Solution
{
public:
    int goodNodes(TreeNode *root, int maxValue = INT_MIN /*Optional Argument */)
    {
        if (root == NULL)
        {
            return 0;
        }
        if (root->val >= maxValue)
        {
            return 1 + goodNodes(root->left, root->val) + goodNodes(root->right, root->val);
        }
        else
        {
            return goodNodes(root->left, maxValue) + goodNodes(root->right, maxValue);
        }
    }
};