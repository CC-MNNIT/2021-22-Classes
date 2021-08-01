#include <bits/stdc++.h>
using namespace std;

/*
    Parameters:
        1. The first number (a)
        2. The second number (b)
    It is expected to find the gcd of a , b

    Return value: A vector v comprising of the following things
        1. v[0] -> gcd(a , b)
        2. v[1] => x
        3. v[2] -> y

        where x , y are integers satisfying ax + by = gcd(a , b)
*/
vector<int> extended_euclidean_algo(int a , int b) {
    if(b == 0) {
        return vector<int> {a , 1 , 0};
    }
    vector<int> v = extended_euclidean_algo(b , a % b);
    int x = v[1] , y = v[2];
    vector<int> ans(3);
    ans[0] = v[0];
    ans[1] = y;
    ans[2] = x - (a/b)*y;
    return ans;
}

/*
    An alternative implementation of the extended euclidean algorithm
    Parameters:
        1. First number (a)
        2. Second number (b)
        3. x component of the solution
        4. y component ofthe solution
    
    Return value : gcd(a , b)
*/
int extended_euclidean_algo_alter(int a , int b , int& x , int& y) {
    if(b == 0) {
        x = 1;
        y = 0;
        return a;
    }
    int x1 , y1;
    int hcf = extended_euclidean_algo_alter(b , a % b , x1 , y1);
    x = y1;
    y = x1 - (a/b)*y1;
    return hcf;
}


int main() {
    int a = 29 , b = 37;
    vector<int> v = extended_euclidean_algo(a , b);
    assert(a * v[1] + b * v[2] == v[0]);
    cout << v[0] << " " << v[1] << " " << v[2] << "\n";

    int x , y;
    int hcf = extended_euclidean_algo_alter(a , b , x , y);
    assert(a * x + b * y == hcf);

    cout << hcf << " " << x << " " << y << "\n";
}