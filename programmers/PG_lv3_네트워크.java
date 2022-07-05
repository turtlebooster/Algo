package programmers;

import java.util.Queue;
import java.util.LinkedList;

public class PG_lv3_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // BFS
        boolean[] check = new boolean[n];        
        Queue<Integer> q = new LinkedList<>();        
        
        int curr;
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            answer++;
            check[i] = true;
            q.add(i);
            while(!q.isEmpty()) {
                curr = q.poll();

                for (int j = 0; j < n; j++) {
                    // 연결되지 않았거나, 이미 체크했다면 통과
                    if (computers[curr][j] != 1 || check[j]) continue;                
                    check[j] = true;
                    q.add(j);
                }
            }     
        }
        
        return answer;
    }
}
