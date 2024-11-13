/**
 * Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 */
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
    vector<double> averageOfLevels(TreeNode *root)
    {
        vector<double> average;
        queue<TreeNode *> q;
        int level = 0;
        int node_curr_level = 1;
        int ncl = 1;
        int node_next_level = 0;
        double sum = 0;
        q.push(root);
        while (!q.empty())
        {
            root = q.front();
            sum += root->val;
            if (root->left != NULL)
            {
                q.push(root->left);
                node_next_level++;
            }
            if (root->right != NULL)
            {
                q.push(root->right);
                node_next_level++;
            }
            q.pop();
            node_curr_level--;
            if (!node_curr_level)
            {
                average.push_back(sum / ncl);
                node_curr_level = ncl = node_next_level;
                node_next_level = 0;
                sum = 0;
            }
        }
        return average;
    }
};