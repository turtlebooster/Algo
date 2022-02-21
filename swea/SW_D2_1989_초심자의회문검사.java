package swea;

import java.util.Scanner;

public class SW_D2_1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			String msg = sc.next();
			int ans = 1;
			
			
//			String rmsg = "";
//			for (int i = msg.length() - 1; i >= 0; i--) {
//				rmsg += msg.charAt(i);
//			}
//			
//			if (msg.equals(rmsg)) ans = 1;
			
//			for (int i = 0; i < msg.length() / 2; i++) {
//				if (msg.charAt(i) != msg.charAt(msg.length() - 1 - i)) {
//					ans = 0;
//					break;
//				}				
//			}
			
			for(int i=0, j=msg.length()-1; i<=j; i++,j--){
                if(msg.charAt(i) != msg.charAt(j)){
                    ans = 0;
                    break;
                }
            }			
			
			System.out.println("#" + tc + " " + ans);			
			
		}
		sc.close();
	}
}
