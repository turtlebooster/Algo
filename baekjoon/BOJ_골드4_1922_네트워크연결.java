package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_골드4_1922_네트워크연결 {
	public static class Net {
		int s;		// 시작점
		int e;		// 끝 점
		int cost;	// 비용
		public Net(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}
	static Map<Integer, Integer> p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		
		Net[] network = new Net[M];
		p = new HashMap<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			network[i] = new Net(s, e, Integer.parseInt(st.nextToken()));
			p.put(s, s);
			p.put(e, e);
		}
		
		// 크루스칼
		Arrays.sort(network, (n1, n2) -> n1.cost - n2.cost);
		int ans = 0;
		int pick = 0;
		for (int i = 0; i < M; i++) {
			int px = findSet(network[i].s);
			int py = findSet(network[i].e);
			
			if (px != py) {
				union(px, py);
				ans += network[i].cost;
				if (++pick == N - 1) break;
			}
		}
		
		System.out.println(ans);
	}
	public static int findSet(int x) {
		if (p.get(x) == x) return x;
		int px = findSet(p.get(x));
		p.put(x, px);
		return px;
	}
	public static void union(int px, int py) {
		p.put(py, px);
	}
}
