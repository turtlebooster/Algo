package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_골드5_2668_숫자고르기 {
	public static int N;
	public static int[] arr;
	public static boolean[] visited;
	public static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		list = new ArrayList<>();
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			pick(i, i);
			visited[i] = false;
		}
		
		System.out.println(list.size());
		System.out.print(list.toString().replaceAll("[\\[\\]]", "").replace(", ", "\n"));		
	}
	private static void pick(int idx, int i) {
		if (arr[idx] == i) list.add(i);
		
		if(visited[arr[idx]]) return;
		visited[arr[idx]] = true;
		pick(arr[idx], i);
		visited[arr[idx]] = false;
	}
}
