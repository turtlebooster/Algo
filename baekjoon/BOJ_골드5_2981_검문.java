package baekjoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class BOJ_골드5_2981_검문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N]; 
		// 숫자 데이터 입력
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		// 가능한 M 목록
		
		int G = nums[1] - nums[0];
		
		for (int i = 2; i < N; i++) {
			G = gcd(G, nums[i] - nums[i - 1]);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(G);
		double root = Math.pow(G, 0.5);
		for (int i = 2; i < root; i++) {
			if (G % i == 0) {
				pq.add(i);
				pq.add(G / i);
			}
		}
		if (root == (int)root) pq.add((int)root);
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll() + " ");
		}
		System.out.println(sb);
		sc.close();
	}
	// 최대공약수
	public static int gcd(int n1, int n2) {
		if(n1 < n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		int remain = n1 % n2; 
		if(remain == 0) return n2;
		return gcd(n2, remain);
	}
}
