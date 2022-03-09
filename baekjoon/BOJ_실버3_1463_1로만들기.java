package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_실버3_1463_1로만들기 {
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		System.out.println(calc(X));
		
		br.close();
	}
	
	static int INF = 1000000;
	public static int calc (int X) {
		int[] p = new int[X + 1];
		
		for (int i = 0; i <= X; i++) p[i] = INF;
		
		if (X >= 3) p[3] = 1; 
		if (X >= 2) p[2] = 1;
		p[1] = 0;
		
		for (int i = 1; i < X; i++) {
			if (i + 1 > X) continue;
			p[i + 1] = Math.min(p[i + 1], p[i] + 1);
			
			if (i * 2 > X) continue;
			p[i * 2] = Math.min(p[i * 2], p[i] + 1);
			
			if (i * 3 > X) continue;
			p[i * 3] = Math.min(p[i * 3], p[i] + 1);
		}
				
		return p[X];
	}
}
