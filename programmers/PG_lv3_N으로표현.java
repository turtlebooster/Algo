package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PG_lv3_N으로표현 {
    public int solution(int N, int number) {
        int answer = -1;
        
        Map<Integer, Integer> dpMap = new HashMap<>();
        List<Integer> dpList = new ArrayList<>();
        
        int n = 0;
        for (int i = 1; i <= 8; i++) {
            n = 10 * n + N;
            dpMap.put(n, i);
            dpList.add(n);
        }        
        
        int cnt;
        int num1, num2;
        for (int i = 0; i < dpList.size(); i++) {
            num1 = dpList.get(i);
            for (int j = 0; j < dpList.size(); j++) {
                num2 = dpList.get(j);
                cnt = dpMap.get(num1) + dpMap.get(num2);
                if (cnt > 8) continue;
								// 덧셈
                add(num1 + num2, cnt, dpMap, dpList);
								// 곱셈
                add(num1 * num2, cnt, dpMap, dpList);
                // 뺄셈                
                if (num1 < num2) {
                    add(num2 - num1, cnt, dpMap, dpList);
                } else {
                    add(num1 - num2, cnt, dpMap, dpList);
                }
								// 나눗셈
                if(num1 != 0) {
                    add(num2 / num1, cnt, dpMap, dpList);                    
                }
                if(num2 != 0) {
                    add(num1 / num2, cnt, dpMap, dpList);                    
                }     
            }
        }
        
        if (dpMap.get(number) != null) {
            answer = dpMap.get(number);
        }
        return answer;
    }
    public void add(int res, int cnt, Map<Integer, Integer> dpMap, List<Integer> dpList) {
        if(dpMap.get(res) == null) {
            dpMap.put(res, cnt);                    
            dpList.add(res);
        } else if(dpMap.get(res) > cnt) {
            dpMap.put(res, cnt);                    
        }   
    }
}
