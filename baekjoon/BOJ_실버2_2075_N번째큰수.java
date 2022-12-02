package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_실버2_2075_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // pq 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // N 개의 숫자 입력
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (pq.peek() >= temp) continue;
                pq.poll();
                pq.add(temp);
            }
        }

        // 출력
        System.out.println(pq.peek());
        br.close();
    }
}
