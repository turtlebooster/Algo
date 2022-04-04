package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_14226_이모티콘 {
	public static int S, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		S = sc.nextInt();
//		for (S = 2; S <= 1000; S++) {
			min = Integer.MAX_VALUE;
			work(0, 0, 1);
//			System.out.println("S : " + S + " min : " + min);			
//		}
	
		System.out.println(min);			
		sc.close();
	}
	public static void work(int clip, int time, int disp) {
		// S 보다 클때는 삭제만 진행
		// 화면에 있는 이모티콘 삭제
		if (disp > S) {
			min = Math.min(min, time + disp - S);
			return;
		}
		
		// S와 같을때 끝난 시간 최소값이면 저장
		if (disp == S) {
			min = Math.min(min, time);
			return;
		}
		
//		// 삭제 - 언제해야하니??
//		work(clip, time + 1, disp - 1);
		for (int i = 1; ; i ++) {
			if (2 * disp - 2 * i <= disp) break;
			if (2 * disp - 2 * i == S) {
				min = Math.min(min, time + i + 2);
			}			
		}
		
		// 클립보드에 저장
		if(clip != disp) work(disp, time + 1, disp);
		
		// 클립보드에 있는 이모티콘 붙여넣기
		if (clip > 0) work(clip, time + 1, disp + clip);
		
	}
}
