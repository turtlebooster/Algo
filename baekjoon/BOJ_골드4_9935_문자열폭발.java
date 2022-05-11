package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_골드4_9935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine();
		String bomb = br.readLine();
		
//		while(msg.contains(bomb)) {
//			msg = msg.replace(bomb, "");
//		}		
		String ans = pung(msg, bomb);
		System.out.println(ans.length() == 0 ? "FRULA" : ans);
	}
	public static String pung(String msg, String bomb) {
		if(msg.contains(bomb)) return pung(msg.replace(bomb, ""), bomb);
		return msg;
	}
}
