package algo;

public class Search_BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 7, 9, 11, 19, 23 };
		
		int want = 8;
		
		int s = 0;
		int e = arr.length - 1;
		int mid = (e + s) / 2;
		
		boolean find = false;
		while(s <= e) {
			mid = (e + s) / 2;
			int midnum = arr[mid];
			if (midnum == want) {
				find = true;
				break;
			}
			if (midnum > want) e = --mid;
			else s = ++mid;
		}
		if (find) System.out.println("want idx: " + mid);
		else System.out.println("there is no want");
	}
}
