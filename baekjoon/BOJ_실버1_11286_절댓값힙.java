package baekjoon;

import java.util.Arrays;
//import java.util.Comparator;
//import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_실버1_11286_절댓값힙 {
	// 트리를 활용한 절댓값 힙 구현
	static class AbsHeap {
		int[] data;
		int pos;
		
		AbsHeap() {
			data = new int[16 + 1];
		}
		
		AbsHeap(int size) {
			data = new int[size + 1];
		}
		
		private boolean isFull() {
			return pos >= data.length - 1;
		}
		
		private void swap(int idx1, int idx2) {
			int temp = data[idx1];
			data[idx1] = data[idx2];
			data[idx2] = temp;
		}
		
		public void add(int num) {
			// 배열이 가득 차면 길이 2 배 큰 배열로 변경
			if (isFull()) {
				data = Arrays.copyOf(data, 2 * data.length);
			}
			
			// 마지막 자리에 들어온 값 추가
			data[++pos] = num;
			
			// 힙 재정렬

			int idx = pos;
			while (idx > 1 && (Math.abs(data[idx]) < Math.abs(data[idx / 2])
								|| (Math.abs(data[idx]) == Math.abs(data[idx / 2]) && data[idx] < data[idx / 2]))
					) {
				swap(idx, idx / 2);
				idx /= 2;
			}
		}
		
		public int poll() {
			if (pos == 0) return 0;
			
			int result = data[1];
			data[1] = data[pos];
			data[pos--] = 0;
			
			// 힙 재정렬
			heapify();
			
			return result;
		}
		
		private void heapify() {
			int idx = 1;
			while (idx * 2 <= pos) {
				// 자식들과 비교해서 모두 조건을 만족할때
				if ((Math.abs(data[idx * 2]) > Math.abs(data[idx])
								|| (Math.abs(data[idx * 2]) == Math.abs(data[idx]) && data[idx * 2] >= data[idx]))
						&& (idx * 2 == pos
								|| Math.abs(data[idx * 2 + 1]) > Math.abs(data[idx])
								|| (Math.abs(data[idx * 2 + 1]) == Math.abs(data[idx]) && data[idx * 2 + 1] >= data[idx]))) {
					// 정렬 완료된 경우
					break;
				}
				
				// 왼쪽만 자식이 있거나, 왼쪽 절댓값이 더 작거나 , 절댓값이 같고 왼쪽 값이 더 작을때
				if (idx * 2 == pos
						|| Math.abs(data[idx * 2]) < Math.abs(data[idx * 2 + 1])
						|| (Math.abs(data[idx * 2]) == Math.abs(data[idx * 2 + 1]) && data[idx * 2] < data[idx * 2 + 1])) {
					// 왼쪽 값과 교환
					swap(idx, idx * 2);
					idx = idx * 2;
				} else {
					// 아닐 경우 오른쪽과 교환
					swap(idx, idx * 2 + 1);
					idx = idx * 2 + 1;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		AbsHeap Q = new AbsHeap(N);
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			switch (num) {
			case 0:
//				if (Q.isEmpty()) System.out.println(0);
//				else System.out.println(Q.poll());
				System.out.println(Q.poll());
				break;
			default:
				Q.add(num);
			}
		}
		
		sc.close();
	}
	
	/*
	// PriorityQueue 활용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> Q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) return o1 - o2; 
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			switch (num) {
			case 0:
				if (Q.isEmpty()) System.out.println(0);
				else System.out.println(Q.poll());
				break;
			default:
				Q.add(num);
			}
		}
		
		sc.close();
	}
	*/
}
