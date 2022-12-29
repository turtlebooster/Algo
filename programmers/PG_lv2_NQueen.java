package programmers;

public class PG_lv2_NQueen {
    class Solution {
        int N, cnt;
        public int solution(int n) {
            int answer = 0;

            N = n;
            putQueen(0, 0, 0, 0, 0);

            answer = cnt;
            return answer;
        }

        public void putQueen(int idx, int row, int col, int dia1, int dia2) {
            if (idx >= N) {
                cnt++;
                return;
            }

            int rBit, cBit, d1Bit, d2Bit;
            rBit = 1 << idx;
            for (int c = 0; c < N; c++) {
                cBit = 1 << c;
                d1Bit = 1 << (idx + c);
                d2Bit = 1 << (idx - c + N);

                if ((col & cBit) > 0 || (dia1 & d1Bit) > 0 || (dia2 & d2Bit) > 0) continue;

                putQueen(idx + 1, row | rBit, col | cBit, dia1 | d1Bit, dia2 | d2Bit);
            }
        }
    }
}
