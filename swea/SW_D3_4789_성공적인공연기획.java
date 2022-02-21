package swea;

import java.util.Scanner;

public class SW_D3_4789_성공적인공연기획 {
	// 모든 관객 수가 몇명인지 잘 이해 안감
	// 주어진 데이터에서 순차적으로 다 일어날 수 있도록 하면 된다고 생각하고 풀이 진행
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;	// 고용해야할 최소 인원
			String input = sc.next();
			int N = input.length();	// 데이터 길이
			
			int up = 0;		// 기립한 사람 수
			for (int i = 0; i < N; i++) {
				// i 명 이상이 안되서 기립 못할 경우 고용
				if (up < i) ans += i - up++;	// 기립해야할 인원 - 이미 기립한 인원
				// i 이상을 만들었으므로 인덱스 i 에 해당하는 인원이 기립
				up += input.charAt(i) - '0';				
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
