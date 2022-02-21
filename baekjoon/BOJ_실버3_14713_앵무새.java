package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class BOJ_실버3_14713_앵무새 {
	/*
	 * 한 앵무새는 한 문장 기억하며, 단어를 순서대로 말함
	 * 한 단어 단위로 앵무새가 서로 말을 가로채고 말할 수 있음
	 * 같은 단어가 2번 이상 등장하지 않음
	 * 
	 * 받아적은 문장 L 이 위의 규칙에 따라 나올 수 있는 문장인지 판별
	 * 
	 * input
	 * N	앵무새의 수 = 문장의 수
	 * S1	앵무새가 말하는 문장
	 * S2
	 * ...Sn
	 * L	받아 적은 문장
	 * 
	 * output
	 * ans	가능 여부(ossible 또는 Impossible)
	 * 
	 */
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 앵무새의 수 = 문장의 수
//		int N = Integer.parseInt(sc.next());	// 앵무새의 수 = 문장의 수
//		sc.nextLine();
		
		// 문장별 단어 순서대로 저장 행렬
		String[][] splitMsg = new String[N][];		
		int sum = 0;	// 단어 갯수 저장
		for (int i = 0; i < N; i++) {
			splitMsg[i] = br.readLine().split(" ");
//			splitMsg[i] = sc.nextLine().split(" ");
			sum += splitMsg[i].length;
		}
		
		String[] L = br.readLine().split(" ");	// 받아 적은 문장 단어 순서대로 저장 행렬
//		String[] L = sc.nextLine().split(" ");	// 받아 적은 문장 단어 순서대로 저장 행렬
		String ans = "Possible"; // "Impossible"
		
		// 문장 단어 수 < 앵무새 단어 갯수 이면 확인 할 필요 없이 Impossible
		if (L.length != sum) {
			ans = "Impossible";
			System.out.println(ans);
//			sc.close();	
			return;
		}
		
		// 앵무새 마다 확인해야할 인덱스 표시
		int[] idx = new int[N];
		outer:
		for (int i = 0; i < L.length; i++) {
			for (int j = 0; j < N ; j++) {
				// 인덱스 범위를 넘으면 확인하지 않는다.
				if (idx[j] > splitMsg[j].length - 1) continue;		
				// 같은 단어를 찾으면
				if (L[i].equals(splitMsg[j][idx[j]])) {
					// 앵무새 문장 다음 인덱스로 넘어감
					idx[j]++;
					// 받아 적은 문장 다음 단어 체크하도록 바깥쪽 for문으로 이동
					continue outer;
				}
			}
			// 틀렸을 경우에만 아래로 온다
			ans = "Impossible";
			break;
		}
		
		
		System.out.println(ans);
//		sc.close();		
	}
}
