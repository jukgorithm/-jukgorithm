import java.util.*;

class Solution {
    public String solution(String p) {
        // 1
        if (p == "") return "";
		
		if (isValidate(p)) return p;

		String answer = "";

		int right= 0;
		int left = 0;
		int index = 0 ;

        // 2
		for (char c : p.toCharArray()) {
			index++;

			if(c == '(') left++;
			else if(c == ')') right++;

			if (right == left) {
				break;
			}
		}

		String u = p.substring(0,index);
		String v = p.substring(index,p.length());
		
		// System.out.println("u : " + u +", v : " + v );
		
        // 3
		if (isValidate(u)) {
			answer = u;
			answer += solution(v);
		} else {
            // 4
			answer += "(";
			answer += solution(v);
			answer += ")";
			
			u = u.substring(1,u.length()-1);

			for( char c : u.toCharArray() ) {
				if(c==')') {
					answer += "(";
				} else if(c == '(')
					answer += ")";
			}
		}
        
		return answer;
	}

	// 올바른 괄호 문자열 임을 확인함
	private static boolean isValidate(String p) {

		int cnt = 0 ;

		for ( char c : p.toCharArray() ) {
			if(c=='(') cnt++;
			else if(c==')') cnt--;

			if(cnt < 0 ) return false;
		}

		return true;
	}
}
