#include <bits/stdc++.h>
using namespace std;

// adjacency list of unweighted graph
vector<vector<int>> a;

// adjacency list of weighted graph
vector<vector<pair<int, int>>> adj;

vector<int> visited;

// DFS for any graph
void dfs(int s) {
    visited[s] = 1;
    for(int i = 0 ; i < a[s].size() ; i++) {
        if(!visited[a[s][i]]) {
            dfs(a[s][i]);
        }
    }
}

/*
    dfs(1) -> dfs(2) -> dfs(3) -> dfs(2) -> dfs(4) -> dfs(2) -> dfs(1) -> dfs(5) -> dfs(6) -> dfs(5) -> dfs(1) -> main
*/


// Tree DFS. We only to need to make sure that we don't go back to the parent.
void tree_dfs(int s , int p = -1) {
    for(int i = 0 ; i < a[s].size() ; i++) {
        if(a[s][i] != p) {
            tree_dfs(a[s][i] , s);
        }
    }
}

int main() {
    int n , m;
    cin >> n >> m;
    visited.resize(n);
    a.resize(n);
    adj.resize(n);
    for(int i = 0 ; i < m ; i++) {
        int x , y , w;
        cin >> x >> y >> w;
        a[x].push_back(y);
        adj[x].push_back({y , w});
    }

    for(int i = 0 ; i < n ; i++) {
        if(!visited[i])
            dfs(i);
    }
    tree_dfs(0);
}