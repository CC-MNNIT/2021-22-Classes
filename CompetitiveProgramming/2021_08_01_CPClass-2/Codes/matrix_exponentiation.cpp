#include <bits/stdc++.h>
using namespace std;

/*
    Matrix Multiplication

    Assumptions : Matrices are compatible for multiplication
    
    Paramaters:
        1. A 2-D vector representing the first matrix (a)
        2. A 2-D vector representing the second matrix (b)

    Return value : A 2-D vector representing the product of a and b
*/

vector<vector<int>> matrix_multiplication(vector<vector<int>>& a , vector<vector<int>>& b) {
    int n = a.size();
    int x = a[0].size();
    int m = b[0].size();

    assert(x == b.size());

    vector<vector<int>> prod(n , vector<int> (m)); 
    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < m ; j++) {
            for(int k = 0 ; k < x ; k++) {
                prod[i][j] += a[i][k] * b[k][j];
            }
        }
    }  

    return prod;
}

/*
    Matrix Exponentiation

    Paramters:
        1. Base (Matrix) -> A
        2. Exponent (n)
    
    Return Value : A ^ n
*/

vector<vector<int>> matrix_expo(vector<vector<int>>& a , int b) {
    assert(a.size() == a[0].size());
    int n = a.size();

    vector<vector<int>> prod(n , vector<int> (n , 0));
    for(int i = 0 ; i < n ; i++) {
        prod[i][i] = 1;
    }

    while(b) {
        if(b & 1) {
            prod = matrix_multiplication(prod , a);
        }
        a = matrix_multiplication(a , a);
        b >>= 1;
    } 
    return prod;
}

/*
    Function to calculate the nth fibonacci number using matrix exponentiation

    Paramters:
        1. n -> we need the nth fibonacci number

    Return value : The nth fibonacci number
*/

int fibonacci(int n) {
    vector<vector<int>> a(2 , vector<int> (2 , 1));
    a[1][1] = 0;

    if(n <= 1) {
        return n; 
    }

    a = matrix_expo(a , n-1);
    return a[0][0] + a[0][1];
}

int main() {
    int n = 20;
    for(int i = 0 ; i <= n ; i++) {
        cout << "fib(" << i << ") : " << fibonacci(i) << "\n";
    }
}