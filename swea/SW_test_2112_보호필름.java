package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_test_2112_보호필름 {
	static int D, W, K, ans;
	static boolean flag;
	static int[] film;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());	// 두께
			W = Integer.parseInt(st.nextToken());	// 가로 크기
			K = Integer.parseInt(st.nextToken());	// 합격기준
			film = new int[W];
			
			// 필름 데이터 입력
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					if (Integer.parseInt(st.nextToken()) == 0) continue;
					film[j] |= 1<<i;
				}
			}
			ans = K;	// 합격 기준만큼 약품을 뿌리면 무조건 통과하므로 최대값은 K
			portion(0, 0);				
			
			System.out.println("#" + t + " " + ans);
		}
	}
	public static void portion(int cnt, int idx) {
		if (cnt > ans) return;
		if (idx == D) {
			// 다 뿌린 상태
			if(check()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		int[] temp = Arrays.copyOf(film, W);
		int bit = 1<<idx;
		// idx 층에 1 번 뿌리기
		for (int i = 0; i < W; i++) {
			film[i] |= bit;
		}
		portion(cnt + 1, idx + 1);
		// idx 층에 0 번 뿌리기
		for (int i = 0; i < W; i++) {
			film[i] -= bit;
		}
		portion(cnt + 1, idx + 1);
		// 안뿌리기
		film = temp;
		portion(cnt, idx + 1);
		
	}
	public static boolean check() {
		int bit = (int)Math.pow(2, K) - 1;		
		for (int i = 0; i < W; i++) {
			boolean c = false;
			for (int j = 0; j < D - K + 1; j++) {
				int shift = bit<<j;
				if ((film[i] & shift) == shift || (film[i] & shift) == 0) {
					c = true;
					break;
				}
			}
			if(!c) return false;
		}		
		return true;
	}
}
