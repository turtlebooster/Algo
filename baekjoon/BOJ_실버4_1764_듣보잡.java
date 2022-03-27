package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BOJ_실버4_1764_듣보잡 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 듣도 못한 사람 수
		int M = sc.nextInt();	// 보도 못한 사람 수
		
		Map<String, Integer> notListen = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			notListen.put(sc.next(), 1);
		}
		
		List<String> common = new ArrayList<String>();
		
		for (int i  = 0; i < M; i++) {
			String txt = sc.next();
			if (notListen.get(txt) != null) common.add(txt);
		}
		
		Collections.sort(common);
		
		System.out.println(common.size());
		System.out.println(common.toString().replace(", ", "\n").replaceAll("[\\[\\]]", ""));
		
		sc.close();
	}
}
