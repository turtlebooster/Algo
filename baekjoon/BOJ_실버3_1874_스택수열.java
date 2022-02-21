package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_실버3_1874_스택수열 {
	static Stack<Integer> box;
	static List<Integer> origin, nArr;
	static List<Character> pushpop;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		// 수열의 길이, 마지막 숫자
		int[] arr = new int[N];		// 수열을 저장할 배열
		nArr = new ArrayList<>();	// 과정을 통해 만들어진 수열
		origin = new ArrayList<>();	// 정리되지 않은 수열 1, 2, 3, 4, ...
		pushpop = new ArrayList<>();// 맞을 경우 + - 의 나열을 저장할 공간
		
		// 수열 저장
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			origin.add(i + 1);
		}		
		
		box = new Stack<>();	// 사용할 스택
		boolean ans = true;		// 정답 오답 판별
		// 수열 길이만큼 반복 실행
		for (int i = 0; i < arr.length; i++) {
			int n = arr[i];	// i번 자리에 와야하는 수
			
			// 체크해야하는 수 >= origin 0 번 일때까지 push
			while (!origin.isEmpty() && n >= origin.get(0)) {
				push();
			}
			
			// 체크해야하는 수 <= stack peek 에 있는 수  이면 pop
			while (!box.empty() && n <= box.peek()) {
				pop();
			}
			// 올바르게 들어갔는지 확인 틀리면 break;
			if (arr[i] != nArr.get(i)) {
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
	// push 를 실행할때 진행되는 일들
	private static void push() {		
		box.push(origin.get(0));	//스택에 리스트 첫번째를 push
		pushpop.add('+');			// push 할때마다 + 저장
		origin.remove(0);			// 리스트 첫번째 제거
	}
	// pop 을 실행할때 진행되는 일들
	private static void pop() {
		nArr.add(box.pop());		// 결과 수열에 저장
		pushpop.add('-');			// pop 할때마다 - 저장
	}
	
}
