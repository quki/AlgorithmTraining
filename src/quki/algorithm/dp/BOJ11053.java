package quki.algorithm.dp;

import java.util.Scanner;

/**
 * Longest Increasing Subsequence(LIS) ���������κм���
 * 
 * @author quki
 *
 */
public class BOJ11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N + 1];
		int LIS[] = new int[N + 1]; // �ִ� ����
		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextInt();
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			LIS[i] = 1; // �ּ� 1�̹Ƿ�
			for (int j = 1; j < i; j++) {
				if (a[j] < a[i]) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
			max = Math.max(max, LIS[i]);
		}
		
		System.out.println(max);

	}
}
