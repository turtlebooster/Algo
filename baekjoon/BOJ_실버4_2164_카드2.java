package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_실버4_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();						// 카드의 장 수	1 ~ 500,000
		Queue<Integer> cards = new LinkedList<>();	// 카드 순서대로 보관하기 위한 Queue
		
		// 카드 초기상태 만들기
		for (int i = 1; i <= N ; i++) cards.add(i);
		
		// 카드가 한 장 남을때 까지 반복
		while(cards.size() != 1) {
			cards.poll();					// 제일 위 한 장 버림
			cards.add(cards.poll());		// 그 다음, 제일 위 카드를 제일 아래로 옮김
		}
		
		// 남은 카드 출력
		System.out.println(cards.poll());	
		sc.close();
	}
}
