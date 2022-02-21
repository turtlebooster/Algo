package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.HashMap;
import java.util.StringTokenizer;

public class SW_D3_1493_수의새로운연산 {
// 오히려 느리더라
//	private static HashMap<String, Integer> sharpMap = new HashMap<>();
//	private static HashMap<Integer, String> ampersandMap = new HashMap<>();
//	static {
//		sharpMap.put("1,1", 1);
//		ampersandMap.put(1, "1,1");
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		
		// 테스트 케이스 수 만큼 반복문 실행
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			System.out.println("#" + tc + " " + star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}	
		br.close();
		
	}
	private static int sharp (int x, int y) {
		if (y == 1) {
			if (x == 1) return 1;			// sharp(1, 1) = 1
//			if (x == 1) return sharpMap.get("1,1");			
//			sharpMap.put(x + "," + 1, sharp(x - 1 , 1) + x);
//			ampersandMap.put(sharp(x - 1 , 1) + x, x + "," + 1);
			return sharp(x - 1 , 1) + x;	// 가장 아랫줄에 대해서 sharp(x, 1) = sharp(x - 1 , 1) + x
//			return sharpMap.get(x + "," + 1);
		}
		
//		sharpMap.put(x + "," + y, sharp(x, y - 1) + y + x - 2);
//		ampersandMap.put(sharpMap.get(x + "," + y), x + "," + y);
		// sharp(x, y) = sharp(x, y - 1) + y + x - 2
		return sharp(x, y - 1) + y + x - 2;
//		return sharpMap.get(x + "," + y);
	}
	private static String ampersand (int n) {	
//		if (ampersandMap.get(n) != null) {
//			return ampersandMap.get(n);
//		}
		int y = 1;
		// 몇번째 대각선 줄에 속하는지 찾기
		for (int i = 1; n >= sharp(1, i); y = i++);
		// 해당 번째의 대각선 위의 x = 1 일때 값을 기준으로 n과의 차이만큼 x +방향, y -방향 으로 이동하면 n 이 위치한 자리이다
		// 기준: (1, y) 간격: n - sharp(1, y)
		int x = 1 + n - sharp(1, y);
		y -= n - sharp(1, y);
//		ampersandMap.put(n, x+","+y);
		return x+","+y;
//		return ampersandMap.get(n);
	}
	private static String plus (String pos1, String pos2) {
		// 좌표는 , 를 구분자로 x, y 좌표로 나뉘어 있음
		// spilt 을 사용해 [0] 이 x좌표, [1]이 y 좌표
		// 각각을 더하는 것이니 int 로 바꾸어 더해줌
		int x = Integer.parseInt(pos1.split(",")[0]) + Integer.parseInt(pos2.split(",")[0]);
		int y = Integer.parseInt(pos1.split(",")[1]) + Integer.parseInt(pos2.split(",")[1]);		
		return x + "," + y;
	}
	private static int star (int a, int b) {
		// 문제에서 정해준 연산대로 만든 함수들을 활용해 연산자 구성
		int x = Integer.parseInt(plus(ampersand(a), ampersand(b)).split(",")[0]);
		int y = Integer.parseInt(plus(ampersand(a), ampersand(b)).split(",")[1]);
		
		return sharp(x, y);
	}
}
