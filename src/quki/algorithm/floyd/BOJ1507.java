package quki.algorithm.floyd;

import java.util.Scanner;
/**
 * ��� ������ �˻��ϸ�
 * �ʿ���� ������ �����ϴ� Technique
 * 
 * @author quki
 *
 */
public class BOJ1507 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = sc.nextInt();
			}
		}
		// �ʿ���� ������ ��������
		boolean unused[][] = new boolean[n][n];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < n; j++) {

					if (k == j)
						continue;
					if (i == j)
						continue;

					if (d[i][j] == d[i][k] + d[k][j]) {
						unused[i][j] = true;
					}
					
					// �Է��� �̹� �ִܰ�ΰ� �־����ִµ�,
					// �ٽ� �ִܰ�θ� ����غ��� �� ª���� ���
					// �Է��� ����� �Ǵ� -1�� �������.
					if (d[i][j] > d[i][k] + d[k][j]) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (!unused[i][j]) {
					ans += d[i][j];
				}
			}
		}

		System.out.println(ans);

	}

}
