package baekjoon;

import java.util.Scanner;

public class BOJ_실버5_1316_그룹단어체커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		outer:
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			boolean[] check = new boolean['z' - 'a' + 1];
			char c = str.charAt(0);
			check[c - 'a'] = true;
			for (int j = 1; j < str.length(); j++) {
				if (c == str.charAt(j)) continue;
				if (check[str.charAt(j) - 'a']) continue outer;
				check[str.charAt(j) - 'a'] = true;
				c = str.charAt(j);
			}
			cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
