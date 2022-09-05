/**
 * Link: https://practice.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1
 *
 */

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution
{
public:
    int smallestSumSubarray(vector<int> &a)
    {
        int minimum = a[0];
        int prev = a[0];
        for (int i = 1; i < a.size(); i++)
        {
            prev = min(a[i], prev + a[i]);
            minimum = min(minimum, prev);
        }
        return minimum;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++)
        {
            cin >> a[i];
        }

        Solution ob;

        int ans = ob.smallestSumSubarray(a);

        cout << ans << endl;
    }
}
// } Driver Code Ends