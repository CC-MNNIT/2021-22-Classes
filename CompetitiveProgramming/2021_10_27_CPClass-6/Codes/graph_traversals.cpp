#include <bits/stdc++.h>
using namespace std;

int n;
vector<vector<int>> a;  //adjacency matrix
vector<vector<pair<int , int>>> adj;    // adjacency matrix for weighted graphs.
vector<int> visited;

void dfs_graph(int s) {
    if(visited[s]) return;
    visited[s] = 1;

    for(int it : a[s]) {
        dfs_graph(it);
    }
}

/*
    Since trees are special cases of graphs, we don't need to maintain visited array for them 
*/
void dfs_tree(int s , int p) {
    for(int it : a[s]) {
        if(it != p) {
            dfs_tree(it , s);
        }
    }
}

void single_source_bfs(int s) {
    queue<int> q;
    q.push(s);

    vector<int> visited(n) , d(n , INT_MAX);
    visited[s] = 1;
    d[s] = 0;

    while(!q.empty()) {
        int x = q.front();
        q.pop();
        
        for(int it : a[x]) {
            if(visited[it]) continue;
            visited[it] = 1;
            d[it] = d[x] + 1;
            q.push(it);
        }
    }
}

void multi_source_bfs(vector<int> sources) {
    queue<int> q;
    vector<int> visited(n) , d(n , INT_MAX);

    for(int s : sources) {
        q.push(s);
        visited[s] = 1;
        d[s] = 0;
    }

    while(!q.empty()) {
        int x = q.front();
        q.pop();
        
        for(int it : a[x]) {
            if(visited[it]) continue;
            visited[it] = 1;
            d[it] = d[x] + 1;
            q.push(it);
        }
    }
}

void bfs01(int s) {
    deque<int> q;
    vector<int> visited(n) , d(n , INT_MAX);
    q.push_back(s);
    visited[s] = 1;
    d[s] = 0;
    
    while(!q.empty()) {
        int x = q.front();
        q.pop_front();

        for(pair<int ,int> p : adj[x]) {
            /*
                p.first -> node
                p.second -> weight of edge [x , p.first]. Can only be 0 or 1.
            */
            if(visited[p.first]) continue;
            visited[p.first] = 1;
            if(p.second) {
                d[p.first] = d[x] + 1;
                q.push_back(p.first);
            }
            else {
                d[p.first] = d[x];
                q.push_front(p.first);
            }
        }
    }
}

int main() {
    int m;
    cin >> n >> m;
    a.resize(n);
    adj.resize(n);
    
    for(int i = 0 ; i < m ; i++) {
        int x , y , w;
        cin >> x >> y >> w;
        a[x].push_back(y);
        a[y].push_back(x);

        adj[x].push_back({y , w});
        adj[y].push_back({x , w});
    }

    dfs_graph(0);
    dfs_tree(0 , -1);

    bfs01(0);
    single_source_bfs(0);
    multi_source_bfs(vector<int>{0 , 1});
}