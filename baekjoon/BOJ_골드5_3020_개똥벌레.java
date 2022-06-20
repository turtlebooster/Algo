package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드5_3020_개똥벌레 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동굴 크기 입력
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] sArr = new int[H + 1];
		int[] jArr = new int[H + 1];
		
		// 종유석 석순 높이 별 갯수 입력
		int h;
		for (int i = 0; i < N; i++) {
			h = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				// 석순
				sArr[h]++;
			} else {
				// 종유석
				jArr[h]++;
			}				
		}
		
		// 누적 합 계산 -> 높이 별 장애물 개수
		for (int i = H - 1; i >= 1; i--) {
			sArr[i] += sArr[i + 1];
			jArr[i] += jArr[i + 1];
		}
		
		// 위치 별 장애물 수 최소값 및 그 개수 체크
		int min = N;
		int cnt = 0;
		int res;
		for (int i = 1; i <= H; i++) {
			res = sArr[i] + jArr[H - i + 1];
			if (min > res) {
				min = res;
				cnt = 1;
			} else if (min == res) {
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
	}
}
