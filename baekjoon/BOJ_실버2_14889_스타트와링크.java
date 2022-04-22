package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버2_14889_스타트와링크 {
	static int N, min;
	static int[] selS, selL;
	static int[][] ability;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		ability = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ability[i][j] = ability[j][i] += Integer.parseInt(st.nextToken());
			}
		}
		
//		System.out.println(Arrays.deepToString(ability).replace("], ", "]\n"));
		
		selS = new int[N / 2];
		selL = new int[N / 2];

		min = Integer.MAX_VALUE;
		comb(0, 0, 1);
		
		System.out.println(min);
	}
	public static void comb(int cntS, int cntL, int idx) {
		if (cntL == N / 2 && cntS == N / 2) {
			// 사용된 재료 개수
			clac();
			return;
		}
		if (idx > N) return;
		
		// Start 에 사용		
		if (cntS < N / 2) {
			selS[cntS] = idx;
			comb(cntS + 1, cntL, idx + 1);			
		}
		// Link 에 사용
		if (cntL < N / 2) {
			selL[cntL] = idx;
			comb(cntS, cntL + 1, idx + 1);
		}
	}
	private static void clac() {
		int sumS = 0;
		int sumL = 0;
		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				sumS += ability[selS[i]][selS[j]];
				sumL += ability[selL[i]][selL[j]];
			}
		}
//		System.out.println(sumS);
//		System.out.println(sumL);
		min = Math.min(min, Math.abs(sumS - sumL));
	}
}
