package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class SW_D3_1860_진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String ans = "Possible";
			int N = sc.nextInt();	// 자격을 얻은 사람 수
			int M = sc.nextInt();	// M 초의 시간에
			int K = sc.nextInt();	// K 개의 붕어빵 제작 가능
			
			ArrayList<Integer> time = new ArrayList<>();	// 예약 한 사람들이 도착하는 시간
			for (int i = 0; i < N; i++) {
				time.add(sc.nextInt());
			}
			// 빨리오는 사람이 앞으로
			time.sort((p1, p2) -> p1 - p2);
			
			int get = 0;	// 가져간 붕어빵 수
			while(time.size() > 0) {
				// 생산한 붕어빵 수 = 시간 / M * K		 
				if (time.get(0) / M * K - get++ <= 0) {
					ans = "Impossible";
					break;
				}				
				time.remove(0);
			}			
			
			
			/*	// 시간초과
			int fish = 0;
			for(int i = 1; time.size() > 0; i++) {
				// M 초마다 K 개의 붕어빵 생성
				if (i % M == 0) fish += K;
				if (i == time.get(0)) {
					if (fish-- <= 0) {
						ans = "Impossible";
						break;
					}
					// 가져간 사람은 이제 보내줌
					time.remove(0);
				}				
			}
			*/
			
			// 제대로 다 돌면 Possible
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
