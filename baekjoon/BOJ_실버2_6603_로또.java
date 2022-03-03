package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버2_6603_로또 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			// 0 하나 주어지면 끝
			if (k == 0) break;

			//끝나지 않은 경우
			int[] nums = new int[k];
			for (int i = 0; i < k; i++) {
				nums[i] = (Integer.parseInt(st.nextToken()));
			}
			
			int[] lotto = new int[6];			
			recur(0, 0, nums, lotto);
			
			/*
			// 6겹 반복문
			for (int i = 0; i < k - 5; i++) {
				for (int j = i + 1; j < k - 4; j++) {
					for (int l = j + 1; l < k - 3; l++) {
						for (int m = l + 1; m < k - 2; m++) {
							for (int n = m + 1; n < k - 1; n++) {
								for (int o = n + 1; o < k ; o++) {
									System.out.printf("%d %d %d %d %d %d\n", nums[i], nums[j], nums[l], nums[m], nums[n], nums[o]);
								}								
							}							
						}						
					}					
				}
			}
			*/
			// 한 줄 띄기			
			System.out.println();
		}
		
		
	}
	
	public static void recur (int cnt, int s, int[] nums, int[] lotto) {
		
		if (cnt == 6) {
			System.out.println(Arrays.toString(lotto).replaceAll("[\\[\\,\\]]", ""));			
			
			return;
		}
		
		
		for (int i = s; i < nums.length; i++) {
			lotto[cnt] = nums[i];
			recur(cnt + 1, i + 1, nums, lotto);
		}
		
		
	}
	
}
