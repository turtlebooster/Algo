package swea;

import java.util.Scanner;

public class SW_D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] bit = sc.next().toCharArray();	// 주어진 비트
//			char[] oBit = new char[bit.length];		// 초기화 비트
//			// 초기화 비트 제작
//			for (int i = 0; i < bit.length; i++) oBit[i] = '0';
			char comp = '0';
			
			int ans = 0;	// 고치는 횟수 
			for (int i = 0; i < bit.length; i++) {
				
				// 같으면 고칠 필요 없음
				if (bit[i] == comp) continue;
				comp = bit[i];
//				// 다를경우 고치면 뒤까지 다 바뀜
//				for (int j = i; j < bit.length; j++) {
//					oBit[j] = bit[i];
//				}				
				ans++;
			}		
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
