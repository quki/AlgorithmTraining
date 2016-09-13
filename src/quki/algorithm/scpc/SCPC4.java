package quki.algorithm.scpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * SPFA�� Ǯ���ߴٸ� �� �ð��ʰ��� ������ �𸣰���
 * �׸��� Queue�� ����ִ� ģ���� �ٽ� Queue�� ������ ������ �ʳ�?
 * 
 * @author quki
 *
 */
public class SCPC4 {

	public static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		int inf = 1000000000;
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int d[][] = new int[N + 1][2]; // 0: �ִܰŸ�, 1: ���尡��� ���Ǽ�

			HashMap<Integer, ArrayList<Edge>> hm = new HashMap<>();
			for (int i = 0; i <= N; i++) {
				hm.put(i, new ArrayList<Edge>());
				Arrays.fill(d[i], inf);
			}
			while (M-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int c = sc.nextInt();
				hm.get(u).add(new Edge(v, c));
				hm.get(v).add(new Edge(u, c));
			}
			Queue<Integer> q = new LinkedList<Integer>();
			while (K-- > 0) {
				int p = sc.nextInt();
				d[p][0] = 0;
				d[p][1] = p;
				q.add(p);
			}

			while (!q.isEmpty()) {
				int u = q.poll();

				for (Edge edge : hm.get(u)) {
					int v = edge.v;
					int c = edge.c;

					if (d[v][0] >= d[u][0] + c) {
						d[v][0] = d[u][0] + c;
						d[v][1] = d[u][1];
						if (d[v][0] == d[u][0] + c && d[v][1] > d[u][1]) {
							d[v][1] = d[u][1];
						}

						q.add(v);

					}

				}
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			int ans1 = 0;
			int ans2 = 0;
			for (int i = 1; i <= N; i++) {
				ans1 += d[i][0];
				ans2 += d[i][1];
			}
			System.out.println(ans1 + "\n" + ans2);
		}
	}

}
