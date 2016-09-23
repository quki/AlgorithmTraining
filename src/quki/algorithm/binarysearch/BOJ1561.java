package quki.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * �̺�Ž���� ���ǿ�, ���� ������ ���� start, end�� Ȱ����.
 * 
 * @author quki
 *
 */
public class BOJ1561 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int a[] = new int[M]; // ���̱ⱸ ��ð�
		for (int i = 0; i < M; i++) {
			a[i] = sc.nextInt();
		}

		long left = 0; // �ּ� ��
		long right = 2000000000L * 10000L; // �ִ� ��
		ArrayList<Integer> al = new ArrayList<>(); // ���°���� �˾Ƴ��� ����
		int ans = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			
			// ex) start <= N <= end (�߿�!)
			long start = 0; 
			long end = 0;
			
			for (int i = 0; i < M; i++) {
				end += (mid / a[i]);
				end++;
				if (mid % a[i] == 0) {
					start--;
				}
			}
			start = start + end + 1;

			if (N < start) { // start���� ������ �� �ٿ����ϹǷ�
				right = mid - 1;
			} else if (N > end) { // end���� ũ�� �� �������Ѿ��ϹǷ�
				left = mid + 1;
			} else { // ������ �������Ƿ� ���� ã�� �� �ִ�!
				for (int i = 0; i < M; i++) {
					if (mid % a[i] == 0) {
						al.add(i);
					}
				}

				ans = al.get((int) (N - start));
				break;
			}
		}
		System.out.println(ans + 1);

	}

}
