package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_17281_야구 {
	static int N, max;
	static int[] team;
	static boolean[] visited;
	static int[][] potential;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 이닝 수
		N = Integer.parseInt(br.readLine());
		potential = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				potential[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;	
		team = new int[9];
		team[3] = 0;
		visited = new boolean[9];
		visited[0] = true;
		
		makeTeam(0);
		System.out.println(max);
		
	}
	// 팀 순서 정하기
	static void makeTeam (int cnt){
		if (cnt == 9) {
			play(0, 0, 0);
			return;
		} 
		if (cnt == 3) {			
			makeTeam(cnt + 1);
			return;
		}
		
		for (int i = 1; i < 9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			team[cnt] = i;
			makeTeam(cnt + 1);
			visited[i] = false;
		}
	}
	// 게임 진행
	static void play(int ining, int sum, int now) {
		if (ining == N) {
			if (max < sum) max = sum;
			return;
		}
		
		int outCnt = 0;
		int[] base = new int[3];
		while (outCnt < 3) {
			switch (potential[ining][team[now]]) {
			case 1:
				// 안타
				sum += base[2];
				base[2] = base[1];
				base[1] = base[0];
				base[0] = 1;						
				break;
			case 2:
				// 2루타
				sum += base[2] + base[1];
				base[2] = base[0];
				base[1] = 1;
				base[0] = 0;						
				break;
			case 3:
				// 3루타
				sum += base[2] + base[1] + base[0];
				base[2] = 1;
				base[1] = 0;
				base[0] = 0;
				break;
			case 4:
				// 홈런
				sum += base[2] + base[1] + base[0] + 1;
				base[2] = 0;
				base[1] = 0;
				base[0] = 0;
				break;
			default:
				// 아웃
				outCnt++;
			}
			now = (now + 1) % 9;
		}	
		play(ining + 1, sum, now);
	}
}
