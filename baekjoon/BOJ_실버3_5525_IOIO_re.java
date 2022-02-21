package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class BOJ_실버3_5525_IOIO_re {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // IOIOI 의 O 갯수
		int M = Integer.parseInt(br.readLine()); // 문자열 길이
//		sc.nextLine();
		
//		String P = "OI";
//		for (int i = 0; i < N; i++) {
//			P += "OI";
//		}
		
		String S = br.readLine();
		
//		int cnt = 0;
//		for (int i = 0; i < S.length() - 2 * N; i++) {
//			if (S.charAt(i) != 'I') continue;
//			if (S.substring(i, i + 2 * N + 1).equals(P)) cnt++;
//		}
		
		int cnt = 0;  // OI 연속 갯수 카운팅
		int ans = 0;  // 답 제출을 위한 변수
		
		// OI를 계속 체크해 나갈 것이므로 문자열 끝 2자리는 반복문에서 제외
		for (int i = 0; i < M - 2 ; i++) {
			// I 가 발견될 때만 체크 진행
			if (S.charAt(i) != 'I') continue;
			
			// I 이후 OI 가 나오면
			if (S.substring(i + 1, i + 3).equals("OI")) {
				cnt++;	// 1개씩 카운트
				i++;	// 다음 자리인 O 자리를 체크할 필요 없음
				
				// cnt = N 이될 때부터 O 갯수가 같아지는 Pn 문자 발견되기 시작
		        // 그러므로 그 때부터는 OI 가 더 발견될때마다 Pn 문자 1개씩 추가 됨
				if (cnt - N >= 0) ans++;
			}
			else {
				// 연속된 OI 가 나오지 않으면 의미 없으므로 카운트 초기화
				cnt = 0;
			}
			
			
//			if (S.charAt(i) != 'I') continue;
//			if (S.substring(i + 1, i + 3).equals(P)) cnt++;
		}
		
		System.out.println(ans);
		br.close();
	}
}

