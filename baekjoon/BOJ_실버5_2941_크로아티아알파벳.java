package baekjoon;

import java.util.Scanner;

public class BOJ_실버5_2941_크로아티아알파벳 {
	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		
		String input = sc.next();
		int cnt = 0; 	// 갯수를 세기위한 변수
		for (int i = 0; i < input.length();) {
			String alpha = "";
			// 2글자 체크
			if (i + 1 < input.length()) {
				alpha = input.substring(i, i+2);
				if (	
						alpha.equals("c=") 
						|| alpha.equals("c-")
						|| alpha.equals("d-") 
						|| alpha.equals("lj") 
						|| alpha.equals("nj") 
						|| alpha.equals("s=") 
						|| alpha.equals("z=")) {
					cnt++;
					i += 2;
					continue;
				}			
			}
			// 3글자 체크
			if (i + 2 < input.length()) {
				alpha = input.substring(i, i+3);
				if (alpha.equals("dz=")) {
					cnt++;
					i += 3;
					continue;
				}
			}
			// 1글자 체크
			cnt++;
			i++;
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
/*
public class BOJ_2941_정수빈 {
	public static void main(String[] args) {
		//해당하는 알파벳을 모두 한글자로 바꾼 후 길이 세기 
		Scanner sc = new Scanner(System.in);
		String[] alpha = {"c=", "c-","dz=","d-","lj","nj","s=","z="};

		String str = sc.nextLine();
		for(String apl : alpha) {
			if(str.contains(apl)) {
				str = str.replace(apl, "_");
			}
		}
		System.out.println(str +" "+str.length());
	}
}
*/
