#include <bits/stdc++.h>
using namespace std;

/*
    BINARY EXPONENTIATION

    Paramaters:
        1. Base (a)
        2. Exponent (n)
    
    Return value : a^n
*/
int power(int a , int b) {
    int prod = 1;
    while(b) {
        if(b & 1) {
            prod *= a;
        }
        a *= a;
        b >>= 1;
    }

    return prod;
}

const int mod = 1e9 + 7;

/*
    BINARY EXPONENTIATION mod m

    Paramters:
        1. Base
        2. Exponent
    
    Return value : (a ^ n) mod m
*/
long long mod_power(long long a , long long b) {
    long long prod = 1;
    while(b) {
        if(b & 1) {
            prod = (prod * a) % mod;
        }
        a = (a * a) % mod;
        b >>= 1;
    }
    return prod;
}

/*
    Recursive Binary Exponentiation
    Paramaters:
        1. Base (a)
        2. Exponent (n)
    
    Return value : a^n
*/
int rec_power(int a , int b) {
    if(b == 0) {
        return 1;
    }

    int num = power(a , b/2);
    num *= num;
    if(b % 2) num *= a;
    return num;
}

int main() {
    int a = 3 , b = 3;
    cout << rec_power(a , b) << "\n"; 
}