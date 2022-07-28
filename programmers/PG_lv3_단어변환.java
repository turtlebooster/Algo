package programmers;

import java.util.*;

public class PG_lv3_단어변환 {
	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int N = words.length;
        
        List<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adjList[i] = new ArrayList<>();
        
        // 타겟이 words 안에 있는지 여부 및 위치 찾기           
        int targetIdx = -1;
        for (int i = 0; i < N; i++) {
            // words 안에 target 이 있는지 체크
            if (words[i].equals(target)) {                         
                targetIdx = i;
            }
            for (int j = i + 1; j < N; j++) {
                // 인접 리스트 작성
                if (!changable(words[i], words[j])) continue;
                adjList[i].add(j);
                adjList[j].add(i);
            }
        }        
                
        // target이 없을경우 0 
        if (targetIdx == -1) {
            return 0;
        }
        
        // begin과의 관계
        for (int i = 0; i < N; i++) {
                // 인접 리스트 작성
                if (!changable(begin, words[i])) continue;
                adjList[N].add(i);
                adjList[i].add(N);
        }
                
        // target이 있을경우 BFS 탐색 진행
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new int[] {N, 0});
        visited[N] = true;
        
        int[] curr;
        while(!q.isEmpty()) {
            curr = q.poll();
            
            if (curr[0] == targetIdx) {
                return curr[1];
            }
            
            for (int next : adjList[curr[0]]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(new int[] {next, curr[1] + 1});                
            }
        }
        
        // 변환 못할 경우
        return 0;
    }
    
    // 한 개의 알파벳만 다른지 체크
    public boolean changable(String s1, String s2) {
        int cnt = 0;
        
        if (s1.length() != s2.length()) return false;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (++cnt > 1) return false;
        }
                
        return true;
    }
}
