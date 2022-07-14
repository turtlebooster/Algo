package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_골드5_5430_AC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		String P, ans; 
		String[] arr;
		List<String> list;
		int N;
		char c;
		boolean front, error;
		while(T-- > 0) {			
			P = sc.next();
			N = sc.nextInt();
			arr = sc.next().replaceAll("[\\[\\]]", "").split(",");
			
			// 리스트에 입력
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(arr[i]);
			}
			
			front = true;
			error = false;
			outer:
			for (int i = 0; i < P.length(); i++) {
				c = P.charAt(i);
				switch (c) {
				case 'R':
					front = !front;
					break;
				case 'D':
					if (list.size() == 0) {
						error = true;
						break outer;
					}					
					if (front) {
						list.remove(0);
					} else {
						list.remove(list.size() - 1);
					}
					break;
				}
			}
			
			if (error) {
				sb.append("error\n");
			} else {
				if (list.size() == 0) {
					sb.append("[]\n");
				} else {
					if (front) {
						sb.append(list.toString().replace(", ", ",")).append("\n");
					} else {
						sb.append("[");
						for (int i = list.size() - 1; i > 0; i--) {
							sb.append(list.get(i)).append(",");
						}
						sb.append(list.get(0)).append("]\n");
					}
				}
			}
				
		}
		
		System.out.println(sb);
		sc.close();
	}
}
