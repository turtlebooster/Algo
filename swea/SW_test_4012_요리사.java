package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_test_4012_요리사 {
	static int N, min;
	static int[] selA, selB;
	static int[][] synergy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			synergy = new int[N + 1][N + 1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					synergy[i][j] = synergy[j][i] += Integer.parseInt(st.nextToken());
				}
			}
			
//			System.out.println(Arrays.deepToString(synergy).replace("], ", "]\n"));
			
			selA = new int[N / 2];
			selB = new int[N / 2];

			min = Integer.MAX_VALUE;
			comb(0, 0, 1);
			
			System.out.println("#" + t + " " + min);
		}
	}
	public static void comb(int cntA, int cntB, int idx) {
		if (cntB == N / 2 && cntA == N / 2) {
			// 사용된 재료 개수
			clac();
			return;
		}
		if (idx > N) return;
		
		// A 에 사용		
		if (cntA < N / 2) {
			selA[cntA] = idx;
			comb(cntA + 1, cntB, idx + 1);			
		}
		// A 에 사용 안함
		if (cntB < N / 2) {
			selB[cntB] = idx;
			comb(cntA, cntB + 1, idx + 1);
		}
	}
	private static void clac() {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				sumA += synergy[selA[i]][selA[j]];
				sumB += synergy[selB[i]][selB[j]];
			}
		}
//		System.out.println(sumA);
//		System.out.println(sumB);
		min = Math.min(min, Math.abs(sumA - sumB));
	}
}
