package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드3_10986_나머지합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		int[] remains = new int[N + 1];
		int[] sum = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			remains[i] = num % M;
			sum[i] = sum[i - 1] + remains[i];
			if (remains[i] == 0) ans++;
		}
				
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if ((sum[j] - sum[i - 1]) % M == 0) ans++;
			}
		}
		
		System.out.println(ans);
	}
}
