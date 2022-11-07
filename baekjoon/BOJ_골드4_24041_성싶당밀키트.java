package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_24041_성싶당밀키트 {
	static int day, N, G, K;
	static int[] S, L, O;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		G = sc.nextInt();
		K = sc.nextInt();
		
		S = new int[N];
		L = new int[N];
		O = new int[N];
		
		// 중요하지 않은 재료 수, 중요한 재료 수
		int M = 0;
		int I = 0;
		// 중요하지 않은 재료 번호, 중요한 재료 번호
		int[] mNums = new int[N];
		int[] iNums = new int[N];
		// 최소 날짜 최대 날짜
		int mMin = 1000_000_000, mMax = 1;
		int iMin = 1000_000_000, iMax = 1; 
		
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			L[i] = sc.nextInt();
			O[i] = sc.nextInt();
			
			if (O[i] == 1) {
				mNums[M++] = i;
				mMin = Math.min(mMin, L[i]);
				mMax = Math.max(mMax, L[i]);
			} else {
				iNums[I++] = i;
				iMin = Math.min(iMin, L[i]);
				iMax = Math.max(iMax, L[i]);
			}
		}
		
		day = 1;
		if (M < K) {	
			binarySearch(G, 1, 1000_000_000, I, iNums);
		} else {
			comb(0, I, N - K, mNums, iNums, M, I);
		}
		System.out.println(day);
		sc.close();
	}
	
	public static void comb(int idx, int cnt, int max, int[] mNums, int[] iNums, int M, int I) {
		if (cnt > max) {
			return;
		}
		if (idx >= M) {
			if (cnt == max) {
				// 계산
				binarySearch(G, 1, 1000000000, max, iNums);
			}
			return;
		}
		
		comb(idx + 1, cnt, max, mNums, iNums, M, I);
		iNums[cnt++] = mNums[idx];
		comb(idx + 1, cnt, max, mNums, iNums, M, I);
	}
	
	public static void binarySearch(int G, int low, int high, int max, int[] iNums) {
		int mid, idx;
		
		while(low <= high) {
			mid = (low + high) / 2;
			long sum = 0;
			for (int i = 0; i < max; i++) {
				idx = iNums[i];
				sum += S[idx] * Math.max(1, mid - L[idx]);
				if (sum > G || sum < 0) {
					sum = G + 1;
					break;
				}
			}
			if (sum == G) {
				day = Math.max(day, mid);
				return;
			} else if (sum > G) {
				high = mid - 1;
			} else {
				day = Math.max(day, mid);
				low = mid + 1;
			}
		}
	}
}
