package quki.algorithm.graph.search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * DP�� Ǯ�� �ȵȴ�.
 * �ֳ��ϸ� ������ �پ��� ���°� �ƴϴ�.
 * ĭ�� 4��(��, ��, ��, ��)���� �̵��ϱ� ����
 * DP�� ������ (��, ��) �� ���� ĭ�� �پ��� �������� �̵��ؾ��Ѵ�.
 * 
 * @author quki
 *
 */
public class BOJ2206 {

	static final int INF = 1000000000;
	
	/**
	 * flag�� ���� �μ̴� ����, ���� �μ̴� ���� ������ 1, ������ 0 
	 */
	static class Point {
		int i, j, flag; 

		Point(int i, int j, int flag) {
			this.i = i;
			this.j = j;
			this.flag = flag;
		}
	}

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int a[][] = new int[N + 1][M + 1];
		// d[i][j][k]: (i,j) �� k ���°� ����, k ���¶� flag���� 0 or 1, ��, ���� �μ̴� ���� ���°�� (0), ���� �μ̴� ���� �־��� ���(1)
		int d[][][] = new int[N + 1][M + 1][2]; 
		for (int i = 1; i <= N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < line.length(); j++) {
				int e = Integer.parseInt(Character.toString(line.charAt(j)));
				a[i][j + 1] = e;
			}
		}

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1, 1, 0));
		d[1][1][0] = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int i = p.i;
			int j = p.j;
			int flag = p.flag;

			for (int k = 0; k < dx.length; k++) {
				int newI = i + dy[k];
				int newJ = j + dx[k];

				if (newI >= 1 && newI <= N && newJ >= 1 && newJ <= M) {
					if (d[newI][newJ][flag] == 0) {

						// ���� �ִ� ��
						if (a[newI][newJ] == 1) {
							if (flag == 0) {
								q.add(new Point(newI, newJ, flag + 1));
								d[newI][newJ][flag + 1] = d[i][j][flag] + 1;
							}
						} else {
							q.add(new Point(newI, newJ, flag));
							d[newI][newJ][flag] = d[i][j][flag] + 1;
						}

					}
				}

			}
		}
		
		if(d[N][M][0] == 0){
			d[N][M][0] = INF;
		}
		if(d[N][M][1] == 0){
			d[N][M][1] = INF;
		}
		int ans  = Math.min(d[N][M][0], d[N][M][1]);
		if(ans == INF){
			System.out.println(-1);
		}else{
			System.out.println(ans);
		}
	}

}
