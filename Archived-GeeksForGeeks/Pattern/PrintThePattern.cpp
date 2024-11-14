/**
 * Link: https://practice.geeksforgeeks.org/problems/print-the-pattern1025/1
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
    vector<string> pattern(int n)
    {
        int counter = 1;
        vector<string> result;
        int shift;
        for (int i = n; i > 0; i--)
        {
            string row = "";
            // rows
            for (int j = 0; j < (n - i) * 2; j++)
            {
                // --s
                row += '-';
            }
            for (int j = 0; j < i; j++)
            {
                // first half of row
                row += to_string(counter);
                row += '*';
                counter++;
            }
            shift = (i - 1) * i;
            for (int j = 0; j < i - 1; j++)
            {
                row += to_string(counter + shift);
                row += '*';
                shift++;
            }
            // last entry without *
            row += to_string(counter + shift);
            result.push_back(row);
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
        int n;
        cin >> n;

        Solution ob;
        vector<string> ans = ob.pattern(n);
        for (int i = 0; i < n; i++)
            cout << ans[i] << "\n";
    }
    return 0;
}
// } Driver Code Ends