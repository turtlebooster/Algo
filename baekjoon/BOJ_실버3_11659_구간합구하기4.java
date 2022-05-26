package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_실버3_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수
		
		// 누적 합 sum[i] 는 1 ~ i 까지 누적합
 		int[] sum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int s, e;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());	// 시작
			e = Integer.parseInt(st.nextToken());	// 끝 
			
			bw.append(sum[e] - sum[s - 1] + "\n");
		}
		
		bw.flush();
	}
}
