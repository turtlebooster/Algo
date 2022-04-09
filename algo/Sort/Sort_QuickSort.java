package algo.Sort;

import java.util.Arrays;

public class Sort_QuickSort {
	public static void main(String[] args) {
		int[] arr = {7,5,40,11,8,8,56,39};
		
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left -1; //i pivot보다 작은값의 경계를 가리킨다.
		
		for(int j = left; j<right; j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		//pivot을 자기 위치로 보내기 위해서 정렬을 하겠당.
		swap(arr, i+1, right);
		return i+1;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	/*
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int L = left+1, R = right;
		int tmp;
		while(L<=R) {
			//L : pivot 보다 큰값을 찾을 떄까지 이동하겠다.
			//요기 제한 범위를 두지 않으면 인덱스 에러가 날수도 있음. 꼭 꼭 유의
			while(L <= R && arr[L]<= pivot) L++;
			//R : pivot 보다 작거나 같은 값을 만날때 까지 이동하겠다.
			while(arr[R]>pivot) R--;
			//아직 교차가 안됬어? 더 해볼게 남았으니 일단 서로 교환한다.
			if(L < R) {
				tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		//pivot이 가리키는 값과 R이 가리키는 값을 바꾸어 pivot의 위치를 결정한다.
		tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;
	}
	*/
}
