import java.util.*;

class Solution {
    private final int MAX_RANK = 7;
    
    public int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> win = new ArrayList<>();
        int zero_count = 0;
        int match = 0;
        
        for(int i: win_nums) {
            win.add(i);
        }
        
        for(int i: lottos) {
            if(i == 0) {
                zero_count ++;
                continue;
            }
            if (win.remove((Integer)i)) match ++;
        }
        int min = MAX_RANK - match;
        int max = min - zero_count;
        
        int[] answer = new int[2];
        
        answer[0] = max > 6 ? 6 : max;
        answer[1] = min > 6 ? 6 : min;
            
        return answer;
    }
}
