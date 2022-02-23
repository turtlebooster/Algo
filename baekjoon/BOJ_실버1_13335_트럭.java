package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_실버1_13335_트럭 {
	/**
	 * 트럭 N대가 길이 w이며, 견딜수 있는 최대 하중이 L인 다리를 거넘
	 * 트럭마다의 하중이 주어짐
	 * 모든 트럭이 다리를 건너는데 걸리는 최소시간은?
	 * 
	 * input: 	N W L 		트럭 수, 길이, 최대 하중
	 * 		  	a1, a2... 	각 트럭의 하중
	 * output: 	time		최소시간
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 다리를 건너는 트럭의 수 1 ~ 1,000
		int w = sc.nextInt();	// 다리의 길이	1 ~ 100
		int L = sc.nextInt(); 	// 다리의 최대하중 10 ~ 1,000
		int[] truck = new int[n + 1];	// 각 트럭의 번호에 따른 하중 배열
		
		// 트럭 하중 입력
		for (int i = 1; i <= n; i++) {
			truck[i] = sc.nextInt();
		}		
		
		// Queue 를 다리로 활용
		// 다리 길이만큼 0을 채워줌
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		// 트럭의 다리 건너기
		int sum = 0;	// 다리에 올라간 트럭 하중 합
		int time = 0;	// 이동에 걸리는 시간 저장할 변수
		for (int i = 1; i <= n; i++) {
			// 새로운 트럭이 다리에 올라갈 수 있을때까지 트럭 진행
			while (sum - bridge.peek() + truck[i] > L) {
				time++;
				sum -= bridge.remove();
				bridge.add(0);
			}
			// 새로운 트럭 다리에 올라감
			time++;
			sum -= bridge.remove();
			bridge.add(truck[i]);
			sum += truck[i];
		}
		// 마지막에 오른 트럭이 다리 건너는데 걸리는 시간 w
		time += w;
		
		System.out.println(time);		
		sc.close();
	}
}
