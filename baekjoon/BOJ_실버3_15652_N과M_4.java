package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버3_15652_N과M_4 {
	public static int N, M;
	public static int[] sel;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		comb(0, 1);
		bw.flush();
	}
	
	public static void comb(int cnt, int num) throws IOException {
		if (cnt == M) {
			bw.append(Arrays.toString(sel).replaceAll("[\\[\\,\\]]", "")).append("\n");
			return;
		}
		if (num > N) return;
		sel[cnt] = num;		
		comb(cnt + 1, num);		// 뽑고 다음에 이거 또 뽑을지 말지
		comb(cnt, num + 1);		// 안뽑고 이 수는 더이상 안 뽑아
	}
}
