package baekjoon;

import java.util.HashSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_실버4_9575_행운의수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 데이터 입력
			int N = Integer.parseInt(br.readLine());
			HashSet<Integer> A = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			HashSet<Integer> B = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B.add(Integer.parseInt(st.nextToken()));
			}
			
			int K = Integer.parseInt(br.readLine());
			HashSet<Integer> C = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				C.add(Integer.parseInt(st.nextToken()));
			}
			
			// 행운의 수 개수 계산
			HashSet<Integer> lucky = new HashSet<>();
			for (int a : A) {
				for (int b : B) {
					for (int c : C) {
						int num = a + b + c;
						if (check(num)) lucky.add(num); 
					}
				}
			}
			
			// 출력
			System.out.println(lucky.size());
		}				
		br.close();
	}
	
	public static boolean check(int num) {
		
		while (num > 0) {
			if (num % 10 != 5 && num % 10 != 8) return false;
			num /= 10;
		}		
		
		return true;
	}
}
