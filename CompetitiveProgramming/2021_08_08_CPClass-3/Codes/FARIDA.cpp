#include <bits/stdc++.h>
using namespace std;

void solve(){
	int n;  // n-> number of monsters
    cin >> n;
    int coins[n];   // number of coins each monster has
    for(int i = 0 ; i < n ; i++) {
        cin >> coins[i];
    }

    long long dp[n+2] = {0};
    for(int i = n-1 ; i >= 0 ; i--) {
        dp[i] = max(dp[i+1] , dp[i+2] + coins[i]);
    }

    cout << dp[0] << "\n";
}
signed main(){
	int t = 1;
	cin >> t;
	for(int i = 1 ; i <= t ; i++){
        cout << "Case " << i << ": ";
		solve();
	}
}