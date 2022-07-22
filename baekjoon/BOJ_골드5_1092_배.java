package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_골드5_1092_배 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		int N = Integer.parseInt(br.readLine());
		List<Integer> crane = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		crane.sort((c1, c2) -> c2 - c1);
		
		int M = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		box.sort((b1, b2) -> b2 - b1);
		
		int time = -1;
		// 가장 무거운 박스를 들 수 있어야만 옮기기 가능
		if (crane.get(0) >= box.get(0)) {
			time = 0;
			int idx;
			while(!box.isEmpty()) {
				idx = 0;
				for (int i = 0; i < crane.size();) {
					if (idx == box.size()) break;
					// 들 수 있으면
					if (crane.get(i) >= box.get(idx)) {
						// 이번 크레인이 이 박스를 맡음 -> 목록에서 제거
						box.remove(idx);
						i++;
					} else {
						idx++;
					}
				}
				time++;
			}
		}
		
		System.out.println(time);
	}
}
