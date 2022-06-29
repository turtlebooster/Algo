package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_브론즈1_10989_수정렬하기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cnt = new int[10001];
		
		for (int i = 0; i < N; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		int size;
		for (int i = 1; i < 10001; i++) {
			size = cnt[i];
			for (int j = 0; j < size; j++) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}
