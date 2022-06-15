package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드5_2110_공유기설치 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] hPos = new int[N];
		
		for(int i = 0; i < N; i++) {
			hPos[i] = Integer.parseInt(br.readLine());
		}
		

		Arrays.sort(hPos);		
		
		int lo = 1;
		int hi = hPos[N - 1] - hPos[0];
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			
			int cnt = 1;
			int prev = hPos[0];
			
			for (int i = 1; i < N; i++) {
				if (hPos[i] - prev >= mid) {
					prev = hPos[i];
					cnt++;
				}
			}
			
			if (cnt < C) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
			
		}
	

		bw.append(Integer.toString(lo - 1));
		bw.flush();

	}
}
