package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_2922_즐거운단어 {
    static int size, lCnt;
    static long ans;
    static String word;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        word = sc.next();
        size = word.length();

        lCnt = 0;
        ans = 0;

        char c = word.charAt(0);
        boolean isL = c == 'L';

        if (c != '_') {
            if (isL) lCnt++;
            boolean now = "AEIOU".contains(c + "");
            recur(1, 1, now, 1);
            if (isL) lCnt--;
        } else {
            // 모음 5 , 자음(L 제외) 20, L 1
            // 모음
            recur(1, 5, true, 1);
            // 자음(L 제외)
            recur(1, 20, false, 1);
            // L
            lCnt++;
            recur(1, 1, false, 1);
            lCnt--;
        }

        System.out.println(ans);
        sc.close();
    }

    public static void recur(int idx, long sum, boolean before, int cnt) {
        if (cnt >= 3) {
            return;
        }
        if (idx >= size) {
            if (lCnt > 0) ans += sum;
            return;
        }

        char c = word.charAt(idx);
        boolean isL = c == 'L';

        if (c != '_') {
            if (isL) lCnt++;
            boolean now = "AEIOU".contains(c + "");
            recur(idx + 1, sum, now, before == now ? cnt + 1 : 1);
            if (isL) lCnt--;
        } else {
            // 모음 5 , 자음(L 제외) 20, L 1
            // 모음
            recur(idx + 1, sum * 5, true, before ? cnt + 1 : 1);
            // 자음(L 제외)
            recur(idx + 1, sum * 20, false, before ? 1 : cnt + 1);
            // L
            lCnt++;
            recur(idx + 1, sum, false, before ? 1 : cnt + 1);
            lCnt--;
        }
    }
}
