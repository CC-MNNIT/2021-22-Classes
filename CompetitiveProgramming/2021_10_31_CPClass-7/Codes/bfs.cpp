#include <bits/stdc++.h>
using namespace std;

// adjacency list of unweighted graph
vector<vector<int>> a;

// adjacency list of weighted graph
vector<vector<pair<int, int>>> adj;

vector<bool> used;
vector<int> d , p;

// BFS for any graph
void bfs(int s) {   // s -> root
    queue<int> q;
    q.push(s);
    used[s] = true;
    p[s] = -1;
    while (!q.empty()) {
        int v = q.front();
        q.pop();
        for (int u : a[v]) {
            if (!used[u]) {
                used[u] = true;
                q.push(u);
                d[u] = d[v] + 1;
                p[u] = v;
            }
            else {
                if(u == p[v]) {
                    continue;
                }
                // graph has cycle
                return;
            }
        }
    }
}

void bfs01(int s) {   // s -> root
    deque<int> q;
    q.push_back(s);
    used[s] = true;
    while (!q.empty()) {
        int v = q.front();
        q.pop_front();
        for (pair<int , int> p : adj[v]) {
            int u = p.first;
            int w = p.second;
            if (!used[u]) {
                if(w == 0) {
                    d[u] = d[v];
                    q.push_front(u);
                    used[u] = true;
                }
                else {
                    used[u] = true;
                    q.push_back(u);
                    d[u] = d[v] + 1;
                }
            }
        }
    }
}

int main() {
    int n , m;
    cin >> n >> m;
    used.resize(n);
    a.resize(n);
    p.resize(n);
    d.resize(n);
    adj.resize(n);
    for(int i = 0 ; i < m ; i++) {
        int x , y , w;
        cin >> x >> y >> w;
        a[x].push_back(y);
        adj[x].push_back({y , w});
    }

    bfs(0);
}