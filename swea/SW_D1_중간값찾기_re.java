package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D1_중간값찾기_re {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
         * N 개의 점수
         * N 은 홀수, 9 <= N <= 199
         * 중간 값에 해당하는 점수 찾기
         */
         
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 선택 정렬
//		for (int i = 0; i < N - 1; i++) {
		for (int i = 0; i < N / 2 + 1; i++) {
			int minIdx = i;
			for (int j = i + 1 ; j < N ; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		
		// 중간값 찾아 출력
		System.out.println(arr[N/2]);
		
		br.close();		
	}
}
