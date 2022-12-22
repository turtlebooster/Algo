package baekjoon;

import java.util.*;

public class BOJ_골드5_소트게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 ~ N 까지의 수
        int N = sc.nextInt();
        // K 개의 수 뒤집기
        int K = sc.nextInt();

        // 만들었던 순열 체크
        Map<String, Boolean> visited = new HashMap<>();

        StringBuilder order = new StringBuilder();
        for (int i = 0; i < N; i++) {
            order.append(sc.next());
        }

        if (check(order.toString())) {
            System.out.println(0);
            sc.close();
            return;
        }

        // BFS
        Queue<String> q = new LinkedList<>();
        visited.put(order.toString(), true);
        q.add(order.toString());

        int ans = 0;
        int maxIdx = N - K;
        boolean flag = false;

        outer:
        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (int idx = 0; idx <= maxIdx; idx++) {
                     String tOrder = turn(curr, idx, K);
                     if (visited.get(tOrder) != null) continue;
                     flag = check(tOrder);
                     if (flag) break outer;
                     visited.put(tOrder, true);
                     q.add(tOrder);
                }
            }
        }

        System.out.println(flag ? ans : -1);
        sc.close();
    }

    // 뒤집기
    public static String turn(String order, int idx, int K) {
        String st = order.substring(0, idx);
        String mid = order.substring(idx, idx + K);
        String ed = order.substring(idx + K);

        StringBuilder tOrder = new StringBuilder(st);
        for (int i = K - 1; i >= 0; i--) {
            tOrder.append(mid.charAt(i));
        }
        tOrder.append(ed);

        return tOrder.toString();
    }


    // 오름차순 체크
    public static boolean check(String order) {
        char[] c = order.toCharArray();

        for (int i = 1; i < c.length; i++) {
            if (c[i - 1] >= c[i]) return false;
        }

        return true;
    }
}
