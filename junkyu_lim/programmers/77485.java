import java.util.*;

class Solution {
    public int[][] table;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        table = new int[rows+1][columns+1];
        int len = queries.length;
        
        for(int i = 1; i < rows+1; i ++) {
            for(int j = 1; j < columns+1; j ++) {
                table[i][j] = (i - 1) * columns + j;
            }
        }

        int[] answer = new int[len];
        
        for(int k = 0; k < len; k ++) {
            answer[k] = rotate(queries[k]);
        }
        return answer;
    }
    public int rotate(int[] query) {
        Queue<Integer> que = new LinkedList<>();
        Queue<point> locations = getLocation(query);
        
        for(point p : locations) {
            que.offer(table[p.row][p.col]);
        }
        int min = Collections.min(que);
        
        point first = locations.poll();
        locations.offer(first);
        
        for(point point : locations) {
            table[point.row][point.col] = que.poll();
        }
        
        return min;
    }
    public Queue<point> getLocation(int[] query) {
        Queue<point> que = new LinkedList<>();
        for(int i = query[1]; i < query[3]; i ++) {
            que.offer(new point(query[0],i));
        }
        for(int j = query[0]; j < query[2]; j ++) {
            que.offer(new point(j, query[3]));
        }
        for(int k = query[3]; k > query[1]; k --) {
            que.offer(new point(query[2], k));
        }
        for(int l = query[2]; l > query[0]; l --) {
            que.offer(new point(l, query[1]));
        }
        
        return que;
    }
}

class point {
    int row;
    int col;
    public point(int x, int y) {
        this.row = x;
        this.col = y;
    }
    
}
