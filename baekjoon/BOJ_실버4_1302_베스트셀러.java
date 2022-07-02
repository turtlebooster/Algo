package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_실버4_1302_베스트셀러 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 팔린 책의 수
		int N = Integer.parseInt(br.readLine());
		
		List<String> bookList = new ArrayList<>();
		Map<String, Integer> bookCnt = new HashMap<>();
		
		String book = "";
		while(N-- > 0) {
			book = br.readLine();
			if (bookCnt.get(book) == null) {
				bookList.add(book);
				bookCnt.put(book, 1);
			} else {
				bookCnt.put(book, bookCnt.get(book) + 1);
			}
		}
		
		bookList.sort(Comparator.naturalOrder());
		int max = 0;
		for (String b : bookList) {
			if (max < bookCnt.get(b)) {
				max = bookCnt.get(b);
				book = b;
			}
		}
		
		System.out.println(book);
	}
}
