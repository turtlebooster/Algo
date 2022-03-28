package swea;

import java.util.Scanner;

public class SW_D3_2930_힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 수행해야 하는 연산의 수
			String ans = "";
			
			Integer[] tree = new Integer[1000000];
			
			// 연산 수행
			int end = 0;	// 마지막 노드 인덱스
			for (int i = 1; i <= N; i++) {
				int calc = sc.nextInt();
				// 연산 1
				if (calc == 1) {
					tree[++end] = sc.nextInt();
					
					int check = end;
					while(check >= 2 && tree[check] > tree[check / 2]) {
						Integer temp = tree[check];
						tree[check] = tree[check / 2];
						tree[check / 2] = temp;
						check /= 2;
					}
				}				
				// 연산 2
				else {
					if (end == 0) {
						// 출력할 값이 없을경우 출력
						ans += " -1";
					} else {
						// 출력할 값이 있을경우 출력
						ans += " " + tree[1];
						
						// 최대 힙 재구성
						tree[1] = tree[end];
						tree[end--] = null;
						
						Integer check = 1;
						if (2 * check > end || 2 * check + 1 > end) continue;
						// 부모가 자식보다 크거나 같을때 -> 최대 힙 조건 만족할때 까지 반복
						Integer childL = tree[2 * check];
						Integer childR = tree[2 * check + 1];
						while((childL != null && tree[check] < childL) 
								|| (childR != null && tree[check] < childR)) {
							if (childR == null || childL >= childR) {
								Integer temp = tree[check];
								tree[check] = childL;
								check = 2 * check;
								tree[check] = temp;
							} else {
								Integer temp = tree[check];
								tree[check] = childR;
								check = 2 * check + 1;
								tree[check] = temp;
							}
							if (2 * check > end || 2 * check + 1 > end) break;
							childL = tree[2 * check];
							childR = tree[2 * check + 1];
						}
					}
				}
				
			}
			
			System.out.printf("#%d" + ans + "\n", tc);
		}
		sc.close();
	}
	
	
}
