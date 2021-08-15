#include <bits/stdc++.h>
using namespace std;

int kadane_algo(vector<int>& A) {
    int curr_sum = A[0] , max_sum = A[0];
    /*
        curr_sum -> suff[i-1]
        max_sum -> fun(i-1)
    */
    for(int i = 1 ; i < A.size() ; i++) {
        curr_sum = max(curr_sum + A[i] , A[i]);
        max_sum = max(max_sum , curr_sum);
    }
    return max_sum;
}

int main() {
    vector<int> A = {-1 , 2 , 3 , -4 , 9};
    cout << kadane_algo(A) << "\n";
}