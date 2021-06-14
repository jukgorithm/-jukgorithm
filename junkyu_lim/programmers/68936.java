class Solution {
    int[][] metrics;
    int[] xQuad = {0, 0, 1, 1};
    int[] yQuad = {0, 1, 0, 1};
    
    public int[] solution(int[][] arr) {
        metrics = arr;
        int size = arr.length;
        
        value rs = getQuad(new point(0,0), new point(size, size));
        
        int[] answer = new int[2];
        
        answer[0] = rs.zero;
        answer[1] = rs.one;
        return answer;
    }
    // 4등분해서 재귀적으로 value를 만들어주는 함수 생성
    
    public value getQuad(point startPoint, point endPoint) {
        value v = new value(0, 0);
        int quadSide = (endPoint.x - startPoint.x) / 2;
        
        // System.out.print(startPoint.toString() + endPoint.toString());
        
        int searchResult = searchMetrics(startPoint, endPoint);
        
        // System.out.println(searchResult);
        
        if(searchResult == -1) {
            for(int idx = 0; idx < 4; idx ++) {
                int x = (xQuad[idx] * quadSide) + startPoint.x;
                int y = (yQuad[idx] * quadSide) + startPoint.y;
                point p = new point(x, y);
                point endP = new point(x+quadSide, y + quadSide);
                
                value newV = getQuad(p, endP);
                v.addValue(newV.zero, newV.one);
            } 
        }
        else if(searchResult == 0) {
            v.addValue(1, 0);
        }
        else if(searchResult == 1) {
            v.addValue(0, 1);
        }
        
        return v;
    }
    
    private int searchMetrics(point startPoint, point endPoint) {
        int firstValue = metrics[startPoint.x][startPoint.y];
        for(int currentX = startPoint.x; currentX < endPoint.x; currentX ++) {
            for(int currentY = startPoint.y; currentY < endPoint.y; currentY ++) {
                if (metrics[currentX][currentY] != firstValue) return -1;
            }
        }
        
        return firstValue;
    }
    
}
class point {
    int x;
    int y;
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "X : " + x + " Y : " + y;
    }
}

class value {
    int zero;
    int one;
    
    public value(int zero, int one) {
        this.zero = zero;
        this.one = one;
    }
    
    public void addValue(int zero, int one) {
        this.zero += zero;
        this.one += one;
    }
}
