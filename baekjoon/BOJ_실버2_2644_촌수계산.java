package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 공통 조상을 구하고
// 각각 공통 조상까지의 거리의 합이 촌수
public class BOJ_실버2_2644_촌수계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 전체 사람 수
		int t1 = sc.nextInt();	// 타겟 1
		int t2 = sc.nextInt();	// 타겟 2
		int[] parents = new int[N + 1];
		
		int M = sc.nextInt();	// 부모 자식들 간의 관계의 개수
		// 부모 정보 입력
		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			parents[n2] = n1;
		}
		
		// t1 의 조상 목록 구하기
		Map<Integer, Integer> t1P = new HashMap<>();
		int idx = t1;
		int dist = 0;
		t1P.put(idx, dist);
		while(parents[idx] != 0) {
			t1P.put(parents[idx], ++dist);
			idx = parents[idx];
		}
		
		int ans = -1;
		if (t1P.size() == 0) {
			System.out.println(ans);
			sc.close();
			return;
		}
		
		// t1, t2 의 일치하는 가장 가까운 조상 구하기
		// 없으면 -1
		// 있으면 조상까지의 거리 합
		idx = t2;
		dist = 0;
		if (t1P.get(idx) != null) {
			ans = t1P.get(idx) + dist;			
		}
		while(parents[idx] != 0) {
			idx = parents[idx];
			dist++;
			if (t1P.get(idx) != null) {
				ans = t1P.get(idx) + dist;
				break;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
