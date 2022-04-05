package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버3_15654_N과M_5 {
	public static int N, M;
	public static int[] data, sel;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) data[i] = Integer.parseInt(st.nextToken()); 
		Arrays.sort(data);
	
		sel = new int[M];
		
		comb(0, 1);
		bw.flush();
	}
	
	public static void comb(int cnt, int num) throws IOException {
		
	}
}
