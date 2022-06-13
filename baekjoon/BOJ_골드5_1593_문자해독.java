package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_1593_문자해독 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int s = sc.nextInt();
		
		String W = sc.next();
		String S = sc.next();
		
		int cnt = 0;
		int[] checkOrigin = new int['z' - 'A' + 1];
		
		for (int i = 0; i < w; i++) {
			checkOrigin[W.charAt(i) - 'A']++;
		}
		
		int[] check = new int[checkOrigin.length];
		for (int i = 0; i < s - w + 1; i++) {
//			check = Arrays.copyOf(checkOrigin, checkOrigin.length);			
			for (int j = 0; j < checkOrigin.length; j++) {
				check[j] = checkOrigin[j];
			}
			for (int j = i; j < i + w; j++) {
				if (!W.contains(S.charAt(j) + "")) {
					i = j;
					break;
				}
				if (check[S.charAt(j) - 'A'] <= 0) {					
					break;
				}
				check[S.charAt(j) - 'A']--;
				if (j == i + w - 1)	cnt++;
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
