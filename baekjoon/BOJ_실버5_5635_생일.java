package baekjoon;

import java.util.Scanner;

public class BOJ_실버5_5635_생일 {
	public static class Student {
		String name;
		int y, m, d;
		public Student(String name, int y, int m, int d) {
			this.name = name;
			this.y = y;
			this.m = m;
			this.d = d;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String name = sc.next();
		int d = sc.nextInt();
		int m = sc.nextInt();
		int y = sc.nextInt();		
		
		Student old;
		Student young = old = new Student(name, y, m, d);
		
		for (int i = 1; i < N; i++) {
			name = sc.next();
			d = sc.nextInt();
			m = sc.nextInt();
			y = sc.nextInt();
			// old
			if (old.y > y || (old.y == y && (old.m > m || (old.m == m && old.d > d)))) {
				old = new Student(name, y, m, d);
			}
			
			// young
			if (young.y < y || (young.y == y && (young.m < m || (old.m == m && young.d < d)))) {
				young = new Student(name, y, m, d);
			}
		}
		
		System.out.println(young.name);
		System.out.println(old.name);
		sc.close();
	}
}
