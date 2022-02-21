package baekjoon;

import java.util.Scanner;

public class BOJ_실버5_8979_올림픽 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); // 국가의 수
		int nth = sc.nextInt() - 1; // 등수를 알고 싶은 국가
		int cnt = 1; // 등수 초기값

		int[][] arr = new int[num][4];

		// 각 국가번호 순서대로 배열에 넣기
		for (int i = 0; i < num; i++) {
			int num2 = sc.nextInt() - 1;
			arr[num2][0] = num2 + 1;
			arr[num2][1] = sc.nextInt();
			arr[num2][2] = sc.nextInt();
			arr[num2][3] = sc.nextInt();
		}

		// 조건에 맞으면 등수가 하나씩 밀려남
		for (int i = 0; i < num; i++) {
			// 금메달 비교
			if (arr[i][1] > arr[nth][1]) {
				cnt++;
			} else if (arr[i][1] == arr[nth][1]) {
				// 은메달 비교
				if (arr[i][2] > arr[nth][2]) {
					cnt++;
				} else if (arr[i][2] == arr[nth][2]) {
					// 동메달 비교
					if (arr[i][3] > arr[nth][3]) {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
		sc.close();
	}
}
