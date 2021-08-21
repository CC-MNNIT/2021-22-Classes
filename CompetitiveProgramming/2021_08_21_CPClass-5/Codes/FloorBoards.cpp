#include <bits/stdc++.h>
using namespace std;


int dp[11][11][2][(1 << 10)];
int fun(int i , int j , int is_hor , int mask , const int& n , const int& m , vector<string>& room) {
    if(i == n) {
        return 0;
    }
    if(j == m) {
        return fun(i+1 , 0 , 0 , mask , n , m , room);
    }

    if(dp[i][j][is_hor][mask] != -1) return dp[i][j][is_hor][mask];

    if(room[i][j] == '#') {
        return dp[i][j][is_hor][mask] = fun(i , j+1 , 0 , mask & (~(1 << j)) , n , m , room);
    }

    
    if(is_hor == 0) {
        if(mask & (1 << j)) {
            return dp[i][j][is_hor][mask] = min(fun(i , j+1 , 0 , mask , n , m , room) , fun(i , j+1 , 1 , mask & (~(1 << j)) , n , m , room) + 1);
        }

        return dp[i][j][is_hor][mask] = min(fun(i , j+1 , 1 , mask , n , m , room) + 1 , fun(i , j+1 , 0 , mask | (1 << j) , n , m , room) + 1);
        
    }

    if(mask & (1 << j)) {
        return dp[i][j][is_hor][mask] = min(fun(i , j+1 , 1 , mask & (~(1 << j)) , n , m , room) , fun(i , j+1 , 0 , mask , n , m , room));
    }
    
    return dp[i][j][is_hor][mask] = min(fun(i , j+1 , is_hor , mask , n , m , room) , fun(i , j+1 , 0 , mask | (1 << j) , n , m , room) + 1);
    
}

int layout(vector <string> room) {
    memset(dp , -1 , sizeof(dp));
    int n = room.size() , m = room[0].size();
    return fun(0 , 0 , 0 , 0 , n , m , room);
}

signed main() {
    vector<string> v = {"....." ,"....." ,"....." ,"....." ,"....."};
    cout << layout(v) << "\n";
}