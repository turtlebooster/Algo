package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class BOJ_골드4_17298_오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] input = new int[N];
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			// 현재의 값이 스택 자리의 값(이 전의 값들 중 해결 되지 않은 녀석들) 보다 크면 그 값이 곧 오큰수  
			while(!stack.isEmpty() && input[i] > input[stack.peek()]) {
				input[stack.pop()] = input[i];
			}			
			stack.add(i);
		}
		
		// 다 돌아도 해결되지 못했으면 없는거 -1
		while(!stack.isEmpty()) {
			input[stack.pop()] = -1;
		}
		
		System.out.println(Arrays.toString(input).replaceAll("[\\[\\,\\]]", ""));
	}
}
/*
// stack을 활용하여 뒤부터 채워가는 풀이 -> 시간 초과
public class BOJ_골드4_17298_오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] input = new int[N];
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		int[] ans = new int[N];
		int max = input[N - 1];
		for (int i = N - 1; i >= 0; i--) {
			int curr = input[i];
			while(!s1.isEmpty() && curr < max) {
				if (s1.peek() > curr) {
					ans[i] = s1.peek();
					break;
				} else {
					s2.add(s1.pop());
				}
			}
						
			if (s1.isEmpty() || curr == max) ans[i] = -1;
			else if (curr > max) {
				ans[i] = -1;
				max = curr;
			}
			
			while(!s2.isEmpty()) {
				s1.add(s2.pop());
			}
			
			s1.add(curr);
		}
		
		System.out.println(Arrays.toString(ans).replaceAll("[\\[\\,\\]]", ""));
	}
}
*/
