package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_실버2_4358_생태학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> treeList = new ArrayList<>();
		Map<String, Integer> treeMap = new HashMap<>();
		
		String input = "";
		int total = 0;
		
		// 데이터가 몇개인지 주어지지 않음 -> null 이면 중지
		while((input = br.readLine()) != null) {
			// Map에 key 로 등록 되지 않았다면 1로 등록
			if (treeMap.get(input) == null) {
				treeMap.put(input, 1);
				treeList.add(input);
			} else {
			// 등록된 적 있다면 이전 값 + 1
				treeMap.put(input, treeMap.get(input) + 1);
			}			
			// 총 갯수 -> 비율로 만들기 위함
			total++;
		}
		// 알파벳 순으로 정렬
		treeList.sort(Comparator.naturalOrder());
		
		//출력
		for (String tree : treeList) {
			System.out.printf("%s %.4f\n", tree, treeMap.get(tree) / (total * 1.0) * 100);
		}
	}
}