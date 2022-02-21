package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_13547_팔씨름 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			int cnt = 0;
			
			for (int i = 0; i < S.length(); i++) {
				if (S.charAt(i) == 'o') cnt++; 
			}
			
			if (15 - S.length() + cnt >= 8) System.out.printf("#%d YES\n", tc);
		
			else System.out.printf("#%d NO\n", tc);	
		}		
	}
}
