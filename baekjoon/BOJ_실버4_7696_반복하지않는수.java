package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버4_7696_반복하지않는수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[1000001];
		int cnt = 1;		
		int num;
		boolean[] check = new boolean[10];
		outer:
		for (int i = 1; cnt <= 1000000; i++) {
			num = i;
			Arrays.fill(check, false); 
			while(num != 0) {
				if(check[num % 10]) continue outer;
				check[num % 10] = true;
				num /= 10;
			}
			arr[cnt++] = i;
		}
		
		// N 번째 반복 숫자 없는 수 찾기
		int N;
		while((N = sc.nextInt()) != 0) {
			System.out.println(arr[N]);
		}
		
		sc.close();
	}
}

