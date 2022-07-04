package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG_lv2_카카오프렌즈컬러링북 {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        // BFS
        boolean[][] visited = new boolean[m][n];        
        Queue<int[]> q = new LinkedList<>();
        
        // 사방탐색을 위한 방향 벡터
        int[] dr = {1, -1, 0 , 0};
        int[] dc = {0 , 0, 1, -1};
        
        int[] curr;
        int nr, nc, cnt, color;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 색칠하지 않는 영역이거나 이미 방문한 곳이면 통과
                if (picture[i][j] == 0 || visited[i][j]) continue;
                // 새로운 영역이므로 + 1
                numberOfArea++;
                // 해당 영역의 색깔
                color = picture[i][j];
                
                q.add(new int[] {i, j});
                visited[i][j] = true;
                
                // 영역 크기 체크 초기화
                cnt = 0;
                while(!q.isEmpty()) {
                    curr = q.poll();
                    
                    cnt++;
                    
                    // 4방 탐색
                    for (int d = 0; d < 4; d++) {
                        nr = curr[0] + dr[d];     
                        nc = curr[1] + dc[d];
                        
                        // 범위 체크, 색깔 체크, 방문 체크
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n
                            || picture[nr][nc] != color
                            || visited[nr][nc]) continue;
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }                    
                }
                
                // 영역 최대값 확인
                if (maxSizeOfOneArea < cnt) maxSizeOfOneArea = cnt;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
