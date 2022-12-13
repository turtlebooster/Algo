package baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_골드5_16719_ZOAC {
    public static class Temp {
        int idx;
        String s;

        public Temp(int idx, String s) {
            this.idx = idx;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        int len = text.length();

        boolean[] check = new boolean[text.length()];

        PriorityQueue<Temp> pq = new PriorityQueue<>((t1, t2) -> t1.s.compareTo(t2.s));

        for (int i = 0; i < len; i++) {
            pq.clear();

            for (int j = 0; j < len; j++) {
                if (check[j]) continue;
                check[j] = true;
                String s = "";
                for (int k = 0; k < len; k++) {
                    if (!check[k]) continue;
                    s += text.charAt(k);
                }
                check[j] = false;
                pq.add(new Temp(j, s));
            }

            Temp temp = pq.poll();
            check[temp.idx] = true;
            System.out.println(temp.s);
        }

        sc.close();
    }
}
