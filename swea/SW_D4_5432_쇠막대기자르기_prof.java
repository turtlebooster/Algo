package swea;

import java.util.Scanner;

public class SW_D4_5432_쇠막대기자르기_prof {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0,
				cnt = 0;	// 막대기 갯수
			char[] data = sc.next().toCharArray();
			for(int i=0; i < data.length; i++) {
				if (data[i] == '(') {
					cnt++;
					continue;
				} else {
					cnt--;
					// 레이저일 경우 cnt를 정답에 추가, 막대의 끝일 경우 1을 추가
					ans += data[i - 1] == '(' ? cnt : 1;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}