package quki.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ���ǿ� ��ȸ(TSP) DP + Bit mask
 * BOJ2098�� ���� ����
 * 
 * @author quki
 *
 */
public class BOJ10971 {
	public static int[][] W;
	public static int[][] dp;
	public static int N;
	public static final int INF = 1000000000;
	/**
	 * 
	 * @param start ������
	 * @param visited ������� ���
	 * @return
	 */
	public static int getShortestPath(int current, int visited) {
		
		// ��� ������ �� �鸥 ���
		if (visited == (1 << N) - 1)
			return W[current][1];

		// �̹� �鷶�� ����̹Ƿ� �ٷ� return
		if (dp[current][visited] >= 0)
			return dp[current][visited];

		int ret = INF;

		// ���տ��� ������ �� ���Ҹ� ����!
		for (int i = 1; i <= N; i++) {
			int next = i;

			if ((visited & (1 << (next - 1))) != 0) // �߿�!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				continue;
			
			if(W[current][next] == 0) // 0�� ��ΰ� �����Ƿ� pass
				continue;
			
			int temp = W[current][next] + getShortestPath(next, visited + (1 << (next - 1)));
			ret = Math.min(ret, temp);
		}

		return dp[current][visited] = ret;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = new int[N + 1][N + 1];
		dp = new int[N + 1][1 << N];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				W[i][j] = sc.nextInt();
			}
		}
		// 2���� �迭�� ��� ���Ҹ� -1��
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int start = 1;
		System.out.println(getShortestPath(start, 1));

	}

}
