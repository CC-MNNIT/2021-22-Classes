#include <bits/stdc++.h>
using namespace std;

const int INF = 1000000000;
int n , m;

struct edge
{
    int a, b, cost;
};

vector<edge> e;

vector<int> used , d , p;


// bellman ford works on directed graphs

/*
    a -> b
*/
void bellman_ford(int v) {
    d.assign(n , INF);
    d[v] = 0;

    int iterations = n;
    while(iterations--)
    {
        bool any = false;

        for (int j = 0 ; j < m ; ++j)
            if (d[e[j].a] < INF)
                if (d[e[j].b] > d[e[j].a] + e[j].cost)
                {
                    d[e[j].b] = d[e[j].a] + e[j].cost;
                    any = true;
                }

        if (!any) break;
    }

    if(iterations == 0) {
        cout << "Negative Cycle present so all distances would be -oo\n";
        return;
    }

    // display d, for example, on the screen
}

/*
    Time Complexity : O(N * M)
    Space COmplexity : O(N + M)
*/


int main() {
    cin >> n >> m;
    used.resize(n);
    p.resize(n);
    d.resize(n);
    e.resize(m);
    for(int i = 0 ; i < m ; i++) {
        int x , y , w;
        cin >> x >> y >> w;
        e[i] = {x , y , w};
    }

    bellman_ford(0);
}
