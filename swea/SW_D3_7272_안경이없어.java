package swea;

import java.util.Scanner;

public class SW_D3_7272_안경이없어 {
	// 이 정도면 보조 안경을 들고 다니자!!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String ans = "SAME";
			
			String m1 = sc.next();	// 첫 번째 단어
			String m2 = sc.next();	// 두 번째 단어
			int N = m1.length();	// 첫 번째 단어 길이
			
			// 문자 길이가 서로 다르면 비교할 필요 없이 DIFF
			if (N != m2.length()) {	
				ans = "DIFF";
			} else { // 문자 길이가 같으면 비교 해보자!
				for (int i = 0; i < N; i++) {
					// 두 문자의 i 번째 자리를 같은 문자로 생각할 수 있다면 다음 문자 비교
					if ("CEFGHIJKLMNSTUVWXYZ".contains(m1.charAt(i) + "") && "CEFGHIJKLMNSTUVWXYZ".contains(m2.charAt(i) + "")) continue;
					if ("ADOPQR".contains(m1.charAt(i) + "") && "ADOPQR".contains(m2.charAt(i) + "")) continue;
					if (m1.charAt(i) == 'B' && m2.charAt(i) == 'B') continue;
					// 여기로 내려왔다면 두 문자를 같은 문자로 생각할 수 없는 문자이다!!
					ans = "DIFF";
					break;
				}
			}			
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
