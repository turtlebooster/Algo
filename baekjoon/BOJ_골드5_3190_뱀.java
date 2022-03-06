package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드5_3190_뱀 {
	/**
	 * N x N 정사각 보드 위에서 게임 진행
	 * 보드의 상하좌우 끝에 벽, 몇몇 칸에는 사과
	 * 게임 시작시 
	 * 		뱀위 위치: 맨 위 맨 좌측
	 * 		뱀의 길이: 1
	 * 		뱀의 방향: 오른쪽
	 * 
	 *  뱀은 매 초마다 이동
	 *  이동 규칙
	 *  	먼저 뱀은 몸 길이를 늘려 머리를 다음 칸에 위치
	 *  	이동한 칸에 사과가 있으면, 사과가 사라지고 꼬리는 움직이지 않음 (몸 길이 1 증가)
	 *  	이동한 칸에 사과가 없으면, 몸 길이를 줄여 꼬리가 위치한 칸을 비움 (몸 길이 변화 x)
	 *  
	 *  벽 또는 자기자신의 몸과 부딪히면 게임 끝
	 *  
	 *  사과의 위치와 뱀의 이동경로가 주어질 때, 게임이 끝나는데 걸리는 시간(초) 계산 
	 *  
	 *  input: N			보드의 크기 
	 *  	   K			사과의 개수
	 *  	   i1 j1		사과의 위치 (행 열)
	 *  	   ...
	 *  	   ik jk		
	 *  	   L			뱀의 방향 변환 횟수
	 *  	   sec1 dir1	방향 변화 시간 / 회전 방향	
	 *  	   ...	
	 *  	   secl dirl 	
	 *  
	 *  output: sec			게임 종료까지 걸리는 시간(초)
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 보드의 크기
		int[][] map = new int[N + 1][N + 1];		// 보드, 1행 1열 부터 시작하므로 배열 크기 N + 1 사용		
		
		int K = Integer.parseInt(br.readLine());	// 사과의 개수
		
		// 사과의 위치 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;	// 사과는 map 에서 2로 표현
		}
		
		int L = Integer.parseInt(br.readLine());	// 방향 변환 횟수
		int[][] cmd = new int[L][2];	// 방향전환 시간 및 방향
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			cmd[i][0] = Integer.parseInt(st.nextToken());
			if (st.nextToken().equals("L"))	cmd[i][1] = -1;	// 왼쪽 -1
			else cmd[i][1] = 1;								// 오른쪽 1
		}
		
		// 방향 우 하 좌 상
		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		// 뱀 정보
		int dirHIdx = 0;	// 머리 방향 인덱스 - 초기 방향: 우
		int[] posH = {1, 1};	// 머리 위치 초기위치: 1행 1열
		int cmdHIdx = 0;	// 머리 방향전환 명령 인덱스
		
		int dirTIdx = 0;	// 꼬리 방향 인덱스 - 초기 방향: 우
		int[] posT = {1, 1};	// 꼬리 위치 초기위치: 1행 1열
		int cmdTIdx = 0;	// 꼬리 방향전환 명령 인덱스
		
		int len = 1;	// 길이 - 초기 길이: 1
				
		
		// 게임 실행
		int time = 1; // 시작 시간 1로 설정
		
		while (true) {
			// 이동
			// 머리 다음 위치 갱신 
			posH[0] += dir[dirHIdx][0];
			posH[1] += dir[dirHIdx][1];
			
			// 벽, 자기 자신 확인 -> 종료
			if (posH[0] < 1 || posH[0] > N || posH[1] < 1 || posH[1] > N || map[posH[0]][posH[1]] == 1) break;
			
			// 다음 칸이 사과일 경우 꼬리 그대로
			if (map[posH[0]][posH[1]] == 2) {
				len++;	// 길이 1 증가
			} else {	// 사과 아닐 경우 꼬리 한 칸 이동
				map[posT[0]][posT[1]] = 0;
				
				posT[0] += dir[dirTIdx][0];
				posT[1] += dir[dirTIdx][1];
			}
			
			// 머리 위치에 자리 표시
			map[posH[0]][posH[1]] = 1;
			
			// 방향전환
			// 머리
			if (cmd[cmdHIdx][0] == time) {
				dirHIdx = (dirHIdx + 4 + cmd[cmdHIdx][1]) % 4;
				if (cmdHIdx < L - 1) cmdHIdx++;
			}
			// 꼬리 - 방향전환 길이 - 1 초 후
			if (cmd[cmdTIdx][0] + len - 1 == time) {
				dirTIdx = (dirTIdx + 4 + cmd[cmdTIdx][1]) % 4;
				if (cmdTIdx < L - 1) cmdTIdx++;
			}			
			time++;
		}
		
		System.out.println(time);
		br.close();
	}
}
