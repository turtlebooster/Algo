package swea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SW_test_2383_점심식사시간 {
	static class Stair {
		int r;	// row
		int c;	// col
		int l;	// 계단 길이			
		List<Person> list = new ArrayList<>();
		public Stair(int r, int c, int l) {
			this.r = r;
			this.c = c;
			this.l = l;
		}
	}
	static class Person {
		int in; // 계단 들어온 시간
		int out; // 계단 나가는 시간
		public Person(int in, int out) {
			this.in = in;
			this.out = out;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, pCnt, time;
		int[][] dist;
		Stair[] stair;
		List<int[]> pList, sList;
		Queue<int[]> q, s0q, s1q;
//		int[][] map, dist;
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			// 사람 및 계단 위치 정보 입력
			pCnt = 0;
			pList = new ArrayList<>();
//			sList = new ArrayList<>();
			stair = new Stair[2];
			int sIdx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					map[i][j] = sc.nextInt();
					int num = sc.nextInt();
					if (num == 1) {
						// 사람 수 파악
						pCnt++;
						// 사람마다 초기 위치 저장
						pList.add(new int[] {i, j});
					} else if (num != 0) {
						// 계단이면
						// 계단은 항상 2개
						// 계단 위치 및 계단 길이 저장
//						sList.add(new int[] {i, j, num});
						stair[sIdx++] = new Stair(i, j, num);
					}
				}
			}
			
			// 계단과의 거리 정보 저장
			dist = new int[2][pCnt];
			for (int i = 0; i < pCnt; i++) {
				dist[0][i] = getDist(pList.get(i), stair[0]);
				dist[1][i] = getDist(pList.get(i), stair[1]);
			}
			
			// 시간마다 계산해서 더 좋은 쪽에 넣기
//			boolean flag = false;
			q = new LinkedList<>();
//			s0q = new LinkedList<>();
//			s1q = new LinkedList<>();
//			for (int i = 0; i < stair[0].l; i++) s0q.add(new int[] {});			
//			for (int i = 0; i < stair[1].l; i++) s1q.add(new int[] {});			
			for (time = 1; pCnt > 0 ; time++) {
				// 계단 내려가기
				for (int i = 0; i < 2; i++) {
					List<Person> list = stair[i].list;
					int size = list.size();
					for (int j = 0; j < size; j++) {
						Person p = list.get(0);
						if (p.out <= time) list.remove(0);
					}
				}
				
				// 거리 1 씩 줄이기
				for (int i = 0; i < pCnt; i++) {
					if (dist[0][i] > 0) dist[0][i]--;
					if (dist[1][i] > 0) dist[1][i]--;
					// 거리가 0이 되는 계단이 하나라도 있으면
					if (dist[0][i] == 0 || dist[1][i] == 0) {
						int idx = -1;
						int min = 9999;
						for (int j = 0; j < 2; j++) {
							if (min > (dist[j][i] + stair[j].l + (stair[j].list.size() != stair[j].l ? 0 : (stair[j].list.get(0).out - time)))) {
								idx = j;
							}
						}
						if (idx != -1 && dist[idx][i] == 0) {
							stair[idx].list.add(new Person(time, time + stair[idx].l));
							// 이미 들어간 사람 표시
							dist[0][i] = dist[1][i] = -1;
							pCnt--;
						}
					}
				}
			}
			
			int max = 0;
			for (int i = 0; i < 2; i++) {
				List<Person> list = stair[i].list;
				for (Person p : list) {
					max = Math.max(max, p.out);
				}
			}
			
			System.out.println("#" + t + " " + max);
			
		}
		sc.close();
	}

	private static int getDist(int[] p, Stair s) {
		return Math.abs(p[0] - s.r) + Math.abs(p[1] - s.c);
	}
}
