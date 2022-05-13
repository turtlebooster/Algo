package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드4_2448_별찍기11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int N = (int)(Math.log((sc.nextInt() / 3)) / Math.log(2));
		
		String[] star = {"  *  ", " * * ", "*****"};
		
		int blank = 3;
		for (int n = 0; n < N; n++) {
			String[] nStar = new String[2 * star.length];
			for (int i = 0; i < nStar.length; i++) {
				nStar[i] = "";
			}
			for(int i = 0; i < star.length; i++) {
				sb = new StringBuilder();
				for (int j = 0; j < blank; j++) {
					sb.append(" ");
				}
				sb.append(star[i]);
				for (int j = 0; j < blank; j++) {
					sb.append(" ");
				}
				nStar[i] += sb;
			}
			for(int i = 0; i < star.length; i++) {	
				sb = new StringBuilder();
				sb.append(star[i]).append(" ").append(star[i]);
				nStar[star.length + i] += sb;
			}
			star = nStar;
			blank *= 2;
		}
		
		System.out.println(Arrays.toString(star).replace(", ", "\n").replaceAll("[\\[\\]]", ""));
		sc.close();
	}
}
