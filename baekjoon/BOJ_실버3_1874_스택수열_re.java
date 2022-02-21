package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_실버3_1874_스택수열_re {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();						// 수열의 길이, 마지막 숫자
		List<Integer> origin = new ArrayList<>();	// 정리되지 않은 수열 1, 2, 3, 4, ...
		List<Character> pushpop = new ArrayList<>();// 맞을 경우 + - 의 나열을 저장할 공간
		
		// 정리되지 않은 수열 생성
		for (int i = 0; i < N; i++) {
			origin.add(i + 1);
		}		
		
		Stack<Integer> box = new Stack<>();	// 사용할 스택
		boolean ans = true;		// 정답 오답 판별
		// 수열 길이만큼 반복 실행
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();	// i번 자리에 와야하는 수
			
			//push
			// 체크해야하는 수 >= origin 첫번째 숫자 일때까지 push
			while (!origin.isEmpty() && n >= origin.get(0)) {
				box.push(origin.get(0));	//스택에 리스트 첫번째를 push
				pushpop.add('+');			// push 할때마다 + 저장
				origin.remove(0);			// 리스트 첫번째 제거
			}
			// pop 및 체크
			pushpop.add('-');				// pop 할때마다 - 저장
			if (n != box.pop()) {			// 올바르게 들어갔는지 확인 틀리면 break;
				ans = false;
				break;
			}
		}

		sc.close();
		if (ans) {	// 맞는 답일 경우 + - 출력
			for (int i = 0; i < pushpop.size(); i++) {
				System.out.println(pushpop.get(i));					
			}
			return;
		}
		// 틀릴경우 NO 출력
		System.out.println("NO");		
	}	
}
