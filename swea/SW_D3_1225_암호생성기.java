package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_D3_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] number = new int[8];
		Queue<Integer> q = new LinkedList<>();
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();	// 테스트케이스 번호 버리기
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				number[i] = sc.nextInt();
				min = Math.min(min, number[i]);
			}
//			System.out.println(min);
			
			int v = min / 15 * 15;
			if (v != 0 && v == min) v -= 15;
			
			q.clear();
			
			for (int i = 0; i < number.length; i++) {
				q.offer(number[i] - v);
			}
			
			int minus = 1, tmp = 0;
			while(true) {
				tmp = q.poll() - minus;
				if (tmp <=0 ) {
					q.offer(0);
					break;
				}
				q.offer(tmp);
				
				minus = minus % 5 + 1;
			}
			System.out.println("#" + t + " " + q.toString().replaceAll("[\\[\\,\\]]", ""));
		}
		sc.close();
	}
	/*
	// 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int tc = sc.nextInt();	// 테스트 케이스 번호
			Queue<Integer> nums = new LinkedList<>();	// 주어진 8개의 데이터 저장하기 위한 큐
			
			// 8개의 데이터 입력
			for (int i = 0; i < 8; i++) {
				nums.add(sc.nextInt());
			}
			
			int k = 0;	// 빼야할 수
			// 가장 앞의 수에 이번에 빼야할 수를 뺐을때 0 이하라면 반복 종료 
			while (nums.peek() - (k % 5 + 1) > 0) {
				nums.add(nums.remove() - (k++ % 5 + 1));				
			}			
			// 가장 앞의 수를 제거하고 맨 뒤에 0을 붙임
			nums.remove();
			nums.add(0);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc);
			// 큐에 생성된 암호 순서대로 나열
			while (!nums.isEmpty()) {
				sb.append(" " + nums.remove());				
			}
			
			System.out.println(sb);
		}		
		sc.close();
	}
	*/
}
