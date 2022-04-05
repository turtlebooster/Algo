package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_골드5_15686_치킨배달 {
	public static int N, M, minCLen;
	public static int[] sel;
	public static int[][] map, len;
	public static List<int[]> cList, hList;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 도시 크기 N x N
		M = sc.nextInt();	// 남길 수 있는 최대 치킨 집의 수
		map = new int[N][N];// 도시 정보
		
		cList = new ArrayList<>();	// 치킨집 좌표
		hList = new ArrayList<>();	// 집 좌표
		
		// 도시 정보 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					// 집
					hList.add(new int[] {i, j});
				} else if (map[i][j] == 2) {
					// 치킨집
					cList.add(new int[] {i, j});
				}
			}
		}
		
		// 각 집 마다 각 치킨집 까지의 치킨거리
		len = new int[hList.size()][cList.size()];	
		// 치킨 거리 계산 및 저장
		for (int i = 0; i < hList.size(); i++) {
			for (int j = 0; j < cList.size(); j++) {
				// i 집에서 j 치킨집까지의 치킨거리 저장
				len[i][j] = length(hList.get(i), cList.get(j));				
			}
		}
		
		sel = new int[M]; 				// 선택받은 치킨집
		minCLen = Integer.MAX_VALUE; 	// 최소 도시 치킨거리
		comb(0, 0);
		
		System.out.println(minCLen);
		sc.close();
	}
	
	// 선택 받은 치킨집들로 최소 도시 치킨거리 계산
	private static void calc() {
		int sum = 0;
		for (int i = 0; i < hList.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < sel.length; j++) {
				min = Math.min(min, len[i][sel[j]]);
			}
			sum += min;
		}
		minCLen = Math.min(sum, minCLen);
	}
	
	// 치킨집들 중 M 개의 치킨집 선택(조합)
	public static void comb (int cnt, int idx) {
		if (cnt == M) {
			// 계산 해줘
			calc();
			return;
		}
		if (idx == cList.size()) return;
		
		sel[cnt] = idx;
		comb(cnt + 1, idx + 1);
		comb(cnt, idx + 1);
		
	}
	
	// 치킨 거리 계산
	private static int length(int[] h, int[] c) {
		return Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
	}
}
