package swea;

import java.util.Scanner;

public class SW_test_no3_ShuffleOMatic {
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 5 초과시 의미 없음
			min = 6;
			// 카드의 수
			int N = sc.nextInt();
			int[] cards = new int[N];
			// 카드 입력
			for (int i = 0; i < N; i++) {
				cards[i] = sc.nextInt();
			}
			// 최소 셔플 수 찾기
			findMin(cards, 0);
			System.out.println("#" + t + " " + (min <= 5 ? min : -1));
		}
		sc.close();
	}
	
	public static void findMin (int[] cards, int cnt) {
		// 최솟값 보다 크거나 같으면 가지치기
		if (cnt >= min) return;
		// 오름차순 또는 내림차순인지 체크
		if (check(cards)) {
			min = cnt;
			return;
		}
		// x 값에 따른 셔플 재귀
		int N = cards.length;
		for (int x = 0; x < N; x++) {
			findMin(shuffle(cards, x), cnt + 1);
		}		
	}
	
	public static int[] shuffle (int[] cards, int x) {
		int N = cards.length;
		int[] sCards = new int[N];
		int i = 0;
		int l = 0, r = N / 2;
		int d = Math.abs(x - N / 2);
		// 어느 쪽(왼, 오) 덱이 먼저 나오는 셔플인지 판별
		boolean flag = x < N / 2;
		while (true) {
			if (flag) {
				// 왼쪽 먼저 나오는 셔플
				if (l < N / 2) {
					sCards[i++] = cards[l++];					
				}
				if (i >= d && r < N) {
					sCards[i++] = cards[r++];					
				}
			} else {
				// 오른쪽 먼저 나오는 셔플
				if (r < N) {
					sCards[i++] = cards[r++];					
				}				
				if (i >= d + 1 && l < N / 2) {
					sCards[i++] = cards[l++];					
				}
			}
			// 셔플이 끝났다면 셔플된 덱 반환
			if (i >= N) {
				return sCards;
			}
		}
	}
	
	public static boolean check (int[] cards) {
		// 오름차순 true, 내림차순 false
		boolean d = cards[0] < cards[1];
		for (int i = 2; i < cards.length; i++) {
			// 앞 뒤 카드 크기 관계가 일정하다면 올바른 정렬
			if (cards[i - 1] < cards[i] == d) continue;
			return false;
		}
		return true;
	}
}
