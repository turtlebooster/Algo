package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드5_11000_강의실배정 {
	static class Lecture {
		int s, t;	// 시작, 끝

		public Lecture(int s, int t) {
			this.s = s;
			this.t = t;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
//		List<Integer> roomEndTime = new ArrayList<>();	// 강의실 별 끝 시간 기록
		PriorityQueue<Integer> roomEndTime = new PriorityQueue<>();
		
		
		// 강의 시간이 빠른 순으로, 같을 경우 더 늦게 끝나는 강의 순으로 정렬
		PriorityQueue<Lecture> pq = new PriorityQueue<>((l1, l2) -> {
			if (l1.s != l2.s) return l1.s - l2.s;
			else return l2.t - l1.t;
		});
		// 데이터 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));			
		}
		
		// 첫번째 강의는 일단 강의실에 배치
		roomEndTime.add(pq.poll().t);
		
		while(!pq.isEmpty()) {
			Lecture curr = pq.poll();
			
			// 가장 끝나는 시간이 빠른 강의실에 이번 강의를 넣을 수 있을경우
			if (roomEndTime.peek() <= curr.s) {
				// 그 강의실의 강의 끝나는 시간 갱신
				roomEndTime.poll();
				roomEndTime.add(curr.t);
				continue;
			}
			
			// 강의를 넣을 수 없었을 경우
			// 새로운 강의실 추가 후 끝 시간 반영
			roomEndTime.add(curr.t);
		}
		
		System.out.println(roomEndTime.size());
	}
}
