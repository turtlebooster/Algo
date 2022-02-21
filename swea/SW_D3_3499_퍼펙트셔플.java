package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_D3_3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			double N = sc.nextDouble(); // N 개의 카드
			
			int len1 = (int)Math.ceil(N / 2);
			int len2 = (int)N / 2;
			
			String[] set1 = new String[len1];
			String[] set2 = new String[len2];
			sc.nextLine();
			st = new StringTokenizer(sc.nextLine(), " ");
			for (int i = 0; st.hasMoreTokens() ; i++) {
				if (i < len1) set1[i] = st.nextToken();
				else set2[i - len1] = st.nextToken();
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < len1; i++) {
				System.out.print(set1[i] + " ");
				if (i <= len2 - 1) System.out.print(set2[i] + " ");
			}
			System.out.println();	
			
		}
		sc.close();
	}
}
