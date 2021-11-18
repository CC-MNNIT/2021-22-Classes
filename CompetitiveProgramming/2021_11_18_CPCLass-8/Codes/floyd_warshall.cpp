#include <bits/stdc++.h>
using namespace std;

const int INF = 1000000000;

// adjacency matrix of unweighted graph
vector<vector<int>> a;

int main() {
    int n , m;
    cin >> n >> m;
   
    a.resize(n , vector<int> (n , 0));
    vector<vector<int>> d(n , vector<int> (n));
    for(int i = 0 ; i < m ; i++) {
        int x , y , w;
        cin >> x >> y >> w;
        a[x][y] = w;
        a[y][x] = w;
    }

    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < n ; j++) {
            if(!a[i][j]) d[i][j] = INF;
            else d[i][j] = a[i][j];
        }
    }
    
    for (int k = 0; k < n; ++k) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (d[i][k] < INF && d[k][j] < INF)
                    d[i][j] = min(d[i][j], d[i][k] + d[k][j]); 
            }
        }
    }
}

