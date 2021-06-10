class Solution {
    public int[] solution(String s) {
        int count = 0;
        int deleteZeroCount = 0;
        while(true) {
            count ++;
            String deleteZero = s.replaceAll("0", "");
            int c = deleteZero.length();
            deleteZeroCount += (s.length() - c);
            
            s = Integer.toBinaryString(c);
            
            if(s.equals("1")) break;
        }
        
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = deleteZeroCount;
        return answer;
    }
}
