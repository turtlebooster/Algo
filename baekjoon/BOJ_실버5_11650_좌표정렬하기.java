package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버5_11650_좌표정렬하기 {
	static int[][] sorted;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] pos = new int[N][];
		sorted = new int[N][];
		for (int i = 0; i < N; i++) {
			pos[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		
		mergeSort(pos, 0, pos.length - 1);
		
		System.out.println(Arrays.deepToString(pos).replace("], ", "\n").replaceAll("[\\[\\,\\]]", ""));
		sc.close();
	}

	private static void mergeSort(int[][] pos, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(pos, left, mid);
			mergeSort(pos, mid + 1, right);
			merge(pos, left, mid, right);
		}
	}

	private static void merge(int[][] pos, int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;
		
		while (L <= mid && R <= right) {
			if (check(pos[L], pos[R])) {
				sorted[idx++] = pos[L++];
			} else {
				sorted[idx++] = pos[R++];
			}
		}
		while (L <= mid) sorted[idx++] = pos[L++];
		while (R <= right) sorted[idx++] = pos[R++];
		
		for (int i = left; i <= right; i++) pos[i] = sorted[i];
		
	}
	
	private static boolean check(int[] pos1, int[] pos2) {
		if (pos1[0] != pos2[0]) return pos1[0] < pos2[0];
		else return pos1[1] <= pos2[1];
	}
	
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BOJ_실버5_11650_좌표정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] pos = new int[N][];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		quickSort(pos, 0, pos.length-1);
		System.out.println(Arrays.deepToString(pos).replace("], ", "\n").replaceAll("[\\[\\,\\]]", ""));
	}
	
	static void quickSort(int[][] arr, int left, int right) {
		if(left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
	private static int partition(int[][] arr, int left, int right) {
		int[] pivot = arr[left];
		int L = left+1, R = right;
		int[] tmp;
		while(L<=R) {
			while(L <= R && (arr[L][0] < pivot[0] 
							|| (arr[L][0] == pivot[0] && arr[L][1] <= pivot[1]))) L++;
			while(arr[R][0] > pivot[0] 
					|| (arr[R][0] == pivot[0] && arr[R][1] > pivot[1])) R--;
			if(L < R) {
				tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;
	}
}
*/

/*
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버5_11650_좌표정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] pos = new int[N][];
		for (int i = 0; i < N; i++) {
			pos[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		
		Arrays.sort(pos, (p1, p2) -> {
			if (p1[0] != p2[0]) return p1[0] - p2[0];
			else return p1[1] - p2[1];
		});
		
		System.out.println(Arrays.deepToString(pos).replace("], ", "\n").replaceAll("[\\[\\,\\]]", ""));
		sc.close();
	}
}
*/
