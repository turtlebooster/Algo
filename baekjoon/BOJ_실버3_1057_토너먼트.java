package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_1057_토너먼트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int kim = sc.nextInt();
		int lim = sc.nextInt();
		
		int round = 0;
		while (kim != lim) {			
			round++;
			kim = kim / 2 + kim % 2;
			lim = lim / 2 + lim % 2;
		}
		
		System.out.println(round);
		sc.close();
	}
}
