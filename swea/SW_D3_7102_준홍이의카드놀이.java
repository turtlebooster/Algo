package swea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SW_D3_7102_준홍이의카드놀이 {
	/* 
	 * 카드세트1: 1 ~ N		카드세트2: 1 ~ M
	 * 각 세트에서 한 장씩 골라 더함
	 * 등장할 확률이 가장 높은 숫자는?
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 카드세트1 범위
			int M = sc.nextInt();	// 카드세트2 범위
			HashMap<Integer, Integer> sumCnt = new HashMap<>();
			ArrayList<Integer> sum = new ArrayList<>();
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (sumCnt.get(i + j) == null) {
						sumCnt.put(i + j, 1) ;
						sum.add(i + j);
						continue;
					}
					sumCnt.put(i + j, sumCnt.get(i + j) + 1) ;
					if (sumCnt.get(ans) == null || sumCnt.get(ans) < sumCnt.get(i + j)) {
						ans = i + j;
					}
				}
			}
			
			sum.sort((o1, o2) -> (sumCnt.get(o1) - sumCnt.get(o2)) * -1);
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i > 0 ? sumCnt.get(sum.get(i)) == sumCnt.get(sum.get(i - 1)): true ; i++) {
				System.out.print(sum.get(i) + " ");
			}
			System.out.println();			
		}
		sc.close();
	}
}