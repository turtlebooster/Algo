package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D2_1859_백만장자프로젝트 {
	/*
	 * 사재기를 해서 최대 이득을 얻자! 
	 * 1. 연속된 N 일 동안의 물건 매매가를 알고있음 
	 * 2. 하루에 최대 1만큼만 구입 
	 * 3. 판매는 언제든 가능
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long ans = 0;
			int N = Integer.parseInt(br.readLine()); // N일동안의 물건 매매가를 알고있다! 2 ~ 1,000,000

			int[] price = new int[N]; // N 일동안의 가격 배열

			// 가격 배열 데이터 세팅
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			// 각각의 날짜에 해당하는 가격보다 뒤쪽에 이익이 되는 가격이 있으면 일단 구입
			// 최대 이익의 날짜를 찾아 최대 이익을 더해나간다
			int max = price[N - 1];
			for (int i = N - 1; i > 0; i--) {
				max = Math.max(max, price[i]);
				if (max - price[i - 1] > 0) ans += max - price[i - 1];
			}
			
			/*	시간초과
			// 각각의 날짜에 해당하는 가격보다 뒤쪽에 이익이 되는 가격이 있으면 일단 구입
			// 최대 이익의 날짜를 찾아 최대 이익을 더해나간다
			for (int i = 0; i < N - 1; i++) {
				int max = price[i];
				// 이후의 날짜들 중에서 가격 최댓값 찾기
				for (int j = i + 1; j < N; j++) {
					max = Math.max(max, price[j]);
				}
				// 최댓값이 i 일의 가격보다 높을경우 판매하여 이익을 더함
				if (max > price[i])
					ans += max - price[i];
			}
			*/
			System.out.println("#" + tc + " " + ans);
		}

		br.close();
	}
}
