/**
 * Link: https://practice.geeksforgeeks.org/problems/minimum-cost-to-cut-a-board-into-squares/1
 *
 */

//{ Driver Code Starts
/* Driver program to test above function */

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution
{
public:
    int minimumCostOfBreaking(vector<int> X, vector<int> Y, int M, int N)
    {
        /**
         * Approach:
         * 1. Sort both the vectors, everytime get the maximum value of the two vectors, such that;
         * if both vector have same largest value, then pick the value from the larger vector and
         * multiply by the number of horizontal or vertical Partitions.
         * 2. Got this idea by observing the sample test cases.
         */
        int cost = 0;
        int horizontalPartitions = 1;
        int verticalPartitions = 1;
        sort(X.begin(), X.end());
        sort(Y.begin(), Y.end());

        while (X.size() > 0 || Y.size() > 0)
        {
            if (X.back() > Y.back() || (X.back() == Y.back() && X.size() > Y.size()))
            {
                cost += X.back() * verticalPartitions;
                horizontalPartitions++;
                X.pop_back();
            }
            else
            {
                cost += Y.back() * horizontalPartitions;
                verticalPartitions++;
                Y.pop_back();
            }
        }
        return cost;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int m, n;
        cin >> m >> n;
        vector<int> X(m - 1), Y(n - 1);
        for (int i = 0; i < m - 1; i++)
        {
            cin >> X[i];
        }
        for (int i = 0; i < n - 1; i++)
        {
            cin >> Y[i];
        }
        Solution ob;
        int ans = ob.minimumCostOfBreaking(X, Y, m, n);
        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends