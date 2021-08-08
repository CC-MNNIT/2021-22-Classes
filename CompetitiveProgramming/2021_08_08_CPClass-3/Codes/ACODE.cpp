#include <bits/stdc++.h>
using namespace std;

const int inf = 1e9 + 9;
typedef long long ll;

int main() {
    string s;
    cin >> s;
    while(true) {
        if(s == "0") return 0;

        int n = s.size();
        ll dp[n+1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2 ; i <= n ; i++) {
            if(s[i-2] == '0') {
                dp[i] = dp[i-1];
            }
            else if(s[i-1] == '0') {
                dp[i] = dp[i-2];
            }
            else if(s[i-2] == '1') {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else if(s[i-2] == '2' && s[i-1] <= '6') {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        cout << dp[n] << endl;
        cin >> s;
    }
} 