package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드5_1759_암호만들기 {
	static int L, C;
	static String[] txt, sel;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		txt = br.readLine().split(" ");
		// 알파벳 순으로 정렬
		Arrays.sort(txt);
	    // 선택된 알파벳 저장할 배열
		sel = new String[L];
		comb(0, 0, 0, 0);
		
		br.close();
	}
	public static void comb(int cnt, int idx, int jCnt, int mCnt) {
		if (cnt == L) {
			// 자음 2개, 모음 1개의 조건을 만족 못시켰으면 처리 없이 리턴
			if (jCnt < 2 || mCnt < 1) return;
			// 만족했으면 출력
			for (int i = 0; i < L; i++) System.out.print(sel[i]);
			System.out.println();
			return;
		}
		if (idx == C) return;
		String next = txt[idx]; 
		sel[cnt] = next;
		// 사용할 경우
		if ("aeiou".contains(next)) {
			// 모음이면
			comb(cnt + 1, idx + 1, jCnt, mCnt + 1);			
		} else {
			// 자음이면
			comb(cnt + 1, idx + 1, jCnt + 1, mCnt);			
		}
		// 사용하지 않을 경우
		comb(cnt, idx + 1, jCnt, mCnt);
	}
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_골드5_1759_암호만들기 {
	static int L, C, mIdxSize, jIdxSize;
	static List<String> mtxt, jtxt;
	static String[] sel;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		mtxt = new ArrayList<>();
		jtxt = new ArrayList<>();
		for (int i = 0; i < C; i++) {
			String next = st.nextToken();
			if ("aeiou".contains(next)) {
				mtxt.add(next);
			} else {
				jtxt.add(next);
			}
		}
		mIdxSize = mtxt.size();
		jIdxSize = jtxt.size();
		Collections.sort(mtxt);
		Collections.sort(jtxt);
		
		sel = new String[L];
		comb(0, 0, 0);
		
		br.close();
	}
	public static void comb(int cnt, int m, int j) {
		if (cnt == L) {
			if (m < 1 || j < 2) return;
			Arrays.sort(sel);
			for (int i = 0; i < L; i++) System.out.print(sel[i]);
			System.out.println();
			return;
		}
		if (m >= mIdxSize && j >= jIdxSize) return;
		
		// 모음 넣기
		if (m < mIdxSize) {
			sel[cnt] = mtxt.get(m);
			comb(cnt + 1, m + 1, j);			
		}
		// 자음 넣기
		if (j < jIdxSize) {
			sel[cnt] = jtxt.get(j);
			comb(cnt + 1, m, j + 1);
		}
//		comb(cnt, m, j);
	}
}
*/
