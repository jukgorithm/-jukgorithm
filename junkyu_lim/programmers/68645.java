import java.util.*;

class Solution {
    int topPoint = 0;
    int bottomPoint;
    
    int Num = 1;
    
    public int[] solution(int n) {
        ArrayList<ArrayList<Integer>> tri = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            tri.add(new ArrayList<Integer>());
        }
        bottomPoint = n;
        int current = 0;
        while(true) {
            makeTri(tri, current);
            current ++;
            topPoint += 2;
            bottomPoint -= 1;
            if ((bottomPoint - topPoint) == 1) {
                tri.get(topPoint).add(current, Num ++);
                break;
            }
            if (bottomPoint <= topPoint) break;
        }
        System.out.println(Num);
        
        int[] answer = new int[Num-1];
        int count = 0;
        for(ArrayList<Integer> arr : tri) {
            for(int rs : arr) {
                answer[count] = rs;
                count ++;
            }
        }
        return answer;
    }
    public void makeTri(ArrayList<ArrayList<Integer>> tri, int current) {
        int idx;
        int side = 0;
        for(idx = topPoint; idx < bottomPoint; idx ++) {
            side ++;
            tri.get(idx).add(current, Num ++);
        }
        
        int bottomCount = current + 1;
        for(int j = 1; j < side; j ++) {
            tri.get(bottomPoint - 1).add(bottomCount,Num ++);
            bottomCount ++;
        }
        
        for(int i = bottomPoint-2; i > topPoint; i --) {
            tri.get(i).add(current+1, Num ++);
        }
    }
}

