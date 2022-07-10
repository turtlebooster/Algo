package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_실버5_10814_나이순정렬 {
	static class User {
		int age, no;
		String name;
		
		public User(int age, int no, String name) {
			this.age = age;
			this.no = no;
			this.name = name;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<User> pq = new PriorityQueue<>((u1, u2) -> {
			if (u1.age != u2.age) return u1.age - u2.age;
			return u1.no - u2.no;
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new User(Integer.parseInt(st.nextToken()), i, st.nextToken()));			
		}
		
		User u;
		while(!pq.isEmpty()) {
			u = pq.poll();
			sb.append(u.age).append(" ").append(u.name).append("\n");
		}
		
		System.out.print(sb);
	}
}
