import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] st : clothes) {
            if(map.get(st[1]) == null) map.put(st[1], 2);
            else map.put(st[1], map.get(st[1])+1);
        }
        Collection<Integer> v = map.values();
        
        int answer = 1;
        
        for(int val : v) {
            answer *= val;
        }
        
              return answer-1;
    }
}
