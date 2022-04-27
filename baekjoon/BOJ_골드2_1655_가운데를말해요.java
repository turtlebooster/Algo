package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
public class BOJ_골드2_1655_가운데를말해요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());	// 외치는 정수의 개수
		
		// 첫 값 입력
		int mid = Integer.parseInt(br.readLine().trim());
		bw.append(mid + "\n");
		
		// mid 보다 앞에 위치 한 수들 -> 꺼내면 큰 수 부터 나오도록
		PriorityQueue<Integer> fpq = new PriorityQueue<>((n1, n2) -> n2 - n1);
		// mid 보다 뒤에 위치 한 수들 -> 꺼내면 작은 수 부터 나오도록
		PriorityQueue<Integer> bpq = new PriorityQueue<>((n1, n2) -> n1 - n2);
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			if (num > mid) bpq.add(num);
			else fpq.add(num);
			
			int res = (bpq.size() - fpq.size());
			if (res > 1) {
				// 뒤로 이동
				fpq.add(mid);
				mid = bpq.poll();
			} else if (res < 0) {
				// 앞으로 이동
				bpq.add(mid);
				mid = fpq.poll();
			}
			bw.append(mid + "\n");
		}
		bw.flush();
	}	
}
/*
public class BOJ_골드2_1655_가운데를말해요 {
	static class Node {
		Node f;
		Node b;
		int val;
		public Node(int val) {
			this.val = val;
		}
		public Node(Node f, Node b, int val) {
			this.f = f;
			this.b = b;
			this.val = val;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());	// 외치는 정수의 개수
		
		// 첫 값 입력
		Node mid = new Node(Integer.parseInt(br.readLine().trim()));
		System.out.println(mid.val);
		int fCnt = 0;	// mid 보다 앞에 있는 수의 개수
		int bCnt = 0;   // mid 보다 뒤에 있는 수의 개수
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			// 자리 배치 및 앞 뒤 개수 갱신
			if (num == mid.val) {
				fCnt++;
				if (mid.f == null) {
					mid.f = new Node(null, mid, num);
				} else {
					Node currf = mid.f;
					mid.f = new Node(currf, mid, num);
					currf.b = mid.f;
				}
			} else if (num > mid.val) {
				bCnt++;
				if (mid.b == null) {
					mid.b = new Node(mid, null, num);
				} else {
					Node currb = mid.b;
					while (currb.val < num) {
						if (currb.b == null) break;
						currb = currb.b;
					}
					// 얘 의 앞에 붙이기
					Node curr = currb.f;
					currb.f = new Node(curr, currb, num);
					curr.b = currb.f;
				}
			} else {
				fCnt++;
				if (mid.f == null) {
					mid.f = new Node(null, mid, num);
				} else {
					Node currf = mid.f;
					while (currf.val > num) {
						if (currf.f == null) break;
						currf = currf.f;
					}
					// 얘 의 뒤에 붙이기
					Node curr = currf.b;
					currf.b = new Node(currf, curr, num);
					curr.f = currf.b;
				}
			}
			
			int res = (bCnt - fCnt) / 2;
			if (res > 0) {
				// 뒤로 이동
				mid = mid.b;
				bCnt--;
				fCnt++;
			} else if (res < 0) {
				// 앞으로 이동
				mid = mid.f;
				bCnt++;
				fCnt--;
			}
			
			System.out.println(mid.val);
		}
		
	}
}
*/