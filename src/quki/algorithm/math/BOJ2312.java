package quki.algorithm.math;

import java.util.Scanner;

/**
 * �����佺�׳׽��� ä�� ���� ������ Ʋ���� ����
 * 
 */
public class BOJ2312 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();

			StringBuilder ans = new StringBuilder();
			for (int i = 2; i <= N; i++) {

				int cnt = 0;
				while (N % i == 0) {
					N /= i;
					cnt++;
				}

				if (cnt != 0) {
					ans.append(i);
					ans.append(" ");
					ans.append(cnt);
					ans.append("\n");
				}
			}

			System.out.print(ans.toString());
		}
	}

}
