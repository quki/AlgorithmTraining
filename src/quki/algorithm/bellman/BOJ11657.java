package quki.algorithm.bellman;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ÿ�Ӹӽ� ���� Bellman Ford
 * 
 * �ð����⵵: VE, �׷��� E<=V^2 �̱� ������ �Ϲ������� V^3
 * 
 * @author quki
 *
 */
public class BOJ11657 {

	public static class Edge {
		int u;
		int v;
		int c;

		Edge(int u, int v, int c) {
			this.u = u;
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d[] = new int[n + 1];
		Edge edgeArr[] = new Edge[m + 1]; // Edge�� ������ŭ �ʱ�ȭ

		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			edgeArr[i] = new Edge(a, b, c);
		}
		int inf = 1000000000;
		Arrays.fill(d, inf);
		d[1] = 0;
		boolean isNegativeCycleExist = false;
		// V��ŭ for�� ����, ���� ������ ���ٸ� V-1��ŭ ������ ������,
		// ���� cycle�� �ִ� ��� ������ V��°�� update�� �̷����Ƿ� V������ �������Ѵ�.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				Edge e = edgeArr[j]; // ��� Edge�� �˻�
				int u = e.u;
				int v = e.v;
				int c = e.c;

				// Relaxation
				if (d[v] > d[u] + c) {
					d[v] = d[u] + c;
					if (i == n)
						isNegativeCycleExist = true;
				}

			}
		}

		if (isNegativeCycleExist) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= n; i++) {
				if(d[i] == inf){
					System.out.println(-1);
				}else{
					System.out.println(d[i]);
				}
			}
		}

	}

}
