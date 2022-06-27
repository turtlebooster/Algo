package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_1002_터렛 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int T = sc.nextInt();
		
		int x1, y1, r1,
			x2, y2, r2,
			sum, sub, ans;
		double dist;
		while(T-- > 0) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			r1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			r2 = sc.nextInt();
			
			dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));	
			sum = r1 + r2;
			sub = Math.abs(r1 - r2);
			
			if (dist == sum || (dist == sub && dist != 0)) ans = 1;
			else if (dist < sum && dist > sub) ans = 2;
			else if (dist > sum || dist < sub || (dist == 0 && r1 != r2)) ans = 0;				
			else ans = -1;
			
			System.out.println(ans);
		}
		
		sc.close();
	}
}
