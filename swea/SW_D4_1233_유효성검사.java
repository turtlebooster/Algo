package swea;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_D4_1233_유효성검사 {
	static String[][] tree;
	static int N;
	static Stack<String> box;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(sc.nextLine());	// 정점의 총 수
			
			tree = new String[N + 1][3];	// tree[i][0] 숫자 or 연산자  /  tree[i][1], tree[i][2] 왼, 오 자식 
			box = new Stack<>();
			
			String[] data = new String[N];
			for (int i = 0; i < N; i++) {
				data[i] = sc.nextLine();
			}
			
			int ans = 1;
			
			// N 줄에 걸쳐 각 정점 정보 입력
			// 트리 배열 생성
			try {
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(data[i]);
					
					int idx = Integer.parseInt(st.nextToken());
					tree[idx][0] = st.nextToken();
					if (st.hasMoreTokens()) {
						tree[idx][1] = st.nextToken();
						tree[idx][2] = st.nextToken();
					}
				}
				inorder(1);				
				
			} catch(Exception e) {
				ans = 0;
			}
			
			// 중위순회 하여 계산
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
	
	public static void calc() throws Exception{
		double num2 = Double.parseDouble(box.pop());
		String op = box.pop();
		double num1 = Double.parseDouble(box.pop());
		
		switch (op) {
		case "+":
			box.add((num1 + num2) + "");
			break;
		case "-":
			box.add((num1 - num2) + "");
			break;
		case "*":
			box.add((num1 * num2) + "");
			break;
		case "/":
			box.add((num1 / num2) + "");
			break;
		}
	}
	
	public static void inorder(int idx) throws Exception{
		if (idx > N) return;
		
		Integer left = tree[idx][1] == null ? 0 : Integer.parseInt(tree[idx][1]);
		Integer right = tree[idx][2] == null ? 0 : Integer.parseInt(tree[idx][2]);
		
		// 왼쪽 자식 존재
		if (left != 0) inorder(left);
		box.add(tree[idx][0]);
		// 오른쪽 자식 존재
		if (right != 0) {
			inorder(right);
			// 연산
			if ("+-*/".contains(box.peek())) return;
			calc();
		}
		
	}
	
}
