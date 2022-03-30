package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SW_D3_2930_힙_prof {
	
	static class MaxHeap {
		int[] data;
		int pos;
		
		// 기본적으로 10 크기의 배열 제작
		MaxHeap() {
			this(10);
		}
		
		// 주어진 size 크기의 배열 제작
		MaxHeap(int size) {
			data = new int[size + 1];
		}
		
		// 배열이 가득 찼는지 확인
		private boolean isFull() {
			return pos == data.length - 1;
		}
		
		// 교환
		private void swap(int idx1, int idx2) {
			int temp = data[idx1];
			data[idx1] = data[idx2];
			data[idx2] = temp;
		}
		
		// 데이터 삽입
		public void offer(int val) {
			if (isFull()) {
				// 공간 확장
				data = Arrays.copyOf(data, data.length * 2);
			}
			
			data[++pos] = val;
			int idx = pos;
			while (idx > 1 && data[idx] > data[idx / 2]) {
				swap(idx, idx / 2);
				idx /= 2;
			}
		}
		
		public void print() {
			System.out.println(Arrays.toString(data));
		}
		
		public int poll() {
			if (pos == 0) return -1;
			
			int result = data[1];
			data[1] = data[pos];
			data[pos--] = 0;
			
			// 힙의 재정렬
			heapify();
			
			return result;
		}
		private void heapify() {
			int idx = 1;
			while (idx * 2 <= pos) {
				if (data[idx] >= data[idx * 2] && data[idx] >= data[idx * 2 + 1]) {
					// 정렬 완료
					break;
				}
				if (idx * 2 == pos || data[idx * 2] > data[idx * 2 + 1]) {
					// 왼쪽이 더 클때
					swap(idx, idx * 2);
					idx = idx * 2;
				} else {
					// 오른쪽이 더 클때
					swap(idx, idx * 2 + 1);
					idx = idx * 2 + 1;
				}
				
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			MaxHeap heap = new MaxHeap();
			StringBuffer sb = new StringBuffer();
			sb.append("#").append(t);
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				int op = sc.nextInt();
				if (op == 1) {
					// op = 1
					heap.offer(sc.nextInt());
				} else {
					// op = 2
					sb.append(" ").append(heap.poll());
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}
