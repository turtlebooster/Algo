package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_골드1_1700_멀티탭스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 멀티탭 구멍 수
        int N = Integer.parseInt(st.nextToken());
        // 전기용품 총 사용 횟수
        int K = Integer.parseInt(st.nextToken());

        // 전기용품별 순서 인덱스 저장 q 배열
        Queue<Integer>[] indexQ = new LinkedList[K + 1];
        // q 배열 초기화
        for (int i = 1; i <= K; i++) {
            indexQ[i] = new LinkedList<>();
        }

//        int[] cnt = new int[K + 1];
        // 사용하는 전기 용품 종류
        Set<Integer> set = new HashSet<>();
        // 전기 용품 사용 순서
        int[] order = new int[K];

        // 전기용품별 사용 횟수, 종류, 순서 기록
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            indexQ[num].add(i);
            set.add(num);
            order[i] = num;
        }

        // 사용되지 않을 경우 100 번째 index 로 초기화
        for (int num : set) {
            indexQ[num].add(100);
        }

        // 나중에 다시 사용할 콘센트 순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> indexQ[i2].peek() - indexQ[i1].peek());

        // 사용 중 체크
        boolean[] use = new boolean[K + 1];

        // 최소 횟수 구하기
        int ans = 0;
        for (int num : order) {
            if (indexQ[num].peek() != 100) indexQ[num].poll();

            if (!use[num]) {
                use[num] = true;
                if (pq.size() == N) {
                    use[pq.poll()] = false;
                    ans++;
                }
                pq.add(num);
            } else {
                // pq 갱신
                int idx = 0;
                int[] temp = new int[pq.size()];
                while(pq.peek() != num) {
                    temp[idx++] = pq.poll();
                }
                temp[idx++] = pq.poll();
                for (int i = 0; i < idx; i++) {
                    pq.add(temp[i]);
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
