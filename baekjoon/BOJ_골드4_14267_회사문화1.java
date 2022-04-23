package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_골드4_14267_회사문화1 {
	static class Node {
		int w;
		List<Integer> child = new ArrayList<>();
	}
	static int[] wArr;
	static Node[] tree;
	static Map<Integer, Integer> wMap;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 회사 직원 수
		int M = Integer.parseInt(st.nextToken());	// 최초의 칭찬 횟수
		
		tree = new Node[N + 1];
		for (int i = 1; i <= N; i++) tree[i] = new Node();
		
		List<Integer> root = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p == -1) {
				// -1 이면 root
				root.add(i);
				continue;
			}
			// 들어오는 값은 부모, i 는 자식 번호
			tree[p].child.add(i);
		}
		
		wMap = new HashMap<>();	// 칭찬 받은 정도 매핑	직원 번호 : 칭찬 정도
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			if (wMap.get(idx) != null) {
				// 칭찬을 여러번 받을 경우
				wMap.put(idx, wMap.get(idx) + Integer.parseInt(st.nextToken()));				
			} else {
				// 처음 받는 칭찬
				wMap.put(idx, Integer.parseInt(st.nextToken()));				
			}
		}
		
		// 칭찬 받은 정도 저장
		wArr = new int[N + 1];
		
		// 각 루트마다 순회
		for (int i : root) {
			travle(i, 0);
		}
		System.out.println(Arrays.toString(wArr).replaceAll("[\\[\\,\\]]", "").substring(2));
	}
	
	public static void travle(int idx, int wSum) {
		
		if(wMap.get(idx) != null) {
			// 칭찬 받은 적 있으면
			// 그 만큼 더해 줌
			wSum += wMap.get(idx);
		}
		// 결과를 칭찬 정도 저장 배열에 저장
		wArr[idx] = wSum;
		
		// 자식들에게 칭찬 전달
		for (int n : tree[idx].child) {
			travle(n, wSum);
		}
		
	}
}
