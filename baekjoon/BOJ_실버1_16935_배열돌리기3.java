package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버1_16935_배열돌리기3 {
	static int[][] arr;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 행 개수, 짝수, 2 ~ 100
		M = sc.nextInt();	// 열 개수, 짝수, 2 ~ 100
		int R = sc.nextInt();	// 연산의 수, 1 ~ 1000
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < R; i++) {
			change(sc.nextInt());
		}
				
		System.out.println(Arrays.deepToString(arr).replace("],", "\n").replace(" [", "").replaceAll("[\\[\\,\\]]", ""));
		sc.close();
	}
	
	public static void change (int k) {
		int[][] newArr = new int[N][M];
		
		switch(k) {
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newArr[i][j] = arr[N - 1 - i][j];
				}
			}			
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newArr[i][j] = arr[i][M - 1 - j];
				}
			}
			break;
		case 3:
			newArr = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					newArr[i][j] = arr[N - 1 - j][i];
				}
			}
			int temp = N;
			N = M;
			M = temp;			
			break;
		case 4:
			newArr = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					newArr[i][j] = arr[j][M - 1 - i];
				}
			}
			temp = N;
			N = M;
			M = temp;			
			break;
		case 5:
			// new 1 번 자리 는 이전 4번자리 원소들
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					newArr[i][j] = arr[i + N / 2][j];
				}
			}
			// new 2 번 자리 는 이전 1번자리 원소들
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					newArr[i][j] = arr[i][j - M / 2];
				}
			}
			// new 3 번 자리 는 이전 2번자리 원소들
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					newArr[i][j] = arr[i - N / 2][j];
				}
			}
			// new 4 번 자리 는 이전 3번자리 원소들
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					newArr[i][j] = arr[i][j + M / 2];
				}
			}
			break;
		case 6:
			// new 1 번 자리 는 이전 2번자리 원소들
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					newArr[i][j] = arr[i][j + M / 2];
				}
			}
			// new 2 번 자리 는 이전 3번자리 원소들
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					newArr[i][j] = arr[i + N / 2][j];
				}
			}
			// new 3 번 자리 는 이전 4번자리 원소들
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					newArr[i][j] = arr[i][j - M / 2];
				}
			}
			// new 4 번 자리 는 이전 1번자리 원소들
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					newArr[i][j] = arr[i - N / 2][j];
				}
			}
			break;
		}
		arr = newArr;
		
	}
}
