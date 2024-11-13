/**
 *  Author: Waquar Shamsi
 *  Question:
 */

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
public:
    vector<int> FactDigit(int N)
    {
        // Solution
        int factorials[10]; /** To store factorial values for digits 0-9. */
        vector<int> X;      /** To store Result */
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) /** Calculate and store factorials 0-9. */
        {                            // O(1)
            factorials[i] = i * factorials[i - 1];
        }
        while (N != 0) /** Until a sum of N is reached, keep subtracting the largest factorial digit possible and push to result. */
        {              // O(N)
            for (int i = 9; i >= 0; i--)
            { // O(1)
                if (N >= factorials[i])
                {
                    X.push_back(i); // O(1)
                    N = N - factorials[i];
                    break;
                }
            }
        }
        reverse(X.begin(), X.end()); // O(X) /** Reverse the order of pushing to get smallest number. */
        return X;
    }
};

//{ Driver Code Starts.
int main()
{
    int tc;
    cin >> tc;
    while (tc--)
    {
        int N;
        cin >> N;
        Solution ob;
        vector<int> ans = ob.FactDigit(N);
        for (auto i : ans)
            cout << i;
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends