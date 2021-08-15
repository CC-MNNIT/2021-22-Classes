#include <bits/stdc++.h>
using namespace std;

int lis_quadratic(vector<int>& A) {
    int n = A.size();
    int lis[n] = {0};

    int ans = 1;

    for(int i = 0 ; i < n ; i++) {
        lis[i] = 1;
        for(int j = i-1 ; j >= 0 ; j--) {
            if(A[j] < A[i]) {
                lis[i] = max(lis[i] , lis[j] + 1);
            }
        }
        ans = max(ans , lis[i]);
    }

    return ans;
}

int lis_optimised(vector<int>& A) {
    int n = A.size();
    const int INF = 1e9 + 9;
    vector<int> d(n+1, INF);
    d[0] = -INF;
    for (int i = 0; i < n; i++) {
        int j = upper_bound(d.begin(), d.end(), A[i]) - d.begin();
        if (d[j-1] < A[i] && A[i] < d[j])
            d[j] = A[i];
    }
    int ans = 0;
    for (int i = 0; i <= n; i++) {
        if (d[i] < INF)
            ans = i;
    }
    return ans;
}

int main() {
    vector<int> A = {1 , 2 , 5 , 3 , 4};
    cout << lis_quadratic(A) << " " << lis_optimised(A) << "\n";
}