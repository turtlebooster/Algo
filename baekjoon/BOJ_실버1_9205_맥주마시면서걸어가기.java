package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_실버1_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 맥주를 파는 편의점의 개수 0 ~ 100
			int[] start = {sc.nextInt(), sc.nextInt()};
			
			Queue<Integer[]> q = new LinkedList<Integer[]>();
			
			for (int i = 0; i < N; i++) {
				Integer[] pos = {sc.nextInt(), sc.nextInt()};
				q.add(pos);
			}
			
			int[] end = {sc.nextInt(), sc.nextInt()};
			
			int beer = 20;
			
			String ans = "happy";
			int min = 0;
			while (start[0] != end[0] && start[1] != end[1] && beer >= 0) {
				// 범위 안 편의점 
				int k = q.size();
				int nx = start[0], ny = start[1];
				boolean flag = false;
				for (int i = 0; i < k; i++) {
					Integer[] cpos = q.poll();
					if (start[0] < end[0]) {
						// 범위 안에 들어가면
						if (cpos[0] >= start[0] && cpos[0] <= end[0] && cpos[1] >= start[1] && cpos[1] <= end[1]) {
							if (min > Math.abs(cpos[0] - start[0]) + Math.abs(cpos[1] - start[1])) {
								min = Math.abs(cpos[0] - start[0]) + Math.abs(cpos[1] - start[1]);
								nx = cpos[0]; ny = cpos[1];
								flag = true;
							}
						}						
					} else {
						// 범위 안에 들어가면
						if (cpos[0] >= end[0] && cpos[0] <= start[0] && cpos[1] >= end[1] && cpos[1] <= start[1]) {
							if (min > Math.abs(cpos[0] - start[0]) + Math.abs(cpos[1] - start[1])) {
								min = Math.abs(cpos[0] - start[0]) + Math.abs(cpos[1] - start[1]);
								nx = cpos[0]; ny = cpos[1];
								flag = true;
							}
						}		
						
					}					
				}
				// 찾았다면
				if (flag) {
					beer -= min / 50;
					if (beer < 0) {
						ans = "sad";
						break;
					}
					start[0] = nx; start[1] = ny;
				}
				// 없으면 범위 밖 가장 가까운 편의점				
				
				
			}
			
			
			
			
			
			System.out.println(ans);
		}
		sc.close();
	}
}
