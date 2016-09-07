package quki.algorithm.floyd;

import java.util.Scanner;
/**
 * ��ΰ� ������
 * d[i][j] == 0
 * 
 * @author quki
 *
 */
public class BOJ11404 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d[][] = new int[n + 1][n + 1];

		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			
			// edge�� �ΰ��� �� �� �����Ƿ�
			// ������ �ּ� cost�� ���� edge�� ��������
			if(d[u][v] == 0 || d[u][v] > c){ 
                d[u][v] = c;
            }
		}

		// �߿�! d[i][j] == 0 �̶�� ���� �̵��� �� ���ٴ� ��������,
		// ���� �ʱ��� d �迭�� ������ cost�� ǥ�� �ȴ�.
		// �׷��Ƿ� �߰��� k�� Ȱ���ؼ� ��� ����� ������ Relaxation�Ѵ�.
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] != 0 && d[k][j] != 0 && i!=j) {
						if (d[i][j] > d[i][k] + d[k][j] || d[i][j] == 0) {
							d[i][j] = d[i][k] + d[k][j];
						}
					}
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(d[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

}
