#include <bits/stdc++.h>
using namespace std;

const int inf = 1e9 + 9;

int main() {
    /*
        n -> Change to give
        m -> Number of denominations
    */
    int n , m;
    cin >> n >> m;

    /*
        coins -> The denomination of coins which we have.
    */
    int coins[m];
    for(int i = 0 ; i < m ; i++) {
        cin >> coins[i];
    }

    /*
        dp[i] -> minimum number of coins needed to give a change of i units.
    */
    int dp[n+1];

    // Base case. We don't need to spend any coins if there is no 
    dp[0] = 0;
    for(int i = 1 ; i <= n ; i++) {
        dp[i] = inf;        // Initially we assume that we need infinite coins to give a change of i coins
        for(int j = 0 ; j < m ; j++) {
            if(i >= coins[j])
            dp[i] = min(dp[i] , dp[i - coins[j]] + 1);
        }
    }

    cout << dp[n] << "\n";
}