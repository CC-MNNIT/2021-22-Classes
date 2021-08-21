#include <bits/stdc++.h>
using namespace std;

int main() {
    int n , k , S;
    cin >> n >> k >> S;
    int a[n];
    for(int i = 0 ; i < n ; i++) {
        cin >> a[i];
    }

    vector<int> dp(S+1);
    dp[0] = 1;

    /*
        0/k knapsack
    */
    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < a[i] ; j++) {       // j -> current equivalence class we are considering
            vector<int> curr_class;
            for(int x = j ; x <= S ; x += a[i]) {
                curr_class.push_back(x);
            }

            int cnt[2] = {0};
            for(int x = curr_class.size() - 1 , num = 0 ; num <= k && x >= 0 ; x-- , num++) {
                cnt[dp[curr_class[x]]]++;
            }

            // Sliding window
            for(int x = curr_class.size() - 1 ; x >= 0 ; x--) {
                int idx = curr_class[x];
                int prev = dp[idx];
                if(cnt[1]) {
                    dp[idx] = 1;
                }
                if(idx - a[i] * (k+1) >= 0) {
                    cnt[dp[idx - a[i] * (k+1)]]++;
                }
                cnt[prev]--;
            }
        }
    }

    /*
        Simple 0/1 knapsack for checking the correctness of the above code
    */
    vector<int> aux_dp(S+1);
    aux_dp[0] = 1;

    vector<int> b;
    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < k ; j++) {
            b.push_back(a[i]);
        }
    }

    for(int i = 0 ; i < b.size() ; i++) {
        for(int j = S ; j >= b[i] ; j--) {
            aux_dp[j] = max(aux_dp[j] , aux_dp[j-b[i]]);
        }
    }

    for(int i = 0 ; i <= S ; i++) {
        assert(dp[i] == aux_dp[i]);     // Checking whether both algo give same answer or not.
        cout << i << ": " << dp[i] << "\n";
    }
}