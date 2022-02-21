package swea;

import java.util.HashSet;
import java.util.Scanner;

public class SW_D3_4047_영준이의카드카운팅 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String ans = "";
			String cards = sc.next();
			HashSet<Integer> S = new HashSet<>();
			HashSet<Integer> D = new HashSet<>();
			HashSet<Integer> H = new HashSet<>();
			HashSet<Integer> C = new HashSet<>();
			
			boolean flag = true;
			for (int i = 0; i < cards.length(); i += 3) {
				if (cards.charAt(i) == 'S') {
					int n = S.size();		// 카드를 set에 추가하기 전 카드 개수
					S.add(Integer.parseInt(cards.substring(i + 1, i + 3)));
					if (n == S.size()) {	// 카드 숫자가 변하지 않으면 중복
						flag = false;
						break;
					}
				}				
				else if (cards.charAt(i) == 'D') {
					int n = D.size();		// 카드를 set에 추가하기 전 카드 개수
					D.add(Integer.parseInt(cards.substring(i + 1, i + 3)));
					if (n == D.size()) {	// 카드 숫자가 변하지 않으면 중복
						flag = false;
						break;
					}
				}				
				else if (cards.charAt(i) == 'H') {
					int n = H.size();		// 카드를 set에 추가하기 전 카드 개수
					H.add(Integer.parseInt(cards.substring(i + 1, i + 3)));
					if (n == H.size()) {	// 카드 숫자가 변하지 않으면 중복
						flag = false;
						break;
					}
				}				
				else if (cards.charAt(i) == 'C') {
					int n = C.size();		// 카드를 set에 추가하기 전 카드 개수
					C.add(Integer.parseInt(cards.substring(i + 1, i + 3)));
					if (n == C.size()) {	// 카드 숫자가 변하지 않으면 중복
						flag = false;
						break;
					}
				}			
			}
			
			if (flag) ans = (13 - S.size()) + " " + (13 - D.size()) + " " + (13 - H.size()) + " " + (13 - C.size());
			else ans = "ERROR";
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}