package quki.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �̺� Ž��,������ ��ġ ����
 * N * log(������ ���� �ִ� �Ÿ�)
 * 
 * @author quki
 *
 */
public class BOJ2110 {
	/**
	 * �ſ� �߿��� �˰����� ����ִ� �Լ� Greedy�� ������ ����ִ� �˰����̹Ƿ� �� �����غ��� �ٶ�.
	 * 
	 * @return ����� ������ true
	 */
	public static boolean isPossible(int[] a, int C, int mid) {
		int count = 1;
		int pivot = a[0];
		for (int house : a) {
			if (house - pivot >= mid) {
				pivot = house;
				count++;
			}
		}
		return count >= C;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);

		// left�� right�� ���� ������ �ִ�Ÿ��� ã�´�.
		// �ʱ� left �� �ּҰŸ��� 1, right�� �ִ�Ÿ��� ��������-ù°��
		int left = 1;
		int right = a[N - 1] - a[0];
		int ans = 1;

		// while �� ���� �� �����غ���
		while (left <= right) {
			int mid = (left + right) / 2;
			if (isPossible(a, C, mid)) {
				left = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
