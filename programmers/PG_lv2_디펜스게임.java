import java.util.*;

public class PG_lv2_디펜스게임 {
  class Solution {    
      public int solution(int n, int k, int[] enemy) {        
          int rounds = enemy.length;

          // 라운드보다 무적권 횟수가 많으면 모든 라운드 막기 가능
          if (rounds <= k) return rounds;           

          PriorityQueue<Integer> pq = new PriorityQueue<>();
          for (int i = 0; i < rounds; i++) {                    
              // 무적권 다 사용했는지 판단
              if (pq.size() < k) {
                  pq.add(enemy[i]);
              }
              // 무적권 모두 사용
              else {
                  // 무적권을 사용한 최소 적의 수보다 현재 적의 수가 더 많을 경우 무적권 사용 교체
                  // 현재 라운드에 무적권 사용, 최소 적의 수에는 병사 소모
                  if (pq.peek() < enemy[i]) {
                      int e = pq.poll();
                      // 병사 소모 가능 여부 판단
                      if (e > n) return i;
                      // 병사 소모
                      n -= e;
                      // 무적권 사용
                      pq.add(enemy[i]);
                  } 
                  // 무적권 사용한 최소 적의 수 보다 적은 적의 수
                  else {
                      // 병사 소모 가능 여부 판단
                      if (enemy[i] > n) return i;
                      // 병사 소모
                      n -= enemy[i];
                  }
              }
          }

          return rounds;
      }
  }
}
