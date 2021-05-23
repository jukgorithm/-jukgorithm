import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, ArrayList<originCode>> hmNum = new HashMap<>();
        PriorityQueue<Node> que = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i ++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<originCode> tmp = hmNum.getOrDefault(
                genres[i], 
                new ArrayList<originCode>()
            );
            
            tmp.add(new originCode(i, plays[i]));
            hmNum.put(genres[i], tmp);
        }
        
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            que.offer(new Node(entry.getKey(), entry.getValue()));
        }

        while(!que.isEmpty()) {
            String target = que.poll().genre;
            ArrayList<originCode> ansList = sort(hmNum.get(target));
            ans.add(ansList.get(0).code);
            if(ansList.size() > 1) ans.add(ansList.get(1).code);
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i ++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    private ArrayList<originCode> sort(ArrayList<originCode> arr) {
        Collections.sort(arr, Collections.reverseOrder());
        return arr;
    }
}

class Node implements Comparable<Node>{
    String genre;
    int play;
    
    public Node(String genre, int play) {
        this.genre = genre;
        this.play = play;
    }
    
    @Override
    public int compareTo(Node n) { // 가중치 기준 오름차순 정렬
        return n.play-this.play;
    }
}

class originCode implements Comparable<originCode>{
    int code;
    int play;
    
    public originCode(int code, int play) {
        this.code = code;
        this.play = play;
    }
    
    @Override
    public int compareTo(originCode n) {
        return this.play-n.play;
    }
}
