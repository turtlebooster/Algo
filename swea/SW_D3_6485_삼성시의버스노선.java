package swea;

import java.util.Scanner;

public class SW_D3_6485_삼성시의버스노선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 노선 개수
			int[] A = new int[N + 1];	// A[i]번 이상 
			int[] B = new int[N + 1];	// B[i]번 이하인 모든 정류장만 다니는 버스 노선
			
			// A[i], B[i] 주어진 데이터 세팅
			for (int i = 1; i <= N; i++) {
				A[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}
						
			int P = sc.nextInt();		// 버스 정류장의 수
			int[] C = new int[P + 1];	// C[j]는 버스 정류장 번호

			// 버스 정류장 번호 데이터 세팅
			for (int j = 1; j <= P ; j++) {
				C[j] = sc.nextInt();
			}
			
			// 정답 출력		
			System.out.print("#" + tc);
			for (int j = 1; j <= P ; j++) {
				int cnt = 0;	// 정류장을 지나는 노선 수 카운트
				for (int i = 1; i <= N; i++) {
					// C(버스 정류장 번호)가 A ~ B 범위 안에 있으면 노선 수 카운트
					if(C[j] >= A[i] && C[j] <= B[i]) cnt++;
				}
				System.out.print(" " + cnt);
			}
			System.out.println();
		}
		sc.close();
	}
}
