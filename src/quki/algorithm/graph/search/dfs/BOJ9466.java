package quki.algorithm.graph.search.dfs;

import java.util.Scanner;
/**
 * DFS + ����Ŭ ã��
 * 
 * @author quki
 *
 */
public class BOJ9466 {

	static int dfs(int i, int cnt, int source, int a[], int check[], int step[]) {
		if (check[i] != 0) {

			// �̹� ��� ��
			if (step[i] != source) {
				return 0;
			} else {

				int pair = cnt - check[i];
				return pair;
			}
		}
		check[i] = cnt;
		step[i] = source;
		return dfs(a[i], cnt + 1, source, a, check, step);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int a[] = new int[N + 1];
			int check[] = new int[N + 1]; //
			int step[] = new int[N + 1]; // source ����

			for (int i = 1; i <= N; i++) {
				a[i] = sc.nextInt();
			}

			int pair = 0;
			for (int i = 1; i <= N; i++) {
				if (check[i] == 0) {
					pair += dfs(i, 1, i, a, check, step);
				}
			}
			System.out.println(N - pair);
		}
	}

}
