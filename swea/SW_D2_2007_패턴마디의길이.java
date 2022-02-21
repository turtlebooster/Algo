package swea;

import java.util.Scanner;

public class SW_D2_2007_패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			String txt = sc.next();
			
			// 패턴 길이는 최대 10
			// 첫자리가 같은 부분을 체크할때는 10번째 자리까지만 확인하면 됨
			for (int i = 1; i <= 10 ; i++) {
				// 첫자리와 같으면 해당 길이만큼의 문자가 같은지 체크
				if (txt.charAt(i) == txt.charAt(0)) {
					if (txt.substring(0, i).equals(txt.substring(i, i + i))) {
						ans = i;
						break;
					}
				}				
			}			
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
