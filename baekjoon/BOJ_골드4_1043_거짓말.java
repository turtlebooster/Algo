package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_1043_거짓말 {
	static class Person {
		boolean check;
		List<Party> partyList = new ArrayList<>();
	}
	static class Party {
		boolean truth;
		List<Person> attendList = new ArrayList<>();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사람의 수, 파티의 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Person[] people = new Person[N + 1];
		Party[] parties = new Party[M + 1];
		
		for (int i = 1; i <= N; i++) people[i] = new Person();		
		for (int i = 1; i <= M; i++) parties[i] = new Party();
		
		// 진실을 아는 사람 정보
		st = new StringTokenizer(br.readLine());
//		List<Person> truthList = new ArrayList<>();
		int truthNum = Integer.parseInt(st.nextToken());
		Queue<Person> peopleQ = new LinkedList<>();
		
		for (int i = 0; i < truthNum; i++) {
			Person p = people[Integer.parseInt(st.nextToken())];
			peopleQ.add(p);
			p.check = true;
//			truthList.add(people[Integer.parseInt(st.nextToken())]);
		}
		
		// 파티 정보 입력
		int size, pNum;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			// 파티 인원
			size = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= size; j++) {
				pNum = Integer.parseInt(st.nextToken());
				parties[i].attendList.add(people[pNum]);
				people[pNum].partyList.add(parties[i]);
			}
		}
		
		
//		for (Person p : truthList) {
//			peopleQ.add(p);
//			p.check = true;
//		}
		
		int cnt = 0;
		while(!peopleQ.isEmpty()) {
			Person p = peopleQ.poll();
			
			for (Party pt : p.partyList) {
				if (pt.truth) continue;
				cnt++;
				pt.truth = true;
				for (Person pp : pt.attendList) {
					if (pp.check) continue;
					pp.check = true;
					peopleQ.add(pp);
				}
			}			
		}
		
		System.out.println(M - cnt);
	}
}
