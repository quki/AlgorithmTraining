package quki.algorithm.floyd;

import java.util.Scanner;
/**
 * �ɺ������� ��Ģ
 * BFS�ε� Ǯ �� ����
 * 
 * @author quki
 *
 */
public class BOJ1389 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d[][] = new int[n + 1][n + 1];

		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			d[u][v] = 1; // ���� Edge�� ��� 1�� �ʱ�ȭ
			d[v][u] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(d[i][k]!=0 && d[k][j]!=0){
						if(d[i][j] > d[i][k]+d[k][j] || d[i][j] == 0){
							d[i][j] = d[i][k] + d[k][j];
						}
					}
				}
			}
		}
		
		// �ּҰ��� ���� Vertex ���ϱ�
		int ans = 1;
		int min = 1000000000;
		for(int i = 1; i<=n;i++){
			int sum = 0;
			for(int j = 1; j<=n;j++){
				sum += d[i][j];
			}
			if(min>sum){
				min = sum;
				ans = i;
			}
		}
		
		System.out.println(ans);

	}

}
