package swea;

import java.util.Scanner;

public class SW_D3_7964_부먹왕국의차원관문 {
	// 나는 부먹 찍먹 상관 없이 처먹
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;	// 추가로 건설 해야 하는 차원관문의 최소 개수
			int N = sc.nextInt();	// 부먹 왕국의 도시 수
			int D = sc.nextInt();	// 차원관문 이동 제한 거리
			int[] map = new int[N + 2]; 
			map[0] = map[N + 1] = 1;	//	0 과 N + 1 자리에는 차원문이 있다! 
			
			// 도시에 건설되어있는 차원관문 데이터 저장
			for (int i = 1; i <= N; i++) {
				map[i] = sc.nextInt();
			}
			
			for (int i = 0; i <= N + 1; ) {
				int jump = D;
				boolean over = false;
				for (int j = i + 1; j <= i + D && j <= N + 2; j++) {
					if (j == N + 2) {
						over = true;
						break;
					}
					if (map[j] != 1) continue;
					// 1 일 경우
					jump = j - i;
				}
				if (i == 0 && map[i] == 0 && jump == D) {
					map[i] = 1;
					ans++;
				}
				i += jump;
				if (!over && map[i] == 0) {
					map[i] = 1;
					ans++;
				}
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
