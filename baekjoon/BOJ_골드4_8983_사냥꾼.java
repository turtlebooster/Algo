package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드4_8983_사냥꾼 {
//	static class Animal {
//		int x, y;
//		boolean hunted;
//		
//		public Animal(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());	// 사대의 수
		int N = Integer.parseInt(st.nextToken());	// 동물의 수
		long L = Integer.parseInt(st.nextToken());	// 사정거리
		
		int[] points = new int[M];					// 사대의 위치
//		List<Animal> animals = new ArrayList<>();	// 동물들 정보
//		Animal[] animals = new Animal[N];	// 동물들 정보
		
		// 사대 위치 정보 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}
		
		// x 기준 오름차순 정렬
		Arrays.sort(points);
		
		// 동물 위치 정보 입력
		// 동물마다 사격 가능한 사대가 있는지 체크
		int x, y;
		int cnt = 0; // 사냥한 동물의 수
		int s, e, mid;
		long dist;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if (y > L) continue;
			s = 0;
			e = M - 1;
			while (s <= e) {
				mid = (s + e) / 2;
				dist = Math.abs(points[mid] - x) + y;
				
				if (dist <= L) {
					cnt++;
					break;
				}
				
				if (x < points[mid]) e = mid - 1;
				else s = mid + 1;
			}
		}
		
		System.out.println(cnt);
	}	

}
