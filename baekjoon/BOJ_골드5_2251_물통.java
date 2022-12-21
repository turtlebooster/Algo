package baekjoon;

import java.util.*;

public class BOJ_골드5_2251_물통 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 각 통에 담을수 있는 물의 최댓값
        int[] max = new int[3];
        for (int i = 0; i < 3; i++) {
            max[i] = sc.nextInt();
        }

        // 담길 수 있는 물의 양
        Set<Integer> set = new HashSet<>();
        set.add(max[2]);

        // BFS
        // 방문 체크
        boolean[][] visited = new boolean[max[0] + 1][max[1] + 1];
        Queue<int[]> q = new LinkedList<>();

        visited[0][0] = true;
        q.add(new int[] {0, 0, max[2]});

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    int idx1 = i;
                    int idx2 = j;

                    for (int k = 0; k < 2; k++) {
                        // idx1 -> idx2
                        int[] temp = Arrays.copyOf(curr, 3);
                        if (curr[idx1] != 0 && curr[idx2] != max[idx2]) {
                            if (curr[idx1] + curr[idx2] >= max[idx2]) {
                                // 쏟으면 가득 찰 때
                                temp[idx1] = curr[idx1] - (max[idx2] - curr[idx2]);
                                temp[idx2] = max[idx2];
                            } else {
                                // 가득 차지 않을 때
                                temp[idx1] = 0;
                                temp[idx2] = curr[idx1] + curr[idx2];
                            }

                            if (!visited[temp[0]][temp[1]]) {
                                // 물의 양 저장
                                if (temp[0] == 0) {
                                    set.add(temp[2]);
                                }

                                visited[temp[0]][temp[1]] = true;
                                q.add(new int[] {temp[0], temp[1], temp[2]});
                            }
                        }

                        // swap
                        int temp2 = idx1;
                        idx1 = idx2;
                        idx2 = temp2;
                    }
                }
            }
        }

        // 배열에 저장 및 정렬
        int[] ans = new int[set.size()];
        int idx = 0;
        for (int amount : set) {
            ans[idx++] = amount;
        }

        Arrays.sort(ans);

        System.out.println(Arrays.toString(ans).replaceAll("[\\[\\,\\]]", ""));
        sc.close();
    }
}
