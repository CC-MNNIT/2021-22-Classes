#include <bits/stdc++.h>
using namespace std;

const int MAX = 1e6 + 1;

int mem[MAX];

int fib(int n) {
    if(n <= 0) return n;
    if(mem[n] != -1) return mem[n];

    return mem[n] = fib(n-1) + fib(n-2);
}

int main() {
    int n;
    cin >> n;
    cout << fib(n) << "\n";
}