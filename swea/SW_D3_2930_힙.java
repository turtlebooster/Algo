package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SW_D3_2930_힙 {
	
	static class MaxHeap {
		int[] data;
		int pos;
		
		MaxHeap() {
			this(16);
		}
		
		MaxHeap(int size) {
			data = new int[size + 1];
		}
		
		// 배열이 가득 찼는지 확인
		private boolean isFull() {
			return pos == data.length - 1;
		}
		
		private void swap(int idx1, int idx2) {
			int temp = data[idx1];
			data[idx1] = data[idx2];
			data[idx2] = temp;
		}
		
		public void offer(int val) {
			if (isFull()) {
				// 꽉 차면 공간 2배로 확장
				data = Arrays.copyOf(data, data.length * 2);
			}
			
			data[++pos] = val;
			int idx = pos;
			
			while (idx > 1 && data[idx] > data[idx / 2]) {
				swap(idx, idx / 2);
				idx /= 2;
			}
		}
		
		public int poll() {
			// 비어있을 경우
			if (pos == 0) return -1;
			
			// 비어있지 않을 경우
			// 루트를 꺼내서 반환
			int root = data[1];
			
			data[1] = data[pos];
			data[pos--] = 0;
			
			// 힙 재정렬
			heapify();			
			
			return root;
		}
		
		private void heapify() {
			int idx = 1;
			// 자식이 존재할때만 수행
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
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 수행해야 하는 연산의 수
			String ans = "";
			
			MaxHeap heap = new MaxHeap();
			
			for (int i = 0; i < N; i++) {
				int op = sc.nextInt();
				if (op == 1) {
					// op = 1
					heap.offer(sc.nextInt());
				} else {
					// op = 2
					ans += " " + heap.poll();
				}
			}
			
			System.out.printf("#%d" + ans + "\n", tc);
		}
		sc.close();
	}
	
	
}
