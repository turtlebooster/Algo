package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_브론즈2_3052_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < 10; i++) {
			set.add(sc.nextInt() % 42);			
		}
		
		System.out.println(set.size());
		sc.close();
	}
}
