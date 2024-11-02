/**
 * Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
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
    vector<vector<int>> verticalTraversal(TreeNode *root)
    {
        // map <*node_ptr, pair<int,int> coordinate>
        vector<vector<int>> result;
        queue<pair<TreeNode *, pair<int, int>>> q;
        q.push(make_pair(root, make_pair(0, 0)));
        int lowest_column_index = 0;
        /* if new lowest found then add to front and update lowest col index else,
        take relative index by considering lowest col index as 0, as col can be -ve*/
        int highest_column_index = -1;
        int highest_row_index = 0;
        /* when encounter a node with higher row_index, push all nodes into result that have
         row_index<highest_row_index encountered */
        vector<pair<int, int>> to_be_added; /* pair<index in result (col), value> */
        while (!q.empty())
        {
            TreeNode *node = q.front().first;
            int row = q.front().second.first;
            int col = q.front().second.second;
            if (row > highest_row_index)
            {
                sort(to_be_added.begin(), to_be_added.end());
                for (int i = 0; i < to_be_added.size(); i++)
                {
                    // calculate relative index using first
                    int rel_index = to_be_added[i].first + (-1 * lowest_column_index);
                    result[rel_index].push_back(to_be_added[i].second);
                }
                to_be_added.clear();
                highest_row_index = row;
            }
            if (lowest_column_index > col)
            {
                /* if no element present at this index and is lowest index yet,
                add new vector at beginning of result vector */
                vector<int> new_vector;
                result.insert(result.begin(), new_vector);
                lowest_column_index = col;
            }
            else if (highest_column_index < col)
            {
                vector<int> new_vector;
                result.push_back(new_vector);
                highest_column_index = col;
            }
            /* if col index already exists, get relative index of col wrt lowest_column_vector */
            to_be_added.push_back(make_pair(col, node->val));

            /* Add children of the node */
            if (node->left != NULL)
            {
                q.push(make_pair(node->left, make_pair(row + 1, col - 1)));
            }
            if (node->right != NULL)
            {
                q.push(make_pair(node->right, make_pair(row + 1, col + 1)));
            }
            q.pop();
        }
        if (!to_be_added.empty())
        {
            sort(to_be_added.begin(), to_be_added.end());
            for (int i = 0; i < to_be_added.size(); i++)
            {
                // calculate relative index using first
                int rel_index = to_be_added[i].first + (-1 * lowest_column_index);
                result[rel_index].push_back(to_be_added[i].second);
            }
        }
        return result;
    }
};