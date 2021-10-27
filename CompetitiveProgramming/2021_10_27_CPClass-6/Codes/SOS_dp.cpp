// Problem link : https://codeforces.com/contest/165/problem/E

#include <bits/stdc++.h>
using namespace std;

const int limit = 22;

vector<int> dp(1 << limit , -1);

int change(int x) {
    int num = 0;
    for(int i = 0 ; i < limit ; i++) {
        if(x & (1 << i)) continue;
        num += (1 << i);
    }
    return num;
}

int main() {
    int n;
    cin >> n;
    vector<int> a(n);
    for(int i = 0 ; i < n ; i++) {
        cin >> a[i];
        dp[change(a[i])] = a[i];
        // cout << bitset<limit>(a[i]) << " " << bitset<limit>(a[i] ^ (~0)) << "\n";
    }

    for(int i = 0 ; i < limit ; i++) {
        for(int mask = (1 << limit) - 1 ; mask >= 0 ; mask--) {
            if(mask & (1 << i)) continue;
            dp[mask] = max(dp[mask] , dp[mask | (1 << i)]);
        }
    }

    for(int i = 0 ; i < n ; i++) {
        cout << dp[a[i]] << " ";
    }
}