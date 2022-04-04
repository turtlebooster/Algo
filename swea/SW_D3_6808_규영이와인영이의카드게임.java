package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SW_D3_6808_규영이와인영이의카드게임 {
	public static int[] p1 = new int[9];
	public static int[] p2 = new int[9];
	public static List<Integer> remain;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트 케이스의 수
		
		for (int t = 1; t <= T; t++) {
			remain = new ArrayList<>();
			for (int i = 1; i <= 18; i++) {
				remain.add(i);
			}			
			
			for (int i = 0; i < 9; i++) {				
				p1[i] = sc.nextInt();
				remain.remove(remain.indexOf(p1[i]));
			}
			
			res = new int[2];	// {이기는 경우의 수, 지는 경우의 수}
			perm(0, 0);
			
			System.out.println("#" + t + " " + res[0] + " " + res[1]);
		}
		sc.close();
	}
	
	public static int[] res;
	public static void perm(int idx, int visited) {
		if (idx == 9) {
			// 순열 만들어짐
			// 이기는지 지는지 체크
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < 9; i++) {
				if (p1[i] < p2[i]) sum2 += p1[i] + p2[i];
				else sum1 += p1[i] + p2[i];
			}
			if (sum1 < sum2) res[1]++;
			else if (sum1 > sum2) res[0]++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if ((visited & (1<<i)) != 0) continue;
			p2[idx] = remain.get(i);
			perm(idx + 1, visited | (1<<i));
		}
		
	}
	
	
}

