package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_CB_03_S571922년도탐사보고서의건 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int lv, N;
		int[] cnt;
		List<Integer> list;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			lv = Integer.parseInt(st.nextToken());	// 부른 층의 수
			N = Integer.parseInt(st.nextToken());	// 외계인의 수
			cnt = new int[N + 1];
			
			list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int num;
			while(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
				list.add(num);
				cnt[num]++;
			}
			
			int max; 
			max = getMax(cnt);
			
			int sum = 0;
			int size = list.size();
			
			while (sum + size < lv) {
				max = getMax(cnt);
				for (int i = 0; i < size; i++) {
					if (cnt[list.get(i)] == max) {
						cnt[list.get(i)]--;
						list.remove(i);
						break;
					}
				}				
				sum += size--;
			}
			

			System.out.println("#" + t + " " + list.get(lv - sum - 1));
		}
	}
	
	public static int getMax(int[] cnt) {
		int max = cnt[1];
		for (int i = 1; i < cnt.length; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
			}
		}
		
		return max;
	}
}
