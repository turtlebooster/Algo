package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_12904_A와B {
    public static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String T = sc.next();

        recur(S, T);

        System.out.println(ans);
        sc.close();
    }

    public static void recur(String S, String T) {
        if (ans == 1) return;

        // T 의 길이가 S 보다 같아지면 체크
        if (S.length() >= T.length()) {
            if (T.equals(S)) ans = 1;
            return;
        }

        if (T.endsWith("A")) {
            // A 로 끝나면 A 제거
            recur(S, T.substring(0, T.length() - 1));
        } else {
            // B 로 끝나면 B 제거 후 뒤집기
            String reverse = "";

            for (int i = T.length() - 2; i >= 0; i--) {
                reverse += T.charAt(i);
            }

            recur(S, reverse);
        }
    }
}
