package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_MyChew {
	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 나눠줄 마이쮸 개수
		int st = N;				// 처음 마이쮸 갯수 저장
		
		Queue<person> Q = new LinkedList<>();
		int i = 1;
		person p;
		
		int ans = 1;
		while(true) {
			System.out.println("새로 " + i + "번이 줄을 선다");
			Q.add(new person(i++));
			p = Q.poll();
			p.get += ++p.candy;
			if (N - p.candy <= 0) {
				ans = p.no;
				System.out.println(p.no + "번이 마지막으로 남은 " + N + "개의 마이쮸를 받는다");	
				N = 0;
				break;
			}			
			System.out.println();			
			System.out.println(p.no + "번이 " + p.candy + "개의 마이쮸를 받는다");	
			N -= p.candy;
//			sc.nextLine();
//			System.out.println();
//			System.out.println("큐에 있는 사람의 수: " + Q.size());
//			System.out.println("현재 일인당 나눠주는 사탕의 수: " + p.candy);
//			System.out.println("현재까지 나눠준 사탕의 수: " + (st- N));
			
			System.out.println(p.no + "번이 다시 줄을 선다");
			Q.add(p);	
			
		}
		System.out.println();
		System.out.println(st + "개의 마이쮸가 있을 때 마지막 것을 가져간 것은: " + ans + "번");
		sc.close();
	}
	static class person {
		int no;				// 번호
		int candy = 0;		// 받을 사탕 수 저장
		int get = 0;		// 총 받은 사탕 수 저장
		
		person (int no){
			this.no = no;
		}
	}
	
}
