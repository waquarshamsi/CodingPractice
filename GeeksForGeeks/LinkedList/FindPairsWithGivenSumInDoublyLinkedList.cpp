/**
 * Link: https://practice.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1
 *
 */

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int data;
    Node *next, *prev;
    Node(int val) : data(val), next(NULL), prev(NULL)
    {
    }
};

// } Driver Code Ends
// User function Template for C++

/* Doubly linked list node class
class Node
{
public:
    int data;
    Node *next, *prev;
    Node(int val) : data(val), next(NULL), prev(NULL)
    {
    }
};
*/

class Solution
{
public:
    vector<pair<int, int>> findPairsWithGivenSum(Node *head, int target)
    {
        /**
         * Approach:
         * 1. Take two pointers, initilialize both at 0th element.
         * 2. Increment the right pointer until (*left_ptr + *right_ptr)<target
         * 3. When *left_ptr+*(right_ptr+1)>=target, insert the pair in result vector
         * 4. Then keep incrementing left ptr and decrmeneting right ptr to obtain other pairs.
         */
        vector<pair<int, int>> result;
        Node *left_ptr = head;
        Node *right_ptr = head;
        /* case 1: head == null or only one element */
        if (head == NULL || head->next == NULL)
        {
            return result;
        }
        while (right_ptr->next != NULL && (left_ptr->data + right_ptr->data < target))
        {
            right_ptr = right_ptr->next;
        }
        while (left_ptr != right_ptr)
        {
            if (left_ptr->data + right_ptr->data == target)
            {
                result.push_back(make_pair(left_ptr->data, right_ptr->data));

                if (left_ptr->next != right_ptr)
                {
                    /*
                        update both pointers as, elements are unique so ith element cannot match with j-1th element and
                        i+1th element won't match with jth element.
                     */
                    left_ptr = left_ptr->next;
                    right_ptr = right_ptr->prev;
                }
                else
                {
                    /* if the two pointers are neighbours, then updating them both would lead to infinite loop */
                    left_ptr = left_ptr->next;
                }
            }
            else if (left_ptr->data + right_ptr->data < target)
            {
                left_ptr = left_ptr->next;
            }
            else
            {
                right_ptr = right_ptr->prev;
            }
        }
        return result;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, target;
        cin >> target >> n;
        int a;
        cin >> a;
        Node *head = new Node(a);
        Node *tail = head;
        for (int i = 0; i < n - 1; i++)
        {
            cin >> a;
            tail->next = new Node(a);
            tail->next->prev = tail;
            tail = tail->next;
        }
        Solution ob;
        auto ans = ob.findPairsWithGivenSum(head, target);
        if (ans.size() == 0)
            cout << "-1";
        else
        {
            for (int i = 0; i < ans.size(); i++)
            {
                cout << "(" << ans[i].first << "," << ans[i].second << ")"
                     << " ";
            }
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends