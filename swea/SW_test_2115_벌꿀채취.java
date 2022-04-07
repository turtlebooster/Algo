package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_test_2115_벌꿀채취 {
	static class Honey {
		int amount;
		int cost;
		boolean check;
		Honey(int amount) {
			this.amount = amount;
			this.cost = amount * amount;
		}
	}
	static int N, M, C, ans;
	static int[] max;
	static Honey[][] honey, choosed;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			honey = new Honey[N][N];
			choosed = new Honey[2][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					honey[i][j] = new Honey(Integer.parseInt(st.nextToken()));					
				}
			}
			
			ans = 0;			
			// 두 명의 일꾼 벌통 선택
			choose(0, 0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
		
		br.close();
	}
	
	// 두 명의 일꾼 벌통 선택
	public static void choose(int cnt, int r, int c) {
		if (cnt == 2) {
			// 벌통 선택 완료!
			max = new int[2];
			getMax(0, 0, 0, 0);
			getMax(1, 0, 0, 0);
			ans = Math.max(ans, max[0] + max[1]);
			return;
		}
		if (r >= N || c >= N) return;
		
		// 다음 인덱스
		int nr = c == N - M ? r + 1 : r; 
		int nc = c == N - M ? 0 : c + 1;
		
		if (honey[r][c].check) {
			// 이미 선택받은 상태
			choose(cnt, nr, nc);		// 선택 못하니까 다음 인덱스로
			return;
		}
		
		for (int i = 0; i < M; i++) {
			choosed[cnt][i] = honey[r][i + c];
			honey[r][i + c].check = true;
		}
		choose(cnt + 1, nr, nc);	// 선택한 경우
		
		for (int i = 0; i < M; i++) {
			honey[r][i + c].check = false;
		}
		choose(cnt, nr, nc);		// 선택하지 않은 경우
	}
	
	// 선택한 벌통에서 C 이하로 채취하는 최대값
	private static void getMax(int p, int idx, int sum, int costSum) {
		if (sum > C) return;
		if (idx == M) {
			// 다 골랐당
			max[p] = Math.max(max[p], costSum);
			return;
		}
		getMax(p, idx + 1, sum + choosed[p][idx].amount, costSum + choosed[p][idx].cost);
		getMax(p, idx + 1, sum, costSum);
	}
}
