package swea;

import java.util.Scanner;

public class SW_test_1952_수영장 {
	static int ans;
	static int[] costs = new int[4];
	static int[] plan = new int[12];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 요금 입력 - 1일, 1달, 3달, 1년 순서
			for (int i = 0; i < 4; i++) {
				costs[i] = sc.nextInt();
			}
			
			// 1년 수영장 이용 계획 입력
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			ans = costs[3];	// 1년 이용권 가격으로 초기화
			month3(0, 0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
	private static void month3(int idx, int sum, int check) {
		if (sum >= ans) return;
		if (idx >= 12) {
			// 3달권 사용할 곳 다 정했으니 1달권 사용할 곳 정하기
			month1(0, sum, check);
			return;
		}
		if (plan[idx] == 0 
				|| (idx + 1 < 12 && plan[idx + 1] == 0) 
				|| (idx + 2 < 12 && plan[idx + 2] == 0)) {
			month3(idx + 1, sum, check);
			return;
		}
		
		// 이번 달 부터 3달권 사용할 경우 -> 3달 뒤 부터 생각
		month3(idx + 3, sum + costs[2], check | 7<<idx);
		// 이번 달 부터는 사용 안할 경우 1 달 뒤 부터 사용할지 말지 
		month3(idx + 1, sum, check);
		
	}
	private static void month1(int idx, int sum, int check) {
		if (sum >= ans) return;
		if (idx == 12) {
			// 3달권 및 1달권 사용하지 않은 곳에 1일권으로 채워서 더하기
			for (int i = 0; i < 12; i++) {
				if ((check & 1<<i) > 0 || plan[i] == 0) continue;
				sum += costs[0] * plan[i];
			}
			ans = Math.min(ans, sum);
			return;
		}
		int bit = 1<<idx;
		if (plan[idx] == 0 || (check & bit) > 0) {
			month1(idx + 1, sum, check);
			return;
		}
		// 이번 달 한달 권 사용할 경우
		month1(idx + 1, sum + costs[1], check | bit);
		// 이번 달 한달 권 사용하지 않을 경우
		month1(idx + 1, sum, check);
	}
	
	
}
