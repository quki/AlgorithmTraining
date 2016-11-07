package quki.algorithm.sort;

/**
 * MergeSort, O(NlogN): logN(����) * N(�񱳿���)
 */
public class MergeSort {

	/**
	 * MergeTwoArea
	 */
	public static void mergeTwoArea(int start, int mid, int end, int a[]) {
		int left = start;
		int leftEnd = mid;
		int right = mid + 1;
		int rightEnd = end;

		int temp[] = new int[a.length];
		int tIdx = start;
		while (left <= leftEnd && right <= rightEnd) {

			if (a[left] < a[right]) {
				// �켱 ������ left �� ���� ��Ȳ, ���������̹Ƿ�
				temp[tIdx] = a[left];
				left++;
				tIdx++;
			} else if (a[left] > a[right]) {
				// �켱 ������ right�� ���� ��Ȳ, ���������̹Ƿ�
				temp[tIdx] = a[right];
				right++;
				tIdx++;
			} else {
				// �켱���ǰ� left, right�� ���� ��Ȳ
				temp[tIdx] = a[left];
				left++;
				tIdx++;
				temp[tIdx] = a[right];
				right++;
				tIdx++;
			}
		}

		if (left <= leftEnd) {
			for (int i = left; i <= leftEnd; i++) {
				temp[tIdx] = a[i];
				tIdx++;
			}
		} else {
			for (int i = right; i <= rightEnd; i++) {
				temp[tIdx] = a[i];
				tIdx++;
			}
		}

		for (int i = start; i <= end; i++) {
			a[i] = temp[i];
		}

	}

	/**
	 * MergeSort
	 */
	public static void mergeSort(int start, int end, int a[]) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid, a);
			mergeSort(mid + 1, end, a);
			mergeTwoArea(start, mid, end, a);
		}

	}

	public static void main(String[] args) {
		int a[] = { 3, 6, 2, -1 };
		// int a[] = { 3, 3, 3};
		mergeSort(0, a.length - 1, a);
		for (int e : a) {
			System.out.println(e);
		}

	}

}
