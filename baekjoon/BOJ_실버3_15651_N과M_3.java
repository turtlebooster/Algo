package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버3_15651_N과M_3 {
	public static int N, M;
	public static int[] sel;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		perm(0);
		bw.flush();
	}
	
	public static void perm(int cnt) throws IOException {
		if (cnt == M) {
			bw.append(Arrays.toString(sel).replaceAll("[\\[\\,\\]]", "")).append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			sel[cnt] = i;		
			perm(cnt + 1);
		}
	}
}
