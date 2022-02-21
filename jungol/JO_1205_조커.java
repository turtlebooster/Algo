package jungol;

import java.util.HashSet;
import java.util.Scanner;

public class JO_1205_조커 {
	/*
	 * N 개의 숫자가 적힌 카드
	 * 카드를 뽑아 1씩 증가하는 순서대로 늘어놓은 경우를 스트레이트라 함
	 * 숫자 0: 조커 -> 어떤 숫자로도 변환이 가능
	 * 
	 * 조커와 일반카드가 주어졌을때, 가장 긴 길이의 스트레이트를 만드는 프로그램 작성!
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 카드의 갯수 ~1,000	카드 숫자는 0 ~ 1,000,000
		int[] cards = new int[N];
		int zerocnt = 0;		// 조커의 갯수 저장
		
		for (int i = 0; i < N; i++) {
			// cards 행렬에 카드 숫자 저장
			// 0 카드가 발견될때마다 조커 갯수 + 1
			if ((cards[i] = sc.nextInt()) == 0) zerocnt++;
		}
		
			
		// 0 제외 중복 없는 카드모임 제작
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			if (cards[i] != 0) set.add(cards[i]);
		}
		
		// 0 제외 중복없는 카드모임 배열로 변환
		cards = new int[set.size()];
		int k = 0;
		for (int i : set) {
			cards[k++] = i; 					
		}
		
		// 선택정렬 - 오름차순
		for (int i = 0; i < cards.length - 1; i ++) {
			int minIdx = i;
			// 가장 작은 값의 인덱스 찾기
			for (int j = i + 1; j < cards.length; j ++) {
				if (cards[minIdx] > cards[j]) {
					minIdx = j;
				}				
			}
			// 가장 작은 값을 앞쪽부터 순서대로 정렬
			int temp = cards[i];
			cards[i] = cards[minIdx];
			cards[minIdx] = temp;
		}		
			
		
		int max = zerocnt;	// 최대 스트레이트 길이 저장하기 위한 변수
							// 카드가 0 밖에 없을경우 0의 갯수가 곧 스트레이트 최대 길이
		for (int i = 0; i < cards.length; i++) {
			int zerocoin = zerocnt;		// 0 사용할때마다 갯수를 체크할 변수, 초기값은 0의 갯수
			int edIdx = i;
			for(int j = i + 1; j < cards.length; j++) {
				if(cards[j] - cards[j - 1] - 1 <= zerocoin) {
					zerocoin -= cards[j] - cards[j-1] - 1;	// 연속되도록 0 사용하고 사용한 만큼 갯수 줄이기
					edIdx = j;								// 적어도 얘 까지는 연속 진행이 충분히 가능
					continue;
				}
				// 연속을 만들기엔 0 갯수 부족
				break;
			}
			
			max = Math.max(cards[edIdx] - cards[i] + 1 + zerocoin, max); 
		}
		
		System.out.println(max);
		sc.close();
	}
}
