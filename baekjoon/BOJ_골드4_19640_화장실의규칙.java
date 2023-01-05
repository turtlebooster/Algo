package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_19640_화장실의규칙 {
    static class Employee {
        int d, h, m, idx;

        public Employee(int d, int h, int m, int idx) {
            this.d = d;
            this.h = h;
            this.m = m;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 사원 줄 별 입력
        int ed = N / M + 1;
        Employee[][] row = new Employee[M][ed];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = i % M;
            int r = i / M;
            row[m][r] = new Employee(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), m, i);
        }

        int kr = K % M;
        int kc = K / M;
        Employee e = row[kr][0];
        // 데카가 속한 줄에서 데카가 나갈 수 있는 최소 조건 가진 사원 찾기
        for (int i = 1; i <= kc; i++) {
            Employee n = row[kr][i];
            if (e.d > n.d) {
                e = n;
            }
            else if (e.d == n.d && e.h > n.h) {
                e = n;
            }
        }

        int cnt = kc;
        for (int i = 0; i < M; i++) {
            if (i == kr) continue;
            for (int j = 0; j < ed; j++) {
                // 줄 끝
                if (row[i][j] == null) break;
                // 조건 만족 못하면 그 뒷사람은 데카 나가기 전에 못나감
                if (!check(e, row[i][j])) break;
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    static boolean check (Employee e, Employee n) {
        if (e.d < n.d) {
            return true;
        }
        if (e.d == n.d) {
            if (e.h < n.h) {
                return true;
            }
            else if (e.h == n.h && e.m > n.m) {
                return true;
            }
        }
        return false;
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BOJ_골드4_19640_화장실의규칙 {
//    static class Employee {
//        int d, h, m, idx;
//
//        public Employee(int d, int h, int m, int idx) {
//            this.d = d;
//            this.h = h;
//            this.m = m;
//            this.idx = idx;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        // 선두 선정 조건 적용 pq
//        PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) -> {
//            if (e1.d != e2.d) return e2.d - e1.d;
//            if (e1.h != e2.h) return e2.h - e1.h;
//            return e1.m - e2.m;
//        });
//
//        // 줄 순서
//        Queue<Employee>[] q = new LinkedList[M];
//        for (int i = 0; i < M; i++) {
//            q[i] = new LinkedList<>();
//        }
//
//        // 각 줄의 인원 입력
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int m = i % M;
//            q[m].add(new Employee(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), m, i));
//        }
//
//        // 첫 선두 입력
//        for (int i = 0; i < M; i++) {
//            if (q[i].isEmpty()) continue;
//            pq.add(q[i].poll());
//        }
//
//        // 먼저 들어간 사원 수
//        int cnt = 0;
//        while (!pq.isEmpty()) {
//            Employee n = pq.poll();
//            // 데카 차례
//            if (n.idx == K) break;
//            cnt++;
//            // 다음 사람으로 선두 갱신
//            if (q[n.m].isEmpty()) continue;
//            pq.add(q[n.m].poll());
//        }
//
//        System.out.println(cnt);
//        br.close();
//    }
//}
