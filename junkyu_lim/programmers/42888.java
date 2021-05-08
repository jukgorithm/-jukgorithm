import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> uid = new HashMap<>();
        Queue<Message> mes = new LinkedList<>();
        
        for(String i: record){
            String[] tar = i.split(" ");
            
            switch(tar[0]){
                case "Enter":
                    //todo
                    uid.put(tar[1] ,tar[2]);
                    mes.add(new Message(tar[1], "들어왔습니다."));
                    break;
                case "Leave":
                    //todo
                    mes.add(new Message(tar[1], "나갔습니다."));
                    break;
                case "Change":
                    // todo
                    uid.put(tar[1] ,tar[2]);
                    break;
            }
        }
        
        String[] answer = new String[mes.size()];
        int cnt = 0;
        for(Message m: mes) {
            answer[cnt] = uid.get(m.id) + "님이 " + m.action;
            cnt ++;
        }
        return answer;
    }
    
    // public String getMessage(Message mes) {
    //     return 
    // }
}

class Message {
    String id;
    String action;
    
    public Message(String id, String action) {
        this.id = id;
        this.action = action;
    }
}
