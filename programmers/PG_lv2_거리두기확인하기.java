package programmers;

import java.util.Queue;
import java.util.LinkedList;

public class PG_lv2_거리두기확인하기 {
	class Solution {
	    public int[] solution(String[][] places) {
	        int[] answer = {1, 1, 1, 1, 1};
	        
	        outer:
	        for (int t = 0; t < 5; t++) {
	            char[][] pos = new char[5][];
	            for (int i = 0; i < 5; i++) {
	                pos[i] = places[t][i].toCharArray();
	            }

	            int[] dr = {-1, 1, 0, 0};
	            int[] dc = {0, 0, -1, 1};
	            
	            Queue<int[]> q;
	            boolean[][] visited = new boolean[5][5];
	            
	            int size, nr, nc, cnt;
	            int[] p;
	            for (int i = 0; i < 5; i++) {
	                for (int j = 0; j < 5; j++) {
	                    // 응시자일 경우만 탐색 진행
	                    if (pos[i][j] != 'P') continue;
	                    q = new LinkedList<>();
	                    q.add(new int[] {i, j});
	                    visited[i][j] = true;
	                    
	                    // BFS
	                    cnt = 0;
	                    while(!q.isEmpty()) {
	                        size = q.size();
	                        for (int k = 0; k < size; k++) {
	                            p = q.poll();
	                            
	                            for (int d = 0; d < 4; d++) {
	                                nr = p[0] + dr[d];                                    
	                                nc = p[1] + dc[d];                                    
	                                
	                                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5
	                                    || visited[nr][nc]
	                                    || pos[nr][nc] == 'X') continue;
	                                visited[nr][nc] = true;
	                                
	                                if (pos[nr][nc] == 'P') {
	                                    answer[t] = 0;
	                                    continue outer;
	                                }
	                                
	                                if (cnt >= 1) continue;
	                                q.add(new int[] {nr, nc});
	                            }
	                        }
	                        cnt++;
	                    }
	                    
	                }
	            }
	            
	            
	        }
	        
	        return answer;
	    }
	}
}
