package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_골드4_1062_가르침 {
	static int K, max;
	static List<Integer> voca, idxList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt() - 5;	// antic 5개 제외
		
		voca = new ArrayList<>();
		int all = 0;
		int cnt;
		int bit;
		String txt;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			bit = 0;
			txt = sc.next();
			// anta ~~ tica
			for (int j = 4; j < txt.length() - 4; j++) {
				char c = txt.charAt(j);
				if ("antic".contains(c + "")) continue;				
				int b = 1<<(c - 'a');
				// 이미 체크한 알파벳이면 패스
				if ((bit & b) > 0) continue;
				bit |= b;
				// 새로운 알파벳 수 + 1 하고 K 보다 크면 이 단어는 어차피 못 읽음
				if (++cnt > K) break;
			}
			if (cnt > K) continue;
			voca.add(bit);
			all |= bit;
		}
		// 사용된 전체 알파벳 비트마스킹 리스트
		idxList = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			if ((all & 1<<i) > 0) idxList.add(1<<i);
		}
		
		max = 0;
		comb(0, 0, 0);
		
		System.out.println(max);
		sc.close();
	}
	
	public static void comb(int cnt, int idx, int res) {
		if (max == voca.size()) return;
		if (cnt <= K) {
			// 읽을 수 있는 단어 수 체크
			check(res);
			if (cnt == K)return;
		}
		if (idx == idxList.size()) return;
		
		comb(cnt + 1, idx + 1, res | idxList.get(idx));
		comb(cnt, idx + 1, res);
		
	}

	private static void check(int res) {
		int cnt = 0;
		
		for (int i = 0; i < voca.size(); i++) {
			if ((res & voca.get(i)) == voca.get(i)) cnt++;
		}
		
		max = Math.max(max, cnt);
	}
}
