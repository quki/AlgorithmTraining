package quki.algorithm.graph.search.perfect;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * �Ҽ� �Ǻ� + digit change ��ũ��
 * 
 * @author quki
 *
 */
public class BOJ1963 {

	public static int change(int index, int digit, int origin) {
		
		// 4�ڸ��� �׻� �����ؾ��ϹǷ� 1000�� �ڸ��� 0�̵Ǹ� �ȵ�, return�� 3�ڸ��� �ع���
		if (index == 0 && digit == 0) {
			return -1;
		}
		String strOrigin = Integer.toString(origin);
		StringBuilder sb = new StringBuilder(strOrigin);
		sb.setCharAt(index, (char) (digit + '0')); // digit set�ϴ� �߿��� �Լ�!
		return Integer.parseInt(sb.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// �����佺�׳׽��� ä
		boolean[] prime = new boolean[10001];
		Arrays.fill(prime, true);
		for (int i = 2; i <= 10000; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= 10000; j += i) {
					prime[j] = false;
				}
			}
		}
		prime[1] = false;

		int T = sc.nextInt();

		while (T-- > 0) {
			int a = sc.nextInt();
			int target = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			q.add(a);
			boolean check[] = new boolean[10001];
			int depth[] = new int[10001];
			depth[a] = 0;
			check[a] = true;
			while (!q.isEmpty()) {
				int now = q.poll();
				if (now == target)
					break;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j <= 9; j++) {
						
						int next = change(i, j, now);

						if (next != -1) {
							if (!check[next] && prime[next]) {
								q.add(next);
								depth[next] = depth[now] + 1;
								check[next] = true;
							}
						}

					}
				}
			}

			System.out.println(depth[target]);

		}

	}

}
