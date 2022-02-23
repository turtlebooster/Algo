package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_D3_1225_암호생성기 {
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
}
