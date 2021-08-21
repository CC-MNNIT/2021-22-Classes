#include <bits/stdc++.h>
using namespace std;

const int mod = 1e9 + 7;

int n;
vector<vector<int>> A;

long long dp[(1 << 21)];

int fun(int mask) {
    /*
        __builtin_popcount returns the number of set bits in the mask, and this number will give us
        how many couples have been formed.
    */
    if(__builtin_popcount(mask) == n) {
        // If all the couples have been formed, we return 1 because that's one of the ways in which the couples can be formed
        return 1;
    }

    // If mask has already been processed no need to re calculate it.
    if(dp[mask] != -1) return dp[mask];

    int idx = __builtin_popcount(mask);     // The index of the current woman being considered.
    
    long long ans = 0;
    for(int i = 0 ; i < n ; i++) {
        if(mask & (1 << i)) {
            // The ith man has been paired, so we'll ignore him
            continue;
        }
        if(A[idx][i] == 0) {
            // Not compatible
            continue;
        }

        ans += fun(mask | (1 << i));
        ans %= mod;
    }

    return dp[mask] = ans;
}

int main() {
    cin >> n;
    A.resize(n , vector<int> (n , 0));
    memset(dp , -1 , sizeof(dp));
    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < n ; j++) {
            cin >> A[i][j];
        }
    }

    cout << fun(0) << "\n";
}