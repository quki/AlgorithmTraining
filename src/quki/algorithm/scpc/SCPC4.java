package quki.algorithm.scpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * SPFA로 풀긴했다만 왜 시간초과가 나는지 모르겠음 
 * 그리고 Queue에 들어있는 친구를 다시 Queue에 넣으면 느리지 않나?
 * 
 * @author quki
 *
 */
public class SCPC4 {

	static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static final int INF = 1000000000;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int d[][] = new int[N + 1][2]; // 0: 최단거리, 1: 가장가까운 대피소
			
			HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();
			for (int i = 1; i <= N; i++) {
				graph.put(i, new ArrayList<Edge>());
				d[i][0] = INF;
			}
			while (M-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int c = sc.nextInt();
				graph.get(u).add(new Edge(v, c));
				graph.get(v).add(new Edge(u, c));
			}
			Queue<Integer> q = new LinkedList<>();
			boolean isInQueue[] = new boolean[N + 1];
			boolean isP[] = new boolean[N+1];
			while (K-- > 0) {
				int p = sc.nextInt();
				d[p][0] = 0;
				d[p][1] = p;
				q.add(p);
				isInQueue[p] = true;
				isP[p] = true;
			}

			while (!q.isEmpty()) {
				int u = q.poll();
				isInQueue[u] = false;
				for (Edge edge : graph.get(u)) {
					int v = edge.v;
					int c = edge.c;
					
					if(isP[v])
						continue;
					
					if (d[v][0] > d[u][0] + c) {
						d[v][0] = d[u][0] + c;
						d[v][1] = d[u][1];
						if (!isInQueue[v])
							q.add(v);

					} else if (d[v][0] == d[u][0] + c && d[v][1] > d[u][1]) {
						d[v][1] = d[u][1];
					}

				}
			}

			// 이 부분에서 정답을 출력하십시오.
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
