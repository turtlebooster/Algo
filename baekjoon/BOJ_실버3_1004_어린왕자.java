package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버3_1004_어린왕자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());		
		
		for (int t = 1; t <=T; t++) {
			st = new StringTokenizer(br.readLine());
			int[] start = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] end = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			int cnt = 0;
			
			int N = Integer.parseInt(br.readLine());
			// 각 행성의 위치 및 반지름 기록
			int[][] planet = new int[N][];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				planet[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
				
				// 한 행성에 대해 하나는 내부 나머지는 외부에 있는게 판별될때마다 경계 하나를 지나야됨
				if (isIn(start, planet[i]) != isIn(end, planet[i])) cnt++;
			}
			
			System.out.println(cnt);
		}	
	}
	
	// 시작점 이나 끝점 그리고 행성정보가 주어졌을때 안에 있는지 밖에 있는지 판별
	public static boolean isIn(int[] pos, int[] planet) {
		double dist = Math.pow((pos[0] - planet[0]), 2) + Math.pow((pos[1] - planet[1]), 2);
		double R2 = Math.pow(planet[2], 2);
		
		if (dist < R2) return true;
		else return false;
	}
}
