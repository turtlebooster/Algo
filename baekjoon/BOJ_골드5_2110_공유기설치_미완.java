package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_골드5_2110_공유기설치_미완 {
	/*
	 * 수직선 위 집 N개
	 * 각 집의 좌표 x1, x2, ..., xN
	 * 공유기 C개 설치
	 * 한 집에는 한 개만 설치 가능
	 * 가장 인접한 공유기 사이의 거리를 가능한 크게!
	 * 
	 * 2 <= N <= 200,000	2 <= C <= N
	 * 
	 * 입력
	 * N C
	 * x1
	 * x2
	 * ...
	 * xi
	 * ...
	 * 
	 * 출력
	 * L 
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
//		int N = sc.nextInt();
//		int C = sc.nextInt();
		int[] hPos = new int[N];
		
		for(int i = 0; i < N; i++) {
			hPos[i] = Integer.parseInt(br.readLine());
		}
		
		// 위치 정렬 - 선택정렬 
//		for(int i = 0; i < N; i++) {
//			int minIdx = i;
//			for(int j = i + 1; j < N; j++) {
//				if(hPos[minIdx] > hPos[j]) minIdx = j;
//			}
//			int temp = hPos[i];
//			hPos[i] = hPos[minIdx];
//			hPos[minIdx] = temp;
//		}
		Arrays.sort(hPos);
		
		// 인접 길이 저장 리스트
		// 길이 가지 수 N * (N - 1) / 2
//		List<Integer> L = new ArrayList<>();
		// 메모리 초과 - > 저장 없이
		
		int max = Integer.MIN_VALUE;
		double minL = 1.0 * (hPos[N - 1] - hPos[0]) / (C - 1);
		for (int i = 0; i < N; i ++) {
			for (int j = i + 1; j < N; j ++) {
				if (hPos[j] - hPos[i] <= minL) {
					max = Math.max(max, hPos[j] - hPos[i]);					
				}
			}			
		}
		
//		System.out.println(min);
		bw.append(Integer.toString(max));
		bw.flush();
		
//		L.sort((l1, l2) -> l1 - l2);
//		
//		for (int i = 0; i < L.size(); i++ ) {
//			if (L.get(i) >= 1.0 * (hPos[N - 1] - hPos[0]) / C) {
//				System.out.println(L.get(i));
//				break;
//			}
//		}		
		
		br.close();
	}
}
