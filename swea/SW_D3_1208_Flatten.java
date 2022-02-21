package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_1208_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 반복
		for(int tc = 1; tc <= 10; tc++) {
			// 입력
//			int dNum = sc.nextInt();
			int dNum = Integer.parseInt(br.readLine());
			
			int[] arr = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
//				arr[i] = sc.nextInt();
				arr[i] = Integer.parseInt(st.nextToken());
			}
				
			// max, min 탐색
			int maxIdx = 0;
			int minIdx = 0;
			for (int i = 0; i < dNum; i++) {
				for (int j = 0; j < 100; j++) {
					if (arr[maxIdx] < arr[j]) maxIdx = j;
					if (arr[minIdx] > arr[j]) minIdx = j;
				}
				// 최고점과 최저점 차이가 1 이하일 경우 덤프의 의미가 없음
				if (arr[maxIdx] - arr[minIdx] <= 1) break;
				
				// 최고점 한개를 최저점 한개에게 전달
				arr[maxIdx]--;
				arr[minIdx]++;				
			}
			
			// 최종 이동 후 max, min 재 탐색
			for (int j = 0; j < 100; j++) {
				if (arr[maxIdx] < arr[j]) maxIdx = j;
				if (arr[minIdx] > arr[j]) minIdx = j;
			}
			
			System.out.printf("#%d %d\n", tc, arr[maxIdx] - arr[minIdx] );
			
		}
		br.close();
	}
}
