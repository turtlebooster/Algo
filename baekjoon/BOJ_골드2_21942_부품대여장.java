package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_골드2_21942_부품대여장 {
    static class Fee {
        String name;
        long fee;

        public Fee(String name, long fee) {
            this.name = name;
            this.fee = fee;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정보 개수, 대여 기간, 벌금
        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        int due = 24 * 60 * Integer.parseInt(L.substring(0, 3)) + 60 * Integer.parseInt(L.substring(4, 6)) + Integer.parseInt(L.substring(7));
        int F = Integer.parseInt(st.nextToken());

        // 벌금 명단
        Map<String, Long> feeMap = new HashMap<>();
        // 정보 입력
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int min = makeMin(st.nextToken(), st.nextToken());
            String part = st.nextToken();
            String name = st.nextToken();

            if (map.get(name) == null) {
                // 처음 등장한 이름
                // 빌린 물건 map
                Map<String, Integer> itemMap = new HashMap<>();
                itemMap.put(part, min);
                map.put(name, itemMap);
            } else {
                // 등장 했던 이름
                // 빌렸던 물건인지 판별
                Map<String, Integer> itemMap = map.get(name);
                if (itemMap.get(part) == null || itemMap.get(part) < 0) {
                    // 새로 빌리는 물건
                    itemMap.put(part, min);
                } else {
                    long temp = due - (min - itemMap.get(part));
                    // 벌금 내야할 경우
                    if (temp < 0) {
                        feeMap.merge(name, - F * temp, Long::sum);
                    }
                    // 반납 완료
                    itemMap.put(part, -1);
                }
            }
        }

        // 벌금 명단 pq
        PriorityQueue<Fee> pq = new PriorityQueue<>((f1, f2) -> f1.name.compareTo(f2.name));
        for (String n : feeMap.keySet()) {
            pq.add(new Fee(n, feeMap.get(n)));
        }

        // 명단 출력
        if (pq.isEmpty()) {
            System.out.println(-1);
            br.close();
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Fee f = pq.poll();
            sb.append(f.name).append(" ").append(f.fee).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int[] daySum = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    public static int makeMin(String date, String time) {
        int M = Integer.parseInt(date.substring(5, 7));
        int d = Integer.parseInt(date.substring(8));
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));

        return m + 60 * h + 24 * 60 * (d + daySum[M - 1]);
    }
}
