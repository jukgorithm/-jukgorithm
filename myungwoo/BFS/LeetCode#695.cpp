// Max Area of Island
using namespace std;
class Solution {
public:
    
    const int Visit = 2;
    const int Island = 1;
    
    vector<vector<int>> dirs = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    
    
    int bfs(pair<int, int> pos, vector<vector<int>>& grid){
        int ret = 0;
        queue<pair<int, int>> q;
        
        q.push({pos.first, pos.second});
        grid[pos.first][pos.second] = Visit;
        ret++;
        
        while(!q.empty()){
            auto cur = q.front();
            q.pop();
            for(auto dir : dirs){
                int newR = cur.first + dir[0];
                int newC = cur.second + dir[1];
                
                if(newR < 0 || newR >= grid.size() || newC < 0 || newC >= grid[0].size()) continue;
                
                if(grid[newR][newC] != Visit && grid[newR][newC] == Island){
                    q.push({newR, newC});
                    grid[newR][newC] = Visit;
                    ret++;
                }
            }
        }
        return ret;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int ret = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[0].size(); ++j) {
                if(grid[i][j] == Island){
                    ret = max(ret, bfs({i,j}, grid));
                }
            }
        }
        return ret;
    }
};