#include <bits/stdc++.h>
using namespace std;

const int MAX = 1e5 + 1;

int main() {
    int n , S;
    cin >> n >> S;
    int a[n];
    for(int i = 0 ; i < n ; i++) {
        cin >> a[i];
    }

    bitset<MAX> b(1);   // 000000000000000001
                        // 00000000000000100
                        // 00000000000000101

                        /*
                            For 3
                            not taking 3 - > 00000000000000101
                            with 3 ->        00000000000101000          0 -> 3
                                                                        1 -> 4 similarly every position shift by 3
                        
                                          or   -----------------
                                            000000000000101101
                        */
    for(int i = 0 ; i < n ; i++) {
        b = (b | (b << a[i]));
    }

    for(int i = 0 ; i <= S ; i++) {
        cout << i << ": " << b[i] << "\n";
    }
}