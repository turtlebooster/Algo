package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드5_7511_소셜네트워킹어플리케이션 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		int N, K, a, b, M;
		int[] P;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
			
			P = new int[N];
			for (int i = 0; i < N; i++) {
				P[i] = i;
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				union(a, b, P);
			}
			
			sb.append("Scenario " + t + ":\n");
			M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if (findSet(a, P) == findSet(b, P)) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int findSet(int x, int[] P) {
		if(P[x] != x) P[x] = findSet(P[x], P);
		return P[x];
	}
	
	static void union(int x, int y, int[] P) {
		int X = findSet(x, P);
		int Y = findSet(y, P);
		if (X < Y) {
			P[Y] = X;
		} else {
			P[X] = Y;
		}
	}
}
