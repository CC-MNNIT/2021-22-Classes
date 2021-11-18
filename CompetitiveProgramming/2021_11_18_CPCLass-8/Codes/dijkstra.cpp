#include <bits/stdc++.h>
using namespace std;

const int INF = 1000000000;

// adjacency list of weighted graph
vector<vector<pair<int, int>>> a;
 
vector<int> d , p , visited;
void dijkstra(int s){
	priority_queue<pair<int,int>> p;
	p.push({0 , s});
	d[s] = 0;
	
	while(!p.empty()){
		pair<int,int> p1 = p.top();
		p.pop();
		int x = p1.second;
		if(visited[x])continue;
		visited[x] = 1;
		
		for(pair<int,int> it : a[x]){
			if(d[it.first] > d[x] + it.second){
				d[it.first] = d[x] + it.second;
				p.push({-d[it.first] , it.first});
			}
		}
	}
}


int main() {
    int n , m;
    cin >> n >> m;
    visited.resize(n);
    a.resize(n);
    p.resize(n);
    d.resize(n);

    for(int i = 0 ; i < m ; i++) {
        int x , y , w;
        cin >> x >> y >> w;
        a[x].push_back({y , w});
    }

    dijkstra(0);
}