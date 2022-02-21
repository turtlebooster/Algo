package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_실버3_1966_프린터큐 {
	public static void main(String[] args) {
		// 문서 번호와 랭크가 담길 클래스 생성
		class printer {
			int no;
			int rank;
			
			printer (int no, int rank){
				this.no = no;
				this.rank = rank;
			}
		}	
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 문서의 개수
			int M = sc.nextInt();	// 궁금한 문서 번호
			Integer[] order = new Integer[N];
			Queue<printer> Q = new LinkedList<>();
			
			// 중요도 배열 저장
			for (int i = 0; i < N; i++) {
				order[i] = sc.nextInt();
				Q.add(new printer(i, order[i]));
			}
			
			// order 배열 오름차순 정렬: 큰 랭크 -> 작은 랭크 순으로 정렬됨
			Arrays.sort(order, Comparator.reverseOrder());
			
			
			
			// 몇 번째로 인쇄 되는지 찾기
			// order 배열에 정렬된 랭크 순으로 나와야 함 
			int nth = 0;
			for (int i = 0; i < N; i++) {				
				// 같아질때까지 꺼내서 Q에 다시 넣기
				while (order[i] != Q.peek().rank) Q.add(Q.poll());
				// 같아질 경우에만 여기로 내려옴
				// 원하는 문서 번호와 같으면
				if (Q.peek().no == M) {
					nth = i + 1;	// 출력된 nth 번째 저장 후 반복문 종료
					break;
				} 
				// 원하는 문서 번호가 아닌 경우 꺼내기만
				Q.poll();					
			}			
			
			System.out.println(nth);
		}		
		
		
		sc.close();
	}
}
