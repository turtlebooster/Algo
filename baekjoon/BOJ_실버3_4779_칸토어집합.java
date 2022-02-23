package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_4779_칸토어집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append("-");
			
			for (int i = 1; i <= N; i++) {
				StringBuilder sbCopy = sb;
//				String sbCopy = sb.toString();
				for (int j = 0; j < Math.pow(3, i - 1); j++) sb.append(" ");		
				sb.append(sbCopy);
			}
			System.out.println(sb);
		}
		sc.close();
	}	
}
	
	/*
	// 메모리 초과
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {			
			int N = sc.nextInt();
			if (N < 10) {
				String txt = "";
				for (int i = 0; i < (int)Math.pow(3, N); i++) txt += "-";			
				System.out.println(cantor(txt, 0, (int)Math.pow(3, N)));				
			} else {
				String txt = "";
				for (int i = 0; i < (int)Math.pow(3, 9); i++) txt += "-";			
				System.out.print(cantor(txt, 0, (int)Math.pow(3, 9)));
				for (int i = 0; i < (int)Math.pow(3, 9); i++) System.out.print(" ");							
			}
		}
		
		sc.close();
	}
	
	private static String cantor (String txt, int st, int ed) {
		
		if (txt.length() == 1) return "-";
		if (txt.length() == 3) {			
			return "- -";
		}
		
		// 3 등분
		// 0 ~ ed - st / 3 ~ 2 * (ed - st) / 3 ~ ed - st
		String s1 = txt.substring(0, (ed - st) / 3);
		String s2 = txt.substring((ed - st) / 3, 2 * (ed - st) / 3);
		String s3 = txt.substring(2 * (ed - st) / 3, ed - st);		
		s2 = s2.replace('-', ' ');		
		
		return cantor(s1, st, st + (ed - st) / 3) + s2 + cantor(s3, st + 2 * (ed - st) / 3, ed);
	}
	*/
	
