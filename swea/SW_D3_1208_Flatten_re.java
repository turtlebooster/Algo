package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_1208_Flatten_re {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 1;
		while (tc <= 10) {
			int dump = Integer.parseInt(br.readLine());
			
			int[] count = new int[101];
		
			// 입력받기
			st = new StringTokenizer(br.readLine());
			int i = 0;		
			while (i < 100) {
				count[Integer.parseInt(st.nextToken())]++;
				i++;
			}
			
			// 최고점 최저점 찾아 최고점 - 1, 최저점 + 1		
			int maxH;
			int minH;
			while (dump > 0) {
				// 최고점 최저점 찾기
				i = 1;
				maxH = 1;
				minH = 100;
				while (i <= 100) {
					if(count[i] == 0) continue;
					if (maxH < i) maxH = i;
					else if (minH > i) minH = i;						
					i++;
				}
				
				if (maxH - minH<= 1) break;
				
				//dump 작업
				//최고점 1개 감소, 최저점 1개 갑소
				count[maxH]--;
				count[minH]--;
				//(최고점-1) 1개 증가 , (최저점+1) 1개 증가
				count[maxH - 1]++;
				count[minH + 1]++;
				
				dump--;
			}	
			
			// 최고점 최저점 찾기
			i = 1;
			maxH = 1;
			minH = 100;
			while (i <= 100) {
				if(count[i] == 0) continue;
				if (maxH < i) maxH = i;
				else if (minH > i) minH = i;						
				i++;
			}
			
			System.out.println("#" + tc++ + " " + (maxH - minH));
		}
		
	}
}
