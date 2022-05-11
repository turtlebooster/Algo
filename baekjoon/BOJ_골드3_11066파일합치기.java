package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드3_11066파일합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int K;
		int[] arr, sum;
		int[][] dp;
		for (int t = 0; t < T; t++) {
			K = Integer.parseInt(br.readLine().trim());
			arr = new int[K]; // 주어진 데이터
			sum = new int[K]; // 누적합 
			
			st = new StringTokenizer(br.readLine());			
			sum[0] = arr[0] = Integer.parseInt(st.nextToken());
			for (int i = 1; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + arr[i];
			}
			
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(sum));
			
			dp = new int[K][K];	// dp[i][j] 는 arr[i] ~ arr[j] 까지 합칠때 드는 최소 비용  -> i >= j 인 곳의 값은 0
			// 초기값 : 2 개 합쳐서 나오는 값들
			for (int i = 0; i < K - 1; i++) {
				dp[i][i + 1] = arr[i] + arr[i + 1];
			}
			
			// 대각선 오른쪽 아래 방향 순으로 진행
			for (int j = 2; j < K; j++) {				
				for (int i = 0; i + j < K; i++) {
					// arr[i] ~ arr[i + j] 를 합치는 모든 조합
					for (int k = i; k < i + j; k++) {	
						// 처음 값은 0 이므로 0 일때는 값을 무조건 넣는다
						if (dp[i][i + j] == 0) {
							dp[i][i + j] = dp[i][k] + dp[k + 1][i + j];							
						} else { // 0이 아닐때는 비교해서 더 작은 값을 넣는다							
							dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j]);
						}						
					}
					// arr[i] ~ arr[i + j] 를 합치는 조합이 만들어지면
					// arr[i] ~ arr[i + j] 까지의 합을 더해준다
					dp[i][i + j] += sum[i + j] - (i > 0 ? sum[i - 1] : 0);
				}
			}
			
			System.out.println(dp[0][K - 1]);
		}
	}
}
