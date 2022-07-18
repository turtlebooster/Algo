package programmers;

import java.util.*;

public class PG_lv2_오픈채팅방 {
	class Solution {
	    public String[] solution(String[] record) {
	        StringTokenizer st;
	        int N = record.length;
	        HashMap<String, String> list = new HashMap<>(); // uid : name
	        String[][] ans = new String[N][2];      // {uid, in or out}
	        
	        int len = N;
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(record[i]);
	            String in = st.nextToken();
	            String uid = st.nextToken();
	            String name = st.nextToken();
	            
	            // 들어왔을때
	            if (in.equals("Enter")){                    
	                // 키값 등록되지 않았으면 등록
	                if (list.get(uid) == null) {
	                    list.put(uid , name);    
	                }        
	                ans[i][0] = uid;
	                ans[i][1] = "in";
	            }
	            // 나갔을때
	            else if (in.equals("Leave")){    
	                ans[i][0] = uid;
	                ans[i][1] = "out";
	            }
	            // 이름 변경 (change)
	            else {                
	                list.replace(uid, name);     
	                len--;
	            }
	        }
	        
	        // 답 입력
	        String[] answer = new String[len];
	        for (int i = 0; i < len; i++) {
	            answer[i] = list.get(ans[i][0]) + "님이 ";
	            if (ans[i][1].equals("in")) {
	                answer[i] += "들어왔습니다.";
	            } else {
	                answer[i] += "나갔습니다.";
	            }
	        }        
	
	        return answer;
	    }   
	
	}
}