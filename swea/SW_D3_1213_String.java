package swea;

import java.util.Scanner;

public class SW_D3_1213_String {
	/*
	 * 주어지는 영어 문장에서 특정한 문자열 개수 반환
	 * 
	 * 10 개의 테스트 케이스
	 * 문장의 길이는 1000자 이하
	 * 검색 문자열 길이 10자 이하
	 * 한 문장에서는 하느의 문자열만 검색
	 * 
	 * 입력
	 * tc 테스트케이스
	 * S 검색문자열
	 * text 문장
	 * 
	 * 출력
	 * #tc 객수
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for (int tc = 1; tc <= 10; tc++ ) {
			sc.next();
			String S = sc.next();
			String text = sc.next();	
			
			int cnt = 0;
			
			// 보이어-무어
			
			// skip 배열 저장
			int[] skip = new int[S.length() + 1];
			int skiplen = S.length();
			skip[S.length()] = skiplen--;
			for (int i = 0; i < S.length(); i++) {
				skip[i] = skiplen--; 
			}
			
			// 오른쪽에서 왼쪽으로 비교
			// 오른쪽 끝 문자가 불일치하고 
			// 1) 이 문자가 패턴 내에 존재하지 않는 경우 패턴 길이만큼 이동
			// 2) 이 문자가 패턴 내에 존재할 경우 패턴에서 일치하는 문자 자리에 맞게 점프
			
			// 초기 인덱스는 패턴의 끝자리 인덱스
			int tIdx = S.length() - 1;
			int sIdx = S.length() - 1;
			while(tIdx < text.length()) {
				// 오른쪽 끝 문자 불일치
				if (text.charAt(tIdx) != S.charAt(sIdx)) {
					// 패턴내에 존재 유무 체크
					boolean flag = true;
					// 패턴 길이만큼 체크
					for (int i = S.length() - 1 ; i >= 0; i--) {
						// 패턴 내에 존재하지 않는 경우
						if (S.charAt(i) != S.charAt(tIdx - S.length() + 1 + i)) {
							tIdx += skip[S.length()];
							flag = false;
						}						
					}
					if (flag); 
					
				}
				
				
				break;
			}
			
			
			/*
			// 처음부터 순서대로 정직하게 찾는 방법 with flag
			for (int i = 0; i < text.length() - S.length() + 1; i++) {
				boolean flag = true;
				if (text.charAt(i) != S.charAt(0)) continue;		
				for (int j = 0; j < S.length(); j++) {
					if (text.charAt(i + j) != S.charAt(j)) {
						flag = false;
						break;
					}
										
				}
				if (flag) cnt++;				
			}
			 */
						
			/*
			// 처음부터 순서대로 정직하게 찾는 방법 with substring
			for (int i = 0; i < text.length() - S.length() + 1; i++) {
				if (text.charAt(i) != S.charAt(0)) continue;				
				if (text.substring(i, i + S.length()).equals(S)) cnt++;

			}
			*/

			
			System.out.println("#" + tc + " " + cnt);
		}
		
		sc.close();
	}	
}
