package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_14891_톱니바퀴 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] gears = new int[4];
		for (int i = 0; i < 4; i++) {
			gears[i] = Integer.parseInt(sc.next(), 2);
		}		
				
		int K = sc.nextInt();
		
		int idx;
		int left = 1 << 1;
		int right = 1 << 5;
		// clockwise 면 true
		boolean dir, copyDir;
		for (int k = 0; k < K; k++) {			
			idx = sc.nextInt() - 1;
			dir = (sc.nextInt() == 1);
			
			boolean[] move = new boolean[4];
			boolean[] moveDir = new boolean[4];
			move[idx] = true;
			moveDir[idx] = dir;
			
			// 왼쪽
			copyDir = dir;
			for (int i = idx - 1; i >= 0; i--) {
				if (((gears[i] & right) > 0) == ((gears[i + 1] & left) > 0)) break;
				move[i] = true;
				copyDir = !copyDir;
				moveDir[i] = copyDir;
			}
			
			// 오른쪽
			copyDir = dir;
			for (int i = idx + 1; i < 4; i++) {
				if (((gears[i - 1] & right) > 0) == ((gears[i] & left) > 0)) break;
				move[i] = true;
				copyDir = !copyDir;
				moveDir[i] = copyDir;
			}			
			
			// 회전	
			for (int i = 0; i < 4; i++) {
				if (!move[i]) continue;
				if (moveDir[i]) {
					gears[i] = moveClockwise(gears[i]);
				} else {
					gears[i] = moveCounterClockwise(gears[i]);
				}
			}
		}
		
		int sum = 0;
		int score = 1;
		for (int i = 0; i < 4; i++) {
			if ((gears[i] & 128) > 0) {
				sum += score;
			}
			score *= 2;
		}
		
		System.out.println(sum);
		sc.close();
	}
	
	public static int moveCounterClockwise(int gearBit) {
		int add = 0;
		if (gearBit >= 128) {
			add = 1;
			gearBit -= 128;
		}
		
		return (gearBit << 1) + add;
	}
	
	public static int moveClockwise(int gearBit) {
		int add = gearBit & 1;
		
//		gearBit = (gearBit >> 1) + (add << 7);
		
		return (gearBit >> 1) + (add << 7);
	}
}
